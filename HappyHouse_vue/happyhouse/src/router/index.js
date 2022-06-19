import Vue from "vue";
import VueRouter from "vue-router";
import MainView from "../views/MainView.vue";
import questionRouter from "@/router/questionRouter.js";
import noticeRouter from "@/router/noticeRouter.js";
import userRouter from "@/router/userRouter.js";
import houseRouter from "@/router/houseRouter.js";
import mypageRouter from "@/router/mypageRouter";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "main",
    component: MainView,
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/news",
    name: "news",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/NewsView.vue"),
  },
  {
    path: "/interest",
    name: "interest",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/InterestView.vue"),
  },
  ...mypageRouter,
  ...questionRouter,
  ...noticeRouter,
  ...userRouter,
  ...houseRouter,
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
