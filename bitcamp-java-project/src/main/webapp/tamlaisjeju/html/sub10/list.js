

//템플릿 엔진이 사용할 템플릿 데이터 가져오기
var trTemplateSrc = $("#tr-template").html();

// 위에서 준비한 템플릿 데이터를 가지고 HTML을 생성할 템플릿 엔진 준비
var templateFn = Handlebars.compile(trTemplateSrc);

$.getJSON(serverRoot+"/json/planner/5", (data) => {
	   var trHTML = templateFn(data);
       $(trHTML).appendTo('#tableBody');
});


var trTemplateSrc = $("#tt-template").html();
var templateFn = Handlebars.compile(trTemplateSrc);

$('#a12').on('click', function() {
$.getJSON("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?serviceKey=AghOwOn9iSRKD4eyNq4IepTd%2F3cDZ%2FWIuLq3zY4QHRE3OKKaRIRd6XHMc%2F66smnwRpZ0eSsflIyqdd9yrL30Dg%3D%3D&pageNo=1&startPage=1&numOfRows=999&pageSize=20&MobileApp=AppTest&MobileOS=ETC&arrange=A&areaCode=39&listYN=Y&contentTypeId=12&_type=json", 
	function(contentTypeId) {
// json 객체 내부 접근하기
console.dir(contentTypeId);
console.log(contentTypeId);
console.log(contentTypeId.response);
console.log(contentTypeId.response.body);
console.log(contentTypeId.response.body.items);
console.log(contentTypeId.response.body.items.item);

var items = contentTypeId.response.body.items.item;
var html = templateFn({list:items});
console.log(html);

$('#placesList').html(html);
});
});

$('#a39').on('click', function() {
$.getJSON("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?serviceKey=AghOwOn9iSRKD4eyNq4IepTd%2F3cDZ%2FWIuLq3zY4QHRE3OKKaRIRd6XHMc%2F66smnwRpZ0eSsflIyqdd9yrL30Dg%3D%3D&pageNo=1&startPage=1&numOfRows=999&pageSize=20&MobileApp=AppTest&MobileOS=ETC&arrange=A&areaCode=39&listYN=Y&contentTypeId=39&_type=json", 
	function(contentTypeId) {
// json 객체 내부 접근하기
var items = contentTypeId.response.body.items.item;
var html = templateFn({list:items});
console.log(html);

$('#placesList').html(html);
});
});

$('#a38').on('click', function() {
$.getJSON("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?serviceKey=AghOwOn9iSRKD4eyNq4IepTd%2F3cDZ%2FWIuLq3zY4QHRE3OKKaRIRd6XHMc%2F66smnwRpZ0eSsflIyqdd9yrL30Dg%3D%3D&pageNo=1&startPage=1&numOfRows=999&pageSize=20&MobileApp=AppTest&MobileOS=ETC&arrange=A&areaCode=39&listYN=Y&contentTypeId=38&_type=json", 
	function(contentTypeId) {
// json 객체 내부 접근하기
var items = contentTypeId.response.body.items.item;
var html = templateFn({list:items});
console.log(html);

$('#placesList').html(html);
});
});

$('#a32').on('click', function() {
$.getJSON("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?serviceKey=AghOwOn9iSRKD4eyNq4IepTd%2F3cDZ%2FWIuLq3zY4QHRE3OKKaRIRd6XHMc%2F66smnwRpZ0eSsflIyqdd9yrL30Dg%3D%3D&pageNo=1&startPage=1&numOfRows=999&pageSize=20&MobileApp=AppTest&MobileOS=ETC&arrange=A&areaCode=39&listYN=Y&contentTypeId=32&_type=json", 
	function(contentTypeId) {
// json 객체 내부 접근하기
var items = contentTypeId.response.body.items.item;
var html = templateFn({list:items});
console.log(html);

$('#placesList').html(html);
});
});








