function hello(name, funcArg) {
		document.write(">>> kQuery -> hello(name, funcArg)실행<br>");
		let msg = name + " 님 안녕하세요.<br>";
		funcArg(msg);
}
	
function forEach(array, userCallBackFunction) {
    	for(let i = 0; i < array.length; i++) {
    		userCallBackFunction(i, array[i]);
    	}
}