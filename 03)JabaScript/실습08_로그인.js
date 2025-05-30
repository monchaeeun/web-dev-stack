window.addEventListener("DOMContentLoaded", () => {
  const userId = document.querySelector("#userId");
  const password = document.querySelector("#password");
  const join = document.querySelector("#join");
  const header = document.querySelector(".header");
  const mainBox = document.querySelector(".mainBox");

  //클릭
  let idCheck = false;
  let pwCheck = false;
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
      sessionStorage.setItem("name", userId.value);
      const getName = sessionStorage.getItem("name");
      console.log(userId.value);
      header.innerHTML = `${getName}님 환영합니다!`;
      mainBox.innerHTML = `<button id="cancel">로그아웃</button>`;
      //join.textContent = "로그아웃";

      const cancel = document.querySelector("#cancel");

      cancel.addEventListener("click", () => {
        header.innerHTML = "로그인";
        mainBox.innerHTML = `<input type="text" id="userId" placeholder="이름을 입력해주세요" />
        <input
          type="text"
          id="password"
          placeholder="비밀번호를 입력해주세요"
        />
        <div class="allBtn">
          <button id="join" type="submit">로그인</button>
        </div>`;
      });
    }
  });
});
