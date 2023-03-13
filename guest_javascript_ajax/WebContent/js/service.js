/**
 * 
 */
//import {ajaxRequest} from './request.js';
function guestService(method,url,params){
	//ajax요청
	let returnJsonResult={};
	ajaxRequest(method,
				url,
				function(jsonResult){
					returnJsonResult=jsonResult;
				},
				params,
				false);
				
	return returnJsonResult;
}

function ajaxRequest(method,url,callbackFunction,params,async){
	let xhr=new XMLHttpRequest();
	url=(method=='GET'&& params!=null)?url+'?'+params:url;
	async= async ?async:false;
	xhr.onload=function(){
		callbackFunction(JSON.parse(xhr.responseText));
	}
	xhr.open(method,url,async);
	xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded')
	xhr.send(method=='POST'?params:null);
}
export{ guestService} 