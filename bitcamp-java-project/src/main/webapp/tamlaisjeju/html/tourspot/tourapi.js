var common = {

	date: new Date(),

	getDate: function () {
		var year = this.date.getFullYear(),
			month = this.date.getMonth() + 1,
			day = this.date.getDate();

		if (month >= 1 && month < 10) {
			month = "0" + month;
		}
		day = "0" + 1;
		var result = year + month + day
		return result;
	},

	getInfo: function (method, flag, option, returnFunction) {
		console.log(option)
		$.ajax({
			crossOrigin: true,
			type: method,

			url: "http://api.visitkorea.or.kr/openapi/service/rest/KorService/" + flag,
			data: "ServiceKey=5fTAWN079L8Yfhs%2F9YQ7zBKyOO6%2BKpeQJ15u5GiLJY4AN%2Bx96uwIQHWmIyyxcQwhOxdfQw8s23QzN%2B22icuKbw%3D%3D&" + option + "&_type=json",
			dataType: "json",
			success: function (data) {
				if (data.response.header.resultCode !== "0000") {
					alert('데이터 통신에 오류가 발생하였습니다.\n 지속적으로 문제가 발생하면 홈페이지 관리자에게 문의하세요')
				}
				returnFunction(data)

			}
		});
	},













	detailPageIntroInfoDraw: function (data) {





		var InfoElements;
		var list = data.response.body.items.item
		var ref = list.contenttypeid
		if (ref === 12) { //관광지
			 InfoElements = 
			 	"<li><b>유모차대여여부</b><span>" + list.chkbabycarriage + "</span></li>" +
				"<li><b>주차가능 여부</b><span>" + list.parking + "</span></li>" 
			 $(".view_info ul").append(InfoElements)
		} else if (ref === 14) { // 문화시설
			InfoElements = "<div class='detail_info'>" +

				"<table class='tbl_basic center'>" +
				"<tr><td colspan='2'><em>상세 정보</em></td></tr>" +
				"<tr><td class='introLeft'><em>문의 및 안내  </em></td><td class='introRight'>" + list.infocenterculture + "</td>" +
				"<tr><td class='introLeft'><em>관람소요시간      </em></td><td class='introRight'>" + list.spendtime + "</td>" +
				"<tr><td class='introLeft'><em>수용인원 	   </em></td><td class='introRight'>" + list.accomcountculture + "</td>" +
				"<tr><td class='introLeft'><em>규모      </em></td><td class='introRight'>" + list.scale + "</td>" +
				"<tr><td class='introLeft'><em>할인정보      </em></td><td class='introRight'>" + list.discountinfo + "</td>" +
				"<tr><td class='introLeft'><em>이용시간 	  </em></td><td class='introRight'>" + list.usetimeculture + "</td>" +
				"<tr><td class='introLeft'><em>이용요금 	   </em></td><td class='introRight'>" + list.usefee + "</td>" +
				"<tr><td class='introLeft'><em>쉬는날	   </em></td><td class='introRight'>" + list.restdateculture + "</td>" +
				"<tr><td class='introLeft'><em>유모차대여여부	 </em></td><td class='introRight'>" + list.chkbabycarriageculture + "</td>" +
				"<tr><td class='introLeft'><em>주차시설	   </em></td><td class='introRight'>" + list.parkingculture + "</td>" +
				"<tr><td class='introLeft'><em>주차요금  </em></td><td class='introRight'>" + list.parkingfee + "</td>" +
				"</table>" +
				"</div>"
			$("#detailIntro").append(InfoElements)
		} else if (ref === 15) { // 축제정보
			InfoElements = "<div class='detail_info'>" +
				"<div>" + list.program + "</div>" +
				"<div>" + list.subevent + "</div>" +
				"<table class='tbl_basic center'>" +
				"<tr><td colspan='2'><em>상세 정보</em></td></tr>" +
				"<tr><td class='introLeft'><em>행사장소  </em></td><td class='introRight'>" + list.eventplace + "</td>" +
				"<tr><td class='introLeft'><em>행사장위치안내 	 </em></td><td class='introRight'>" + list.placeinfo + "</td>" +
				"<tr><td class='introLeft'><em>이용요금 	 </em></td><td class='introRight'>" + list.usetimefestival + "</td>" +
				"<tr><td class='introLeft'><em>할인정보 	 </em></td><td class='introRight'>" + list.discountinfofestival + "</td>" +
				"<tr><td class='introLeft'><em>예매처 	 </em></td><td class='introRight'>" + list.bookingplace + "</td>" +
				"<tr><td class='introLeft'><em>행사시작일 	 </em></td><td class='introRight'>" + list.eventstartdate + "</td>" +
				"<tr><td class='introLeft'><em>행사종료일	   </em></td><td class='introRight'>" + list.eventenddate + "</td>" +
				"<tr><td class='introLeft'><em>관람가능연령	   </em></td><td class='introRight'>" + list.agelimit + "</td>" +
				"<tr><td class='introLeft'><em>관람소요시간 </em></td><td class='introRight'>" + list.spendtimefestival + "</td>" +
				"<tr><td class='introLeft'><em>할인정보 </em></td><td class='introRight'>" + list.discountinfofestival + "</td>" +
				"<tr><td class='introLeft'><em>공연시간  </em></td><td class='introRight'>" + list.playtime + "</td>" +
				"<tr><td class='introLeft'><em>주최자  </em></td><td class='introRight'>" + list.sponsor1 + "</td>" +
				"<tr><td class='introLeft'><em>주최자연락처 </em></td><td class='introRight'>" + list.sponsor1tel + "</td>" +
				"</table>" +
				"</div>"
			$("#detailIntro").append(InfoElements)
		} else if (ref === 25) { // 여행코스
			InfoElements = "<div class='detail_info'>" +

				"<table class='tbl_basic center'>" +
				"<tr><td colspan='2'><em>상세 정보</em></td></tr>" +
				"<tr><td class='introLeft'><em>문의 및 안내  </em></td><td class='introRight'>" + list.infocentertourcourse + "</td>" +
				"<tr><td class='introLeft'><em>코스테마	   </em></td><td class='introRight'>" + list.theme + "</td>" +
				"<tr><td class='introLeft'><em>코스일정  </em></td><td class='introRight'>" + list.schedule + "</td>" +
				"<tr><td class='introLeft'><em>코스총거리	   </em></td><td class='introRight'>" + list.distance + "</td>" +
				"<tr><td class='introLeft'><em>코스총소요시간  </em></td><td class='introRight'>" + list.taketime + "</td>" +
				"</table>" +

				"</div>"
			$("#detailIntro").append(InfoElements)
		} else if (ref === 28) { //레포츠
			InfoElements = "<div class='detail_info'>" +

				"<table class='tbl_basic center'>" +
				"<tr><td colspan='2'><em>상세 정보</em></td></tr>" +
				"<tr><td class='introLeft'><em>문의 및 안내  </em></td><td class='introRight'>" + list.infocenterleports + "</td>" +
				"<tr><td class='introLeft'><em>예약 안내	   </em></td><td class='introRight'>" + list.reservation + "</td>" +
				"<tr><td class='introLeft'><em>입장료	   </em></td><td class='introRight'>" + list.usefeeleports + "</td>" +
				"<tr><td class='introLeft'><em>수용인원 </em></td><td class='introRight'>" + list.accomcountleports + "</td>" +
				"<tr><td class='introLeft'><em>개장기간	   </em></td><td class='introRight'>" + list.openperiod + "</td>" +
				"<tr><td class='introLeft'><em>개장시간  </em></td><td class='introRight'>" + list.openperiod + "</td>" +
				"<tr><td class='introLeft'><em>이용시간  </em></td><td class='introRight'>" + list.usetimeleports + "</td>" +
				"<tr><td class='introLeft'><em>쉬는날 	 </em></td><td class='introRight'>" + list.restdateleports + "</td>" +
				"<tr><td class='introLeft'><em>주차시설  </em></td><td class='introRight'>" + list.parkingleports + "</td>" +
				"<tr><td class='introLeft'><em>주차요금		   </em></td><td class='introRight'>" + list.parkingfeeleports + "</td>" +
				"<tr><td class='introLeft'><em>유모차대여여부 	 </em></td><td class='introRight'>" + list.chkbabycarriageleports + "</td>" +
				"<tr><td class='introLeft'><em>신용카드가능여부  </em></td><td class='introRight'>" + list.chkcreditcardleports + "</td>" +
				"<tr><td class='introLeft'><em>애완동물가능여부 </em></td><td class='introRight'>" + list.chkpetleports + "</td>" +
				"</table>" +

				"</div>"
			$("#detailIntro").append(InfoElements)
		} else if (ref === 32) { // 숙박정보 
			InfoElements = "<div class='detail_info'>" +
				"<table class='tbl_basic center'>" +
				"<tr><td colspan='2'><em>상세 정보</em></td></tr>" +
				"<tr><td class='introLeft'><em>문의 및 안내  </em></td><td class='introRight'>" + list.infocenterlodging + "</td>" +
				"<tr><td class='introLeft'><em>예약 안내	   </em></td><td class='introRight'>" + list.reservationlodging + "</td>" +
				"<tr><td class='introLeft'><em>예약 안내홈페이지 </em></td><td class='introRight'>" + list.reservationurl + "</td>" +
				"<tr><td class='introLeft'><em>부대시설	   </em></td><td class='introRight'>" + list.subfacility + "</td>" +
				"<tr><td class='introLeft'><em>주차가능 여부  </em></td><td class='introRight'>" + list.parkinglodging + "</td>" +
				"<tr><td class='introLeft'><em>객실내취사여부  </em></td><td class='introRight'>" + list.chkcooking + "</td>" +
				"<tr><td class='introLeft'><em>식음료장  </em></td><td class='introRight'>" + list.foodplace + "</td>" +
				"<tr><td class='introLeft'><em>객실수		   </em></td><td class='introRight'>" + list.roomcount + "</td>" +
				"<tr><td class='introLeft'><em>수용가능인원 	 </em></td><td class='introRight'>" + list.accomcountlodging + "</td>" +
				"<tr><td class='introLeft'><em>체크인 시간 	 </em></td><td class='introRight'>" + list.checkintime + "</td>" +
				"<tr><td class='introLeft'><em>체크아웃 시간  </em></td><td class='introRight'>" + list.checkouttime + "</td>" +
				"<tr><td class='introLeft'><em>주차가능 여부  </em></td><td class='introRight'>" + list.parkinglodging + "</td>" +
				"</table>" +

				"</div>"
			$("#detailIntro").append(InfoElements)
		} else if (ref === 38) { // 쇼핑
			InfoElements = "<div class='detail_info'>" +
				"<table class='tbl_basic center'>" +
				"<tr><td colspan='2'><em>상세 정보</em></td></tr>" +
				"<tr><td class='introLeft'><em>매장안내 </em></td><td class='introRight'>" + list.shopguide + "</td>" +
				"<tr><td class='introLeft'><em>문의및안내 </em></td><td class='introRight'>" + list.infocentershopping + "</td>" +
				"<tr><td class='introLeft'><em>영업시간</em></td><td class='introRight'>" + list.opentime + "</td>" +
				"<tr><td class='introLeft'><em>쉬는날  </em></td><td class='introRight'>" + list.restdateshopping + "</td>" +
				"<tr><td class='introLeft'><em>규모 </em></td><td class='introRight'>" + list.scaleshopping + "</td>" +
				"<tr><td class='introLeft'><em>장서는날 </em></td><td class='introRight'>" + list.fairday + "</td>" +
				"<tr><td class='introLeft'><em>문화센터바로가기  </em></td><td class='introRight'>" + list.culturecenter + "</td>" +
				"<tr><td class='introLeft'><em>화장실 </em></td><td class='introRight'>" + list.restroom + "</td>" +
				"<tr><td class='introLeft'><em>신용카드가능여부	   </em></td><td class='introRight'>" + list.chkbabycarriageshopping + "</td>" +
				"<tr><td class='introLeft'><em>신용카드가능여부	   </em></td><td class='introRight'>" + list.chkcreditcardshopping + "</td>" +
				"<tr><td class='introLeft'><em>애완동물가능여부	   </em></td><td class='introRight'>" + list.chkpetshopping + "</td>" +
				"<tr><td class='introLeft'><em>주차시설	   </em></td><td class='introRight'>" + list.parkingshopping + "</td>" +
				"<tr><td class='introLeft'><em>판매품목별가격  </em></td><td class='introRight'>" + list.saleitemcost + "</td>" +
				"</table>" +

				"</div>"
			$("#detailIntro").append(InfoElements)
		} else if (ref === 39) { // 음식점
			InfoElements = "<div class='detail_info'>" +
				"<table class='tbl_basic center'>" +
				"<tr><td colspan='2'><em>상세 정보</em></td></tr>" +
				"<tr><td class='introLeft'><em>대표메뉴 </em></td><td class='introRight'>" + list.firstmenu + "</td>" +
				"<tr><td class='introLeft'><em>취급메뉴 </em></td><td class='introRight'>" + list.treatmenu + "</td>" +
				"<tr><td class='introLeft'><em>문의및안내 </em></td><td class='introRight'>" + list.infocenterfood + "</td>" +
				"<tr><td class='introLeft'><em>할인정보 </em></td><td class='introRight'>" + list.discountinfofood + "</td>" +
				"<tr><td class='introLeft'><em>영업시간  </em></td><td class='introRight'>" + list.opentimefood + "</td>" +
				"<tr><td class='introLeft'><em>주차가능 여부</em></td><td class='introRight'>" + list.parkingfood + "</td>" +
				"<tr><td class='introLeft'><em>급연/흡연 여부  </em></td><td class='introRight'>" + list.smoking + "</td>" +
				"<tr><td class='introLeft'><em>포장가능 여부  </em></td><td class='introRight'>" + list.packing + "</td>" +
				"<tr><td class='introLeft'><em>쉬는날  </em></td><td class='introRight'>" + list.restdatefood + "</td>" +
				"<tr><td class='introLeft'><em>신용카드가능여부	   </em></td><td class='introRight'>" + list.chkcreditcardfood + "</td>" +
				"</table>" +

				"</div>"
			$("#detailIntro").append(InfoElements)
		}

	},

	getMonth: function () {
		$('#festivalMonth').append(this.date.getMonth() + 1)
	},





}
















