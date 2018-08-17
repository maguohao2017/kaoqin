var check_time = {
    id: "checkTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    init:function(){
        this.initTime();
        //初始化
        var defaultColunms = check_time.initColumn();
        var table = new BSTable(check_time.id, "/checkTime/list", defaultColunms);
        table.setPaginationType("client");
        table.init();
        check_time.table = table;
    },
    initEvent:function(){

    },
    initTime:function(){
        var date = new Date();
        var hour = date.getHours();
        var minute = date.getMinutes();
        var seconds = date.getSeconds();
        var year = date.getFullYear();
        var month = date.getMonth()+1;
        var day = date.getDay();
        var str = "现在时间:"+year+"年"+month+"月"+day+"日"+hour+"时"+minute+"分"+seconds+"秒";
        return str;
    },
    openAddCheck:function(){
        var ajax = new $ax(Feng.ctxPath + "/checkTime/insertInfo", function (data) {
            Feng.success("打卡成功!");
            check_time.table.refresh();
        }, function (data) {
            Feng.error("打卡失败!");
        });
        ajax.start();
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

    openHistory:function(){
        var index = layer.open({
            type: 2,
            title: '历史打卡信息',
            area: ['600px', '550px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/checkTime/check_history_staff'
        });
        this.layerIndex = index;
    },

};
$(function(){
    check_time.init();
    check_time.initEvent();
});
setInterval(function() {
    $('#showTime').html(check_time.initTime)
}, 1000);