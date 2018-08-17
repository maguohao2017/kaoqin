var vacation_add = {
    init:function(){

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
        var ajax = new $ax(Feng.ctxPath + "/vacation/add_staff/"+JSON.stringify(params), function (data) {
            Feng.success("添加成功!");
            vacation_add.close();
            window.parent.vacation.table.refresh();
        }, function (data) {
            Feng.error("添加失败!");
        });
        // ajax.set("remark",remark);
        ajax.start();
    },
    /**
     * 关闭此对话框
     */
    close:function(){
        parent.layer.close(window.parent.vacation.layerIndex);
    },

};
$(function(){
    vacation_add.init();
});

