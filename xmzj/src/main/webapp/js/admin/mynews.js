$(function () {
  $("#jqGrid").jqGrid({
    url: '../active/showAll?status=1',
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
        vm.user.img = r.url
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
    roleList: {},
    types: [],
    form: {}
  },
  created: function () {

    $.getJSON("../type/list2", function (r) {
      vm.types = r.list;
    })

  },
  methods: {
    query: function () {
      vm.reload();
    },
    add: function () {
      vm.showInfo = false
      vm.showList = false;
      vm.title = "发布新闻";
      vm.roleList = {};

    },
    update: function () {
      vm.showInfo = true
      var userId = getSelectedRow();
      if (userId == null) {
        return;
      }

      vm.showList = false;
      vm.title = "修改";

      vm.getform(id);
    },
    del: function () {
      var userIds = getSelectedRows();
      if (userIds == null) {
        return;
      }

      confirm('确定要删除选中的记录？', function () {
        $.ajax({
          type: "POST",
          url: "../sys/user/delete",
          data: JSON.stringify(userIds),
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
    saveOrUpdate: function (event) {
      var url = vm.user.userId == null ? "../sys/user/save" : "../sys/user/update";
      $.ajax({
        type: "POST",
        url: url,
        data: JSON.stringify(vm.user),
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
    getexpert() {

    },
    getform(id) {
      $.get("../active/detail?id=" + id, function (r) {
        vm.form = r.detail;
      });
    },
    reload: function (event) {
      vm.showList = true;
      var page = $("#jqGrid").jqGrid('getGridParam', 'page');
      $("#jqGrid").jqGrid('setGridParam', {
        postData: {
          'search': vm.search
        },
        page: page
      }).trigger("reloadGrid");
    },
    selectobj(e) {
      console.log(e)
    }
  }
});