/*
 * ux.popup.js
 * 팝업
 */


//팝업 미리보기
function previewPopup(f, className){
	var t = f.po_top.value+"px";
	var l = f.po_left.value+"px";
	var w = f.po_width.value+"px";
	var h = f.po_height.value+"px";
	var c = f.po_color_content.value;
	var c_line = f.po_color_line.value;
	var content = f.po_content.value;
	var hour = f.po_disable_hours.value;
	
	var layer_area = $(".layer_area");
	var blind = $(".blind");
	$("<div>", { 
		css : {
			"position" : "absolute",
			"zIndex" : "100",
			"top" : t, 
			"left" : l, 
			"width" : w, 
			"height" : h,
			"color" : "#000",
			"background-color" : c,
			"border" : "3px solid "+c_line
		},
		class : className + " layer_popup",
		text : content
	}).appendTo(layer_area);
	$("<div>", {
		css : {
			"position" : "absolute",
			"bottom" : 0,
			"left" : 0,
			"right" : 0,
			"background-color" : c_line,
			"line-height" : "20px"
		},
		class : "layer_popup_bottom",
		html : "<label><input type='checkbox' id='chk_view_popup' value='1' />"+hour+" 시간동안 보이지 않습니다. </label>" +
				"<a href='javascript:closePopup(\""+className+"\");'>[닫기]</a>"
	}).appendTo($(".layer_popup"));
	
	layer_area.show();
	blind.show();
}

function closePopup(className){
	var layer_area = $(".layer_area");
	var blind = $(".blind");
	
	$("."+className).hide();
	layer_area.hide();
	blind.hide();
}