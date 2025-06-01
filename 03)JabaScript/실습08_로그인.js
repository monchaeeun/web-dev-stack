window.addEventListener("DOMContentLoaded", () => {
  const userId = document.querySelector("#userId");
  const password = document.querySelector("#password");
  const join = document.querySelector("#join");
  const header = document.querySelector(".header");
  const mainBox = document.querySelector(".mainBox");

  //클릭
  let idCheck = false;
  let pwCheck = false;

  //코드 중복 함수 기능

  const show = () => {
    document.mainBox.innerHTML = `<div>${getName}님 환영합니다!<div>`;
    mainBox.innerHTML = `<button id="cancel">로그아웃</button>`;
    /*
    const cancel = document.querySelector("#cancel");
      cancel.addEventListener("click",() =>{
      localStorage.removeItem("name");
      location.reload();      
    })
    */
  };

  //이름 입력 란
  userId.addEventListener("input", (e) => {
    if (userId.value !== "") {
      idCheck = true;
      console.log(e.target.value);
      console.log("아이디 : ", idCheck);
    }
    if (userId.value === "") {
      idCheck = false;
      console.log("아이디 : ", idCheck);
    }
  });
  //비번 입력 란
  password.addEventListener("input", (e) => {
    if (e.target.value !== "") {
      pwCheck = true;
      console.log(e.target.value);
      console.log("비번 : ", pwCheck);
    } else if (e.target.value == "") {
      pwCheck = false;
      console.log("비번 : ", pwCheck);
    }
  });
  //화면 전환
  join.addEventListener("click", () => {
    //00님 환영합니다!
    if (idCheck && pwCheck) {
      localStorage.setItem("name", userId.value);
      const getName = localStorage.getItem("name");

      localStorage.setItem("password", password.value);
      const getPw = localStorage.getItem("name");
      console.log(userId.value);
      header.innerHTML = `${getName}님 환영합니다!`;
      mainBox.innerHTML = `<button id="cancel">로그아웃</button>`;
      //join.textContent = "로그아웃";

      const cancel = document.querySelector("#cancel");

      cancel.addEventListener("click", () => {
        localStorage.removeItem("name");
        location.reload();
      });
    }
    //방법 2

    /*아이디 입력, 비번 입력 값들 로그인 처리
    로그인을 성공하고 이름을 저장
    .addEventListener("click", () => {
      //둘 증 하나가 값이 없을 때
      if(userId.value === && password.value === "")
      {
      alert("이름과 비밀번호를 입력해주세요");
       return; //아무것도 없이 저장 방지
      }
      localStorage.setItem("name", userId.value);
       show(userId.value);
    })
    
    
    */
  });
});
