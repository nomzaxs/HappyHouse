<template>
  <div>
    <hr />
    <div>
      <h5>댓글 수 {{ comments.length }}</h5>
    </div>
    <!-- 해당 공지사항에 달린 댓글 -->
    <div v-for="(comment, index) in comments" :key="comment.commentno">
      <b-form-textarea
        class="mt-2"
        id="textarea-rows"
        rows="3"
        size="lg"
        :disabled="registFlag"
        :value="comments[index].content"
      ></b-form-textarea>

      <div
        align="right"
        v-if="comment.userid === $store.state.auth.user.username"
      >
        <b-button
          type="submit"
          variant="outline-danger"
          size="md"
          @click="onDelete($event, comment)"
          class="btn_notice mt-3 ml-3"
          >삭제</b-button
        >
      </div>
    </div>
    <hr />
    <!-- 댓글 등록 -->
    <div>
      <b-form-textarea
        class="mt-2"
        v-model="item.content"
        id="textarea-rows"
        placeholder="댓글을 등록해보세요 💭"
        rows="3"
        size="lg"
        ref="content"
      ></b-form-textarea>

      <div align="right">
        <b-button
          variant="outline-dark"
          size="md"
          type="submit"
          class="btn_notice mt-3"
          v-on:click="onSubmit"
          >등록</b-button
        >

        <b-button
          type="reset"
          variant="outline-danger"
          size="md"
          v-on:click="onReset"
          class="btn_notice mt-3 ml-3"
          >내용 지우기</b-button
        >
      </div>
    </div>
  </div>
</template>

<script>
import { listAnswers, writeAnswer, deleteAnswer } from "@/api/answer.js";

export default {
  name: "noticeAnswers",
  props: {
    articleno: { type: Number },
  },
  computed: {},
  data() {
    return {
      comments: [],
      item: {
        articleno: 0,
        userid: "", // ** userid 추후 수정
        content: "",
      },
      registFlag: this.registFlagValue(),
    };
  },
  created() {
    this.item.articleno = this.articleno;
    this.item.userid = this.$store.state.auth.user.username;
    listAnswers(
      this.articleno,
      (response) => {
        this.comments = response.data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods: {
    onSubmit(event) {
      // 유효성 검사
      event.preventDefault();
      let err = true;
      let msg = "";
      err &&
        !this.item.content &&
        ((msg = "내용 입력해주세요"),
        (err = false),
        this.$refs.content.focus());

      if (!err) alert(msg);
      else {
        this.registAnswer();
      }
    },
    onReset(event) {
      event.preventDefault();
      // Reset our form values
      this.item.subject = "";
      this.item.content = "";
    },
    onDelete(event, comment) {
      event.preventDefault();
      console.log("commentno", comment);
      // Reset our form values
      deleteAnswer(
        comment.commentno,
        ({ data }) => {
          console.log(data);
          alert("삭제가 완료되었습니다.");
        },
        (error) => {
          console.log(error);
          alert("삭제 중 문제가 발생하였습니다.");
        }
      );
      this.$router.go(-1);
    },
    registAnswer() {
      console.log(this.item);
      writeAnswer(
        this.item,
        ({ data }) => {
          let msg = "등록 중 문제가 발생하였습니다.";
          if (data === "SUCCESS") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
        },
        (error) => {
          console.log(error);
          alert("에러가 발생했습니다. 원래 페이지로 돌아갑니다.");
        }
      );
      this.$router.go(-1);
    },
    registFlagValue() {
      return "disabled";
    },
  },
};
</script>

<style scoped>
textarea:disabled {
  background: #fbfbf7;
}
</style>
