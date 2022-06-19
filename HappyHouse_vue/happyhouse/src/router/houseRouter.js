import HouseView from "@/views/HouseView.vue";
import HouseList from "@/components/house/HouseList.vue";
// import HouseWrite from "@/components/house/HouseWrite.vue";
// import HouseDetail from "@/components/house/HouseDetail.vue";
// import HouseModify from "@/components/house/HouseModify.vue";

export default [
  {
    path: "/house",
    name: "house",
    component: HouseView,
    redirect: "/house/list",
    children: [
      {
        path: "list",
        name: "houselist",
        component: HouseList,
      },
      //   {
      //     path: "write",
      //     name: "write",
      //     component: HouseWrite,
      //   },
      //   {
      //     path: "detail",
      //     name: "detail",
      //     component: HouseDetail,
      //   },
      //   {
      //     path: "modify",
      //     name: "modify",
      //     component: HouseModify,
      //   },
    ],
  },
];
