window.addEventListener("DOMContentLoaded", () => {
  const click = document.querySelector("#button1 span");
  const button1 = document.querySelector("#button1");
  const img = document.querySelectorAll(".images img");
  let count = 0;
  let randomNum = [0, 1, 2];
  button1.addEventListener("click", (e) => {
    for (let i = 0; i < img.length; i++) {
      //이미지 랜덤하게 바꾸기
      // img[i].getAttribute("src") == `assets/spy${random}.jpg}`;
      console.log(img[i].getAttribute("src"));
      // 랜덤 이미지
      img[i].setAttribute(
        "src",
        `assets/spy${Math.floor(Math.random() * 3 + 1)}.jpg`
      );
      // if (false /*숫자가 같을 때*/) {
      //   e.setAttribute("disabled", true);
      // }
    }
    count += 1;
    click.textContent = `${count}번`;
    console.log(count);
  });
});
