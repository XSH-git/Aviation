<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="icon" href="" />
    <link rel="stylesheet" type="text/css" href="css/form-data.css" />
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <style type="text/css">
        /* *代表所有。设置外边距和内边距都为0px  */
        * {
            margin: 0px;
            padding: 0px;
        }
        /* 表单div */
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
                document.getElementById("passwordspan").innerHTML = "<font color='red'>用户名不能为空</font>";
                return false;
            }
            if (repassword.value == "" || repassword.value == null || repassword.value == undefined) {
                repassword.style.borderColor = "red";
                document.getElementById("repasswordspan").innerHTML = "<font color='red'>用户名不能为空</font>";
                return false;
            }
            if (password.value != repassword.value) {
                password.style.borderColor = "red";
                repassword.style.borderColor = "red";
                document.getElementById("repasswordspan").innerHTML = "<font color='red'>两次密码不一致</font>";
                return false;
            }

            if (mobile.value != "" && !mobilereg.test(mobile.value)) {
                mobile.style.borderColor = "red";
                document.getElementById("mobilespan").innerHTML = "<font color='red'>手机格式不正确</font>";
                return false
            }

            if (email.value != "" && !emailreg.test(email.value)) {
                email.style.borderColor = "red";
                document.getElementById("emailspan").innerHTML = "<font color='red'>邮箱格式不正确</font>";
                return false
            }
            return true;
        }

        /*第三次 是在页面加载完成后*/
        // window.onload = function() {
        //     var username3 = document.getElementById("username").value;
        //     alert("3username:" + username3);
        // }

        // $(function () {
        //
        // })
    </script>
</head>
<body>
<div class="form-data">
    <form method="post" action="registerUser" onsubmit="return toValidate()">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input id="username" type="text" name="username" placeholder="请输入用户名，不可为空。"/><span id="usernamespan"></span></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input id="password" type="password" name="password" placeholder="请输入密码，不可为空" /><span id="passwordspan"></span></td>
            </tr>
            <tr>
                <td>确认密码：</td>                              <%-- 键 =  值   /  repassword = value --%>
                <td><input id="repassword" type="password" name="repassword" placeholder="请再次输入密码，不可为空" /><span id="repasswordspan"></span></td>
            </tr>
            <tr>
                <td>手机号：</td>
                <td><input id="mobile" type="text" name="mobile" placeholder="请输入手机号"/><span id="mobilespan"></span></td>
            </tr>
            <tr>
                <td>邮箱：</td>
                <td><input id="email" type="text" name="email" placeholder="请输入邮箱"/><span id="emailspan"></span></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"></td>
            </tr>
            <tr>
                <td colspan="2"><font color="red">${requestScope.msg}</font></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
