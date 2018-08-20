$(document).ready(function () {
    $("#header").load("../include/sub_header.html")
    $("#footer").load("../include/sub_footer.html")
    /* id 지정을 통해서도 가능합니다. 
     $("#header").load("header.html #navbar")
     */
  });

  $(document).ready(function () {

    $.get(serverRoot + "/json/auth/islogin", {}, user => {
      var isLogins = decodeURIComponent(user);

      if (user != 'n') {
        $("#write").click(function () {
          location.href = 'travelog_form.html'
        })
      } else {
        $("#write").click(function () {
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

      type: "GET",

      url: serverRoot + "/json/travelLog/list",

      dataType: "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨

      success: function (data) {
        var pageNo = data.length / 10;
        Math.ceil(pageNo)
        $('#pageBtn').append(
          "<a id='preBtn' href='#'>&laquo;</a>"
        )
        for (let i = 0; i < Math.ceil(pageNo); i++) {
          $('#pageBtn').append(
            "<a href='#' id='page_" + (i + 1) + "' class='pageNoBtns' onclick='pageClick(this)'>" + (i +
              1) + "</a>"
          )
        }
        $('#pageBtn').append(
          "<a id='nextBtn' href='#'>&raquo;</a>"
        )
        $('#page_1').trigger('click')

        $('#preBtn').click(function () {
          if ($('.active').prev()[0] != $('#preBtn')[0]) {
            $('.active').prev().trigger('click')
          }
        })

        $('#nextBtn').click(function () {
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
    var memberId = [];





    $.ajax({

      type: "GET",

      url: serverRoot + "/json/travelLog/listpageNo=" + no,

      dataType: "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨

      success: function (data) {

        var addData = data;

        $('#contnetList').empty();

        for (let i = 0; i < data.length; i++) {
          $('#contnetList').append(
            "<a href='travelog_view.html?" + data[i].tlno + "'>" +
            "<figure class='effect type02'>" +
            "<strong class='img_wrap'>" +
            "<img id='travelImg" + data[i].tlno +
            "' src='' alt=''>" +
            "<figcaption>" +
            "<h2>" + data[i].title + "</h2>" +
            "<p>View More</p>" +

            "</figcaption>" +
            "</strong>" +
            "<div class='travelog_cont'>" +

            "<span id='member_" + data[i].tlno + "' class='writer'>" +
            // "<img id=memberImg_"+data[i].tlno+">" +
            // "<span id='memberName_'"+data[i].tlno+" class='name'></span>" +
            "</span>" +
            "<span class='day' style='margin-bottom:10px;'>" + data[i].startDate + "-" + data[i].endDate +
            "</span>" +

            "<span class='hashtag' style='height:60px;' id='createDate_" + data[i].tlno + "'></span>" +
            "<ul>" +
            "<li>" +

            "<span>" +
            "<i class='far fa-eye'></i>조회수</span>" +
            "<b>"+data[i].count+"</b>" +
            "</li>" +
            "<li>" +

            "<span>" +
            "<i class='far fa-heart'></i>좋아요</span>" +
            "<b>23</b>" +
            "</li>" +
            "<li>" +

            "<span>" +
            "<i class='far fa-calendar-alt'></i>작성일</span>" +
            "<b id='createDate_" + data[i].tlno + "'>" + data[i].createDate + "</b>" +
            "</li>" +
            "</ul>" +
            "</div>" +
            "</figure>" +
            "</a>")
        }
        photoInsert()
        hashInsert()
        memberInsert()


        function photoInsert() {

          for (let i = 0; i < addData.length; i++) {

            $.ajax({

              type: "GET",

              url: serverRoot + "/json/travelLogContent/" + addData[i].tlno,

              dataType: "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨

              success: function (data) {
                $('#travelImg' + addData[i].tlno).attr('src', serverRoot + '/files/' + data[0].photo)


              }
            })
          }
        }

        function hashInsert() {

          for (let i = 0; i < addData.length; i++) {

            $.ajax({

              type: "GET",

              url: serverRoot + "/json/hashTag/" + addData[i].tlno,

              dataType: "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨

              success: function (data) {
                for (let j = 0; j < data.length; j++) {

                  $('#createDate_' + addData[i].tlno).append(
                    "<a style='z-index:9999;font-weight: bold;' target='_blank' href=../../search.html?"+data[j].content+">" + data[j].content + " <a>"
                  )
                }

              }
            })
          }
        }

        function memberInsert() {

          for (let i = 0; i < addData.length; i++) {
            console.log(addData[i].id)

            $.ajax({

              type: "GET",

              url: serverRoot + "/json/member/" + addData[i].memberId,

              dataType: "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨

              success: function (data) {

                $('#member_' + addData[i].tlno).append(
                  "<img src=" + data.profileImg + ">" +
                  "<span class='name'>" + data.name + " </span>"
                )
                console.log(data.profileImg)
                console.log(data[0].profileImg)


              }
            })
          }
        }



      }
    })
  }