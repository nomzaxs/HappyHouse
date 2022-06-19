<template>
  <div class="header">
    <div
      class="w3-bar w3-white w3-padding w3-card"
      style="letter-spacing: 8px"
      id="nav-bar1"
    >
      <a
        href="/"
        class="w3-bar-item w3-animate-top"
        id="logo"
        style="margin-top: 30px; margin-left: 20px"
        ><img src="@/assets/logo.png"
      /></a>

      <div class="w3-right w3-hide-small" style="margin-right: 20px">
        <div v-if="currentUser" class="w3-bar-item w3-hover-white">
          <router-link to="/user/detail"> 마이페이지 </router-link>
          <a class="ml-3" href @click.prevent="logOut"> 로그아웃 </a>
        </div>
      </div>
    </div>
    <!-- Right-sided navbar links. Hide them on small screens -->
    <div
      class="w3-bar w3-white w3-padding"
      style="letter-spacing: 5px"
      id="nav-bar2"
    >
      <div class="w3-left" style="margin-left: 20px; margin-top: 30px">
        <router-link to="/" class="w3-bar-item w3-hover-white"
          >Home</router-link
        >
        <router-link to="/about" class="w3-bar-item w3-hover-white"
          >About</router-link
        >
        <router-link to="/house" class="w3-bar-item w3-hover-white"
          >매물검색</router-link
        >
        <router-link to="/news" class="w3-bar-item w3-hover-white"
          >뉴스</router-link
        >
        <router-link to="/notice" class="w3-bar-item w3-hover-white"
          >커뮤니티</router-link
        >
        <router-link to="/question" class="w3-bar-item w3-hover-white"
          >FAQ</router-link
        >
        <router-link
          v-if="showAdminBoard"
          to="/mypage"
          class="w3-bar-item w3-hover-white"
          >관리자 페이지</router-link
        >
        <!-- v-if="showAdminBoard" -->
      </div>
      <div
        v-if="currentUser"
        class="w3-bar-item w3-hover-white w3-right mr-3"
        style="margin-top: 20px"
      >
        <h3>
          {{ currentUser.username }} 님, 안녕하세요 &nbsp;<img
            src="https://img.icons8.com/doodle/48/000000/panda.png"
          />
        </h3>
      </div>
    </div>
    <hr />
    <!-- <hr style="height: 12px; background-color: black; border: 0" /> -->
  </div>
</template>

<script>
import EventBus from "../common/EventBus";

export default {
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    showAdminBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes("ROLE_ADMIN");
      }

      return false;
    },
    showModeratorBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes("ROLE_MODERATOR");
      }

      return false;
    },
  },
  methods: {
    logOut() {
      this.$store.dispatch("auth/logout");
      this.$router.push("/user/login");
    },
  },
  mounted() {
    EventBus.on("logout", () => {
      this.logOut();
    });
  },
  beforeDestroy() {
    EventBus.remove("logout");
  },
  created() {
    if (this.currentUser == null) {
      this.$router.push("/user/login");
    }
  },
};
</script>

<style scoped>
.header h3 {
  font-family: GangwonEduPowerExtraBoldA;
  font-style: oblique;
}
.header a {
  font-family: GangwonEduPowerExtraBoldA;
}
#nav-bar1 {
  line-height: 5;
}

#nav-bar1 {
  line-height: 7;
}

.header a {
  color: black;
  font-weight: 600;
}

#nav-bar1 a:hover {
  text-decoration: none;
}

#nav-bar1 a {
  font-size: 18px;
}

#nav-bar1 a:hover {
  text-decoration-line: underline;
  text-decoration-style: dotted;
  text-decoration-color: rgb(190, 184, 184);
}

#nav-bar2 a {
  font-size: 25px;
}

#nav-bar2 a:hover {
  text-decoration-thickness: 10px;
  text-decoration-line: underline;
  text-decoration-color: #fae404;
}
</style>
