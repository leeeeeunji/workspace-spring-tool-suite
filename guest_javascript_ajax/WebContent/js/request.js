/*
* ajax 요청
*/
function ajaxRequest(method, url, callbackFunction, params, async) {
	let xhr = new XMLHttpRequest();
	
	url=(method == 'GET' && params !=null)?url + '?' + params:url;
	async=async ?async:false;
	
	xhr.onload = function() {
		callbackFunction(JSON.parse(xhr.responseText));
	}
	xhr.open(method, url, async);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send(method=='POST'?params:null);
}
export {ajaxRequest}
