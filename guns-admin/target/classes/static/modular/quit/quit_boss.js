var quit = {
    
    id: "quitTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,

    init:function(){
        quit.initTime();
        //初始化
        var defaultColunms = quit.initColumn();
        var table = new BSTable(quit.id, "/quit/list_boss", defaultColunms);
        table.setPaginationType("client");
        table.init();
        quit.table = table;
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

    check:function(){
        var selected = $('#' + this.id).bootstrapTable('getSelections');
        if (selected.length == 0) {
            Feng.info("请先选中表格中的某一记录！");
            return false;
        } else {
            quit.seItem = selected[0];
            return true;
        }
    },

    // add:function(){
    //     var index = layer.open({
    //         type: 2,
    //         title: '添加休假申请',
    //         area: ['800px', '360px'], //宽高
    //         fix: false, //不固定
    //         maxmin: true,
    //         content: Feng.ctxPath + '/quit/quit_add'
    //     });
    //     this.layerIndex = index;
    // },

    edit:function(){
        if (this.check()) {
            //提交信息
            var ajax = new $ax(Feng.ctxPath + "/quit/edit_boss/"+this.seItem.id, function (data) {
                Feng.success("审批成功!");
                quit.table.refresh();
                // UserInfoDlg.close();
            }, function (data) {
                Feng.error("审批失败!");
            });
            // ajax.set("remark",remark);
            ajax.start();
        }
    },

    delete:function(){
        if (this.check()) {
            var operation = function(){
                var id = quit.seItem.id;
                var ajax = new $ax(Feng.ctxPath + "/quit/delete_boss/"+id, function () {
                    Feng.success("删除成功!");
                    quit.table.refresh();
                }, function (data) {
                    Feng.error("删除失败!");
                });
                ajax.start();
            };

            Feng.confirm("是否删除?",operation);
        }
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
            {title: '修改时间', field: 'updatetime', align: 'center', valign: 'middle', sortable: true},
            {title: '状态', field: 'status', align: 'center', valign: 'middle', sortable: true}];
        return columns;
    },
};
$(function(){
    quit.init();
});
// quit.search = function () {
//     var queryData = {};
//
//     queryData['beginTime'] = $("#beginTime").val();
//     queryData['endTime'] = $("#endTime").val();
//
//     quit.table.refresh({query: queryData});
// }

setInterval(function() {
    $('#showTime').html(quit.initTime)
}, 1000);