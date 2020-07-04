$(function () {
    $("#jqGrid").jqGrid({
        url: '../project/list',
        datatype: "json",
        colModel: [
            {
                label: 'id',
                name: 'id',
                index: 'id',
                width: 50,
                key: true,
                hidden: true,
                formatter: function (v, a, r) {
                    return "<a onclick='vm.info(\"" + r.id + "\")'>" + v + " </a>"
                }
            },
            {
                label: '名称',
                name: 'name',
                index: 'name',
                width: 80
            },

            {
                label: '领域',
                name: 'typeEntity.name',
                index: 'typeEntity.name',
                width: 80
            },

            {
                label: '所属用户',
                name: 'sysUserEntity.username',
                index: 'sysUserEntity.username',
                width: 80
            },
            {
                label: '费用',
                name: 'price',
                index: 'price',
                width: 80
            },

            {
                label: '状态',
                name: 'state',
                index: 'state',
                width: 80
            },
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
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });


});

var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            name: ''
        },
        showAdd: false,
        showPrint: false,
        showInfo: false,
        showList: true,
        title: null,
        user: {},
        comments: [],
        users: [],
        comment:{},



        types: [],


        pros: [],


        project: {},
    },
    created: function () {
        $.getJSON("../sys/user/info", function (r) {
            vm.user = r.user;
        })


        $.getJSON("../sys/user/list2", function (r) {
            vm.users = r.list;
        })

        $.getJSON("../type/list2", function (r) {
            vm.types = r.list;
        })
        $.getJSON("../pro/list2", function (r) {
            vm.pros = r.list;
        })

    },
    methods: {
        query: function () {
            vm.reload();
        }
        ,
        add: function () {
            vm.showAdd = true;
            vm.showList = false;
            vm.title = "新增";
            vm.project = {};
        }
        ,
        update: function (event) {
            var id =
                getSelectedRow();
            if (id == null
            ) {
                return;
            }

            vm.showAdd = true;
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        }
        ,

        saveOrUpdate1: function (event) {
            vm.comment.project = vm.project.id;
            vm.comment.pro = vm.project.pro;
            $.ajax({
                type: "POST",
                url: "../comment/save",
                data: JSON.stringify(vm.comment),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {

                            $.getJSON("../comment/list2?project="+vm.project.id,function (r) {
                                vm.comments = r.list;
                            })

                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });

            vm.saveOrUpdate();
        }
        ,

        saveOrUpdate: function (event) {
            vm.project.state = '已指导'
            var url = vm
                .project.id ==
            null ? "../project/save" : "../project/update";
            $.ajax({
                type: "POST",
                url: url,
                data: JSON.stringify(vm.project),
                success: function (r) {
                    if (r.code === 0) {

                    } else {
                        alert(r.msg);
                    }
                }
            });
        }
        ,
        del: function (event) {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: "../project/delete",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        }
        ,
        getInfo: function (id) {
            $.get("../project/info/" + id, function (r) {
                vm.project = r.project;
            });
            $.getJSON("../comment/list2?project="+id,function (r) {
                vm.comments = r.list;
            })
        }
        ,
        info: function (id) {
            if (isNaN(id)) {
                id
                    = getSelectedRow();
                if (id == null
                ) {
                    return;
                }
            }
            vm.showAdd = false;
            vm.showList = false;
            vm.showInfo = true;
            vm.title = "详情";


            vm.getInfo(id)
        }
        ,
        p:function(){
            vm.showPrint = true;
            vm.showList = false;
            vm.showInfo = false;

            setTimeout(function () {
                window.print();
            },200)

        },
        reload: function (event) {
            vm.showList = true;
            vm.showInfo = false;
            vm.showAdd = false;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: vm.q,
                page: page
            }).trigger("reloadGrid");
        }
    }
});