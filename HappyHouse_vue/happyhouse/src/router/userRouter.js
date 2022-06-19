import UserView from "@/views/UserView.vue";
import UserLogin from "@/components/user/UserLogin.vue";
import UserSignUp from "@/components/user/UserSignUp.vue";
import UserDetail from "@/components/user/UserDetail.vue";
import UserModify from "@/components/user/UserModify.vue";

export default [
  {
    path: "/user",
    name: "user",
    component: UserView,
    redirect: "/user/login",
    children: [
      {
        path: "login",
        name: "userLogin",
        component: UserLogin,
      },
      {
        path: "signUp",
        name: "userSignup",
        component: UserSignUp,
      },
      {
        path: "detail",
        name: "userDetail",
        component: UserDetail,
      },
      {
        path: "modify",
        name: "userModify",
        component: UserModify,
      },
    ],
  },
];
