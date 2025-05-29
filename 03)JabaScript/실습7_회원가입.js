//아이디
const userId = document.querySelector("#userId");
const idText = document.querySelector("#idText");
//비번
const userPw = document.querySelector("#userPw");
const pwText = document.querySelector("#pwText");
//비번 다시
let userPwRe = "a";
const PwRe = document.querySelector("#PwRe");
const pwReText = document.querySelector("#pwReText");
//이름
const userName = document.querySelector("#userName");
const nameText = document.querySelector("#nameText");
//이메일 형식
const userEmail = document.querySelector("#userEmail");
const emailText = document.querySelector("#emailText");
//전화번호 형식
const userNum = document.querySelector("#userNum");
const numText = document.querySelector("#numText");
//입력란 확인 여부
let idTrue = false;
let pwTrue = false;
let pwReTrue = false;
let nameTrue = false;
let emailTrue = false;
let numTrue = false;
//회원가입 버튼
const join = document.querySelector("#join");
//취소 버튼
const cancel = document.querySelector("#cancel");
userId.addEventListener("input", (e) => {
  //만약 맞으면 e.target.value
  let idTest = /^[a-zA-Z][a-zA-Z0-9]{3,11}$/;
  if (idTest.test(e.target.value)) {
    idText.textContent = "아이디가 가능합니다.";
    idText.style.color = "green";
    idTrue = true;
  } else {
    idText.textContent = "아이디 형식이 아닙니다.";
    idText.style.color = "red";
    idTrue = false;
  }
  if (e.target.value == "") {
    idText.textContent = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
    idText.style.color = "black";
    idTrue = false;
  }
});
//비밀번호
userPw.addEventListener("input", (e) => {
  let pwTest =
    /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;
  if (pwTest.test(e.target.value)) {
    pwText.textContent = "비밀번호가 가능합니다.";
    pwText.style.color = "green";
    pwTrue = true;
  } else {
    pwText.textContent = "비밀번호 형식이 틀립니다.";
    pwText.style.color = "red";
    pwTrue = false;
  }

  if (e.target.value == "") {
    pwText.textContent = "영문자,숫자,특수문자 조합으로 8~15자 이내";
    pwText.style.color = "black";
    pwTrue = false;
  }
  userPwRe = e.target.value;
});
//비번 확인
PwRe.addEventListener("input", (e) => {
  if (e.target.value == userPwRe) {
    pwReText.textContent = "비밀번호가 일치합니다.";
    pwReText.style.color = "green";
    pwReTrue = true;
  } else {
    pwReText.textContent = "비밀번호가 다릅니다.";
    pwReText.style.color = "red";
    pwReTrue = false;
  }
  if (e.target.value == "") {
    pwReText.textContent = "위 비밀번호와 동일하게";
    pwReText.style.color = "black";
    pwReTrue = false;
  }
});
//이름
userName.addEventListener("input", (e) => {
  let nameTest = /^[가-힣]{2,}$/;
  if (nameTest.test(e.target.value)) {
    nameText.textContent = "가능합니다.";
    nameText.style.color = "green";
    nameTrue = true;
  } else {
    nameText.textContent = "이름 형식이 틀립니다.";
    nameText.style.color = "red";
    nameTrue = false;
  }

  if (e.target.value == "") {
    nameText.textContent = "한글 2자 이상";
    nameText.style.color = "black";
    nameTrue = false;
  }
});
//이메일
userEmail.addEventListener("input", (e) => {
  let emailTest = /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/;
  if (emailTest.test(e.target.value)) {
    emailText.textContent = "가능한 이메일 입니다.";
    emailText.style.color = "green";
    emailTrue = true;
  } else {
    emailText.textContent = "이메일 형식이 아닙니다.";
    emailText.style.color = "red";
    emailTrue = false;
  }

  if (e.target.value == "") {
    emailText.textContent = "이메일 형식";
    emailText.style.color = "black";
    emailTrue = false;
  }
});
//전화번호
userNum.addEventListener("input", (e) => {
  let numTest = /^010-\d{4}-\d{4}$/;
  if (numTest.test(e.target.value)) {
    numText.textContent = "가능한 전화번호 입니다.";
    numText.style.color = "green";
    numTrue = true;
  } else {
    numText.textContent = "전화번호 형식이 아닙니다.";
    numText.style.color = "red";
    numTrue = false;
  }

  if (e.target.value == "") {
    numText.textContent = "전화번호 형식";
    numText.style.color = "black";
    numTrue = false;
  }
});
//회원가입 버튼
join.addEventListener("click", () => {
  if (
    idTrue == pwTrue &&
    pwTrue == pwReTrue &&
    pwReTrue &&
    nameTrue &&
    nameTrue == emailTrue &&
    emailTrue == numTrue
  ) {
    join.setAttribute("disabled", false);
    alert("성공");
  } else {
    join.setAttribute("disabled", true);
  }
});

//취소 버튼
cancel.addEventListener("click", () => {
  //아이디 부분 다시
  userId.value = "";
  idText.textContent = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
  idText.style.color = "black";
  //비번다시
  userPw.value = "";
  pwText.textContent = "영문자,숫자,특수문자 조합으로 8~15자 이내";
  pwText.style.color = "black";
  //비번다시 다시
  PwRe.value = "";
  pwReText.textContent = "위 비밀번호와 동일하게";
  pwReText.style.color = "black";
  //이름 다시
  userName.value = "";
  nameText.textContent = "한글 2자 이상";
  nameText.style.color = "black";
  //이메일 다시
  userEmail.value = "";
  emailText.textContent = "이메일 형식";
  emailText.style.color = "black";
  //전번 다시
  userNum.value = "";
  numText.textContent = "전화번호 형식";
  numText.style.color = "black";
});
//placeholder에 접근
console.log(userId.placeholder);

// 아이디 : /^[a-zA-Z][a-zA-Z0-9]{3,11}$/
// 비밀번호 : /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/
// 이름 : /^[가-힣]{2,}$/
// 이메일 : /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/
// 전화번호 : /^010-\d{4}-\d{4}$/
