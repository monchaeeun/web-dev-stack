const market = document.querySelector("#market");
const market2 = document.querySelector("#market2");
const market3 = document.querySelector("#market3");

const fetchUpbit = async () => {
  const result = await fetch(" https://api.upbit.com/v1/market/all");
  const data = await result.json();
  for (let i = 0; i < data.length; i++) {
    // console.log(data[i].market, data[i].market.indexOf("KRW"));
    if (!data[i].market.indexOf("KRW")) {
      market.innerHTML += `<br>${data[i].korean_name} (${data[i].market}) `;
    }
  }
  market.style.fontWeight = "bolder";
  //   console.log(data.length);
};
fetchUpbit();
// 방법2------------------------------------------------------------
//async function dataFetch() {};
//const dataFetch = async function () {};

const dataFetch = async () => {
  const response = await fetch("https://api.upbit.com/v1/market/all");
  const data = await response.json();

  data.forEach((item) => {
    // startsWith 시작 하는 단어 여부
    //includes 포함 여부
    if (item.market.startsWith("KRW")) {
      market2.innerHTML += `<h2>${item.korean_name}(${item.market})</h2>`;
    }
  });
  //   forEach + 조건문 일 경우 => filter
  //새 배열 생성(KRW가 있는 경우만)
  const krwMarkets = data.filter((item) => item.market.includes("KRW"));

  //현재가 정보 가져오기
  //     let markets = "";
  //   krwMarkets.forEach((item) => {
  //     markets += item.market2 + ",";
  //   });

  //forEach + 내가 원하는 형태로 가공하고자 할때 -> map
  const markets = krwMarkets.map((item) => item.market).join(",");
  const tickerResponse = await fetch(
    //상승 & 하락 값 가져오기
    `https://api.upbit.com/v1/ticker?markets=${markets}`
  );
  const tickerData = await tickerResponse.json();
  console.log(tickerData);
  //정보 출력
  krwMarkets.forEach((item) => {
    //같은 값 찾기
    const ticker = tickerData.find((ticker) => ticker.market === item.market);
    market2.innerHTML += `
    <h2>${item.korean_name}(${item.market})</h2>
    <p>현재가 : ${ticker.trade_price.toLocaleString()}</p>
    <p>24시간 거래량 : ${ticker.acc_trade_volume_24h.toFixed(2)}</p>
    <p>전일 대비 : ${
      ticker.change === "RISE"
        ? "상승"
        : ticker.change === "FALL"
        ? "하락"
        : "보합"
    }(${(ticker.change_rate * 100).toFixed(2)}%)</p>
    `;
  });
  //   toLocaleString : , 자동 표시
  //    toFixed(2) : 소수점 2자리까지 표시
};
dataFetch();
