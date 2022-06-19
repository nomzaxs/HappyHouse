import QuestionView from "@/views/QuestionView.vue";
import QuestionList from "@/components/question/QuestionList.vue";
import QuestionWrite from "@/components/question/QuestionWrite.vue";
import QuestionDetail from "@/components/question/QuestionDetail.vue";
import QuestionModify from "@/components/question/QuestionModify.vue";

export default [
  {
    path: "/question",
    name: "question",
    component: QuestionView,
    redirect: "/question/list",
    children: [
      {
        path: "list",
        name: "questionList",
        component: QuestionList,
      },
      {
        path: "regist",
        name: "questionRegist",
        component: QuestionWrite,
      },
      {
        path: "detail",
        name: "questionDetail",
        component: QuestionDetail,
      },
      {
        path: "modify",
        name: "questionModify",
        component: QuestionModify,
      },
    ],
  },
];
