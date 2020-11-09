<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新用户</title>
    <link rel="stylesheet" href="../css/form-data.css">
    <script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
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
    </script>
</head>
<body>
<div class="form-data">
    <form method="post" action="EditUser" onsubmit="return toValidate()">
        <table>
            <tr>
                <td>用户编码：</td>
                <td><input type="text" name="userId" readonly="readonly" value="${sessionScope.user.id}"></td>
            </tr>
            <tr>
                <td>用户名：</td>
                <td><input id="username" type="text" name="username" value="${sessionScope.user.username}"/><span id="usernamespan"></span></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input id="password" type="password" name="password" value="${sessionScope.user.password}" /><span id="passwordspan"></span></td>
            </tr>
            <tr>
                <td>确认密码：</td>                              <%-- 键 =  值   /  repassword = value --%>
                <td><input id="repassword" type="password" name="repassword" value="${sessionScope.user.password}" /><span id="repasswordspan"></span></td>
            </tr>
            <tr>
                <td>权限：</td>                              <%-- 键 =  值   /  repassword = value --%>
                <td>   <%--${sessionScope.user.role==1? "checked='checked'" : ""}--%>     <%--四大作用域 page- req -sess -apl --%>
                    <input id="role" type="radio" name="role" value="1" ${sessionScope.user.role==1? "checked='checked'" : ""} />管理员
                    <input type="radio" name="role" value="2" ${sessionScope.user.role==2? "checked='checked'" : ""} />普通用户
                </td>
            </tr>
            <tr>
                <td>手机号：</td>
                <td><input id="mobile" type="text" name="mobile" value="${sessionScope.user.mobile}"/><span id="mobilespan"></span></td>
            </tr>
            <tr>
                <td>邮箱：</td>
                <td><input id="email" type="text" name="email" value="${sessionScope.user.email}"/><span id="emailspan"></span></td>
            </tr>
            <tr>
                <td>注册时间：</td>
                <td><input type="text" name="regtime" readonly="readonly" value="${sessionScope.user.regtime}"></td>
            </tr>
            <tr>
                <td>更新时间：</td>
                <td><input type="text" name="updatetime" readonly="readonly" value="${sessionScope.user.updatetime}"></td>
            </tr>
            <tr>
                <td>删除时间：</td>
                <td><input type="text" name="regtime" readonly="readonly" value="${sessionScope.user.deletetime}"></td>
            </tr>
            <tr>
                <td>用户状态：</td>
                <td>
                    <input id="userstatus" type="radio" name="userstatus" value="1" ${sessionScope.user.userstatus==1?"checked='checked'":""} />正常
                    <input type="radio" name="userstatus" value="2" ${sessionScope.user.userstatus==2?"checked='checked'":""}/>删除
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
