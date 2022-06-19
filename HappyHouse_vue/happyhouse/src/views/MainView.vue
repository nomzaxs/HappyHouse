<template>
  <main-content />
</template>

<script>
// @ is an alias to /src
import MainContent from "@/components/main/MainContent.vue";

export default {
  name: "MainView",
  created() {
    if (!this.$store.state.auth.user) {
      this.$router.push("login");
    }
  },
  components: {
    MainContent,
  },
};
</script>

<style scoped></style>
