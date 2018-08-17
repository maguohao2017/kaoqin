var travel_add = {
    id: "managerTable",//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    deptid:0,
    init:function(){
        var defaultColunms = travel_add.initColumn();
        var table = new BSTable("managerTable", "/mgr/list", defaultColunms);
        table.setPaginationType("client");
        travel_add.table = table.init();
    },
    addSubmit:function(){
        var remark = $("#remark").val();
        var starttime = $("#starttime").val();
        var endtime = $("#endtime").val();
        var params = {};
        params.remark = remark;
        params.starttime = starttime;
        params.endtime = endtime;
        //提交信息
        var ajax = new $ax(Feng.ctxPath + "/travel/add_boss/"+JSON.stringify(params), function (data) {
            Feng.success("添加成功!");
            travel_add.close();
            window.parent.travel.table.refresh();
        }, function (data) {
            Feng.error("添加失败!");
        });
        // ajax.set("remark",remark);
        ajax.start();
    },
    /**
     * 关闭此对话框
     */
    close:function () {
        parent.layer.close(window.parent.travel.layerIndex);
    },
    /**
     * 初始化表格的列
     */
    initColumn:function () {
        var columns = [
            {field: 'selectItem', radio: true},
            {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
            {title: '姓名', field: 'name', align: 'center', valign: 'middle', sortable: true},
            {title: '性别', field: 'sexName', align: 'center', valign: 'middle', sortable: true},
            {title: '部门', field: 'deptName', align: 'center', valign: 'middle', sortable: true},
            {title: '邮箱', field: 'email', align: 'center', valign: 'middle', sortable: true},
            {title: '电话', field: 'phone', align: 'center', valign: 'middle', sortable: true},
            {title: '状态', field: 'statusName', align: 'center', valign: 'middle', sortable: true}];
        return columns;
    },

};
$(function(){
    travel_add.init();
});
