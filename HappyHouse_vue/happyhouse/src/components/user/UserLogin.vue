<template>
  <b-container fluid id="signup">
    <b-row class="justify-content-center mt-5"
      ><img src="@/assets/logo.png"
    /></b-row>
    <b-row class="justify-content-center mt-5"
      ><h5 class="mt-4" style="color: gray">
        로그인 하셔야 서비스를 이용할 수 있습니다
      </h5></b-row
    >
    <b-row style="margin-top: 2%">
      <b-col cols="6">
        <b-col style="margin-left: 3%">
          <img src="@/assets/login.jpg" width="120%" style="opacity: 0.4"
        /></b-col>
      </b-col>
      <b-col cols="4" class="justify-content-center" style="margin-top: 2%">
        <div>
          <h1>
            <strong
              ><img
                src="data:image/png;base64,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"
              />
              &nbsp; 로그인
            </strong>
          </h1>
        </div>
        <div class="card card-container mt-4">
          <form name="form" @submit.prevent="handleLogin" class="m-5">
            <div class="form-group">
              <label for="username"><h4>아이디</h4></label>
              <b-input
                v-model="user.username"
                v-validate="'required'"
                type="text"
                class="form-control"
                name="username"
                size="lg"
              />
              <div
                v-if="errors.has('username')"
                class="alert alert-danger"
                role="alert"
              >
                Username is required!
              </div>
            </div>
            <div class="form-group mt-5">
              <label for="password"><h4>비밀번호</h4></label>
              <b-input
                v-model="user.password"
                v-validate="'required'"
                type="password"
                class="form-control"
                name="password"
                size="lg"
              />
              <div
                v-if="errors.has('password')"
                class="alert alert-danger"
                role="alert"
              >
                Password is required!
              </div>
            </div>
            <div class="form-group mt-5">
              <button
                class="btn btn-dark btn-block"
                pill
                size="lg"
                :disabled="loading"
              >
                <span
                  v-show="loading"
                  class="spinner-border spinner-border-sm"
                ></span>
                <span><h4>로그인</h4></span>
              </button>
              <button
                class="btn btn-block mt-4"
                pill
                size="lg"
                @click="$router.push('/user/signup')"
              >
                <h4>회원가입</h4>
              </button>
            </div>
            <div class="form-group">
              <div v-if="message" class="alert alert-danger" role="alert">
                {{ message }}
              </div>
            </div>
          </form>
        </div>
        <h6
          class="mt-5 text-center"
          style="font-family: ROKAFSlabSerifMedium; color: gray"
        >
          비밀번호가 기억나지 않는다면 관리자에게 메일을 보내주세요
          [admin@ssafy.com]
        </h6>
        <h6 class="mt-5 text-center">
          <a
            href="https://www.freepik.com/vectors/access-control"
            style="color: #ebebe8; font-style: italic"
            >Image copyright: Access control vector created by vectorjuice -
            www.freepik.com</a
          >
        </h6>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import User from "../../models/user";

export default {
  name: "UserLogin",
  data() {
    return {
      user: new User("", ""),
      loading: false,
      message: "",
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  created() {
    if (this.loggedIn) {
      this.$router.push("/");
    }
  },
  methods: {
    handleLogin() {
      this.loading = true;
      this.$validator.validateAll().then((isValid) => {
        if (!isValid) {
          this.loading = false;
          return;
        }

        if (this.user.username && this.user.password) {
          this.$store.dispatch("auth/login", this.user).then(
            () => {
              this.$router.push("/");
            },
            (error) => {
              this.loading = false;
              this.message =
                (error.response &&
                  error.response.data &&
                  error.response.data.message) ||
                error.message ||
                error.toString();
            }
          );
        }
      });
    },
  },
};
</script>

<style></style>
