var quit_add = {

    init:function(){

    },

    addSubmit:function(){

        var remark = $("#remark").val();
        //提交信息
        var ajax = new $ax(Feng.ctxPath + "/quit/add_staff/"+remark, function (data) {
            Feng.success("添加成功!");
            quit_add.close();
            window.parent.quit.table.refresh();
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
        parent.layer.close(window.parent.quit.layerIndex);
    },

};
$(function(){
    quit_add.init();
});

