import *  as View from "./view.js";
import * as Request from "./request.js";
import * as ResponseStatusCode from "./response_status_code.js";
import * as ResponseMessage from "./response_message.js";

/************* validator기본설정************ */
/*################################################################################*/
/*##############################메뉴객체이벤트등록################################
   메뉴객체이벤트등록
	#menu_user_login_form
	#menu_user_write_form
	#menu_user_logout_action
	#menu_user_view
	
	#btn_user_write_form
	#btn_user_write_action
	#btn_user_login_action
	#btn_user_modify_form_action
	#btn_user_delete_action
	
	<<< template id >>>>>>>>
	#user-main-template
	#user-write-form-template
	#user-view-template
	#user-modify-form-template
	#user-login-form-template
*/ 
/****user home******/
$('#menu_user_main').click(function(e){
	console.log(e.target);
	View.render("#user-main-template");
	e.preventDefault();
});
$(document).on('click','#menu_user_write_form,#btn_user_write_form',function(e){
	console.log(e.target);
	View.render("#user-write-form-template");
	e.preventDefault();
});

$('#menu_user_login_form').click(function(e){
	console.log(e.target);
	View.render("#user-login-form-template");
	e.preventDefault();
});

$(document).on('click','#btn_user_write_action',function(e){
		let sendData={
			userId:document.f.userId.value,
			password:document.f.password.value,
			name:document.f.name.value,
			email:document.f.email.value,
		};
		Request.ajaxRequest('user',
							'POST',
							'application/json;charset=UTF-8',
							JSON.stringify(sendData),
							function(resultJson){
								console.log(resultJson);
								if(resultJson.status==ResponseStatusCode.EXISTED_USER){
								   View.render('#user-write-form-template',resultJson);
								   $("#user_write_form input[name='userId']").select();	
								}else if(resultJson.status==ResponseStatusCode.CREATED_USER){
								    View.render("#user-login-form-template");
								}
							},
							true);
		e.preventDefault();
		
});
$(document).on('click','#btn_user_login_action',function(e){
		let sendData={
			userId:document.f.userId.value,
			password:document.f.password.value,
			name:'',
			email:'',
		};
		Request.ajaxRequest('user/login',
							'POST',
							'application/json;charset=UTF-8',
							JSON.stringify(sendData),
							function(resultJson){
								console.log(resultJson);
								if(resultJson.status==ResponseStatusCode.LOGIN_FAIL_NOT_FOUND_USER){
								   View.render('#user-login-form-template',resultJson);
								   $("#user_login_form input[name='userId']").select();	
								}else if(resultJson.status==ResponseStatusCode.LOGIN_FAIL_PASSWORD_MISMATCH_USER){
								   View.render('#user-login-form-template',resultJson);
								   $("#user_login_form input[name='password']").select();	
								}else if(resultJson.status==ResponseStatusCode.LOGIN_SUCCESS){
								    //View.render('#user-main-template',resultJson);	
								    location.href='user';
								}
							},
							true);
		e.preventDefault();
		
});

$(document).on('click','#menu_user_logout_action',function(e){
		console.log(e.target);
		let sendData={};
		Request.ajaxRequest('user/logout',
							'GET',
							'application/json;charset=UTF-8',
							 null,
							function(resultJson){
								if(resultJson.status==ResponseStatusCode.LOGOUT_USER){
								   //alert(resultJson.message);
								   location.href='user';
								}else{
									alert(resultJson.message);
								}
							},
							true);
						
		e.preventDefault();
		
});
$(document).on('click','#menu_user_view',function(e){		
		let sendData={};
		let sUserId =document.user_main_form.userId.value;
		Request.ajaxRequest(`user/${sUserId}`,
							'GET',
							'application/json;charset=UTF-8',
							 null,
							function(resultJson){
								if(resultJson.status==ResponseStatusCode.READ_USER){
									console.log(resultJson);
								   View.render('#user-view-template',resultJson);
								  
								}else{
									alert(resultJson.message);
								}
							},
							true);
						
		e.preventDefault();
		
});

$(document).on('click','#btn_user_modify_form',function(e){
		
		let sendData={};
		let sUserId =document.user_main_form.userId.value;
		Request.ajaxRequest(`user/${sUserId}`,
							'GET',
							'application/json;charset=UTF-8',
							 null,
							function(resultJson){
								if(resultJson.status==ResponseStatusCode.READ_USER){
								   View.render('#user-modify-form-template',resultJson);
								   //alert(resultJson.message);
								}else{
									alert(resultJson.message);
								}
							},
							true);
		e.preventDefault();
		
});

$(document).on('click','#btn_user_modify_action',function(e){
		let sendData={
			userId:document.f.userId.value,
			password:document.f.password.value,
			name:document.f.name.value,
			email:document.f.email.value,
		};
		Request.ajaxRequest(`user/${document.f.userId.value}`,
							'PUT',
							'application/json;charset=UTF-8',
							JSON.stringify(sendData),
							function(resultJson){
								console.log(resultJson);
								if(resultJson.status==ResponseStatusCode.UPDATE_USER){
								   View.render('#user-view-template',resultJson);
								}else{
								   alert(resultJson.message);
								}
							},
							true);
		e.preventDefault();
		
});

$(document).on('click','#btn_user_delete_action',function(e){
		let sendData={};
		Request.ajaxRequest(`user/${document.f.userId.value}`,
							'DELETE',
							'application/json;charset=UTF-8',
							JSON.stringify(sendData),
							function(resultJson){
								console.log(resultJson);
								if(resultJson.status==ResponseStatusCode.DELETE_USER){
								   location.href='user';
								}else {
									alert(resultJson.message);
								}
							},
							true);
		e.preventDefault();
		
});

$('#menu_user_main').trigger('click');





