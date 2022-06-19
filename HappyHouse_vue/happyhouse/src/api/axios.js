/* axios(Promise 기반 HTTP 클라이언트) instance 생성 */

import axios from "axios";
import { BASE_URL } from "@/config/url";
import TokenService from "../services/token.service";

const token = TokenService.getLocalAccessToken();

// 기본 서버와의 통신
function baseInstance() {
  const instance = axios.create({
    baseURL: BASE_URL,
    headers: {
      "Content-type": "application/json",
      Authorization: `Bearer ${token}`,
    },
  });
  return instance;
}

export { baseInstance }; //houseInstance 사용 시 포함 시킬 것
