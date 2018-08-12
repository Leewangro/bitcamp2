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




