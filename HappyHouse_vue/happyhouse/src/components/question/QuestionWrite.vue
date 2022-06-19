<template>
  <div class="container">
    <div>
      <h1>
        <strong
          ><img src="https://img.icons8.com/doodle/35/000000/why-quest.png" />
          문의사항 등록</strong
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
  name: "questionRegist",
  components: {
    QuestionInputItem,
  },
  data() {
    return {
      buttonType: "",
    };
  },
  methods: {},
};
</script>

<style scoped>
h1 {
  text-decoration-thickness: 10px;
  text-decoration-line: underline;
  text-decoration-color: #fae404;
}
</style>
