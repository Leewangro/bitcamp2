var serverRoot = "http://localhost:8888/bitcamp-java-project";
//var serverRoot = "http://tamlaisjeju.java106.com:8888/bitcamp-java-project";


$.get(serverRoot + "/json/auth/islogin", {}, user => {
	let name = decodeURIComponent(user);
	if(name != "n") {
		$("#UserName").text(name);
		$("#Login").css("display", "none");
		$("#Logout").css("display", "block");
	}
})