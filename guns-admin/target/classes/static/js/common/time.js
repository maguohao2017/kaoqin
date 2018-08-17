var time = {
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
}