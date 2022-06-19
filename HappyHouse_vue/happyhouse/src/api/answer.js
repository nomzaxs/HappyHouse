import { baseInstance } from "./axios.js";

const base = baseInstance();

// 검색 keyword에 따라 리스트 반환 결과가 달라진다.
// key와 value가 없을 경우 전체 리스트 반환
function listAnswers(articleno, success, fail) {
  base.get(`answer/${articleno}`).then(success).catch(fail);
}

// 댓글 등록
function writeAnswer(answer, success, fail) {
  console.log(answer);
  base.post(`answer`, JSON.stringify(answer)).then(success).catch(fail);
}

// 댓글 수정
function modifyAnswer(answer, success, fail) {
  base.put(`answer`, JSON.stringify(answer)).then(success).catch(fail);
}

// 댓글 삭제
function deleteAnswer(commentno, success, fail) {
  base.delete(`answer/${commentno}`).then(success).catch(fail);
}

export { listAnswers, writeAnswer, modifyAnswer, deleteAnswer };
