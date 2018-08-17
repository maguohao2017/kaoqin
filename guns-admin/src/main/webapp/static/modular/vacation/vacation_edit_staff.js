var vacation_edit = {
    init:function(){
        var remark = $("#edit_remark").text();
        var starttime = $("#edit_starttime").text();
        var endtime = $("#edit_endtime").text();
        $("#remark").val(remark);
        $("#starttime").val(starttime);
        $("#endtime").val(endtime);
    },
    editSubmit:function(){
        var remark = $("#remark").val();
        var id = $("#edit_id").text();
        var starttime = $("#starttime").val();
        var endtime = $("#endtime").val();
        var params = {};
        params.remark = remark;
        params.id = id;
        params.starttime = starttime;
        params.endtime = endtime;
        //提交信息
        var ajax = new $ax(Feng.ctxPath + "/vacation/edit_staff/"+JSON.stringify(params), function (data) {
            Feng.success("修改成功!");
            window.parent.vacation.table.refresh();
        }, function (data) {
            Feng.error("修改失败!");
        });
        // ajax.set("remark",remark);
        ajax.start();
    },
    /**
     * 关闭此对话框
     */
    close:function () {
        parent.layer.close(window.parent.vacation.layerIndex);
    },

};
$(function(){
    vacation_edit.init();
});
