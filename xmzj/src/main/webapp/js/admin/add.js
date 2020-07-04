var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            name: ''
        },
        showAdd: false,
        showInfo: false,
        showList: true,
        title: null,
        user: {},
        users: [],

        pro: "",

        types: [],

        pros: [],

        project: {},
    },
    watch: {
        "pro": function (r) {
            vm.project.price = r.price;
            vm.project.pro = r.userId;
        }
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
        $.getJSON("../sys/user/list2?type1=1", function (r) {
            vm.pros = r.list;
        })
        this.showAdd = true;
        this.showList = false;
        this.title = "上传项目";
        this.project = {
            price: '',
            pro: ''
        };
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showAdd = true;
            vm.showList = false;
            vm.title = "新增";
            vm.project = {};
        },
        update: function (event) {
            var id =
                getSelectedRow();
            if (id == null) {
                return;
            }

            vm.showAdd = true;
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        },
        saveOrUpdate: function (pay) {
            vm.project.pay = pay;
            vm.project.state = "未指导";
            var url = vm
                .project.id ==
                null ? "../project/save" : "../project/update";
            $.ajax({
                type: "POST",
                url: url,
                data: JSON.stringify(vm.project),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            location.reload()
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
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
        },
        getInfo: function (id) {
            $.get("../project/info/" + id, function (r) {
                vm.project = r.project;
            });
        },
        info: function (id) {
            if (isNaN(id)) {
                id
                    = getSelectedRow();
                if (id == null) {
                    return;
                }
            }
            vm.showAdd = false;
            vm.showList = false;
            vm.showInfo = true;
            vm.title = "详情";

            vm.getInfo(id)
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