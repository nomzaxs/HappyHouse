<template>
  <div class="container">
    <div>
      <h1>
        <strong
          ><img src="https://img.icons8.com/doodle/48/000000/apple-notes.png" />
          글 수정</strong
        >
      </h1>
    </div>
    <notice-input-item
      :buttonType="buttonType"
      style="margin-top: 60px"
    ></notice-input-item>
  </div>
</template>

<script>
import NoticeInputItem from "@/components/notice/commonItem/NoticeInputItem.vue";
export default {
  name: "noticeModify",
  components: {
    NoticeInputItem,
  },
  data() {
    return {
      buttonType: "modify",
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
