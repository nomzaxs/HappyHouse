<template>
  <tr>
    <td>{{ index + 1 }}</td>
    <td>
      <router-link
        :to="{
          name: 'noticeDetail',
          params: { articleno: notice.articleno },
        }"
        >{{ notice.subject }}</router-link
      >
    </td>
    <td>{{ notice.userid }}</td>
    <td>{{ notice.regtime | dateFormat }}</td>
    <td>{{ notice.hit }}</td>
  </tr>
</template>

<script>
import moment from "moment"; // 날짜 관련 라이브러리 (필터)

export default {
  name: "noticeItem",
  props: {
    notice: { type: Object, required: true },
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
