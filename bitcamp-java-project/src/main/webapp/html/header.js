var xhr = new XMLHttpRequest();
xhr.open("GET", "/bitcamp-java-project/html/header.html", false);
xhr.send();
header.innerHTML = xhr.responseText;

var xhr = new XMLHttpRequest();
xhr.open("GET", "/bitcamp-java-project/json/auth/loginUser", false);
xhr.send();
if(xhr.responseText == "") {
	location.href = "/bitcamp-java-project/html/auth/login.html";
} else {
var data = JSON.parse(xhr.responseText);
document.querySelector("#username").textContent = data.id;
}

