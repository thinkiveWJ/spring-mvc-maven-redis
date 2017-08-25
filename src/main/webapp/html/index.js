var findPatientListUrl = "/spring/patient/findPatientList.do",
    addPatientInfoUrl = "/spring/patient/addPatientInfo.do";
$(function () {
    //获取病人信息列表
    queryList();
    //点击按钮
    bindBTN();
});
/**
 * 获取病人信息列表
 */
function queryList() {
    var data = {
        pageNum: 1,
        pageSize: 20
    };
    var dataJson = getData(data);
    POST(findPatientListUrl, dataJson, function (result) {
        console.log(result);
    });
}
/**
 * 获取入参信息
 */
function getData(data) {
    return data;
}
/**
 * 点击按钮
 */
function bindBTN() {
    //点击录入新增
    $("#addBTN").click(function () {
        clearAddPanel();
        $("#addPatientInfo").modal();
    });
    //点击录入
    $("#addPatientInfo .ok").unbind("click").bind("click", function () {
        $("#addPatientInfo .error-info").remove();
        var name = $("#addName").val(),
            idCard = $("#addIdCard").val(),
            temp = $("#addTemp").val(),
            sex = $("#addSex").data("chosen").selectedItem(),
            position = $('#addPosition').val();
        sex = sex ? sex['value'] : 0;
        // if(!name){
        //     fillErrorDetails("请输入姓名！", $("#addPatientInfo .modal-body"));
        //     return;
        // }
        // if(!idCard){
        //     fillErrorDetails("请输入身份证！", $("#addPatientInfo .modal-body"));
        //     return;
        // }
        // if(!temp){
        //     fillErrorDetails("请输入体温！", $("#addPatientInfo .modal-body"));
        //     return;
        // }
        // if(!(temp > 36 && temp < 43)){
        //     fillErrorDetails("请输入正确的体温！", $("#addPatientInfo .modal-body"));
        //     return;
        // }
        // if(!position){
        //     fillErrorDetails("请输入病房号！", $("#addPatientInfo .modal-body"));
        //     return;
        // }
        var data = {
            name: "wj",
            idCard: "123456789012345",
            temp: "37",
            sex: "1",
            position: "123"
        };
        POST(addPatientInfoUrl, data, function (result) {

        })
    });
}
/**
 * 清除输入面板
 */
function clearAddPanel() {
    $("#addPatientInfo .error-info").remove();
    $("#addPatientInfo input").val("");
    $("#addPatientInfo select[data-xtype='chosen']").each(function () {
        $(this).data("chosen").selectedItem("");
    });
}