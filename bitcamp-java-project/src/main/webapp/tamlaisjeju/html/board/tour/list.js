// // 템플릿 엔진이 사용할 템플릿 데이터 가져오기
// var trTemplateSrc = $("#tr-template").html();

// // 위에서 준비한 템플릿 데이터를 가지고 HTML을 생성할 템플릿 엔진 준비
// var templateFn = Handlebars.compile(trTemplateSrc);

// $.getJSON(serverRoot + "/json/tour/list", (data) => {
//     //tableBody.innerHTML = templateFn({list:data});
// 	$(tableBody).html(templateFn({list:data}))
// });




var serviceKey = "5fTAWN079L8Yfhs%2F9YQ7zBKyOO6%2BKpeQJ15u5GiLJY4AN%2Bx96uwIQHWmIyyxcQwhOxdfQw8s23QzN%2B22icuKbw%3D%3D";

$(function() {
    $.getJSON("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=" + serviceKey + "&contentTypeId=12&areaCode=39&sigunguCode=&cat1=&cat2=&cat3=&listYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=P&numOfRows=6&pageNo=1&_type=json", function(areaCode) {
        // json 객체 내부 접근하기
        // console.dir(areaCode);
        // console.log(areaCode);
        // console.log(areaCode.response);
        // console.log(areaCode.response.body);
        // console.log(areaCode.response.body.items);
        // console.log(areaCode.response.body.items.item);
        
        var items = areaCode.response.body.items.item;
        
        var temp2 = $('#codeTemp').html();
        var template = Handlebars.compile(temp2);
        
        var html = template(items);
        console.log(html);
        
        $('#result').html(html);
        
    });
});





// $('#clear').on('click', function() {
//     $('#result').html("");
// });





