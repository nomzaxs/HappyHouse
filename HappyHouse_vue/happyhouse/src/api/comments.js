import { baseInstance } from "./axios.js";

const base = baseInstance();

// 검색 keyword에 따라 리스트 반환 결과가 달라진다.
// key와 value가 없을 경우 전체 리스트 반환
function listComments(articleno, success, fail) {
  base.get(`/comment/${articleno}`).then(success).catch(fail);
}

// 댓글 등록
function writeComment(comment, success, fail) {
  base.post(`/comment`, JSON.stringify(comment)).then(success).catch(fail);
}

// 댓글 수정
function modifyComment(comment, success, fail) {
  base.put(`comment`, JSON.stringify(comment)).then(success).catch(fail);
}

// 댓글 삭제
function deleteComment(articleno, success, fail) {
  base.delete(`comment/${articleno}`).then(success).catch(fail);
}

// 댓글 공감 수 증가
// function updateHit(commentno, success, fail) {
//   base.put(`comment/${commentno}`).then(success).catch(fail);
// }

export {
  listComments,
  writeComment,
  modifyComment,
  deleteComment,
  // updateHit,
};
