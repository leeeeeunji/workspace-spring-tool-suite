/**
 * view.js
 */
 export function render(templateId='#guest-main-template', jsonResult={}, contentId="#content") {
	let templateHtml = $(templateId).html();
	let bindTemplate = Handlebars.compile(templateHtml);
	/**************** Handlebars 함수 등록 ****************/
	Handlebars.registerHelper('substring', function(str, start, end) {
		return str.substring(start, end);
	});
	
	let resultTemplate = bindTemplate(jsonResult);
	$(contentId).html(resultTemplate);
}