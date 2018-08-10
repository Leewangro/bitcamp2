var planDate = []; 
var travel_data = [];
var travel_schedule = [];
var travel_hash = [];
function jsonDate() {
$.ajax({
	   url: "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?serviceKey=AghOwOn9iSRKD4eyNq4IepTd%2F3cDZ%2FWIuLq3zY4QHRE3OKKaRIRd6XHMc%2F66smnwRpZ0eSsflIyqdd9yrL30Dg%3D%3D&pageNo=1&startPage=1&numOfRows=1200&pageSize=20&MobileApp=AppTest&MobileOS=ETC&arrange=A&areaCode=39&listYN=Y&_type=json",
	   dataType: "json", 
	   success: function (data2) {
		   travel_data = data2.response.body.items.item
		   console.log(travel_data)
		   planSchedule();
}
});
}

 // 위에서 준비한 템플릿 데이터를 가지고 HTML을 생성할 템플릿 엔진 준비
 $.getJSON(serverRoot+"/json/planner/list", (data) => {
 	   planDate = data;
 	   console.log(planDate);
       for (var i = 0; i< planDate.length; i++) {
    	   if (i == planDate.length-1) {
    		   jsonDate();
           }
       $('.box_wrap').append(
    		   "<div class='box'>" +
               "<figure class='effect type03'>" +
                 "<img src='../../img/common/board_img02.jpg' alt='제주의 바닷가'>" +
                 "<figcaption>" +
                   "<h5>" +
                     "<span>"+planDate[i].title+"</span>" +
                   "</h5>" +
                   "<a href=planner_view.html"+('?'+planDate[i].no)+">'View more'</a>" +
                 "</figcaption>" +
               "</figure>" +
               "<div class='box_cont'>"+
                 "<h5>" +
                   "<a href=planner_view.html"+('?'+i)+'>'+planDate[i].title+'</a>' +
                 "</h5>" +
                 "<p class='planner_txt' id=pltravel"+planDate[i].no+"></p>" +
                 "<p class='hashtag' id=hashtag"+planDate[i].no+">" +
                 "</p>" +
                 //<!-- count_area end-->
               "</div>" +
               //<!-- box_cont end -->
             "</div>"
             //<!-- box end-->	   
       ) 
       } 
});


 function planSchedule() {
	 for (var p = 0; p < planDate.length; p++) {
		 console.log(p);
		 
		 (function(p)
		 {$.getJSON(serverRoot+"/json/travelPlan/"+planDate[p].no, (data) => {
			 travel_schedule = data;
			 var mark ='';
			   for (var s = 0; s < travel_schedule.length; s++) {
				   for (var t = 0; t < travel_data.length; t++) {
					   if (travel_schedule.length != 0) {
					   if (travel_schedule[s].tno == travel_data[t].contentid) {
						   $("#pltravel"+travel_schedule[s].plno+"").append(
								   "<span>"+"\u00A0" +mark+"\u00A0"+travel_data[t].title+"</span>"
								   ) 
								   mark = '→'
					   }
					   }
				   }
			   }
	 });
		 })(p)
	 }
 for (var h = 0; h < planDate.length; h++) { 
		 (function(h)
		 {$.getJSON(serverRoot+"/json/hashTag/"+planDate[h].no, (data) => {
			 travel_hash = data;
			   for (var s = 0; s < travel_hash.length; s++) {
					   if (travel_hash.length != 0) {
						   console.log(travel_hash[s].content)
						   $("#hashtag"+travel_hash[s].cno+"").append(
								   "<a href='#'>#"+travel_hash[s].content+"</a>"
								   ) 
					   }
			   }
	 });
		 })(h)
 }
 }
 
 
/* function travel_sche() {
 for (var t = 0; t < planDate.length; t++) {
	 $.getJSON(serverRoot+"/json/travelPlan/"+planDate[t].no, (data1) => {
		 console.log(planDate.length)
		 travel_schedule.push(data1)
		 console.log(travel_schedule)
	 });
 }
 
 }
 $.ajax({
     url: "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?serviceKey=AghOwOn9iSRKD4eyNq4IepTd%2F3cDZ%2FWIuLq3zY4QHRE3OKKaRIRd6XHMc%2F66smnwRpZ0eSsflIyqdd9yrL30Dg%3D%3D&pageNo=1&startPage=1&numOfRows=1200&pageSize=20&MobileApp=AppTest&MobileOS=ETC&arrange=A&areaCode=39&listYN=Y&_type=json",
     dataType: "json", 
     success: function (data2) {
    	 travel_data = data2
    	 console.log(travel_data)
    	 
    	 for (var i = 0; i < travel_schedule.length; i++) {
    		 for (var j = 0; j < travel_data.length; j++) {
    			 if (travel_schedule[i][1].tno == travel_data[j].contentid) {
    				 // 이미지 찾았음
    			 }
    			 
    		 }
    	 }
     }
 });
*/
/* function schedule_comp1() {
     for (var i = 0; i < schedule.length; i++) {
         for (var d = 1; d < betweenDay + 2; d++) {
             if (schedule[i].plday == d) {
                 for (let j = 0; j < schedule_data.response.body.items.item.length; j++) {
                     if (schedule[i].tno == schedule_data.response.body.items.item[j].contentid) {
                     
                     }
                 }
             }
         }
     }
 }*/


