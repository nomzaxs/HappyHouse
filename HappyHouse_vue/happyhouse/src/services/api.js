import axios from "axios";

const instance = axios.create({
  baseURL: "http://localhost:9999/happyhouse",
  headers: {
    "Content-Type": "application/json",
  },
});

export default instance;
