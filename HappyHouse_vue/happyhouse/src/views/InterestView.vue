<template>
  <b-container class="center-block col-7 justify-content-center">
    <my-interest></my-interest>
  </b-container>
</template>

<script>
import MyInterest from "@/components/mypage/MyInterest.vue";

export default {
  name: "interestView",
  components: {
    MyInterest,
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
