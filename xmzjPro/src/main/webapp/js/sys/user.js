$(function () {
    $("#jqGrid").jqGrid({
        url: '../sys/user/list?type1=1',
        datatype: "json",
        colModel: [{
                name: 'userId',
                index: 'userId',
                width: 0,
                hidden: true,
                key: true
            },
            {
                label: '头像',
                name: 'img',
                width: 75,
                formatter: function (value, options, row) {
                    return "<img width='45' height='45' src='" + value + "'>"
                }
            },
            {
                label: '姓名',
                name: 'username',
                width: 75
            },
            {
                label: '性别',
                name: 'sex',
                width: 90
            },
            {
                label: '擅长领域',
                name: 'type',
                width: 100,
                formatter: function (value, options, row) {
                    vm.types.some(item => {
                        if (item.id === value) {
                            value = item.name
                            return true
                        }
                    })
                    return value
                }
            },
            {
                label: '个人介绍',
                name: 'content',
                width: 100
            },
            {
                label: '指导价格',
                name: 'price',
                width: 100
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
        q: {
            username: null
        },
        showList: true,
        title: null,
        roleList: {},
        types: [],
        userid: null,
        user: {
            status: 1,
            roleIdList: []
        }
    },
    created() {

        $.getJSON("../type/list2", function (r) {
            vm.types = r.list;
        })
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.roleList = {};
            vm.user = {
                status: 1,
                roleIdList: [1],
                type1: 1,
                img: ''
            };

            //获取角色信息
            this.getRoleList();
        },
        // 
        update: function () {
            var userId = getSelectedRow();
            if (userId == null) {
                return;
            }

            vm.showList = false;
            vm.title = "查看详情";

            vm.getUser(userId);
            //获取角色信息
            this.getRoleList();
            $.getJSON("../sys/user/info?_" + $.now(), (r) => {
                let data = {
                    sysuid: r.user.userId,
                    phuid: userId
                }
                $.ajax({
                    type: "GET",
                    url: "../prohis/addpro",
                    data,
                    success: function (r) {
                        res = JSON.parse(res)
                        if (r.code == 0) {
                            vm.reload();
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        collection() {
            let userId = getSelectedRow();
            if (userId == null) {
                return;
            }
            $.getJSON("../sys/user/info?_" + $.now(), (r) => {
                let data = {
                    c_userid: r.user.userId,
                    c_stuffid: userId
                }
                $.ajax({
                    type: "GET",
                    url: "../prohis/addcol",
                    data,
                    success: function (res) {
                        console.log(res);
                        res = JSON.parse(res)
                        if (res.code == 0) {
                            alert('操作成功', function (index) {
                                vm.reload();
                            });
                        } else {
                            alert(res.msg);
                        }
                    }
                });
            });
        },
        // 查看收藏
        showcollection() {
            $.getJSON("../sys/user/info?_" + $.now(), (r) => {
                $("#jqGrid").jqGrid('setGridParam', {
                    url: '../prohis/showAllcol?c_userid=' + r.user.userId
                }).trigger("reloadGrid");
            });

        },
        // 足迹
        footprint() {
            $.getJSON("../sys/user/info?_" + $.now(), (r) => {
                $("#jqGrid").jqGrid('setGridParam', {
                    url: '../prohis/showAllpro?phuid=' + r.user.userId
                }).trigger("reloadGrid");
            });
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
        getUser: function (userId) {
            $.get("../sys/user/info/" + userId, function (r) {
                vm.user = r.user;
            });
        },
        getRoleList: function () {
            $.get("../sys/role/select", function (r) {
                vm.roleList = r.list;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {
                    'username': vm.q.username
                },
                page: page
            }).trigger("reloadGrid");
        }
    }
});