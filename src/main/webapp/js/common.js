$(function () {

    //初始化选择下拉框
    $("select[data-xtype='chosen']").chosen();

});
/***
 * 搜索框中的时间与时间段的关系
 * @param id 开始时间
 * @param id2 结束时间
 */
function dateSearch(id, id2){
    $(id).datetimepicker({
        format: 'yyyy-mm-dd HH:mm',
        language: 'zh-CN',
        autoclose:true,
    }).on("changeDate",function(e){
        var startTime = e.date;
        $(id2).datetimepicker('setStartDate',startTime);
    });
    $(id2).datetimepicker({
        format: 'yyyy-mm-dd HH:mm',
        language: 'zh-CN',autoclose:true,
    }).on("changeDate",function(e){
        var endTime = e.date;
        $(id).datetimepicker('setEndDate',endTime);
    });
}

window.ajaxIsloadingIndex = 0;
var str = '<div class="content-load no-select">' +
    '<div class="content-load-box">' +
    '<img src="../images/ajaxLoading.gif"/>' +
    '<h3 class="title">正在努力加载中。。。</h3>' +
    '</div>' +
    '</div>';
window.$(document).ajaxStart(function() {
    if (window.ajaxIsloadingIndex == 0) {
        window.top.$('body').append(str);
    }
    window.ajaxIsloadingIndex++;
});
window.$(document).ajaxStop(function() {
    window.ajaxIsloadingIndex--;
    if (window.ajaxIsloadingIndex == 0) {
        window.top.$('.content-load').fadeOut(function() {
            $(this).remove();
        });
    }
});
/**
 *
 * @param url 请求路径
 * @param data  请求数据
 * @param callback  回调函数
 */
window.POST = function(url, data, callback){
    var token= sessionStorage.getItem("token");
    window.$.ajax({
        url: url,
        data: data,
        type: "post",
        timeout: "60000",
        dataType: "json",
        headers: {
            token: token
        },
        // contentType: "application/json;charset=UTF-8",
        success: function(result){
            var result = result;
            if(result['errorCode'] !== 0){
                if((window.top.$(".modal.fade.in").length == 0 && $(".modal.fade.in").length == 0)){
                    window.top.$("#dialog-error .modal-title").html("报错信息");
                    window.top.$("#dialog-error .modal-body").html(result["msg"]);
                    window.top.$("#dialog-error").modal();
                }else{
                    if($(".modal.fade.in .modal-body").parents().hasClass("top")){
                        window.top.$(".modal.fade.in .modal-body").append("<div class='form-display error-info'>"+result["msg"]+"</div>");
                    }else{
                        $(".modal.fade.in .modal-body").append("<div class='form-display error-info'>"+result["msg"]+"</div>");
                    }
                }
                return;
            }

            typeof(callback) == "function" && callback(result);
        }
    }).fail(function(err,xhr){
        var msg = err['responseText'];
        if(msg.indexOf("errorCode: 1001") > 0 || msg.indexOf("errorCode: 1002") > 0){
            return window.top.location.href = "/spring/login.html?v=1.0.0"
        }
        if((window.top.$(".modal.fade.in").length == 0 && $(".modal.fade.in").length == 0)){
            window.top.$("#dialog-error .modal-title").html("报错信息");
            window.top.$("#dialog-error .modal-body").html(msg);
            window.top.$("#dialog-error").modal();
        }else{
            if($(".modal.fade.in .modal-body").parents().hasClass("top")){
                window.top.$(".modal.fade.in .modal-body").append("<div class='form-display error-info'>"+msg+"</div>");
            }else{
                $(".modal.fade.in .modal-body").append("<div class='form-display error-info'>"+msg+"</div>");
            }
        }
        // if(err){
        //     var responseText = err.responseText;
        //     if(responseText == "{result=100, data=null, message=token失效}"){
        //         return window.top.location.href="../login.html";
        //     }
        // }
        // window.ajaxIsloadingIndex = 0;
        // window.top.$('.content-load').fadeOut(function() {
        //     $(this).remove();
        // });
    });
};
/**
 * 展示错误信息
 * @param info
 * @param $el
 */
function fillErrorDetails(info, $el) {
    var str = '<div class="form-display error-info">'+ info +'</div>';
    $(str).appendTo($el);
}