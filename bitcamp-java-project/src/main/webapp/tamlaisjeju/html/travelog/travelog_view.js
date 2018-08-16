$(document).ready(function () {
    $("#header").load("../include/sub_header.html")
    $("#footer").load("../include/sub_footer.html")
    /* id 지정을 통해서도 가능합니다. 
     $("#header").load("header.html #navbar")
     */
});

// url경로
var link = document.location.href.split("?")[1];


$.ajax({

    type: "GET",

    url: serverRoot + "/json/travelLogContent/" + link,

    dataType: "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨

    success: function (data) {


        var positions = []
        var markers2 = []
        var mapContainer2 = document.getElementById('map'), // 지도를 표시할 div  

            mapOption = {
                center: new daum.maps.LatLng(33.37648174461977, 126.55064054368353), // 지도의 중심좌표
                level: 10 // 지도의 확대 레벨
            };

        var map2 = new daum.maps.Map(mapContainer2, mapOption); // 지도를 생성합니다

        var marker2 = null;
        var line = null;
        var paths = []
        imageSrc = "http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";


        for (var i = 0; i < data.length; i++) {

            // 마커 이미지의 이미지 크기 입니다
            imageSize = new daum.maps.Size(24, 35);

            // 마커 이미지를 생성합니다    
            markerImage = new daum.maps.MarkerImage(imageSrc, imageSize);
            console.log(markerImage)

            // 마커를 생성합니다
            marker2 = new daum.maps.Marker({
                position: new daum.maps.LatLng(data[i].lotd, data[i].latd), // 마커를 표시할 위치
                image: markerImage // 마커 이미지 
            });

            paths.push(new daum.maps.LatLng(data[i].lotd, data[i].latd))


            marker2.setMap(map2)
            markers2.push(marker2)
        }
        var polyline = new daum.maps.Polyline({
            path: paths, // 선을 구성하는 좌표배열 입니다
            strokeWeight: 4, // 선의 두께 입니다
            strokeColor: 'rgb(195, 60, 60);', // 선의 색깔입니다
            strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
            strokeStyle: 'solid' // 선의 스타일입니다
        });
        polyline.setMap(map2);
        map2.setZoomable();
        // 지도에 표시할 선을 생성합니다

        // 지도에 선을 표시합니다 

    }
})





function relayout() {

    // 지도를 표시하는 div 크기를 변경한 이후 지도가 정상적으로 표출되지 않을 수도 있습니다
    // 크기를 변경한 이후에는 반드시  map.relayout 함수를 호출해야 합니다 
    // window의 resize 이벤트에 의한 크기변경은 map.relayout 함수가 자동으로 호출됩니다
    map.relayout();
}

