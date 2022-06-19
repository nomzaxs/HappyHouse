<template>
  <b-container class="col-md-7">
    <div>
      <h1>
        <strong
          ><img src="https://img.icons8.com/doodle/48/000000/password.png" />
          비밀번호 수정</strong
        >
      </h1>
    </div>
    <div class="card card-container mt-5" style="font-size: 25px">
      <form name="form" @submit.prevent="handleRegister">
        <div v-if="!successful">
          <div class="form-group m-5">
            <label for="username" class="mr-5">Username</label>
            :&nbsp;&nbsp;&nbsp;{{ currentUser.username }}
          </div>
          <div class="form-group m-5">
            <label for="email" class="mr-5">Email</label>
            :&nbsp;&nbsp;&nbsp;{{ currentUser.email }}
          </div>
          <div class="form-group m-5">
            <label for="password" class="mr-5"
              >새로운 비밀번호
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label
            >
            <b-input
              v-model="user.password"
              v-validate="'required|min:6|max:40'"
              type="password"
              class="form-control mt-2"
              name="password"
              size="lg"
              placeholder="6자리 이상 입력하세요"
            />
            <div
              v-if="submitted && errors.has('password')"
              class="alert-danger"
            >
              {{ errors.first("password") }}
            </div>
          </div>
          <div class="form-group">
            <button class="btn btn-dark btn-block" style="margin-top: 2px">
              <h3>수정 완료</h3>
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
  </b-container>
</template>

<script>
import User from "../../models/user";

export default {
  name: "UserModify",
  data() {
    return {
      user: new User("", "", ""),
      submitted: false,
      successful: false,
      message: "",
    };
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },
  methods: {
    handleRegister() {
      this.message = "";
      this.submitted = true;
      this.user.username = this.$store.state.auth.user.username;
      this.user.email = this.$store.state.auth.user.email;
      this.$validator.validate().then((isValid) => {
        if (isValid) {
          this.$store.dispatch("auth/modify", this.user).then(
            (data) => {
              this.message = data.message;
              this.successful = true;
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
          this.$router.push("/user/detail");
        }
      });
    },
  },
};
</script>

<style></style>
