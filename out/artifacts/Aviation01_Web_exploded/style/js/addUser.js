function add(){
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
    var pwd = document.getElementById("pwd").value;
    var email = document.getElementById("email").value;
    var mobile = document.getElementById("mobile").value;
	var sex = document.getElementsByName("sex");
	var sexValue = "";
	var userType = document.getElementsByName("userType");
	var userTypeValue = "";
	
    console.log(userName,password,pwd,email,mobile);
	if (userName==undefined||userName==null||userName==""){
        alert("用户名为空！！！");
        return;
    }
	if (password==undefined||password==null||password==""){
        alert("密码为空！！！");
        return;
    }
	if (password!=pwd){
        alert("密码和确认密码不一致！！！");
        return;
    }
    if (email==undefined||email==null||email==""){
        alert("邮箱为空！！！");
        return;
    }
    if (mobile==undefined||mobile==null||mobile==""){
        alert("手机为空！！！");
        return;
    }
	for(i=0;i<sex.length;i++){
		if(sex[i].checked){
			sexValue = sex[i];
		}
	}
	for(i=0;i<userType.length;i++){
		if(userType[i].checked){
			userTypeValue = userType[i];
		}
	}
    
    document.forms[0].submit();
}