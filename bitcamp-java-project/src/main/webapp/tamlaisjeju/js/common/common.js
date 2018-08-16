var serverRoot = "http://localhost:8888/bitcamp-java-project";
//var serverRoot = "http://tamlaisjeju.java106.com:8888/bitcamp-java-project";
//var serverRoot = "http://kingsroad.xyz:8888/pms";



// 검색
/* Open */
function openSearch() {
    document.getElementById("myOverlay").style.display = "block";
}
/* Close */
function closeSearch() {
    document.getElementById("myOverlay").style.display = "none";
}
// 사이트맵
/* Open */
function openNav() {
    document.getElementById("myNav").style.height = "100%";
}

/* Close */
function closeNav() {
    document.getElementById("myNav").style.height = "0%";
}


$(function() {
    $(window).on("scroll", function() {
        if($(window).scrollTop() > 50) {
            $("#header").addClass("active");
        } else {
            //remove the background property so it comes transparent again (defined in your css)
           $("#header").removeClass("active");
        }
    });
});