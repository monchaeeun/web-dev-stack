//이거 쓰면 DOM쓰기 귀찮아짐
window.addEventListener("DOMContentLoaded", () => {
  //변수 선언
  const click = document.querySelector("#button1 span");
  const button1 = document.querySelector("#button1");
  const img = document.querySelectorAll(".images img");
  const button2 = document.querySelector("#button2");
  const footer = document.querySelector("#footer");
  let count = 0;

  button1.addEventListener("click", () => {
    for (let i = 0; i < img.length; i++) {
      //이미지 랜덤하게 바꾸기
      // img[i].getAttribute("src") == `assets/spy${random}.jpg}`;
      console.log(img[i].getAttribute("src"));
      // 랜덤 이미지
      img[i].setAttribute(
        "src",
        `assets/spy${Math.floor(Math.random() * 3 + 1)}.jpg`
      );
    }
    //이미지 이름 저장
    let img1 = img[0].getAttribute("src");
    let img2 = img[1].getAttribute("src");
    let img3 = img[2].getAttribute("src");
    //이미지가 3개 전부 같을 경우
    if (img1 === img2 && img2 === img3) {
      footer.textContent =
        "축하합니다! 다시 시작하려면 재시작 버튼을 눌러주세요!";
      //버튼 비활성화
      button1.disabled = true;
      // 축하 글자 보이게 css 처리방법
      // footer.visibility : visible
    }
    //횟수 카운트
    count += 1;
    click.textContent = `${count}번`;
  });

  //리셋 버튼
  button2.addEventListener("click", () => {
    count = 0;
    click.textContent = `Click`;
    //이미지 처음처럼 셋팅
    for (let i = 0; i < img.length; i++) {
      img[i].setAttribute("src", `assets/spy${i + 1}.jpg`);
    }
    footer.textContent = "";
    //버튼 활성화
    button1.disabled = false;
    //다른 방법
    // button.setAttribute("disabled", true);
    // button.setAttribute("disabled", "disabled");
  });
  //location.reload(); : 새로고침
  // ->페이지 이동 시 페이지가 깜박거림(원 페이지 방식)/알림 기능, 실시간 기능 안됨
  // = react 활용->해당 부분만 변경
});
