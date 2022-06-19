import { baseInstance } from "./axios.js";

const base = baseInstance();

// 검색 keyword에 따라 리스트 반환 결과가 달라진다.
// key와 value가 없을 경우 전체 리스트 반환
function listQuestion(params, success, fail) {
  if (params.key) {
    base.get(`/qna/${params.key}/${params.value}`).then(success).catch(fail);
  } else {
    base.get(`/qna`).then(success).catch(fail);
  }
}

// 질문 등록
function writeQuestion(qna, success, fail) {
  base.post(`/qna`, JSON.stringify(qna)).then(success).catch(fail);
}

// 질문 상세조회
function getQuestion(articleno, success, fail) {
  base.get(`/qna/${articleno}`).then(success).catch(fail);
}

// 답변 하기
function modifyQuestion(qna, success, fail) {
  base.put(`qna`, JSON.stringify(qna)).then(success).catch(fail);
}

// 질문 삭제
function deleteQuestion(articleno, success, fail) {
  base.delete(`qna/${articleno}`).then(success).catch(fail);
}

// 조회 수 증가
// function updateHit(articleno) {
//   return base.put(`hit/${articleno}`, articleno);
// }

export {
  listQuestion,
  writeQuestion,
  getQuestion,
  modifyQuestion,
  deleteQuestion,
  // updateHit,
};
