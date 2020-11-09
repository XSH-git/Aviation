function checkUser() {
    var userName = document.getElementById("userId").value;
    var password = document.getElementById("pwdId").value;
    console.log(userName,password);
    if (userName==undefined||userName==null||userName==""){
        alert("用户名为空！！！");
        return;
    }
    if (password==undefined||password==null||password==""){
        alert("密码为空！！！");
        return;
    }
    document.forms[0].submit();
}