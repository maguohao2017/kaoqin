var quit_edit = {
    init:function(){
        var remark = $("#edit_remark").text();
        $("#remark").val(remark);
    },
    editSubmit:function(){
        var remark = $("#remark").val();
        var id = $("#edit_id").text();
        var params = {};
        params.remark = remark;
        params.id = id;
        //提交信息
        var ajax = new $ax(Feng.ctxPath + "/quit/edit_staff/"+JSON.stringify(params), function (data) {
            Feng.success("修改成功!");
            quit_edit.close();
            window.parent.quit.table.refresh();
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
        parent.layer.close(window.parent.quit.layerIndex);
    },

};
$(function(){
    quit_edit.init();
});
