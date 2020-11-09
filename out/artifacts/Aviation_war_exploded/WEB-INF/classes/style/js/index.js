function select() {
    var userName = document.getElementById("userName").value;
    console.log(userName);
/*    if (userName==undefined||userName==null||userName==""){
        alert("输入内容为空！！！");
        return;
    }*/
    document.forms[0].submit();
}