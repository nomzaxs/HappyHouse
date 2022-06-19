import MypageView from "@/views/MypageView.vue";
import MypageList from "@/components/mypage/MypageList.vue";

export default [
  {
    path: "/mypage",
    name: "mypage",
    component: MypageView,
    redirect: "/mypage/list",
    children: [
      {
        path: "list",
        name: "list",
        component: MypageList,
      },
    ],
  },
];
