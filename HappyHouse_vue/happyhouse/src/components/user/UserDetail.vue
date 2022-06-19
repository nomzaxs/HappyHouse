<template>
  <b-container fluid style="width: 90%; margin-top: 20px">
    <div>
      <h1>
        <strong
          ><img src="https://img.icons8.com/doodle/48/000000/information.png" />
          마이페이지
        </strong>
      </h1>
    </div>
    <b-row>
      <b-col cols="6">
        <div class="jumbotron mt-5" id="jumbotron_user">
          <h4>
            <img
              src="https://img.icons8.com/doodle/48/000000/panda.png"
            /><strong>&nbsp;&nbsp;&nbsp;{{ currentUser.username }}</strong> 님,
            오늘도 행복한 하루 보내세요 😊
          </h4>
          <p>
            <b-button variant="dark" @click="moveModify()" class="ml-5 mt-5">
              <h3>비밀번호 수정</h3></b-button
            >
          </p>
        </div>
        <div id="content">
          <b-row>
            <p>
              <strong>Email:</strong>
              {{ currentUser.email }}
            </p>
          </b-row>
          <b-row class="mt-3">
            <strong>Authorities:</strong>
            <ul>
              <li v-for="(role, index) in currentUser.roles" :key="index">
                {{ role | dataFormat }}
              </li>
            </ul>
          </b-row>
        </div>
      </b-col>
      <b-col cols="6"><my-interest /></b-col>
    </b-row>
  </b-container>
</template>

<script>
import MyInterest from "@/components/mypage/MyInterest.vue";

export default {
  name: "UserDetail",
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },
  components: {
    MyInterest,
  },
  methods: {
    moveModify() {
      this.$router.push("/user/modify");
    },
  },
  mounted() {
    if (!this.currentUser) {
      this.$router.push("/");
    }
  },
  filters: {
    dataFormat(data) {
      return data == "ROLE_USER" ? "사용자" : "관리자";
    },
  },
};
</script>
<style scoped>
#jumbotron_user {
  background-color: blanchedalmond;
  border-radius: 30px;
}
#content {
  margin-left: 40px;
  font-size: 30px;
  padding-top: 40px;
}
</style>
