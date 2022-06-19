<template>
  <b-container class="center-block col-11 justify-content-center">
    <div>
      <h1>
        <strong
          ><img src="https://img.icons8.com/doodle/48/000000/group.png" />
          커뮤니티</strong
        >
      </h1>
    </div>
    <div class="d-flex align-items-center" style="margin-bottom: 30px">
      <b-button
        class="ml-auto"
        variant="outline"
        size="md"
        @click="moveRegist()"
        ><img src="https://img.icons8.com/doodle/48/000000/notability.png" />
        <h5>글쓰기</h5></b-button
      >
    </div>
    <div>
      <!-- 검색 리스트 / 전체 리스트 -->
      <table class="styled-table" v-if="notices.length">
        <thead>
          <tr>
            <th>No.</th>
            <th>Title</th>
            <th>Writer</th>
            <th>Date</th>
            <th>👀</th>
          </tr>
        </thead>
        <tbody>
          <notice-item
            v-for="(notice, index) in notices"
            :key="notice.articleno"
            :notice="notice"
            :index="index"
          ></notice-item>
        </tbody>
      </table>

      <div v-else class="note1"><h4>등록된 글이 없습니다</h4></div>
    </div>
    <div style="margin-top: 40px">
      <b-input-group class="ml-auto" style="width: 40%">
        <b-form-select
          v-model="params.key"
          :options="options"
          size="lg"
        ></b-form-select>
        <b-form-input
          v-model="params.value"
          size="lg"
          style="width: 40%"
          placeholder="검색어를 입력하세요"
        ></b-form-input>
        <b-button
          class="ml-auto"
          variant="outline-dark"
          size="lg"
          @click="searchList"
        >
          <b-icon icon="search"></b-icon>
        </b-button>
      </b-input-group>
    </div>
  </b-container>
</template>

<script>
import noticeItem from "@/components/notice/commonItem/NoticeItem";
import { listNotice } from "@/api/notice.js";

export default {
  name: "noticeList",
  components: {
    noticeItem,
  },
  data() {
    return {
      options: [
        { text: "분류", value: null, disabled: true },
        { text: "작성자", value: "userid", disabled: false },
        { text: "제목", value: "subject", disabled: false },
        { text: "내용", value: "content", disabled: false },
      ],
      notices: [],
      params: {
        key: null,
        value: "",
      },
    };
  },
  created() {
    listNotice(
      this.params,
      (response) => {
        this.notices = response.data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods: {
    moveRegist() {
      this.$router.push({ name: "noticeRegist" });
    },
    searchList() {
      listNotice(
        this.params,
        (response) => {
          this.notices = response.data;
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};
</script>

<style scoped>
.note1 {
  margin-top: 10px;
  position: relative;
  background: #161616;
  border-radius: 5px;
  max-width: 100%;
  text-align: center;
  padding: 12px;
  color: rgb(249, 249, 249);
}

.note1:before {
  content: "";
  position: absolute;
  top: 0;
  right: 0;
  border-width: 0 16px 16px 0;
  border-style: solid;
  border-color: #ffffff #fcfcfc #ebebeb #d8dadb;
  background: #c7d0d0;
  display: block;
  width: 0;
}

h1 {
  text-decoration-thickness: 10px;
  text-decoration-line: underline;
  text-decoration-color: #fae404;
}
</style>
