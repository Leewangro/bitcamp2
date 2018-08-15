var planDate = []; 
var travel_data = [];
var travel_schedule = [];
var travel_hash = [];
$.get(serverRoot + "/json/auth/islogin", {}, user => {
  var isLogins = decodeURIComponent(user);

  if (user != 'n') {
    $("#writer").click(function () {
      console.log("aaa");
      location.href = 'planner_form.html'
    })
  } else {
    $("#writer").click(function () {
      swal({
        type: 'error',
        title: '로그인후 이용해주세요',
        // text: '로그인후 이용해주세요',
        showConfirmButton: false,
        timer: 1500
      })
    })
  }
})
$.ajax({
	   url: "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?serviceKey=AghOwOn9iSRKD4eyNq4IepTd%2F3cDZ%2FWIuLq3zY4QHRE3OKKaRIRd6XHMc%2F66smnwRpZ0eSsflIyqdd9yrL30Dg%3D%3D&pageNo=1&startPage=1&numOfRows=1200&pageSize=20&MobileApp=AppTest&MobileOS=ETC&arrange=A&areaCode=39&listYN=Y&_type=json",
	   dataType: "json", 
	   success: function (data2) {
		   travel_data = data2.response.body.items.item
		   console.log(travel_data)
		   planSchedule();
}
});

 function planSchedule() {
	 $('.hashtag').empty();
	 for (var p = 0; p < planDate.length; p++) {
		 
		 (function(p)
		 {$.getJSON(serverRoot+"/json/travelPlan/"+planDate[p].no, (data) => {
			 travel_schedule = data;
			 console.log(travel_schedule)
			 var mark ='';
			   for (var s = 0; s < travel_schedule.length; s++) {
				   for (var t = 0; t < travel_data.length; t++) {
					   if (travel_schedule.length != 0) {
					   if (travel_schedule[s].tno == travel_data[t].contentid) {
						   $("#box"+travel_schedule[s].plno+" img")[0].src = travel_data[t].firstimage2;
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
			 console.log(travel_hash.length)
			   for (var s = 0; s < travel_hash.length; s++) {
					   if (travel_hash.length != 0) {
						   console.log(travel_hash[s].content)
						   $("#hashtag"+travel_hash[s].cno+"").append(
								   "<a href='#'>"+travel_hash[s].content+"</a>"
								   )  
					   }
			   }
	 });
		 })(h)
 }
 }
 
 $(document).ready(function () {
     $.ajax({

       type: "GET",

       url: serverRoot + "/json/planner/list",

       dataType: "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨

       success: function (data) {
         var pageNo = data.length / 6;
         Math.ceil(pageNo)
         $('#pageBtn').append(
          "<a id='preBtn' href='#'>&laquo;</a>"
          )
         
         for (let i = 0; i < Math.ceil(pageNo); i++) {
           $('#pageBtn').append(
             "<a href='#' id='page_"+(i+1)+"' class='pageNoBtns' onclick='pageClick(this)'>"+(i+1)+"</a>"
           )
         }
         $('#pageBtn').append(
         "<a id='nextBtn' href='#'>&raquo;</a>"
       )
         $('#page_1').trigger('click')
         
          $('#preBtn').click(function(){
            if ($('.active').prev()[0] != $('#preBtn')[0]) {
               $('.active').prev().trigger('click')
             }
            })

            $('#nextBtn').click(function(){
            if ($('.active').next()[0] != $('#nextBtn')[0]) {
               $('.active').next().trigger('click')
             }
            })
         
         
       }
     })
   })


   function pageClick(val) {
     var no = val.innerText;
     $('.pageNoBtns').removeClass('active')
     $(val).addClass('active')
   
     $.ajax({

       type: "GET",

       url: serverRoot + "/json/planner/listpageNo=" + no,

       dataType: "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨

       success: function (data) {
    	   planDate = data;
    	   console.log(planDate);
         $('.box_wrap').empty();
         console.log(data);

         for (let i = 0; i < data.length; i++) {
        	 $('.box_wrap').append(
          		   "<div class='box' id=box"+data[i].no+">" +
                     "<figure class='effect type03'>" +
                       "<img src='../../img/common/board_img02.jpg' alt='제주의 바닷가'>" +
                       "<figcaption>" +
                         "<h5>" +
                           "<span>"+data[i].title+"</span>" +
                         "</h5>" +
                         "<a href=planner_view.html"+('?'+data[i].no)+">'View more'</a>" +
                       "</figcaption>" +
                     "</figure>" +
                     "<div class='box_cont'>"+
                       "<h5>" +
                         "<a href=planner_view.html"+('?'+data[i].no)+'>'+data[i].title+'</a>' +
                       "</h5>" +
                       "<div class='planner_txt' style=color:#5c5c5c; id=pltravel"+data[i].no+"></div>" +
                       "<div class='hashtag' id=hashtag"+data[i].no+">" +
                       "</div>" +
                     "</div>" +
                   "</div>"
             ) 
             if (i==(data.length-1)) {
            	 planSchedule()
             }
         }
       }
     })
   }


