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
//화면 전환 함수
function ex() {
  const bodyClass = document.querySelector(".bodyClass");
  const english = document.querySelector("#english");
  const footer = document.querySelector("#footer");
  const timeText = document.querySelector("#timeText");
  sec += 1;
  const now = new Date();
  console.log(now);
  timeText.textContent = `${String(now.getHours()).padStart(2, 0)}:${String(
    now.getMinutes()
  ).padStart(2, "0")}:${String(now.getSeconds()).padStart(2, 0)}`;
}
//ex 실행
ex();
setInterval(() => {
  ex();
}, 1000);

//남은 시간 계산
function limitTimes() {
  const limitTime = document.querySelector("#limitTime");
  const now = new Date();
  const newYear = new Date(2026, 0, 1, 0, 0, 0);
  const diff = newYear - now;
  console.log(diff);
  //일수 계산
  const days = Math.floor(diff / (1000 * 60 * 60 * 24));
  console.log(days);
  //시 계산
  const hours = Math.floor(diff / (1000 * 60 * 60));
  const hrs = hours - days * 24; //일 수는 삭제하고 시간만 남김
  console.log(hrs);
  //분 계산
  const minutes = Math.floor(diff / (1000 * 60));
  const mte = minutes - hours * 60; //시간은 삭제하고 분 단위만 남김
  console.log(mte);
  //초 계산
  const seconds = Math.floor(diff / 1000);
  const scs = seconds - minutes * 60; //분 단위는 삭제하고 초만 남김
  //남은 날짜 출력
  limitTime.textContent = `올해 남은 시간 ${days}일 ${hrs}시간 ${mte}분 ${scs}초`;
}
//남은 시간 계산 실행
limitTimes();
setInterval(() => {
  limitTimes();
}, 1000);

const quotes = [
  {
    en: "God doesn't require us to suceed: he only requires that you try.",
    ko: "신은 우리에게 성공할 것을 요구하지 않는다. 우리가 노력할 것을 요구할 뿐이다.",
  },
  {
    en: "Hold faithfulness and sincerity as first principles.",
    ko: "충심과 성실을 첫 번째 원칙으로 삼아라",
  },
  {
    en: "Only actions give life strength: Only moderation gives it a charm",
    ko: "행동만이 삶에 힘을 주고 절제만이 삶에 매력을 준다",
  },
  {
    en: "I'm as proud of we don't do as I am of what we do.",
    ko: "우리가 이룬 것만큼, 우리가 이루지 못한 것도 자랑스럽습니다.",
  },
  {
    en: "No one has ever made a difference by being like everyone else.",
    ko: "그저 남들과 똑같이 살면서 차이를 만들어낸 사람은 없어요",
  },
  {
    en: "Don't pay any attention to what they write about you. Just measure it in inches",
    ko: "그들이 당신에 대해 뭐라고 쓰든 전혀 신경쓰지 마라. 다만 그것을 자세히 평가하라",
  },
];

const count = () => {};

const randomQuote = () => {
  const random = quotes[Math.floor(Math.random() * quotes.length)];
  const quoteE = document.querySelector("#quoteE");
  const quoteK = document.querySelector("#quoteK");
  console.log(random.en);
  console.log(random.ko);
  quoteE.innerHTML = random.en;
  quoteK.innerHTML = random.ko;
};

randomQuote();
setInterval(() => {
  randomQuote();
}, 1000);
// if (sec < 10) {
//     bodyClass.style.backgroundColor = "coral";
//     english.textContent =
//       "Lorem ipsum dolor sit amet consectetur adipisicing elit.";
//     footer.textContent = "내면의 평화는 진정한 자유의 첫 단계다.";
//   } else if ((sec > 10, sec < 20)) {
//     bodyClass.style.backgroundColor = "darkcyan";
//     english.textContent =
//       " quibusdam est! Illum, labore. Libero nostrum animi amet?";
//     footer.textContent = "너 자신을 알라.";
//   } else if ((sec > 20, sec < 30)) {
//     bodyClass.style.backgroundColor = "palevioletred";
//     english.textContent =
//       "Impedit aut eius velit voluptate ut dicta doloribus itaque,";
//     footer.textContent = "산다는 것은 서서히 태어나는 것이다.";
//   } else if ((sec > 30, sec < 40)) {
//     bodyClass.style.backgroundColor = "palevioletred";
//     english.textContent =
//       "Impedit aut eius velit voluptate ut dicta doloribus itaque,";
//     footer.textContent = "산다는 것은 서서히 태어나는 것이다.";
//   } else if ((sec > 40, sec < 50)) {
//     bodyClass.style.backgroundColor = "mediumpurple";
//     english.textContent = "eveniet labore praesentium earum unde,";
//     footer.textContent = "열정 없이 사느니 차라리 죽는 것이 낫다.";
//   } else if (sec == 50) {
//     sec = 0;
//   }
