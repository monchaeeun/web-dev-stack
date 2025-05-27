function btn1() {
  alert("안녕하세요?");
  console.log(document.body);
  //태그 요소 가져오기(div,p)
  //같은 태그로 여러 개일 수 있으므로 배열로 변환
  const divs = document.getElementsByTagName("div");
  const h1 = document.getElementsByTagName("h1");
  console.log(divs[1]); //2번째 div 가져오기
  console.log(h1);
}
//아이디로 가져오기
//고유한 id로 가져오기 때문에 하나의 태그 선택
function btn2() {
  const testId = document.getElementById("testId");
  console.log(testId);
  const testId2 = document.getElementById("testId2");
  console.log(testId2);
} //클래스로 가져오기
//같은 class명이 여러 개일 수 있으므로 배열로 변환
function btn3() {
  const testClass = document.getElementsByClassName("testClass");
  console.log(testClass);
  console.log(testClass[1]);
} //name으로 가져오기
//같은 name 속셩이 여러개일 수 있으므로 배열로 반환
function btn4() {
  const div = document.getElementsByName("testName");
  console.log(div);
} //선택자 문법 사용 가능(#, .)
function btn5() {
  //1개만 가지오고 싶다면
  const qS = document.querySelector("#testId");
  console.log(testId);
  //여러개를 가져오고 싶다면
  const divs = document.querySelectorAll("div");
  console.log(divs);
}
function btn6() {
  //태그 내용 조작
  const divs = document.querySelectorAll(".testClass");
  //<span>안녕하세요</span>
  divs[0].textContent = "<span>안녕하세요</span>";
  //안녕하세요
  divs[1].innerHTML = "<span>안녕하세요</span>";
  //태그를 문자로 출력
  console.log(divs[1].textContent);
  //태그를 HTML로 출력
  console.log(divs[1].innerHTML);
}
//속성 조작하기
function btn7() {
  const testId = document.getElementById("testId");
  //속성 추가(속성 명, 속성 값)
  testId.setAttribute("data-test", "테스트");
  //속성 값 가져오기
  console.log(testId.getAttribute("data-test"));
  console.log(testId.getAttribute("class"));
  //속성 삭제
  testId.removeAttribute("id");
}
//CSS 조작하기
function btn8() {
  const div = document.querySelector("#testId");
  div.style.color = "teal";
}
//classList 사용하기
const div02 = document.querySelector("#testId2");
function btn9() {
  //class 추가
  div02.classList.add("black"); //black 클래스 추가
}
function btn10() {
  //black class 제거

  div02.classList.remove("black");
}
function btn11() {
  //black 클래스가 있는지 확인

  const has = div02.classList.contains("black");
  console.log("black 클래스가 있는지 : ", has);
  if (has == true) {
    div02.classList.remove("black");
  } else {
    div02.classList.add("black");
  }
}
function btn12() {
  // 있으면 없애고,없애면 생성
  div02.classList.toggle("black");
}
//태그 추가
function btn13() {
  const div = document.querySelector("#testId3");
  const p = document.createElement("p"); //p태그 생성
  p.textContent = "안녕하세요"; //내용 넣기
  div.appendChild(p); //태그 안 자식으로 넣기
}
function btn14() {
  //태그 지우기
  const testId3 = document.querySelector("#testId3");
  const p = document.querySelector("#testId3 p");
  // testId3.removeChild(p); //자식 객체 지우기
  if (p != null) {
    p.remove(); // 최신 브라우저만 가능
  }
}
