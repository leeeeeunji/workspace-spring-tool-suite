/**
 * wishlist_view.js
 */
 
export function render(templateId='#wishlist-ticket-template', jsonResult={}, contentId='#wishlist-list'){
	
	let templateHtml = $(templateId).html(); // id로 메인페이지 화면의 html 얻기
	let bindTemplate = Handlebars.compile(templateHtml);
	
	/*************** Handlebars 함수 등록 *******************
	Handlebars.registerHelper('substring', function(str, start, end){
		return str.substring(start, end);
	});
	********************************************************/
	// 날짜 출력 형태 yyyy-mm-dd 함수 
	Handlebars.registerHelper('dateFormat', function(dateString) {
	  var date = new Date(dateString);
	  return date.toLocaleDateString('ko-KR', { year: 'numeric', month: '2-digit', day: '2-digit' });
	});
	
	let resultTemplate = bindTemplate(jsonResult); // {}에 JSON객체/JSON Array 넣어줌 => 메인페이지 화면 + JSON 데이터 합친 결과 = resultTemplate
	$(contentId).html(resultTemplate); // content 부분에 resultTemplate 넣기
	
}