$(function () {
	$("#jqGrid").jqGrid({
		url: '../sys/user/list',
		datatype: "json",
		colModel: [{
				name: 'userId',
				index: 'userId',
				width: 0,
				hidden: true,
				key: true
			},
			{
				label: '用户名',
				name: 'username',
				width: 75
			},
			{
				label: '邮箱',
				name: 'email',
				width: 90
			},
			{
				label: '手机号',
				name: 'mobile',
				width: 100
			},
			{
				label: '状态',
				name: 'status',
				width: 80,
				formatter: function (value, options, row) {
					return value === 0 ?
						'<span class="label label-danger">禁用</span>' :
						'<span class="label label-success">正常</span>';
				}
			},
			{
				label: '创建时间',
				name: 'createTime',
				index: "create_time",
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
});

var vm = new Vue({
	el: '#rrapp',
	data: {
		q: {
			username: null
		},
		showList: true,
		showInfo: false,
		title: null,
		roleList: {},
		userInfo: {
			ud_achievement: "未填写",
			ud_college: "未填写",
			ud_company_name: "未填写",
			ud_education: "未填写",
			ud_email: "未填写",
			ud_field: "未填写",
			ud_id: 1,
			ud_imgurl: null,
			ud_job: "未填写",
			ud_jobyear: 5,
			ud_phone: "未填写",
			ud_rname: "未填写",
			ud_sex: 1,
			ud_status: 1,
			ud_teamname: "未填写",
		},
		user: {
			status: 1,
			roleIdList: []
		},
		roleId: null

	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function () {
			vm.showList = false;
			vm.showInfo = false
			vm.title = "新增";
			vm.roleList = {};
			vm.user = {
				status: 1,
				roleIdList: [1],
				type1: 3
			};

			//获取角色信息
			this.getRoleList();
		},
		update: function () {
			var userId = getSelectedRow();
			if (userId == null) {
				return;
			}
			vm.showInfo = false
			vm.showList = false;
			vm.title = "修改";

			vm.getUser(userId);
			//获取角色信息
			this.getRoleList();
		},
		// 详情
		info() {
			vm.showInfo = true
			var userId = getSelectedRow();
			if (userId == null) {
				return;
			}
			let data = {
				id: userId
			}
			vm.getUser(userId);
			$.ajax({
				type: "GET",
				url: "../udetail/detail",
				data,
				success: function (r) {
					if (r.code == 0) {

						vm.userInfo = r.detail

					} else {
						alert(r.msg);
					}
				}
			});
			layer.open({
				type: 1,
				skin: 'layui-layer-molv',
				title: "完整信息",
				area: ['650px', '500px'],
				shadeClose: false,
				content: jQuery("#userinfoLayer"),
				btn: ['修改', '取消'],
				btn1: function (index) {
					var formData = new FormData(vm.userInfo);
					formData.append("file", document.getElementById('upload').files[0]);
					$.ajax({
						type: "POST",
						url: "udetail/detail",
						data: formData,
						contentType: "application/json",
						dataType: "json",
						success: function (result) {
							if (result.code == 0) {
								layer.close(index);
								layer.alert('修改成功');
							} else {
								layer.alert(result.msg);
							}
						}
					});
				}
			});
		},
		// 权限
		role() {
			var userId = getSelectedRow();
			if (userId == null) {
				return;
			}
			//获取角色信息
			this.getRoleList();
			const than = this
			layer.open({
				type: 1,
				skin: 'layui-layer-molv',
				title: "修改权限",
				area: ['650px', '500px'],
				shadeClose: false,
				content: jQuery("#roleLayer"),
				btn: ['修改', '取消'],
				btn1: function (index) {
					const data = {
						userId,
						roleId: than.roleId
					}
					$.ajax({
						type: "GET",
						url: "../udetail/updateRole",
						data,
						success: function (result) {
							if (result.code == 0) {
								layer.close(index);
								layer.alert('修改成功');
							} else {
								layer.alert(result.msg);
							}
						}
					});
				}
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
				console.log(vm.user);

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