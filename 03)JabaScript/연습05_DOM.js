// 1번 문제
function printText() {
  const test01 = document.querySelector("#result1");
  test01.textContent = "안녕하세요.";
}

// 2번 문제
/*input 은 value로 입력된 값을 가져올 수 있다.*/
function printInputValue() {
  const test02 = document.querySelector("#result2");
  const customer = document.querySelector("#customer");
  //버튼의 input 값을 test02에 할당
  test02.textContent = customer.value;
  customer.value = null;
  //할당한 값을 출력
}

// 3번 문제
function changeColor() {
  const test03 = document.querySelector(".div-test");
  test03.style.backgroundColor = "teal";
}

// 4번 문제
function stringLength() {
  result4 = document.querySelector("#result4");
  test04 = document.querySelector("#text");

  const Len = test04.value;
  result4.textContent = Len.length;
}

// 5번 문제
function stringSplit() {
  const la1 = document.querySelector("#la");
  const result5 = document.querySelector("#result5");
  const ulList = la1.textContent.split(",");
  const allUl = document.createElement("ul");
  result5.appendChild(allUl);
  const li1 = document.createElement("li");
  const li2 = document.createElement("li");
  const li3 = document.createElement("li");
  const li4 = document.createElement("li");

  li1.textContent = ulList[0];
  allUl.appendChild(li1);
  li2.textContent = ulList[1];
  allUl.appendChild(li2);
  li3.textContent = ulList[2];
  allUl.appendChild(li3);
  li4.textContent = ulList[3];
  allUl.appendChild(li4);
}

// 6번 문제
function arrayTest() {
  const preview = document.querySelector("#preview");
  const remove = document.querySelector("#remove");
  const add = document.querySelector("#add");

  const arryList = preview.textContent.split(" ");
  const pizza1 = "피자";
  const chicken1 = "치킨";
  const riceCake1 = "떡볶이";
  console.log(arryList);
  // console.log(pizza);
  // console.log(remove.value);

  //삭제
  if (pizza1 == remove.value) {
    arryList.splice(pizza1, 1);
  } else if (chicken1 == remove.value) {
    arryList.splice(chicken1, 1);
  } else if (riceCake1 == remove.value) {
    arryList.splice(riceCake1, 1);
  }

  console.log(arryList);
  //생성
  if (pizza1 == add.value) {
    arryList.splice(0, 0, "피자");
  } else if (chicken1 == add.value) {
    arryList.splice(0, 0, "치킨");
  } else if (riceCake1 == add.value) {
    arryList.splice(0, 0, "떡볶이");
  }

  preview.textContent = arryList.join(" ");
  console.log(arryList);
  //문자열이 있나 없나 확인
  console.log(arryList.includes(remove.value));
  //   if(arryList.includes(remove.value)) arryList.splice(remove.value,1);
  //   arryList.push(add.value);
}

// 7번 문제
function addStudent() {
  const name1 = document.querySelectorAll(".name");
  const age1 = document.querySelectorAll(".age");
  const addr1 = document.querySelectorAll(".addr");

  console.log(name1.length);
  for (let i = 0; i < name1.length; i++) {
    let name = prompt(i + "번쨰 이름을 입력하세요.");
    let age = prompt(i + "번쨰 나이를 입력하세요");
    let addr = prompt(i + "번쨰 주소를 입력하세요");

    console.log(name);
    console.log(age);
    console.log(addr);

    name1[i].innerHTML = name;
    age1[i].innerHTML = age;
    addr1[i].innerHTML = addr;
  }
}

// 8번
const list = document.querySelector("#list");
function addItem() {
  //1. li 태그로 문자를 추가하는 방식
  const plusLi = document.createElement("li");
  list.appendChild(plusLi);
  console.log("추가");
  //2. innerHTML로 문자를 추가하는 방식
  //list.innerHTML += "<li></li>"'
}
function removeItem() {
  const plusLi = document.querySelector("#list li");

  if (plusLi != null) {
    //부모에서 제거
    // list.removeChild(plusLi);
    // 자식들 중에 지정한 1개만 제거
    // list.removeChild(list.childNodes[0]);
    console.log("삭제");
    //자신이 제거
    const lir = document.querySelector("#list li");
    plusLi.remove();
  }
}

// 9번
function toggleClass() {
  const div_test = document.querySelector("#result9");
  const has = div_test.classList.contains("active");

  if (has == true) {
    div_test.classList.remove("active");
  } else {
    div_test.classList.add("active");
  }
}

// 10번
let totalPrice = 0;
function addToCart() {
  const item = document.querySelector("#item");
  const price = document.querySelector("#price");

  const cart = document.querySelector("#cart");
  const total = document.querySelector("#total span");
  let itemList = document.createElement("li");
  console.log(isNaN(Number(price.value)));
  //총액 계산
  if (!isNaN(Number(price.value))) {
    totalPrice += Number(price.value);
    console.log(totalPrice);
    total.textContent = `${totalPrice}`;
  }
  itemList.textContent = item.value + " => " + price.value + "원";
  item.value = "";
  price.value = "";
  cart.appendChild(itemList);

  item.value;
}
