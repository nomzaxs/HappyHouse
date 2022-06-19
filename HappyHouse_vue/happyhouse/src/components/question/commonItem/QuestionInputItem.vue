<template>
  <div>
    <label for="input-with-list"
      ><h3><strong>질문</strong></h3></label
    >
    <b-form-input
      v-model="form.subject"
      list="input-list"
      id="input-with-list"
      size="lg"
      placeholder="질문을 입력하세요"
      ref="subject"
    ></b-form-input>
    <label for="input-with-list" style="margin-top: 40px"
      ><h3><strong>내용</strong></h3></label
    >
    <b-form-textarea
      v-model="form.content"
      id="textarea-rows"
      placeholder="내용을 입력하세요"
      rows="15"
      size="lg"
      ref="content"
    ></b-form-textarea>

    <div align="right">
      <b-button
        variant="outline-dark"
        size="lg"
        type="submit"
        class="btn_question"
        v-on:click="onSubmit"
        style="margin-top: 30px; margin-bottom: 20px"
        >{{ buttonType === "answer" ? "답변하기" : "등록" }}</b-button
      >

      <b-button
        type="reset"
        variant="outline-danger"
        size="lg"
        v-on:click="onReset"
        class="btn_question"
        style="margin-top: 30px; margin-left: 20px; margin-bottom: 20px"
        >내용 지우기</b-button
      >
    </div>
  </div>
</template>

<script>
import { writeQuestion, getQuestion, modifyQuestion } from "@/api/question";

export default {
  data() {
    return {
      form: {
        articleno: 0,
        subject: "",
        userid: this.$store.state.auth.user.username,
        content: "",
      },
    };
  },
  props: {
    buttonType: { type: String },
  },
  computed: {},
  created() {
    // 답변 - 미리 글 내용 불러오기
    if (this.buttonType === "answer") {
      this.articleno = this.$route.params.articleno;
      getQuestion(
        this.articleno,
        ({ data }) => {
          console.log(data);
          this.form.articleno = data.articleno;
          this.form.subject = data.subject;
          this.form.content = data.content;
          this.form.userid = data.userid;
          if (!this) {
            this.$router.push({ name: "questionList" });
          }
        },
        (error) => {
          console.log(error);
          alert("글 불러오기에 실패했습니다. 목록으로 돌아갑니다.");
          this.$router.push({ name: "questionList" });
        }
      );
    }
  },
  methods: {
    onSubmit(event) {
      // 유효성 검사
      console.log(this.$refs);
      event.preventDefault();
      let err = true;
      let msg = "";
      err &&
        !this.form.subject &&
        ((msg = "빈 칸 없이 입력해주세요"),
        (err = false),
        this.$refs.subject.focus());
      err &&
        !this.form.content &&
        ((msg = "빈 칸 없이 입력해주세요"),
        (err = false),
        this.$refs.content.focus());

      if (!err) alert(msg);
      else {
        this.buttonType === "answer"
          ? this.modifyQuestion()
          : this.registQuestion();
      }
    },
    onReset(event) {
      event.preventDefault();
      // Reset our form values
      this.form.subject = "";
      this.form.content = "";
    },
    async modifyQuestion() {
      await modifyQuestion(
        {
          articleno: this.form.articleno,
          subject: this.form.subject,
          userid: this.form.userid,
          content: this.form.content,
        },
        ({ data }) => {
          let msg = "답변 중 문제가 발생하였습니다.";
          if (data === "SUCCESS") {
            msg = "답변이 완료되었습니다.";
          }
          alert(msg);
          this.$router.replace({
            name: "questionDetail",
            params: { articleno: this.form.articleno },
          });
        },
        (error) => {
          console.log(error);
          alert("에러가 발생했습니다. 목록으로 돌아갑니다.");
          this.$router.push({ name: "questionList" });
        }
      );
    },
    async registQuestion() {
      await writeQuestion(
        {
          subject: this.form.subject,
          userid: this.form.userid,
          content: this.form.content,
        },
        ({ data }) => {
          let msg = "등록 중 문제가 발생하였습니다.";
          if (data === "SUCCESS") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
          this.$router.push({ name: "questionList" });
        },
        (error) => {
          console.log(this.form);
          console.log(error);
          alert("에러가 발생했습니다. 목록으로 돌아갑니다.");
          this.$router.push({ name: "questionList" });
        }
      );
    },
  },
};
</script>

<style>
.form {
  width: 80%;
}
</style>
