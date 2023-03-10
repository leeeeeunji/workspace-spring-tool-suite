/*
*
*/
import {ajaxRequest} from './request.js';
function guestService(method, url, params) {
		//ajax요청
		let returnJsonResult = {};
		ajaxRequest(method, 
					url, 
					function(jsonResult) {
						console.log(jsonResult);
					}, 
					params,
					false);
		
	return returnJsonResult;
}
export{guestService}