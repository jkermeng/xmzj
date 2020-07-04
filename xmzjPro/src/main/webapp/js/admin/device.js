$(function () {
  $("#jqGrid").jqGrid({
    url: '../device/showAll',
    datatype: "json",
    colModel: [{
        name: 'd_id',
        index: 'd_id',
        width: 0,
        hidden: true,
        key: true
      },
      {
        label: '设备名',
        name: 'd_name',
        width: 75
      },
      {
        label: '设备型号',
        name: 'd_type',
        width: 90
      },
      {
        label: '设备价格',
        name: 'd_price',
        width: 100
      }
    ],
    viewrecords: true,
    height: 385,
    rowNum: 10,
    rowList: [10, 30, 50],
    rownumbers: true,
    rownumWidth: 25,
    autowidth: true,
    multiselect: true,
    pager: "#jqGridPager",
    jsonReader: {
      root: "page.list",
      page: "page.currPage",
      total: "page.totalPage",
      records: "page.totalCount"
    },
    prmNames: {
      page: "page",
      rows: "limit",
      order: "order"
    },
    gridComplete: function () {
      //隐藏grid底部滚动条
      $("#jqGrid").closest(".ui-jqgrid-bdiv").css({
        "overflow-x": "hidden"
      });
    }
  });
  new AjaxUpload('#upload', {
    action: '../file/upload',
    name: 'file',
    autoSubmit: true,
    responseType: "json",
    onSubmit: function (file, extension) {
      if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))) {
        alert('只支持jpg、png、gif格式的图片！');
        return false;
      }
    },
    onComplete: function (file, r) {
      if (r.code == 0) {
        vm.form.img = r.url
      } else {
        alert(r.msg);
      }
    }
  });

});

var vm = new Vue({
  el: '#rrapp',
  data: {
    search: null,
    showInfo: false,
    showList: true,
    title: null,
    form: {},
    expertlist: [],
    userlist: []
  },
  created() {

  },
  methods: {
    // 查询
    query: function () {
      vm.reload();
    },
    // 添加
    add: function () {
      vm.showList = false;
      vm.showInfo = false
      vm.title = "添加设备";
    },
    // 详情
    update: function () {
      vm.showInfo = true
      var id = getSelectedRow();
      if (id == null) {
        return;
      }

      vm.showList = false;
      vm.title = "设备详情";

      vm.getform(id);
    },
    // 删除
    del: function () {
      var ids = getSelectedRows();
      if (ids == null) {
        return;
      }

      confirm('确定要删除选中的记录？', function () {
        $.ajax({
          type: "POST",
          url: "../device/del",
          data: JSON.stringify(ids),
          success: function (r) {
            if (r.code == 0) {
              alert('操作成功', function (index) {
                vm.reload();
              });
            } else {
              alert(r.msg);
            }
          }
        });
      });
    },
    // 提交
    saveOrUpdate: function (event) {
      $.ajax({
        type: "GET",
        url: '../device/add',
        data: vm.form,
        success: function (r) {
          if (r.code === 0) {
            alert('操作成功', function (index) {
              vm.reload();
            });
          } else {
            alert(r.msg);
          }
        }
      });
    },
    // 获取详情
    getform(id) {
      $.get("../device/detail?id=" + id, function (r) {
        vm.form = r.detail;
      });
    },
    // 初始化表格
    reload: function (event) {
      vm.showList = true;
      var page = $("#jqGrid").jqGrid('getGridParam', 'page');
      $("#jqGrid").jqGrid('setGridParam', {
        postData: {
          'd_name': vm.search
        },
        page: page
      }).trigger("reloadGrid");
    },
  }
});