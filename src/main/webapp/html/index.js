var findPatientListUrl = "/spring/patient/findPatientList.do";
$(function () {
    //获取病人信息列表
    queryList();

    var arr = [
        {"Id":2,"Pid":0,"Resource":"","Operator":"","Description":"开机泡泡",
            "children":
                [{"Id":4,"Pid":2,"Resource":"http://www","Operator":"access","Description":"开机常规设置","title":"开机常规设置","checked":true},
                    {"Id":5,"Pid":2,"Resource":"button1","Operator":"disable","Description":"button1不可显示","title":"button1不可显示","checked":true}
                ],
            "title":"开机泡泡","checked":true,"nodeKey":2},
        {"Id":4,"Pid":2,"Resource":"http://www","Operator":"access","Description":"开机常规设置","title":"开机常规设置","checked":true},
        {"Id":5,"Pid":2,"Resource":"button1","Operator":"disable","Description":"button1不可显示","title":"button1不可显示","checked":true}];
    var str = "";
    str = getStr(arr,str);
    function getStr(arr,str) {
        for(var i = 0; i < arr.length; i ++){
            if(arr[i]['children'] && arr[i]['children'].length > 0){
                var arr2 = arr[i]['children'];
                str += getStr(arr2, str);
            }else{
                str += arr[i]['Id'] + ",";
            }
        }
        return str;
    }
    str = str.substring(0, str.length-1);
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
