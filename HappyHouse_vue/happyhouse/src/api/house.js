import { baseInstance } from "./axios.js";

const base = baseInstance();

// 시도 리스트 얻어오기
function sidoList(success, fail) {
  base.get(`/house`).then(success).catch(fail);
}

// 구군 리스트 얻어오기
function gugunList(sidocode, success, fail) {
  base.get(`/house/${sidocode}`).then(success).catch(fail);
}

// 동 리스트 얻어오기
function dongList(guguncode, success, fail) {
  base.get(`/house/gugun/${guguncode}`).then(success).catch(fail);
}

// 동코드에 따른 리스트 불러오기
function aptList(dongcode, success, fail) {
  base.get(`/house/dong/${dongcode}`).then(success).catch(fail);
}

// 아파트 이름으로 리스트 얻어오기
function aptListByName(aptname, success, fail) {
  base.get(`/house/name/${aptname}`).then(success).catch(fail);
}

// 아파트 코드에 따른 거래 정보 불러오기
function aptDeal(aptcode, success, fail) {
  base.get(`/house/deal/${aptcode}`).then(success).catch(fail);
}

export { sidoList, gugunList, dongList, aptList, aptListByName, aptDeal };
