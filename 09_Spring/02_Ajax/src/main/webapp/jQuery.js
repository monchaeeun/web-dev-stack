//$(document).ready(function () {});
$(function () {
  //const h1 = document.querySelector("h1");
  const pList = document.querySelectorAll("p");

  //h1.style.color = "teal";
  //for (p of pList) {
  // p.style.color = "white";
  //p.style.backgroundColor = "tomato";
  //}
  //제이쿼리 방식
  $("h1").css("color", "skyblue");
  $("p").css({
    color: "whitesmoke",
  });
  $("p").first().css("font-size", "4rem");
  $("p").last().css("backgroundColor", "orchid");
  $("p:eq(2)").text("eq로 다시 글 작성");
  $(".wrap").children().css({
    color: "whitesmoke",
    border: "2px solid whitesmoke",
  });
  $(".wrap").find("h1").css({
    color: "skyblue",
  });
  $("h1").siblings("p").css({
    backgroundColor: "lightpink",
  });

  //DOM 객체
  // 자바 스크립트
  const p = document.createElement("p");
  p.innerText = "자바 스크립트 추가";
  document.querySelector("#content").appendChild(p);

  //제이쿼리
  const p2 = $("<p>").html("제이쿼리로 추가");
  $("#content").append(p2);
  //append : 해당 자식 요소의 뒷부분에 추가
  $("#item").append("<span>prepend</span>");
  $("<span>append to</span>").appendTo("#item");
  //prepend : 해당 자식 요소 앞부분에 추가
  $("#item").prepend("<span>prepend</span>");
  //after : 해당 형제 요소로 뒷부분에 추가
  $("#item").after("<span>after</span>");
  //before : 해당 형제 요소로 앞부분에 추가
  $("#item").before("<span>before</span>");

  //이벤트
  //on : 이벤트 여러개 할 수 있음
  /*
  $("#textarea").on({
    keydown: (e) => {
      console.log(`keydown - e.key : ${e.key}, 
                              e.keyCode : ${e.keyCode}`);
    },
    keypress: (e) => {
      console.log(`keypress - e.key : ${e.key}, 
                              e.keyCode : ${e.keyCode}`);
    },
    keyup: (e) => {
      console.log(`keyup - e.key : ${e.key}, 
                              e.keyCode : ${e.keyCode}`);
    },
  });
*/

  //글자 수 세기 및 제한
  $("#textarea").keyup((e) => {
    let target = $(e.target);
    let length = target.val().length;
    console.log(length);
    if (length >= 50) {
      target.val(target.val().substr(0, 50));
    } else {
      $("#counter").text(length);
    }
  });
  //저장된 값 #userId
  // 글자 #idCheck
  $("#userId").keyup((e) => {
    const idTest = /^[a-z][0-9a-z]{3,11}$/;
    if ($("#userId").val() == "") {
      $("#idCheck").text("아이디를 입력하세요").css("color", "gray");
    } else if (!idTest.test($("#userId").val())) {
      $("#idCheck").text("첫글자는 영문 소문자, 4~12글자").css("color", "red");
    } else {
      $("#idCheck").text("조건에 충족합니다").css("color", "green");
    }
  });
});
