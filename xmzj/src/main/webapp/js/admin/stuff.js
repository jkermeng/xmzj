$(function () {
	$("#jqGrid").jqGrid({
		url: '../stuff/showAll',
		datatype: "json",
		colModel: [{
				name: 's_id',
				index: 's_id',
				width: 0,
				hidden: true,
				key: true
			},
			{
				label: '材料名',
				name: 's_name',
				width: 75
			},
			{
				label: '用途',
				name: 's_where',
				width: 90
			},
			{
				label: '用法',
				name: 's_how',
				width: 100
			},
			{
				label: '好处',
				name: 's_good',
				width: 100
			},
			{
				label: '坏处',
				name: 's_bad',
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
});

var vm = new Vue({
	el: '#rrapp',
	data: {
		search: null,
		showInfo: false,
		showList: true,
		title: null,
		form: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function () {
			vm.showList = false;
			vm.title = "添加材料";
			vm.showInfo = false
		},
		update: function () {
			vm.showInfo = true
			var userId = getSelectedRow();
			if (userId == null) {
				return;
			}

			vm.showList = false;
			vm.title = "修改材料";

			vm.getUser(userId);
			//获取角色信息
			this.getRoleList();
		},
		del: function () {
			var userIds = getSelectedRows();
			if (userIds == null) {
				return;
			}
			let str = null
			ids.some(item => {
				str += str ? ',' + item : '' + item
			})
			confirm('确定要删除选中的记录？', function () {
				$.ajax({
					type: "GET",
					url: "../stuff/del",
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
			$.ajax({
				type: "GET",
				url: "../stuff/add",
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
		// 
		getUser: function (userId) {
			$.get("../stuff/detail?id=" + userId, function (r) {
				vm.form = r.detail;
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
					's_name': vm.search
				},
				page: page
			}).trigger("reloadGrid");
		}
	}
});