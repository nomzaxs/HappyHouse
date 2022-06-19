import { baseInstance } from "./axios.js";

const base = baseInstance();

// 검색 keyword에 따라 리스트 반환 결과가 달라진다.
// key와 value가 없을 경우 전체 리스트 반환
function listNotice(params, success, fail) {
  if (params.key) {
    base.get(`/notice/${params.key}/${params.value}`).then(success).catch(fail);
  } else {
    base.get(`/notice`).then(success).catch(fail);
  }
}

// 공지사항 등록
function writeNotice(notice, success, fail) {
  base.post(`/notice`, JSON.stringify(notice)).then(success).catch(fail);
}

// 공지사항 상세조회
function getNotice(articleno, success, fail) {
  base.get(`/notice/${articleno}`).then(success).catch(fail);
}

// 공지사항 수정
function modifyNotice(notice, success, fail) {
  base.put(`notice`, JSON.stringify(notice)).then(success).catch(fail);
}

// 공지사항 삭제
function deleteNotice(articleno, success, fail) {
  base.delete(`notice/${articleno}`).then(success).catch(fail);
}

// 조회 수 증가
// function updateHit(articleno) {
//   return base.put(`hit/${articleno}`, articleno);
// }

export {
  listNotice,
  writeNotice,
  getNotice,
  modifyNotice,
  deleteNotice,
  // updateHit,
};
