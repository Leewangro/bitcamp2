
        var trTemplateSrc = $("#tr-template").html();
        var templateFn = Handlebars.compile(trTemplateSrc);

$('#a12').on('click', function() {
    $.getJSON("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?serviceKey=AghOwOn9iSRKD4eyNq4IepTd%2F3cDZ%2FWIuLq3zY4QHRE3OKKaRIRd6XHMc%2F66smnwRpZ0eSsflIyqdd9yrL30Dg%3D%3D&pageNo=1&startPage=1&numOfRows=999&pageSize=20&MobileApp=AppTest&MobileOS=ETC&arrange=A&areaCode=39&listYN=Y&contentTypeId=12&_type=json", 
    		function(contentTypeId) {
        // json 객체 내부 접근하기
        console.log(contentTypeId.response.body.items.item);
        var items = contentTypeId.response.body.items.item;
        var sorted = _.sortBy(items, "firstimage2")
        for (let data of sorted) {
        	if (data.firstimage2 == null) {
        		data.firstimage2 = '../../img/common/noimage.jpg';
        	}
        }
        var html = templateFn({list:sorted});
        $('#placesList').html(html);
    });
});



$('#a39').on('click', function() {
    $.getJSON("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?serviceKey=AghOwOn9iSRKD4eyNq4IepTd%2F3cDZ%2FWIuLq3zY4QHRE3OKKaRIRd6XHMc%2F66smnwRpZ0eSsflIyqdd9yrL30Dg%3D%3D&pageNo=1&startPage=1&numOfRows=999&pageSize=20&MobileApp=AppTest&MobileOS=ETC&arrange=A&areaCode=39&listYN=Y&contentTypeId=39&_type=json", 
    		function(contentTypeId) {
        // json 객체 내부 접근하기
        var items = contentTypeId.response.body.items.item;
        var sorted = _.sortBy(items, "firstimage2")
        for (let data of sorted) {
        	if (data.firstimage2 == null) {
        		data.firstimage2 = '../../img/common/noimage.jpg';
        	}
        }
        var html = templateFn({list:sorted});
        
        $('#placesList').html(html);
    });
});

$('#a38').on('click', function() {
    $.getJSON("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?serviceKey=AghOwOn9iSRKD4eyNq4IepTd%2F3cDZ%2FWIuLq3zY4QHRE3OKKaRIRd6XHMc%2F66smnwRpZ0eSsflIyqdd9yrL30Dg%3D%3D&pageNo=1&startPage=1&numOfRows=999&pageSize=20&MobileApp=AppTest&MobileOS=ETC&arrange=A&areaCode=39&listYN=Y&contentTypeId=38&_type=json", 
    		function(contentTypeId) {
        // json 객체 내부 접근하기
        var items = contentTypeId.response.body.items.item;
        var sorted = _.sortBy(items, "firstimage2")
        for (let data of sorted) {
        	if (data.firstimage2 == null) {
        		data.firstimage2 = '../../img/common/noimage.jpg';
        	}
        }
        var html = templateFn({list:sorted});
        
        $('#placesList').html(html);
    });
});

$('#a32').on('click', function() {
    $.getJSON("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?serviceKey=AghOwOn9iSRKD4eyNq4IepTd%2F3cDZ%2FWIuLq3zY4QHRE3OKKaRIRd6XHMc%2F66smnwRpZ0eSsflIyqdd9yrL30Dg%3D%3D&pageNo=1&startPage=1&numOfRows=999&pageSize=20&MobileApp=AppTest&MobileOS=ETC&arrange=A&areaCode=39&listYN=Y&contentTypeId=32&_type=json", 
    		function(contentTypeId) {
        // json 객체 내부 접근하기
        var items = contentTypeId.response.body.items.item;
        var sorted = _.sortBy(items, "firstimage2")
        for (let data of sorted) {
        	if (data.firstimage2 == null) {
        		data.firstimage2 = '../../img/common/noimage.jpg';
        	}
        }
        var html = templateFn({list:sorted});
        
        $('#placesList').html(html);
    });
});







