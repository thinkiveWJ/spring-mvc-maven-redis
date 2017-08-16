<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./style/base.css?v=1.0.0" charset="UTF-8">
    <link rel="stylesheet" href="./style/bootstrap.css?v=1.0.0" charset="UTF-8">
    <link rel="stylesheet" href="./style/bootstrap-datepicker.css?v=1.0.0" charset="UTF-8">
    <link rel="stylesheet" href="./style/bootstrap-datetimepicker.css?v=1.0.0" charset="UTF-8">
    <link rel="stylesheet" href="./style/ui.chosen.css?v=1.0.0" charset="UTF-8">
    <script type="text/javascript" src="./js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="./js/common.js?v=1.0.0"></script>
    <script type="text/javascript" src="./js/bootstrap.js?v=1.0.0"></script>
    <script type="text/javascript" src="./js/bootstrap-paginator.js"></script>
    <script type="text/javascript" src="./js/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src="./js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="./js/bootstrap-datetimepicker.zh-CN.js"></script>
    <script type="text/javascript" src="./js/highcharts.js"></script>
    <script type="text/javascript" src="./js/ui.chosen.js"></script>
    <!--[if lt IE 9]>
    <script src="./js/html5shiv.min.js?v=2.2.0"></script>
    <script src="./js/respond.min.js?v=2.2.0"></script>
    <![endif]-->
    <title>spring maven测试首页</title>
</head>
<body>

<h2>Hello World!2</h2>
<form id="userForm" method="post">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="">
    <button type="button" onclick="login()">登录</button>
</form>
<script>
    function login() {
        POST("/spring/patient/findPatientList.do", {pageNum: 2, pageSize: 1}, function (result) {
            location.href='/spring/Test/returnSuccess';
        });
    }
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
</script>
</body>
</html>
