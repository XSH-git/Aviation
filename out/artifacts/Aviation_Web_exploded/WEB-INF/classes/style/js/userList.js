/*新增按钮*/
function addbtn(){
	window.location.href="addUser.jsp";
}
/*编辑按钮*/
function editUser(userId){
	window.location.href="EditUserServlet?id="+userId;
}
/*删除按钮*/
function del(id){
	var flag = confirm("确认删除？");
	if(flag){
		window.location.href="DelUserServlet?id="+id;
	}
}