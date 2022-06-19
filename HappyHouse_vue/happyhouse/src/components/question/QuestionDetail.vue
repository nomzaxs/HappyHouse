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
        v-if="$store.state.auth.user.roles[0] === 'ROLE_ADMIN'"
      >
        <b-button
          variant="outline-dark"
          size="lg"
          @click="moveModify"
          class="btn_question mt-4"
          >답변하기</b-button
        >
        <b-button
          variant="outline-danger"
          size="lg"
          @click="deleteQuestion"
          class="btn_question mt-4 ml-3"
          >글 삭제</b-button
        >
      </div>
      <b-card class="mt-3">
        <b-list-group>
          <b-list-group-item
            ><span><strong>질문</strong> </span>
            <span style="margin-left: 130px">
              {{ question.subject }}</span
            ></b-list-group-item
          >
          <b-list-group-item
            ><span><strong>작성자</strong> </span>
            <span style="margin-left: 120px">{{
              question.userid
            }}</span></b-list-group-item
          >
          <b-list-group-item
            ><span><strong>작성일</strong> </span>
            <span style="margin-left: 120px">{{
              question.regtime
            }}</span></b-list-group-item
          >
        </b-list-group>
        <b-card-body>
          {{ question.content }}
        </b-card-body>
      </b-card>
    </div>
  </div>
</template>
<script>
import { getQuestion, deleteQuestion } from "@/api/question.js";

export default {
  name: "questionDetail",
  components: {},
  data() {
    return {
      articleno: 0,
      question: [],
    };
  },
  computed: {},
  created() {
    this.articleno = this.$route.params.articleno;
    console.log(this.articleno);
    getQuestion(
      this.articleno,
      (response) => {
        this.question = response.data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods: {
    moveModify() {
      if (confirm("답변하시겠습니까?")) {
        this.$router.replace({
          name: "questionModify",
          params: { articleno: this.articleno },
        });
      }
    },
    deleteQuestion() {
      if (confirm("정말로 삭제하시겠습니까?")) {
        deleteQuestion(this.question.articleno, () => {
          alert("삭제가 완료되었습니다. 목록으로 돌아갑니다.");
          this.$router.push({ name: "questionList" });
        });
      } // userInfo.userid === this.question.userid
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
