//회원가입 버튼
const join = document.querySelector("#join");

const fields = [
  {
    id: "userId",
    exp: /^[a-zA-Z][a-zA-Z0-9]{3,11}$/,
    message: "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내",
    check: false,
  },
  {
    id: "userPw",
    exp: /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/,
    message: "영문자, 숫자, 특수문자 조합으로 8~15자 이내",
    check: false,
  },
  {
    id: "pwRe",
    message: "위 비밀번호와 동일하게",
    check: false,
  },
  {
    id: "userName",
    exp: /^[가-힣]{2,}$/,
    message: "한글 2자 이상,",
    check: false,
  },
  {
    id: "userEmail",
    exp: /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/,
    message: "이메일 형식",
    check: false,
  },
  {
    id: "userNum",
    exp: /^010-\d{4}-\d{4}$/,
    message: "전화번호 형식",
    check: false,
  },
];
//함수 형식
fields.forEach(({ id, exp, message, check }) => {
  console.log(id);
  console.log(exp);
  console.log(message);
  const input = document.querySelector(`#${id}`);
  const span = document.querySelector(`#${id}Text`);
  let numTest = exp;
  const password = document.querySelector("#userPw");
  const passRegExp = fields[1].exp;
  input.addEventListener("input", (e) => {
    const pwcheck = document.querySelector("#pwRe");

    if (id === "pwRe") {
      id.addEventListener("input", (e) => {
        if (pwTest.test(e.target.value)) {
          pwText.textContent = "비밀번호가 가능합니다.";
          pwText.style.color = "green";
          pwTrue = true;
        } else {
          pwText.textContent = "비밀번호 형식이 틀립니다.";
          pwText.style.color = "red";
          pwTrue = false;
        }
        //아무것도 없을 때
        if (e.target.value == "") {
          pwText.textContent = "영문자,숫자,특수문자 조합으로 8~15자 이내";
          pwText.style.color = "black";
          pwTrue = false;
        }
      });
      //비번 다시 바꿀 때
      if (PwRe.value != "" && e.target.value !== PwRe.value) {
        pwReText.textContent = "비밀번호가 다릅니다.";
        pwReText.style.color = "red";
        pwReTrue = false;
      }
      //바꾸고 다시 확인 란에 맞췄을 떄
      if (e.target.value == PwRe.value) {
        pwReText.textContent = "비밀번호가 일치합니다.";
        pwReText.style.color = "green";
        pwReTrue = true;
      }
      //비번확인 란이 비워졌을 때 원래 글자로
      if (PwRe.value == "") {
        pwReText.textContent = "위 비밀번호와 동일하게";
        pwReText.style.color = "black";
        pwReTrue = false;
      }
    } else if (numTest.test(e.target.value)) {
      span.textContent = "가능합니다.";
      span.style.color = "green";
      numTrue = true;
    } else {
      span.textContent = message;
      span.style.color = "red";
      numTrue = false;

      if (e.target.value == "") {
        span.textContent = message;
        span.style.color = "black";
        check = false;
      }
      join.disabled = fields.every((fields) => fields.check === true);

      if (idTrue && pwTrue && pwReTrue && nameTrue && emailTrue && numTrue) {
        join.setAttribute("disabled", false);

        alert("성공");
      } else {
        join.setAttribute("disabled", true);
      }
    }
  });
});

//비번
const userPw = document.querySelector("#userPw");
const pwText = document.querySelector("#pwText");
//비번 다시
let userPwRe = "a";
const PwRe = document.querySelector("#PwRe");
const pwReText = document.querySelector("#pwReText");

//취소 버튼
const cancel = document.querySelector("#cancel");

//비밀번호
let pwTest = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;
userPw.addEventListener("input", (e) => {
  // console.log("비번확인 : ", PwRe.value);
  // console.log("비번 : ", e.target.value);
  if (pwTest.test(e.target.value)) {
    pwText.textContent = "비밀번호가 가능합니다.";
    pwText.style.color = "green";
    pwTrue = true;
  } else {
    pwText.textContent = "비밀번호 형식이 틀립니다.";
    pwText.style.color = "red";
    pwTrue = false;
  }
  //아무것도 없을 때
  if (e.target.value == "") {
    pwText.textContent = "영문자,숫자,특수문자 조합으로 8~15자 이내";
    pwText.style.color = "black";
    pwTrue = false;
  }
  //비번 다시 바꿀 때
  if (PwRe.value != "" && e.target.value !== PwRe.value) {
    pwReText.textContent = "비밀번호가 다릅니다.";
    pwReText.style.color = "red";
    pwReTrue = false;
  }
  //바꾸고 다시 확인 란에 맞췄을 떄
  if (e.target.value == PwRe.value) {
    pwReText.textContent = "비밀번호가 일치합니다.";
    pwReText.style.color = "green";
    pwReTrue = true;
  }
  //비번확인 란이 비워졌을 때 원래 글자로
  if (PwRe.value == "") {
    pwReText.textContent = "위 비밀번호와 동일하게";
    pwReText.style.color = "black";
    pwReTrue = false;
  }
});
//비번 확인
PwRe.addEventListener("input", (e) => {
  userPwRe = userPw.value;
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

//다른 방법 2
//00.disabled = !(pwReTrue&&idTrue...)

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
