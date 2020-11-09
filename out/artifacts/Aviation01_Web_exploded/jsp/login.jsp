<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <base href="http://localhost:8080/ProjectDemo/">
<%--    ${pageContext.request.contextPath}--%>
    <link rel="stylesheet" type="text/css" href="css/form-data.css" />
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <style type="text/css">
        * {
            margin: 0px;
            padding: 0px;
        }
        /*input{*/
        /*    border: red;*/
        /*}*/
    </style>
    <script type="text/javascript">

        $(function () {
            $("#submitBtn").click(function () {
                var username = $("#username");
                var password = $("#password");
                var vcode = $("#vcode");

                if(username.val() == "" || username.val() == null || username.val() == undefined){
                    username.css("border-color","red");
                    $("#usernamespan").html("<font color='red'>用户名不能为空</font>") ;
                    return false;
                }

                if(password.val() == "" || password.val() == null || password.val() == undefined){
                    password.css("border-color","red");
                    $("#passwordspan").html("<font color='red'>密码不能为空</font>");
                    return false;
                }
                if(vcode.val() == "" || vcode.val() == null || vcode.val() == undefined){
                    vcode.css("border-color","red");
                    $("#vcodespan").html("<font color='red'>验证码不能为空</font>") ;
                    return false;
                }
                //执行一个ajax请求
                $.ajax({
                    //设定参数
                    type:"post",
                    url:"LoginServlet",
                    data:{"username": username.val(),"password": password.val(),"vcode":vcode.val()},
                    // dataType:"json",
                    success:function (data){
                        // console.log(data);
                        var  jsonObj= JSON.parse(data);  //jsonStr---->jsonObj
                        // alert(jsonObj.code);

                        //这里有错，第一个if的code为200，第二个if的为50

                        if (jsonObj.code =="200"){
                            // alert("success");
                            window.location.href = "index.jsp";
                            return;
                        }
                        if (jsonObj.code == "500"){
                            //提示信息放在提交的下面，新建一行
                            //append插入元素
                            $("#loginTable").append('<tr><td colspan="3"><font color="red"> ' + jsonObj.msg + '</font></td></tr>');
                        }
                    }
                });


            })
        })
        //jquery实现
        // $(function () {
        //     $("#submitBtn").click(function () {
        //         var username = $("#username");
        //         var password = $("#password");
        //         var vcode = $("#vcode");
        //
        //         // var user = {
        //         //     username: $("#username").val(),
        //         //     password: $("#password").val(),
        //         //     vcode:$("#vcode").val()
        //         // };
        //         //校验
        //         if(username.val() == "" || username.val() == null || username.val() == undefined){
        //             username.css("border-color","red");
        //             $("#usernamespan").html("<font color='red'>用户名不能为空</font>") ;
        //             return false;
        //         }
        //
        //         if(password.val() == "" || password.val() == null || password.val() == undefined){
        //             password.css("border-color","red");
        //             $("#passwordspan").html("<font color='red'>密码不能为空</font>");
        //             return false;
        //         }
        //         if(vcode.val() == "" || vcode.val() == null || vcode.val() == undefined){
        //             vcode.css("border-color","red");
        //             $("#vcodespan").html("<font color='red'>验证码不能为空</font>") ;
        //             return false;
        //         }
        //         $.ajax({
        //             type:"POST",
        //             url:"LoginServlet",
        //             date:{username:username.val() ,"password":password.val(), "vcode":vcode.val()},
        //
        //             // data:{user},
        //
        //             dateType:"json", //规定服务器返回的参数类型是json
        //             success:function (data) {  //data----服务器响应的参数
        //                 //对data的值进行处理
        //                 var  jsonObj= JSON.parse(data);  //jsonStr---->jsonObj
        //                 // window.alert(jsonObj.code);
        //
        //                 //这里有错，第一个if的code为200，第二个if的为500
        //
        //                 alert(data);
        //
        //                 if (jsonObj.code =="200"){
        //                     window.location.href = "/ProjectDemo/index.jsp";
        //                     return;
        //                 }
        //                 if (jsonObj.code == "500"){
        //                     //提示信息放在提交的下面，新建一行
        //                     //append插入元素
        //
        //                     window.alert(username.val());
        //                     $("#loginTable").append('<tr><td colspan="3"><font color="red"> ' + jsonObj.msg + '</font></td></tr>');
        //                 }
        //             }
        //         });
        //
        //     })
        // })
    </script>
</head>
<body>
<div class="form-data">
    <form>
        <table id="loginTable">
            <tr>
                <td>用户名：</td>
                <td><input id="username" type="text" name="username" placeholder="请输入用户名">
                    <span id="usernamespan"></span>
                </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input id="password" type="password" name="password" placeholder="请输入密码">
                    <span id="passwordspan"></span>
                </td>
            </tr>
            <tr>
                <td>验证码：</td>
                <td><img src="/ProjectDemo/AuthImage"></td>
                <td><input style="width: 85px" id="vcode" type="text" name="vcode" placeholder="验证码"/>
                    <span id="vcodespan"></span>
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center">
                    <input id="submitBtn" type="button" value="提交">
                    <input type="reset" value="重置">
                </td>
            </tr>
            <tr>
                <td colspan="3"><font color="red">${requestScope.msg}</font> </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