function moreView() {
	draw.elementCount += 1;
	draw.elements();
}

function getLocation() {
	$('#travelContents').empty();
	$('#notification').text("위치정보를 가져오고 있습니다...");
	$('#information').css('display', 'block');
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(getGeolocation, getError, {
			enableHighAccuracy: true,
			maximumAge: 0,
			timeout: 50000
		});
	} else {
		alert('현재 사용하는 브라우저는 위치정보를 가져올수 없습니다.')
	}
}

//geolocation api 
//https://hudi.kr/geolocation-api-%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EB%94%94%EB%B0%94%EC%9D%B4%EC%8A%A4-%EC%9C%84%EC%B9%98-%EC%A0%95%EB%B3%B4-%EA%B0%80%EC%A0%B8%EC%98%A4%EA%B8%B0/
//참고

function getGeolocation(position) {
	draw.mapY = position.coords.latitude;
	draw.mapX = position.coords.longitude;
	$('#moreViewWrap').css('display', 'block');
	$('#information').css('display', 'none');
	draw.elements();
}

function getError(error) {
	switch (error.code) {
		case error.PERMISSION_DENIED:
			alert("위치정보 확인을 거부하였습니다.")
			$('#notification').text("위치정보를 확인할 수 없습니다.");
			break;
		case error.POSITION_UNAVAILABLE:
			alert("위치정보를 사용할 수 없습니다.")
			$('#notification').text("위치정보를 확인할 수 없습니다.");
			break;
		case error.TIMEOUT:
			alert("위치정보를 확인하는데 실패하였습니다.\n(TIMEOUT)")
			$('#notification').text("위치정보를 확인할 수 없습니다.");
			break;
		case error.UNKNOWN_ERROR:
			alert("위치정보를 확인하는데 실패하였습니다.\n(알수없는 오류)")
			$('#notification').text("위치정보를 확인할 수 없습니다.");
			break;
	}
}




