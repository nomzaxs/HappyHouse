import { baseInstance } from "./axios.js";

const base = baseInstance();

// 사용자 목록조회
function getUser(success, fail) {
  base.get(`/auth/list`).then(success).catch(fail);
}

// 사용자 삭제
function deleteUser(email, success, fail) {
  base.delete(`/auth/del/${email}`).then(success).catch(fail);
}

export { getUser, deleteUser };