$(document).ready(function () {
    var memberId;
    var contentMember;

    $.get(serverRoot + "/json/auth/islogin", {}, user => {
        memberId = decodeURIComponent(user.id);
    })

    $.ajax({

        type: "GET",

        url: serverRoot + "/json/content/update" + link,

        dataType: "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨

        success: function (data) { 
           

        }
    })

    $.ajax({

        type: "GET",

        url: serverRoot + "/json/content/" + link,

        dataType: "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨

        success: function (data) { //콘텐트
            $('#title_div').append(
                "<h5 id='top_title'>" + data.title + "</h5>")
            $('#recommendation').html(data.id)
            contentMember = data.id;
            $('#delete_div').append(
                "<button id='list' type='button' class='btn btn-primary'>목록으로</button>"
            )

            if (memberId == data.id) {
                $('#delete_div').append(
                    "<button type='button' class='btn btn-primary'>삭제</button>" +
                    "<button id='update' type='button' class='btn btn-primary'>수정</button>"
                )
            }

            $('#list').click(function () {
                location.href = 'travelog_list.html'
            })

            memberCall()

        }
    })

    function memberCall() {


        $.ajax({

            type: "GET",

            url: serverRoot + "/json/member/" + contentMember,

            dataType: "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨

            success: function (data) {

                $('#recommendation_name').html(data.name)


            }
        })
    }
    $.ajax({

        type: "GET",

        url: serverRoot + "/json/hashTag/" + link,

        dataType: "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨

        success: function (data) {
            for (let i = 0; i < data.length; i++) {

                $('#hashTag_div').append(
                    "<h5 id='top_hashTag'>" + data[i].content + "</h5>"
                )
            }

        }
    })
    $.ajax({

        type: "GET",

        url: serverRoot + "/json/travelLog/" + link,

        dataType: "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨

        success: function (data) {
            var partner;

            $('#date_div').append(
                "<h5 id='top_date'>" + data.startDate + '~' + data.endDate + "</h5>")

            if (data.partner == 1) {
                partner = "#혼자여행";
            } else if (data.partner == 2) {
                partner = "#부모님과여행"
            } else if (data.partner == 3) {
                partner = "#아이와여행"
            } else if (data.partner == 4) {
                partner = "#커플여행"
            } else if (data.partner == 5) {
                partner = "#친구와여행"
            } else if (data.partner == 6) {
                partner = "#단체여행"
            }
            $('#partner_div').append(
                "<h5 id='top_partner'>" + partner + "</h5>")
        }
    })

    $.ajax({

        type: "GET",

        url: serverRoot + "/json/travelLogContent/" + link,

        dataType: "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨

        success: function (data) {
            let scheduleOfDay = [];
            let maxDay = 0;
            let no = 0;
            var md = 0;
            for (let i in data) {
                if (maxDay < data[i].day)
                    maxDay = data[i].day;
            }

            for (let idx = 0; idx < maxDay; idx++) {
                scheduleOfDay[idx] = [];

                for (let schedule of data) {
                    if ((idx + 1) == schedule.day)
                        scheduleOfDay[idx].push(schedule);
                }

            }

            for (var i = 1; i < maxDay + 1; i++) {
                $("#nav_day_bar").append(
                    "<div class='timeline_content_day fix_day" + i +
                    " day off clear'>" +
                    "<h4> Day" + i + "</h4>" +
                    "<p></p>" +
                    "<p onclick='MoveMap()' class='loadmap'>" + "경로보기" + "</p>" +
                    "</div>")
            }


            for (let i = 1; i < scheduleOfDay.length + 1; i++) {
                $("#tree_menu").append(
                    "<div id='day" + i + "'" + "level='" + no + "' onclick=" +
                    "'fnMove(" + i + ")'" + "class='lbl_titl'>" +
                    "<span class='lbl '>" + i + "일차 </span>" +
                    "</div>"
                )
                for (let x = 0; x < scheduleOfDay[i - 1].length; x++) {
                    $("#tree_menu").append(
                        "<div level='1'" + "class='under'>" +
                        "<span class='lbl'>" + scheduleOfDay[i - 1][x].place +
                        "</span>" +
                        "</div>"
                    )
                }
            }


            // 콘텐트
            for (let i = 1; i < scheduleOfDay.length + 1; i++) {
                $("#travel_cont").append(
                    "<div id='div" + i + "' class='day" + i + "'>" +
                    "</div>"
                )
                $("#div" + i).append(
                    "<div id='cont_day" + i + "' class='timeline_content_day c_day" +
                    i +
                    "'>" +
                    "<h4>" + "Day" + i + "</h4>" +
                    "<p></p>" +
                    "<p onclick='MoveMap()' class='loadmap'>" + "경로보기</p>" +
                    "</div>"
                )
                for (let x = 0; x < scheduleOfDay[i - 1].length; x++) {
                    $("#div" + i).append(
                        "<div class='t_timeline_content'>" +
                        "<div class='context_menu'>" +
                        // "<span>" +
                        // "<a href='" + "#" + "'>" + "#데이트" + "</a>" +
                        // "<a href='" + "#" + "'>" + "#포토존" + "</a>" +
                        // "<a href='" + "#" + "'>" + "#꽃" + "</a>" +
                        // "</span>" +
                        "</div>" +

                        "<div class='content_box clear'>" +
                        "<div class='thum_img_box'>" +
                        "<img src=" + serverRoot + "/files/" + scheduleOfDay[i - 1]
                        [x].photo + "_50x50.jpg" + " alt='썸네일사진' />" +
                        "</div>" +
                        "<div class='content_icon'>" +
                        "<p class='contnet_name'>" + scheduleOfDay[i - 1][x].place +
                        "</p>" +
                        "<p class='content_addr'>" + scheduleOfDay[i - 1][x].address +
                        "</p>" +
                        "</div>" +
                        "<div class='content_text'>" +
                        "<p>" + scheduleOfDay[i - 1][x].review + "</p>" +
                        "</div>" +
                        "</div>" +
                        "<div class='t_timeline_content_imgbox'>" +
                        "<figure class='snip0016'>" +
                        "<img src=" + serverRoot + "/files/" + scheduleOfDay[i - 1]
                        [x].photo +
                        " alt='jeju1' />" +
                        "<figcaption>" +
                        "<p>사진더보기</p>" +
                        "<a href='#'></a>" +
                        "</figcaption>" +
                        "</figure>" +
                        "</div>" +
                        "</div>"
                    )
                }
            }

            var _createClass = function () {
                function defineProperties(target, props) {
                    for (var i = 0; i < props.length; i++) {
                        var descriptor = props[i];
                        descriptor.enumerable = descriptor.enumerable || false;
                        descriptor.configurable = true;
                        if ("value" in descriptor) descriptor.writable = true;
                        Object.defineProperty(target, descriptor.key, descriptor);
                    }
                }
                return function (Constructor, protoProps, staticProps) {
                    if (protoProps) defineProperties(Constructor.prototype,
                        protoProps);
                    if (staticProps) defineProperties(Constructor, staticProps);
                    return Constructor;
                };
            }();

            function _classCallCheck(instance, Constructor) {
                if (!(instance instanceof Constructor)) {
                    throw new TypeError("Cannot call a class as a function");
                }
            }

            window.log = function (text) {
                // console.log(text);
                //$(".console").prepend(text + "<br/>");  

            };

            var TreeMenu = function () {
                function TreeMenu($container) {
                    _classCallCheck(this, TreeMenu);


                    this.$container = $container;
                    // $container.find("[level]").scrollTop(this.levelClickHandler.bind(
                    //     this));
                    $container.find("[level]").scrollTop(this.levelClickHandler.bind(
                        this));
                    var id = 0;
                    $container.find("[level]").each(function (index, item) {
                        var $item = $(item);
                        $item.attr("data-treemenu-id", ++id);
                        this.setOpen($item, false);
                        if (parseInt($item.attr("level")) > 0) {
                            this.hideItem($item);
                        } else {
                            this.showItem($item);
                        }
                    }.bind(this));
                }

                _createClass(TreeMenu, [{
                    key: "levelClickHandler",
                    value: function levelClickHandler(evt) {

                        var $el = $(evt.currentTarget);

                        if (this.isOpen($el)) {
                            this.closeItem($el);
                        } else {
                            this.openItem($el);
                        }
                    }
                }, {
                    key: "getElementTreeMenuId",
                    value: function getElementTreeMenuId($el) {
                        return $el.attr("data-treemenu-id");
                    }
                }, {
                    key: "getElementLevel",
                    value: function getElementLevel($el) {
                        return parseInt($el.attr("level"));
                    }
                }, {
                    key: "isOpen",
                    value: function isOpen($el) {
                        return $el.attr("data-treemenu-open") ===
                            "1";
                    }
                }, {
                    key: "setOpen",
                    value: function setOpen($el, to) {
                        log("set open: " + to);
                        $el.attr("data-treemenu-open", to ? "1" :
                            "0");
                    }
                }, {
                    key: "getGroup",
                    value: function getGroup($el) {
                        log("get group");
                        //the group is every element that has a higher level than this one
                        var firstElementLevel = this.getElementLevel(
                            $el);
                        var group = [];

                        this.$container.find("[level]").each(
                            function (
                                index, item) {
                                var $item = $(item);

                                if (!group.length) {
                                    //first item has not been passed in the loop
                                    if (this.getElementTreeMenuId(
                                            $el) == this.getElementTreeMenuId(
                                            $item)) {
                                        //the current item is the parent of the group
                                        group.push($item);
                                    }
                                    //stop this iteration of the loop
                                    return true;
                                }
                                //
                                //if the level of the item equals or is lower then the initial level, 
                                // we have reached the end of the group
                                var level = parseInt($item.attr(
                                    "level"));
                                if (level <= firstElementLevel)
                                    return false;
                                if (level == firstElementLevel +
                                    1)
                                    group.push($item);
                            }.bind(this));
                        return group;
                    }
                }, {
                    key: "closeItem",
                    value: function closeItem($el) {
                        this.setOpen($el, false);
                        this.getGroup($el).forEach(function ($item,
                            index) {
                            if (!index) return true;
                            this.hideItem($item);

                            //also close its children
                            this.closeItem($item);
                        }.bind(this));
                    }
                }, {
                    key: "openItem",
                    value: function openItem($el) {
                        this.setOpen($el);
                        $('.under').removeClass('opened');
                        $('.under').addClass('closed');
                        $('.lbl_titl').removeClass('color_active');
                        $('.lbl_titl').removeClass('color_off');
                        ($el).addClass('color_off');
                        ($el).addClass('color_active');
                        this.getGroup($el).forEach(function ($item,
                            index) {
                            if (!index) return true;
                            this.showItem($item);
                        }.bind(this));
                    }
                }, {
                    key: "showItem",
                    value: function showItem($el) {
                        $el.removeClass("closed");
                        $el.addClass("opened");
                    }
                }, {
                    key: "hideItem",
                    value: function hideItem($el) {
                        $el.removeClass('opened');
                        $el.addClass("closed");
                    }
                }]);

                return TreeMenu;
            }();

            var menu = new TreeMenu($(".treemenu"));

            // fixed

            $(document).ready(function () {
                $(window).bind('scroll', function () {
                    var container = $('.container').height();
                    var content = $('.t_timeline').height();
                    if ($(window).scrollTop() > container - content -
                        75) {
                        if ($(window).scrollTop() > content + 80) {
                            $('nav').addClass('absolute');
                            $('nav').removeClass('fixed');
                            return;
                        }
                        $('nav').removeClass('action');
                        $('nav').removeClass('absolute');
                        $('nav').addClass('fixed');
                    } else {
                        $('nav').removeClass('absolute');
                        $('nav').removeClass('fixed');
                        $('nav').addClass('action');
                    }
                });
            });

            //왼쪽 fixed
            $(document).ready(function () {
                var sarr = new Array();
                var cntarr = new Array();
                var dayPath = new Array();
                var treeItem = new Array();
                for (let i = 0; i < maxDay; i++) {
                    sarr.push($('.day' + (i + 1)).offset().top)
                    dayPath.push($('.day' + (i + 1)));
                    treeItem.push($('#day' + (i + 1)))
                }


                function action() {
                    for (let y = maxDay; y >= 0; y--) {
                        while ($(document).scrollTop() > sarr[y] - 95) {
                            $('.day').removeClass('off');
                            $('.day').addClass('off');
                            $('.fix_day' + (y + 1)).removeClass('off');
                            $('.c_day' + (y + 1)).addClass('off');
                            $('.c_day' + (y + 2)).removeClass('off');
                            $('.fix_day' + (y + 1)).addClass('on');
                            menu.openItem(treeItem[y])
                            return;
                        }
                    }
                }

                $(window).bind('scroll', function () {
                    action()
                });

            });
        },
        complete: function (data) {

            // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.

            // TODO
        },

        error: function (xhr, status, error) {

            swal({
                type: 'error',
                title: '페이지에러',
                text: '다시 시도해주세요',
                showConfirmButton: false,
                timer: 1500
            })
        }
    });
});

// 아이디 바로가기
function fnMove(id) {
    var offset = $("#div" + id).offset();
    $('html, body').animate({
        scrollTop: offset.top - 75
    }, 400);
}
// 지도로 바로가기
function MoveMap() {
    var offset = $("#map").offset();
    $('html, body').animate({
        scrollTop: offset.top - 75
    }, 400);
}