<template>
  <tr>
    <td>{{ index + 1 }}</td>
    <td>
      <router-link
        :to="{
          name: 'questionDetail',
          params: { articleno: question.articleno },
        }"
        >{{ question.subject }}</router-link
      >
    </td>
    <td>{{ question.userid }}</td>
    <td>{{ question.regtime | dateFormat }}</td>
    <td>{{ question.hit }}</td>
  </tr>
</template>

<script>
import moment from "moment"; // 날짜 관련 라이브러리 (필터)

export default {
  name: "questionItem",
  props: {
    question: { type: Object, required: true },
    index: {
      type: Number,
      required: true,
    },
  },
  filters: {
    dateFormat(regtime) {
      return moment(new Date(regtime)).format("YY.MM.DD");
    },
  },
};
</script>

<style></style>
