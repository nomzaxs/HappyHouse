<template>
  <div class="container">
    <div>
      <h1>
        <strong
          ><img src="https://img.icons8.com/doodle/48/000000/apple-notes.png" />
          글 답변</strong
        >
      </h1>
    </div>
    <question-input-item
      :buttonType="buttonType"
      style="margin-top: 60px"
    ></question-input-item>
  </div>
</template>

<script>
import QuestionInputItem from "@/components/question/commonItem/QuestionInputItem.vue";
export default {
  name: "questionModify",
  components: {
    QuestionInputItem,
  },
  data() {
    return {
      buttonType: "answer",
    };
  },
};
</script>

<style scoped>
.form {
  width: 80%;
}

h1 {
  text-decoration-thickness: 10px;
  text-decoration-line: underline;
  text-decoration-color: #fae404;
}
</style>
