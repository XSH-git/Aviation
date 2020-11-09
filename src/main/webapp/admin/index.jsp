<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员主页</title>
<%--    <base href="http://localhost:8080/ProjectDemo/admin">--%>
    <link rel="stylesheet" href="../css/form-data.css"/>
    <script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
    <style type="text/css"></style>
    <script type="text/javascript">
        $(function () {
            //渲染数据
            function addData(users) {
                for (var i = 0; i < users.length; i++) {
                    $("#userTable").append('<tr class="data">' +
                        '<td>'+ users[i].username +'</td>' +   //users[i].id
                        '<td>'+ users[i].password +'</td>' +
                        '<td>'+ users[i].role +'</td>' +
                        '<td>'+ users[i].mobile +'</td>' +
                        '<td>'+ users[i].email +'</td>' +
                        '<td>'+ users[i].regtime +'</td>' +
                        '<td>'+ users[i].updatetime +'</td>' +
                        '<td>'+ users[i].deletetime +'</td>' +
                        '<td>'+ users[i].userstatus +'</td>' +
                        '<td><input userId="'+ users[i].id +'" class="updateBtn" type="button" value="更新"/></td>' +
                        '<td><input userId="'+ users[i].id +'" class="deleteBtn" type="button" value="删除"/></td>' +
                        '</tr>');
                }
            }
            //绑定更新按钮
            function updateBtn() {
                $(".updateBtn").click(function () {
                    var userId = $(this).attr("userId");
                    $.ajax({
                        type: "post",
                        url: "QueryUser",
                        data:{"userId": userId},
                        success:function (data) {
                            var jsonObj = JSON.parse(data);
                            // ajax负责页面跳转
                            if (jsonObj.code == "200") {
                                window.location.href = "editUser.jsp";
                            } else {
                                alert(jsonObj.msg);
                            }
                            //后台服务负责页面跳转
                            //js --》 数据绘制 --》 跳转
                            // alert(data);
                        }
                    });
                });
            }

            function deleteBtn() {
                $(".deleteBtn").click(function () {
                    var userId = $(this).attr("userId");
                    // alert("userId:" + userId);
                    $.ajax({
                        type: "post",
                        url: "DeleteUser",
                        data:{"userId": userId},
                        beforeSend:function(){
                            var del = confirm("确认是否删除？");
                            return del;
                        },
                        success:function (data) {
                            var jsonObj = JSON.parse(data);
                            alert(jsonObj.msg);
                        }
                    });
                });
            }


            /*$.ajax({
                type:"post",
                url:"QueryUsers", //服务器解析 /  web目录 --> http:../ProjectDemo/   //浏览器解析 /   http...localhost:8080/
                success:function (data) {//String  格式 JSON --> JSON对象
                    var jsonObj = JSON.parse(data); //转JSONObj
                    if (jsonObj.code == "200") {
                        var users = jsonObj.data; //List<User>   users[user]   user.username   users[i] == user
                        //渲染数据
                        addData(users);
                        //等待所有的按钮渲染完成，添加绑定时间      this --> 当前类
                        //更新   查询用户  跳转页面                                  js  - this -- 当前   jquery  $(this)
                        updateBtn();
                        //删除
                        deleteBtn();
                    } else { // 500 = code
                        $("#userTable").append('<tr class="data"><td colspan="11">' + jsonObj.msg + '</td></tr>');
                    }
                }
            });*/

            //进入页面直接调用一次
            queryUserLimit(1,2);

            function queryUserLimit(nowPageNo, nowPageSize) {
                $.ajax({
                    type:"post",
                    url:"QueryUsers",
                    data:{"pageNo":nowPageNo, "pageSize":nowPageSize},
                    success:function (data) {
                        var jsonObj = JSON.parse(data);
                        if (jsonObj.code == "200"){
                            $("#pageNo").attr("value", nowPageNo);
                            $(".data").remove();
                            var users = jsonObj.data;
                            //数据渲染
                            addData(users);
                            //绑定按钮
                            updateBtn();
                            deleteBtn();
                        } else {  //追加 append
                            $(".data").remove();
                            $("#userTable").append('<tr class="data"><td colspan="11">' + jsonObj.msg + '</td></tr>');
                        }
                    }
                });
            }
            //上一页
            $("#prePage").click(function () {
                //当前页码
                var pageNoStr = $("#pageNo").val();
                var pageNo = parseInt(pageNoStr);
                //当前页面大小
                var pageSizeStr = $("#pageSize").val();
                var pageSize = parseInt(pageSizeStr);

                queryUserLimit(pageNo-1, pageSize);
            });
            //下一页
            $("#nextPage").click(function () {
                //当前页码
                var pageNoStr = $("#pageNo").val();
                var pageNo = parseInt(pageNoStr);
                //当前页面大小
                var pageSizeStr = $("#pageSize").val();
                var pageSize = parseInt(pageSizeStr);

                queryUserLimit(pageNo+1, pageSize);

            });
        })
    </script>
</head>
<body>
<div class="form-data-admin">
    <table border="1px" id="userTable">
        <tr>
            <th colspan="11">
                <input id="prePage" type="button" value="上一页" />
                <span>
                    页码：
                    <input id="pageNo" type="text" name="pageNo" value="1"/>
                </span>
                <span>
                    条数：
                    <input id="pageSize" type="text" name="pageSize" value="2" />
                </span>
                <input id="nextPage" type="button" value="下一页" />
            </th>
        </tr>
        <tr>
            <th>用户名</th>
            <th>密码</th>
            <th>权限</th>
            <th>手机</th>
            <th>邮箱</th>
            <th>注册时间</th>
            <th>更新时间</th>
            <th>删除时间</th>
            <th>用户状态</th>
            <th colspan="2">操作</th>
        </tr>

    </table>
</div>
</body>
</html>
