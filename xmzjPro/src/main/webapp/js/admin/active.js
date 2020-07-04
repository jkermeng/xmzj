$(function () {
  $("#jqGrid").jqGrid({
    url: '../active/showAll2',
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
      },
      {
        label: '审核状态',
        name: 'a_status',
        width: 80,
        formatter: function (value, options, row) {
          return value === 1 ?
            '<span class="label label-warning">审核中</span>' :
            value === 2 ? '<span class="label label-success">通过</span>' : '<span class="label label-danger">不通过</span>'
        }
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

});

var vm = new Vue({
  el: '#rrapp',
  data: {
    user: null,
    search: null,
    showInfo: false,
    showList: true,
    isadd: false,
    title: null,
    form: {},
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
      vm.isadd = true
      vm.title = "发布活动";
    },
    // 审核
    update: function () {
      vm.showInfo = false
      vm.isadd = false
      let id = getSelectedRow();
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
      let str = null
      ids.some(item => {
        str += str ? ',' + item : '' + item
      })
      confirm('确定要删除选中的记录？', function () {
        $.ajax({
          type: "GET",
          url: "../active/del",
          data: {
            ids: str
          },
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
      const url = vm.isadd ? "../active/add" : "../active/update";
      var formData = new FormData(vm.form);
      formData.append("file", document.getElementById('upload').files[0]);
      const {
        a_id,
        a_status
      } = vm.form
      const data = vm.isadd ? formData : {
        a_id,
        a_status
      }
      $.ajax({
        type: "GET",
        url,
        data,
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

    // 获取活动详情
    getform(id) {
      $.get("../active/detail?id=" + id, function (r) {
        vm.form = r.detail;
      });
    },
    // 获取用户
    getUser: function () {
      $.getJSON("sys/user/info?_" + $.now(), function (r) {
        vm.user = r.user;
        console.log(vm.user);
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