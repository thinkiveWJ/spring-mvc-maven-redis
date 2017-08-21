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
    <script type="text/javascript" src="./js/jsEncrypt.js"></script>
    <script type="text/javascript" src="./js/security.js"></script>
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
        POST("/spring/RSA/getRSAPublicKey.do", {userName: "admin", password: "123"}, function (result) {
//            location.href='/spring/Test/returnSuccess';
            var data = result['data'];
            var modulus = data['modulus'], exponent = data['exponent'];
            var publicKey = RSAUtils.getKeyPair(exponent, '', modulus);
            var password = RSAUtils.encryptedString(publicKey, '123');
            POST("/spring/login/queryLogin.do",{userName: "admin",password: password}, function (result) {
            });
        });
    }


</script>
</body>
</html>
