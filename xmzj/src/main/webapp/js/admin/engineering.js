$(function () {
  $("#jqGrid").jqGrid({
    url: '../active/showAll',
    datatype: "json",
    colModel: [{
        name: 'a_id',
        index: 'a_id',
        width: 0,
        hidden: true,
        key: true
      },
      {
        label: '活动主题',
        name: 'a_title',
        width: 75
      },
      {
        label: '活动内容',
        name: 'a_context',
        width: 90
      },
      {
        label: '活动方案',
        name: 'a_scheme',
        width: 100
      },
      {
        label: '参与人数限制',
        name: 'a_pnum',
        width: 80
      },
      {
        label: '参与费用',
        name: 'a_price',
        width: 80
      },
      {
        label: '所属行业',
        name: 'a_type',
        width: 80
      },
      {
        label: '活动时间',
        name: 'a_beginDate',
        width: 80
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
    isadd: false,
    showList: true,
    title: null,
    form: {},
  },
  created() {
    getexpert()
  },
  methods: {
    // 查询
    query: function () {
      vm.reload();
    },
    // 添加
    add: function () {
      vm.showList = false;
      vm.isadd = true
      vm.title = "发布活动";
    },
    // 详情
    update: function () {
      vm.isadd = false
      var id = getSelectedRow();
      if (id == null) {
        return;
      }

      vm.showList = false;
      vm.title = "修改";

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
          url: "../active/del",
          data: ids,
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
        url: '../active/add',
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
    // 获取专家
    getexpert() {
      $.get("../sys/user/list?type1=1", function (r) {
        vm.expertlist = r.list;
        console.log(vm.expertlist);
      });
    },
    // 获取企业
    getuser() {
      $.get("../active/detail", function (r) {
        vm.form = r.detail;
      });
    },
    // 获取活动详情
    getform(id) {
      $.get("../active/detail?id=" + id, function (r) {
        vm.form = r.detail;
      });
    },
    // 初始化表格
    reload: function (event) {
      vm.showList = true;
      var page = $("#jqGrid").jqGrid('getGridParam', 'page');
      $("#jqGrid").jqGrid('setGridParam', {
        postData: {
          'a_title': vm.search
        },
        page: page
      }).trigger("reloadGrid");
    },

    selectobj(e) {
      console.log(e.innertext)
    }
  }
});