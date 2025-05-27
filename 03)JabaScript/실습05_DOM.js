function dateTime() {
  const dateText = document.querySelector("#dateText");
  const date7 = ["일", "월", "화", "수", "목", "금", "토"];
  const now = new Date();
  dateText.textContent = `${now.getFullYear()}년 ${
    now.getMonth() + 1
  }월 ${now.getDate()}일 (${date7[now.getDay()]})`;
}
dateTime();
let sec = 0;

function ex() {
  const bodyClass = document.querySelector(".bodyClass");
  const english = document.querySelector("#english");
  const footer = document.querySelector("#footer");
  const timeText = document.querySelector("#timeText");
  const now = new Date();
  console.log(now);
  timeText.textContent = `${now.getHours()}:${now.getMinutes()}:${String(
    now.getSeconds()
  ).padStart(2, "0")}`;
  sec++;
  if (sec < 10) {
    bodyClass.style.backgroundColor = "coral";
    english.textContent =
      "Lorem ipsum dolor sit amet consectetur adipisicing elit.";
    footer.textContent = "내면의 평화는 진정한 자유의 첫 단계다.";
  } else if (sec > 10) {
    bodyClass.style.backgroundColor = "darkcyan";
    english.textContent =
      " quibusdam est! Illum, labore. Libero nostrum animi amet?";
    footer.textContent = "너 자신을 알라.";
  } else if (sec > 20) {
    bodyClass.style.backgroundColor = "palevioletred";
    english.textContent =
      " Impedit aut eius velit voluptate ut dicta doloribus itaque,";
    footer.textContent = "산다는 것은 서서히 태어나는 것이다.";
  } else if (sec > 30) {
    bodyClass.style.backgroundColor = "mediumpurple";
    english.textContent = "eveniet labore praesentium earum unde,";
    footer.textContent = "열정 없이 사느니 차라리 죽는 것이 낫다.";
  } else if (sec > 40) {
    sec = 0;
  }
}
ex();

setInterval(() => {
  ex();
}, 1000);

setInterval(() => {
  const limitTime = document.querySelector("#limitTime");
  const now = new Date();
  //날짜 계산
  limitTime.textContent = `올해 남은 시간${now.getDay()}일 ${now.getHours()}시간 ${now.getMinutes()}분 ${now.getSeconds()}초`;
}, 1000);
