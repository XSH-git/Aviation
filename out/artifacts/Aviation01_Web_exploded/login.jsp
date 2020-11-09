<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <base href="http://localhost:8080/Aviation01/">
    <link rel="stylesheet" type="text/css" href="css/form-data.css" />
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <style type="text/css">
        * {
            margin: 0px;
            padding: 0px;
        }
        /*input {*/
        /*    border: red;*/
        /*}*/
    </style>
    <script type="text/javascript">
        /*校验表单*/
        function toValidate() {

            var username = document.getElementById("username");  //原生js
            var password = document.getElementById("password");
            var repassword = document.getElementById("repassword");
            var mobile = document.getElementById("mobile");
            var email = document.getElementById("email");
            /*正则表达式校验*/
            // 138 8888 8888   ^匹配开头      $结尾        ^\d+$    //   \d 0-9数字  +多次匹配
            var mobilereg = /^1[3456789]\d{9}$/;  //  /d匹配数字 [0-9]   {9}匹配9位
            // qwe1234567 @ *****  .***  .***  .***      //^[a-zA-Z0-9] 匹配 大小写字母 数字  +匹配一次或多次
            var emailreg = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z0-9]+)+$/;

            var mobilereg1 = new RegExp("^1[3456789]\d{9}$");

            if (username.value == "" || username.value == null || username.value == undefined) {
                username.style.borderColor = "red";
                document.getElementById("usernamespan").innerHTML = "<font color='red'>用户名不能为空</font>";
                return false;
            }
            if (password.value == "" || password.value == null || password.value == undefined) {
                password.style.borderColor = "red";
                document.getElementById("passwordspan").innerHTML = "<font color='red'>密码不能为空</font>";
                return false;
            }
            return true;
        }
        // //原生js实现
        // window.onload = function() {
        //     var submitBtn = document.getElementById("submitBtn");
        //     submitBtn.onclick = function () {
        //         var username = document.getElementById("username");
        //         var password = document.getElementById("password");
        //         //校验
        //         if (username.value == "" || username.value == null || username.value == undefined) {
        //             username.style.borderColor = "red";
        //             document.getElementById("usernamespan").innerHTML = "<font color='red'>用户名不能为空</font>";
        //             return;
        //         }
        //         if (password.value == "" || password.value == null || password.value == undefined) {
        //             password.style.borderColor = "red";
        //             document.getElementById("passwordspan").innerHTML = "<font color='red'>密码不能为空</font>";
        //             return;
        //         }
        //
        //         //原生ajax  参数设定
        //         //1.实例化对象
        //         var xmlHttpRequest = new XMLHttpRequest();
        //         //2.open方法配置参数
        //         xmlHttpRequest.open("post", "loginUser", true);
        //         //3.设置回调函数
        //         xmlHttpRequest.onreadystatechange = function () {
        //             if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
        //
        //             }
        //         }
        //         //4.发送请求
        //         xmlHttpRequest.send();
        //     }
        // }

        // //jquery实现
        // $(function () {
        //     $("#submitBtn").click(function () {
        //         var username = $("#username");  //jquery
        //         var password = $("#password");
        //         var vcode = $("#vcode");
        //
        //         //校验
        //         if (username.val() == "" || username.val() == null || username == undefined) {
        //             username.css("border-color", "red");
        //             $("#usernamespan").html("<font color='red'>用户名不能为空</font>");
        //             return false;
        //         }
        //         if (password.val() == "" || password.val() == null || password == undefined) {
        //             password.css("border-color", "red");
        //             $("#passwordspan").html("<font color='red'>密码不能为空</font>");
        //             return false;
        //         }
        //         if (vcode.val() == "" || vcode.val() == null || vcode == undefined) {
        //             vcode.css("border-color", "red");
        //             $("#vcodespan").html("<font color='red'>验证码不能为空</font>");
        //             return false;
        //         }
        //         // 200  404  500  502  504
        //         $.ajax({
        //             type:"post",
        //             url:"loginUser",
        //             data:{"username":username.val(), "password":password.val(), "vcode":vcode.val()},
        //             // dataType:"json",   //规定服务器返回的参数类型是json  分析
        //             // json字符串（String 格式 json）   json对象（Object）
        //             success:function (data) {   // String  格式：json     == jsonStr
        //                 var jsonObj = JSON.parse(data);   //jsonStr --> jsonObj
        //                 if (jsonObj.code == "200") {
        //                     window.location.href = "index.jsp";//跳页面
        //                     return;
        //                 }
        //                 if (jsonObj.code == "500") {
        //                     $("#loginTable").append('<tr><td colspan="3"><font color="red">' + jsonObj.msg + '</font></td></tr>');
        //                 }
        //             }
        //         });
        //     })
        // })
    </script>
</head>
<body>
<div class="form-data">
<%--    <form method="post" action="loginUser" onsubmit="return toValidate()">--%>
<%--        <table id="loginTable">--%>
<%--            <tr>--%>
<%--                <td>用户名：</td>--%>
<%--                <td colspan="2"><input id="username" type="text" name="username" placeholder="请输入用户名"><span id="usernamespan"></span></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>密码：</td>--%>
<%--                <td colspan="2"><input id="password" type="password" name="password" placeholder="请输入密码"><span id="passwordspan"></span></td>--%>
<%--            </tr>--%>
<%--&lt;%&ndash;            <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <td>验证码：</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <td><img src="com/yg/sevlet/AuthImage"></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <td><input style="width: 90px;" id="vcode" type="text" name="vcode" placeholder="验证码"/><span id="vcodespan"></span></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </tr>&ndash;%&gt;--%>
<%--            <tr>--%>
<%--                <td colspan="3" align="center"><input id="submitBtn" type="button" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td colspan="3"><font color="red">${requestScope.msg}</font></td>--%>
<%--            </tr>--%>

<%--        </table>--%>
<%--    </form>--%>
    <form class="sui-form" action="loginUser" method="post">
        <div class="input-prepend"><span class="add-on loginname"></span>
            <input  type="text" name="username" placeholder="邮箱/用户名/手机号" class="span2 input-xfat">
        </div>
        <div class="input-prepend"><span class="add-on loginpwd"></span>
            <input type="password" name="password" placeholder="请输入密码" class="span2 input-xfat">
        </div>
        <div class="setting">
            <label class="checkbox inline"><input name="m1" type="checkbox" value="2" checked="">自动登录</label>
            <span class="forget">忘记密码？</span>
        </div>
        <div class="logined">
            <button class="sui-btn btn-block btn-xlarge btn-danger" type="submit">登&nbsp;&nbsp;录</button>
        </div>
    </form>
</div>
</body>
</html>
