<template>
  <div id="app">
    <header-nav></header-nav>
    <router-view style="padding-top: 20px" />
    <footer-content style="padding-top: 100px"></footer-content>
  </div>
</template>
<script>
import HeaderNav from "@/components/HeaderNav.vue";
import FooterContent from "@/components/FooterContent.vue";

export default {
  name: "App",
  components: { HeaderNav, FooterContent },
};
</script>

// 모든 곳에서 적용할 공통 css
<style src="@/css/common.css"></style>
