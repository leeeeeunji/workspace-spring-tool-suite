window.jQuery = function(arg) {
	if(typeof arg == 'string') {
		/********************** selector ************************/
		let elementNodeList = document.querySelectorAll(arg);
		if(!elementNodeList) elementNodeList =[];
		let jqueryWrapperObject = {
			'elementNodeList' : elementNodeList,
			'css' : function(propertyName, propertyValue) {
				for(let i = 0; i < this.elementNodeList.length; i++) {
					this.elementNodeList[i].style.cssText += `${propertyName}:${propertyValue};`;
				}
				return this;
			},
			'text':function(textArg) {
				if(textArg == true) {
					//set text
					for(let i = 0; i < this.elementNodeList.length; i++) {
						//this.elementNodeList[i].innerHTML = textArg;
						this.elementNodeList[i].firstChild.nodeValue = textArg;
					}
					return this;
				}else if(textArg == undefined) {
					//get text
					let returnText="";
					for(let i = 0; i < this.elementNodeList.length; i++) {
						//this.elementNodeList[i].innerHTML = textArg;
						returnText += this.elementNodeList[i].firstChild.nodeValue = textArg;
					}
					return returnText;
				}
				
			}
		}
		return jqueryWrapperObject;	
	}else if(typeof arg == 'function') {
		/*
		인자로 대입된 함수를 DOM TREE 생성 직후에 호출되도록 
		window.onload 이벤트 프로퍼티에 등록
		*/
		window.addEventListener('load', arg);
	}else if(typeof arg == 'object') {
		/*
		표준객체(Element, document, window...)
		*/	
		let elementNodeList = [];
		elementNodeList.push(arg);
	}
	
}
/*************** jQuery global function *****************/
window.jQuery.each = function(array, funcArg) {
	for(let i = 0; i < array.length; i++) {
		funcArg(i, array[i]);
	}
}

window.$=window.jQuery;








