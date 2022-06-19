import { baseInstance } from "./axios.js";

const base = baseInstance();

// 검색 keyword에 따라 리스트 반환 결과가 달라진다.
// key와 value가 없을 경우 전체 리스트 반환
function listInterest(username, success, fail) {
  base.get(`interest/${username}`).then(success).catch(fail);
}

// 관심정보 등록
function writeInterest(interest, success, fail) {
  console.log(interest);
  base.post(`interest`, JSON.stringify(interest)).then(success).catch(fail);
}

// 관심정보 삭제
function deleteInterest(interestno, success, fail) {
  base.delete(`interest/${interestno}`).then(success).catch(fail);
}

// 전체주소 불러오기
function getAddress(dongcode, success, fail) {
  base.get(`house/address/${dongcode}`).then(success).catch(fail);
}

export { listInterest, writeInterest, deleteInterest, getAddress };
