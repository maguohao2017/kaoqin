var check_history = {
    id: "checkHistoryTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    init:function(){
        //初始化
        var defaultColunms = check_history.initColumn();
        var table = new BSTable(check_history.id, "/checkTime/history_list", defaultColunms);
        table.setPaginationType("client");
        table.init();
        check_history.table = table;
    },
    initEvent:function(){
    },

    initColumn:function(){
        var columns = [
            {field: 'selectItem', radio: true},
            {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
            {title: '账号', field: 'account', align: 'center', valign: 'middle', sortable: true},
            {title: '姓名', field: 'userName', align: 'center', valign: 'middle', sortable: true},
            {title: '性别', field: 'sex', align: 'center', valign: 'middle', sortable: true},
            {title: '部门', field: 'deptName', align: 'center', valign: 'middle', sortable: true},
            {title: '邮箱', field: 'email', align: 'center', valign: 'middle', sortable: true},
            {title: '电话', field: 'phone', align: 'center', valign: 'middle', sortable: true},
            {title: '打卡时间', field: 'checktime', align: 'center', valign: 'middle', sortable: true},
            {title: '状态', field: 'status', align: 'center', valign: 'middle', sortable: true}];
        return columns;
    },
};
$(function(){
    check_history.init();
    check_history.initEvent();
});