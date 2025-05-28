// DOMContentLoaded 이벤트는 HTML 문서의 구조가 완전히 로드한 후 발생
window.addEventListener("DOMContentLoaded", () => {
  const h1Tag = document.querySelector("h1");
  h1Tag.style.color = "teal";

  //   클릭 이벤트
  const click = document.querySelector("#click");
  //click
  click.addEventListener("click", () => {
    //클릭 이벤트가 일어나면 행하고자 하는 코드 작성
    alert("클릭 이벤트 발생");
    //click 색상 변경
    click.style.backgroundColor = "cadetblue";
  });

  const double = document.querySelector("#double");
  //dblclick
  double.addEventListener("dblclick", () => {
    alert("더블 클릭 발생");
  });

  const right = document.querySelector("#right");
  //contextmenu
  right.addEventListener("contextmenu", () => {
    alert("우클릭 발생");
    event.preventDefault(); //우클릭 창띄우기 방지
  });

  const hover = document.querySelector("#hover");
  //mouseEnter
  hover.addEventListener("mouseenter", () => {
    console.log("mouse Enter!");

    hover.style.backgroundColor = "darkslategrey";
    hover.textContent = "Enter!";
  });
  //mouseLeave
  hover.addEventListener("mouseleave", () => {
    console.log("mouse Leave!");
    hover.style.backgroundColor = "olive";
    hover.textContent = "Leave!";
  });
  // 폼 이벤트
  // input 실시간 반영
  const input = document.querySelector("#input");
  const inputResult = document.querySelector("#inputResult");
  //input
  input.addEventListener("input", (e) => {
    console.log(e.target.value);
    inputResult.textContent = e.target.value;
  });
  //select 선택 값 출력
  const select = document.querySelector("#select");
  const selectResult = document.querySelector("#selectResult");
  //change
  select.addEventListener("change", (e) => {
    console.log(e.target.value);
    selectResult.textContent = e.target.value;
  });
  //submit - 제출 순간 찾기
  const form = document.querySelector("#form");
  const inputText = document.querySelector("#form input");
  form.addEventListener("submit", (e) => {
    //e.preventDefault(); //전송 안됨.

    //값이 없는 경우만 전송불가, 값이 있으면 전송
    if (inputText.value === "") {
      e.preventDefault();
    }
  });
  // 키 이벤트(키보드 입력 순간) ; heydown, keypress, keyup
  const keyboard = document.querySelector("#keyboard");
  const keyResult = document.querySelector("#keyResult");
  keyboard.addEventListener("keydown", (e) => {
    console.log(e.key);
    keyResult.textContent = e.key;
    if (e.key === "Enter") {
      alert("엔터!");
    }
  });
  //박스 움직이기
  let x = 0;
  let y = 0;
  const move = document.querySelector(".moveBox");
  document.addEventListener("keydown", (e) => {
    console.log(e.key);
    if (e.key == "ArrowUp") {
      y -= 10;
      e.key = "";
      move.style.top = `${y}px`;
    }
    if (e.key == "ArrowDown") {
      y += 10;
      e.key = "";
      move.style.top = `${y}px`;
    }
    if (e.key == "ArrowLeft") {
      x -= 10;
      e.key = "";
      move.style.left = `${x}px`;
    }
    if (e.key == "ArrowRight") {
      x += 10;
      move.style.left = `${x}px`;
      e.key = "";
    }
  });

  // 스크롤 이벤트
  const wheel = document.querySelector("#wheel");
  const scroll = document.querySelector("#scroll");
  window,
    addEventListener("wheel", (e) => {
      console.log(e.deltaY);
      // 휠을 올렸더니 -
      if (e.deltaY < 0) {
        wheel.textContent = "스크롤 올리는 중!";
      }
      // 휠을 내렸더니 +
      if (e.deltaY > 0) {
        wheel.textContent = "스크롤 내리는 중@";
      }
    });
  window.addEventListener("scroll", () => {
    // 전체 높이
    // console.log("스크롤 Height : " + document.documentElement.scrollHeight);
    // //화면 보이는 높이
    // console.log("inner height : " + window.innerHeight);

    // console.log("scrollY : " + window.scrollY);
    //scrollHeight === innerHeight + scrolY
    //스크롤 총 내리는 높이 : scrollHeight - innerHeight
    const totalHeight =
      document.documentElement.scrollHeight - window.innerHeight;
    //
    const percent = (window.scrollY / totalHeight) * 100;
    console.log(Math.floor(percent));
    // const bar = `${Math.floor(percent)}%`;
    scroll.style.width = `${percent}%`;
  });

  //이벤트 위임
  //이미지가 클릭될 때마다 해당 이미지 지우기
  const img = document.querySelectorAll(".container img");
  console.log(img);
  // 1. 이미지마다 이벤트 걸려면 반복문 필요
  for (let i = 0; i < img.length; i++) {
    img[i].addEventListener("click", (e) => {
      // img[i].style.display = "none";
      //클릭하면 타겟으로 설정
      console.log(e.currentTarget);
      e.currentTarget.style.display = "none";
    });
  }

  //2. 부모의 컨테이너에  이벤트 걸기
  // const container = document.querySelector(".container");
  // const removeHandler = (e) => {
  //   console.log("target", e.target); //내가 클릭한 이미지 선택
  //   console.log("current", e.currentTarget); //이벤트 걸린 본인

  //   if (e.target !== e.currentTarget) {
  //     e.target.style.display = "none";
  //   }
  // };
  // container.addEventListener("click", removeHandler);
});
