/* 定义函数*/
var carName="Volvo";//全局变量：页面销毁即销毁

function changeDiv(){
	carName="修改后的值";
	console.log(carName);	
	//document.getElementById("demo").innerHTML="新添加的内容";
	document.getElementByName("demo1").item(0).innerHTML="新添加的内容1111";
	var width=5;//js的数据类型只有var，弱类型语言
	height=10;
	var length=16;
	var person={ firstName:"john",   lastName:"Doe",    age:50};
	console.log("Hello console");//浏览器的内置对象
	console.log(person.firstName);
	var x="john";	
	var y = new String("john");
	console.log(x===y);//严格判断是否相等
	console.log(x==y);//判断内容是否相等
	console.log('123');
	if(true){
		
	}else{
		
	}
	var txt="";//初始化
	var person={fname:"John",lname:"Doe",age:25};//
	for(x in person){
		txt = txt + person[x];
	}
	console.log(txt);
}