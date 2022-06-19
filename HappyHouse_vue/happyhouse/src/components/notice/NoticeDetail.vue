<template>
  <div class="container">
    <div>
      <h1>
        <strong>
          <img src="https://img.icons8.com/doodle/48/000000/search--v1.png" />
          상세 조회
        </strong>
      </h1>
    </div>
    <div class="styled-detail">
      <div
        align="right"
        v-if="notice.userid === $store.state.auth.user.username"
      >
        <!--userinfo.userid === notice.userid-->
        <b-button
          variant="outline-dark"
          size="lg"
          @click="moveModify"
          class="btn_notice mt-4"
          >글 수정</b-button
        >
        <b-button
          variant="outline-danger"
          size="lg"
          @click="deleteNotice"
          class="btn_notice mt-4 ml-3"
          >글 삭제</b-button
        >
      </div>
      <b-card class="mt-3">
        <b-list-group>
          <b-list-group-item
            ><span><strong>제목</strong> </span>
            <span style="margin-left: 130px">
              {{ notice.subject }}</span
            ></b-list-group-item
          >
          <b-list-group-item
            ><span><strong>작성자</strong> </span>
            <span style="margin-left: 120px">{{
              notice.userid
            }}</span></b-list-group-item
          >
          <b-list-group-item
            ><span><strong>작성일</strong> </span>
            <span style="margin-left: 120px">{{
              notice.regtime
            }}</span></b-list-group-item
          >
        </b-list-group>
        <b-card-body>
          {{ notice.content }}
        </b-card-body>
      </b-card>
    </div>
    <notice-comments
      :articleno="articleno"
      style="margin-top: 30px"
    ></notice-comments>
  </div>
</template>
<script>
import { getNotice, deleteNotice } from "@/api/notice.js";
import noticeComments from "@/components/notice/NoticeComments.vue";

export default {
  name: "noticeDetail",
  components: {
    noticeComments,
  },
  data() {
    return {
      articleno: 0,
      notice: [],
    };
  },
  computed: {},
  created() {
    this.articleno = this.$route.params.articleno;
    console.log(this.articleno);
    getNotice(
      this.articleno,
      (response) => {
        this.notice = response.data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods: {
    moveModify() {
      if (confirm("수정하시겠습니까?")) {
        this.$router.replace({
          name: "noticeModify",
          params: { articleno: this.notice.articleno },
        });
      }
    },
    deleteNotice() {
      if (confirm("정말로 삭제하시겠습니까?")) {
        deleteNotice(this.notice.articleno, () => {
          alert("삭제가 완료되었습니다. 목록으로 돌아갑니다.");
          this.$router.push({ name: "noticeList" });
        });
      } // userInfo.userid === this.notice.userid
    },
  },
};
</script>

<style scoped>
h1 {
  text-decoration-thickness: 10px;
  text-decoration-line: underline;
  text-decoration-color: #fae404;
}
</style>
