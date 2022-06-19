import NoticeView from "@/views/NoticeView.vue";
import NoticeList from "@/components/notice/NoticeList.vue";
import NoticeWrite from "@/components/notice/NoticeWrite.vue";
import NoticeDetail from "@/components/notice/NoticeDetail.vue";
import NoticeModify from "@/components/notice/NoticeModify.vue";

export default [
  {
    path: "/notice",
    name: "notice",
    component: NoticeView,
    redirect: "/notice/list",
    children: [
      {
        path: "list",
        name: "noticeList",
        component: NoticeList,
      },
      {
        path: "regist",
        name: "noticeRegist",
        component: NoticeWrite,
      },
      {
        path: "detail",
        name: "noticeDetail",
        component: NoticeDetail,
      },
      {
        path: "modify",
        name: "noticeModify",
        component: NoticeModify,
      },
    ],
  },
];
