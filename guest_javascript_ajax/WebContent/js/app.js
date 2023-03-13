import * as View from "./view.js";
//import {render as Render} from "./view.js";
//import {render} from "./view.js";

import * as Service from "./service.js";
import * as URL from "./request-url.js";

/*
메뉴객체이벤트등록
*/
const menuGuestHome = document.querySelector('#menu_guest_home');
const menuGuestList = document.querySelector('#menu_guest_list');
const menuGuestWriteForm = document.querySelector('#menu_guest_write_form');
/*
#guest-detail-template
#guest-main-template
#guest-write-form-template
#guest-modify-form-template
#guest-list-template
*/

menuGuestHome.addEventListener('click', function(e) {
	/*
	let templateHtml = document.querySelector('#guest-main-template');
	document.querySelector('#content').innerHTML = templateHtml.innerHTML;
	*/
	View.render("#guest-main-template", {}, "#content");
	e.preventDefault();
	
});
menuGuestList.addEventListener('click', function(e) {
	let params = '';
	let jsonResult = Service.guestService('GET', URL.GUEST_LIST_URL, params);
	View.render("#guest-list-template", jsonResult, "#content");
	e.preventDefault();
});
menuGuestWriteForm.addEventListener('click', function(e) {
	View.render("#guest-write-form-template", {}, "#content");
	e.preventDefault();	
});

/*
초기 로딩 시에 guesthome anchor click event trigger
*/
//menuGuestHome.click();
document.addEventListener('click', function(e) {
	/*
	Element 속성
	*/
	console.log("Event객체 : " + e);
	console.log("Event Target 객체 : " + e.target);
	console.log("Event Target 객체 ID : " + e.target.id);
	console.log("Event Target 객체 ID : " + e.target.getAttribute("id"));
	console.log("Event Target 객체 className : " + e.target.className);
	console.log("Event Target 객체 classList : " + e.target.classList);
	console.log("Event Target 객체 classList.contains('guest_item_a') : " + e.target.classList.contains('guest_item_a'));
	/********************** guest_detail ***********************/
	if(e.target.classList.contains('guest_item_a')) {
		/*
		<< e.target >>
		<a href="#" class="user guest_item_a" guest_no="585"> 3시40분 시작</a>
		*/
		let params = 'guest_no=' + e.target.getAttribute("guest_no");
		let jsonResult = Service.guestService('GET', URL.GUEST_DETAIL_URL, params);
		View.render("#guest-detail-template", jsonResult, "#content");
	}
	
	/********************** guest_delete_action ***********************/
	if(e.target.id == 'btn_guest_remove_action') {
		let params = 'guest_no=' + e.target.getAttribute("guest_no");
		let jsonResult = Service.guestService('POST', URL.GUEST_REMOVE_ACTION_URL, params);
		if(jsonResult.code == 1) {
			menuGuestList.click();
		}else {
			alert();
		}
	}
	
	/********************** guest_write_action ***********************/
	if(e.target.id == 'btn.write.action') {
		if (document.f.guest_name.value == "") {
			alert("이름을 입력하십시요.");
			document.f.guest_name.focus();
			return false;
		}
		if (document.f.guest_email.value == "") {
			alert("이메일을 입력하십시요.");
			document.f.guest_email.focus();
			return false;
		}
		if (document.f.guest_homepage.value == "") {
			alert("홈페이지를 입력하십시요.");
			document.f.guest_homepage.focus();
			return false;
		}
	
		if (document.f.guest_title.value == "") {
			alert("제목을 입력하십시요.");
			document.f.guest_title.focus();
			return false;
		}
		if (document.f.guest_content.value == "") {
			alert("내용을 입력하십시요.");
			document.f.guest_content.focus();
			return false;
		}
		
		const f = document.querySelector('#guest_write_form');
		const formData = new FormData(f);
		const params = new URLSearchParams(formData).toString();
		
		const jsonResult = Service.guestService('POST', URL.GUEST_WRITE_ACTION_URL, params);
		if(sjonResult.code == 1){
			//쓰기 성공시 리스트클릭이벤트 발생
			menuGuestList.click();
		}else if(jsonResult.code == 2) {
			alert(jsonResult.msg);
		}
	}
	
	/********************** guest_modify_form_action ***********************/
	if(e.target.id == 'btn_guest_modify_form') {
		const params = 'guest_no=' + e.target.getAttribute('guest_no');
		Service.guestService('POST', URL.GUEST_DETAIL_URL, params);
		View.render('#guest-modify-form-template', jsonResult, '#content');
	}
	
	/********************** guest_modify_action ***********************/
	if(e.target.id == 'btn_guest_modify_action') {
		if (document.f.guest_name.value == "") {
			alert("이름을 입력하십시요.");
			document.f.guest_name.focus();
			return false;
		}
		if (document.f.guest_email.value == "") {
			alert("이메일을 입력하십시요.");
			document.f.guest_email.focus();
			return false;
		}
		if (document.f.guest_homepage.value == "") {
			alert("홈페이지를 입력하십시요.");
			document.f.guest_homepage.focus();
			return false;
		}
	
		if (document.f.guest_title.value == "") {
			alert("제목을 입력하십시요.");
			document.f.guest_title.focus();
			return false;
		}
		if (document.f.guest_content.value == "") {
			alert("내용을 입력하십시요.");
			document.f.guest_content.focus();
			return false;
		}
		
		const f = document.querySelector('#guest_modify_form');
		const formData = new FormData(f);
		const params = new URLSearchParams(formData).toString();
		const jsonResult = Service.guestService('POST', URL.GUEST_MODIFY_ACTION_URL, params);
		if(jsonResult == 1) {
			const params = 'guest_no=' + f.guest_no.value;
			Service.guestService('GET', URL.GUEST_DETAIL_URL, params);
			View.render('#guest-detail-template', jsonResult, '#content');
		}else if(jsonResult == 2) {
			alert(jsonResult.msg);
		}
	}
	
	
	/********************** guest_list ***********************/
	if(e.target.id == 'btn_guest_list') {
		menuGuestList.click();
	}
	
	/********************** guest_write_form ***********************/
	if(e.target.id == 'btn_guest_write_form') {
		menuGuestWriteForm.click();
	}
	
	e.preventDefault();
	
});

/*
초기로딩시에 home anchor click event trigger
*/
menuGuestHome.click();



