

//템플릿 엔진이 사용할 템플릿 데이터 가져오기
var trTemplateSrc = $("#tr-template").html();

// 위에서 준비한 템플릿 데이터를 가지고 HTML을 생성할 템플릿 엔진 준비
var templateFn = Handlebars.compile(trTemplateSrc);

$.getJSON(serverRoot+"/json/planner/5", (data) => {
	   var trHTML = templateFn(data);
       $(trHTML).appendTo('#tableBody');
});

$.getJSON(serverRoot + "/json/content/"+link, (data2) => {
	console.log(data2);
    $('.plan_title')[0].textContent = data2.title
});

$.getJSON(serverRoot + "/json/hashTag/"+link, (data3) => {
	console.log(data3);
	for (var h = 0; h < data3.length; h++) {
	$('#hashTag').append(
			"<div class='hashTagCont'>"+data3[h].content+"</div>"
			)
	}
			/*	
	$('#thema')append(
			"<li class='plan_cont clear'>태그: {{memo}}</li>)
	}*/
});
