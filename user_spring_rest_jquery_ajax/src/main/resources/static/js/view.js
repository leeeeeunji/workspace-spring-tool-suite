/**
 * view.js
 */
export function render(templateId = '#user-main-template', jsonResult = {}, contentId = "#content") {
	let templateHtml = $(templateId).html();
	let bindTemplate = Handlebars.compile(templateHtml);
	/*****************Handlebars함수등록*************** */
	Handlebars.registerHelper('substring', function(str, start, end) {
		return str.substring(start, end);
	});
	
	Handlebars.registerHelper('ifCond', function(v1, v2, options) {
		if (v1 === v2) {
			return options.fn(this);
		}
		return options.inverse(this);
	});
	/*
	Handlebars.registerHelper('ifCond', function (v1, operator, v2, options) {
    switch (operator) {
        case '==':
            return (v1 == v2) ? options.fn(this) : options.inverse(this);
        case '===':
            return (v1 === v2) ? options.fn(this) : options.inverse(this);
        case '!=':
            return (v1 != v2) ? options.fn(this) : options.inverse(this);
        case '!==':
            return (v1 !== v2) ? options.fn(this) : options.inverse(this);
        case '<':
            return (v1 < v2) ? options.fn(this) : options.inverse(this);
        case '<=':
            return (v1 <= v2) ? options.fn(this) : options.inverse(this);
        case '>':
            return (v1 > v2) ? options.fn(this) : options.inverse(this);
        case '>=':
            return (v1 >= v2) ? options.fn(this) : options.inverse(this);
        case '&&':
            return (v1 && v2) ? options.fn(this) : options.inverse(this);
        case '||':
            return (v1 || v2) ? options.fn(this) : options.inverse(this);
        default:
            return options.inverse(this);
    }
});
	*/
	
	let resultTemplate = bindTemplate(jsonResult);
	$(contentId).html(resultTemplate);
}

