<template>
  <b-container fluid id="signup">
    <b-row class="justify-content-center mt-5"
      ><img src="@/assets/logo.png"
    /></b-row>
    <b-row style="margin-top: 5%">
      <b-col cols="6">
        <b-col style="margin-left: 3%">
          <img src="@/assets/hi.jpg" width="130%" style="opacity: 0.4"
        /></b-col>
      </b-col>
      <b-col cols="4" class="justify-content-center">
        <div>
          <h1>
            <strong
              ><img
                src="https://img.icons8.com/external-bearicons-detailed-outline-bearicons/64/000000/external-Welcome-miscellany-texts-and-badges-bearicons-detailed-outline-bearicons.png"
              />
              &nbsp; 간편 회원 가입
            </strong>
          </h1>
        </div>
        <div class="card card-container mt-5">
          <form name="form" @submit.prevent="handleRegister" class="m-5">
            <div v-if="!successful">
              <div class="form-group">
                <label for="username"><h4>아이디</h4></label>
                <b-input
                  v-model="user.username"
                  v-validate="'required|min:3|max:20'"
                  type="text"
                  class="form-control"
                  name="username"
                  size="lg"
                />
                <div
                  v-if="submitted && errors.has('username')"
                  class="alert-danger"
                >
                  {{ errors.first("username") }}
                </div>
              </div>
              <div class="form-group">
                <label for="email" class="mt-3"><h4>이메일</h4></label>
                <b-input
                  v-model="user.email"
                  v-validate="'required|email|max:50'"
                  type="email"
                  class="form-control"
                  name="email"
                  size="lg"
                />
                <div
                  v-if="submitted && errors.has('email')"
                  class="alert-danger"
                >
                  {{ errors.first("email") }}
                </div>
              </div>
              <div class="form-group">
                <label for="password" class="mt-3"><h4>비밀번호</h4></label>
                <b-input
                  v-model="user.password"
                  v-validate="'required|min:6|max:40'"
                  type="password"
                  class="form-control"
                  name="password"
                  placeholder="6자리 이상 입력해주세요"
                  size="lg"
                />
                <div
                  v-if="submitted && errors.has('password')"
                  class="alert-danger"
                >
                  {{ errors.first("password") }}
                </div>
              </div>
              <div class="form-group mt-5">
                <button class="btn btn-dark btn-block" pill size="lg">
                  <h4>회원 가입 하기</h4>
                </button>
                <button
                  class="btn btn-block mt-5"
                  pill
                  size="lg"
                  @click="$router.push('/user/login')"
                >
                  <h4>로그인 하기</h4>
                </button>
              </div>
            </div>
          </form>

          <div
            v-if="message"
            class="alert"
            :class="successful ? 'alert-success' : 'alert-danger'"
          >
            {{ message }}
          </div>
        </div>
        <h6 class="mt-3 text-center">
          <a
            href="https://www.freepik.com/vectors/welcome-party"
            style="color: #ebebe8; font-style: italic"
            >Image copyright: Welcome party vector created by storyset -
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
  name: "UserSignUp",
  data() {
    return {
      user: new User("", "", ""),
      submitted: false,
      successful: false,
      message: "",
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  mounted() {
    if (this.loggedIn) {
      this.$router.push("/");
    }
  },
  methods: {
    handleRegister() {
      this.message = "";
      this.submitted = true;
      this.$validator.validate().then((isValid) => {
        if (isValid) {
          this.$store.dispatch("auth/register", this.user).then(
            (data) => {
              this.message = data.message;
              this.successful = true;
              this.$router.push("/user/login");
            },
            (error) => {
              this.message =
                (error.response &&
                  error.response.data &&
                  error.response.data.message) ||
                error.message ||
                error.toString();
              this.successful = false;
            }
          );
        }
      });
    },
  },
};
</script>
