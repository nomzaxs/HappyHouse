<template>
  <b-container>
    <b-card header="검색 결과" class="card_header" v-if="apts.length !== 0">
      <b-pagination
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        aria-controls="itemList"
        align="center"
      ></b-pagination>
      <b-list-group
        v-for="(apt, index) in aptsForList"
        :key="index"
        class="mt-1"
        id="itemList"
      >
        <b-list-group-item
          id="show-btn"
          v-b-hover="handleHover"
          class="border rounded py-3 px-4"
          @click="onModal(apt)"
          v-b-modal.mymodal
        >
          {{ apt.item.apartmentName }} &nbsp;
          <span style="color: gray"
            ><img
              src="https://img.icons8.com/wired/24/000000/search.png"
            />&nbsp; [거래내역 상세조회]</span
          >
        </b-list-group-item>
        <b-list-group-item>
          {{ sidoName }} {{ gugunName }} {{ apt.item.dong }}
          {{ apt.item.jibun }}
        </b-list-group-item>
      </b-list-group>
    </b-card>

    <!-- 아파트 매매정보 상세 조회 -->
    <b-modal id="mymodal" hide-footer>
      <detail-modal :aptCode="aptCode" :aptName="aptName"></detail-modal>
      <b-button
        class="mt-3"
        block
        @click="$bvModal.hide('mymodal')"
        variant="outline-dark"
        >Close</b-button
      >
    </b-modal>
  </b-container>
</template>

<script>
import DetailModal from "@/components/house/DetailModal.vue";

export default {
  name: "HouseList",
  components: {
    DetailModal,
  },
  props: {
    sidoName: { type: String },
    gugunName: { type: String },
    apts: { type: Array },
  },
  data() {
    return {
      currentPage: 1,
      perPage: 5,
      isHovered: false,
      isModal: false,
      item: {},
      aptCode: "",
      aptName: "",
    };
  },
  methods: {
    handleHover(hovered) {
      this.isHovered = hovered;
    },
    onModal(apt) {
      this.aptCode = apt.item.aptCode;
      this.aptName = apt.item.apartmentName;
    },
  },
  // watch: {
  //   aptCode: function (newAptCode) {
  //     aptDeal(
  //       newAptCode,
  //       (response) => {
  //         this.dealList = response.data;
  //       },
  //       (error) => {
  //         console.log(error);
  //       }
  //     );
  //   },
  // },
  computed: {
    aptsForList() {
      return this.apts.slice(
        (this.currentPage - 1) * this.perPage,
        this.currentPage * this.perPage
      );
    },
    rows() {
      return this.apts.length;
    },
  },
};
</script>

<style scoped>
#show-btn:hover {
  background: rgba(239, 247, 212, 0.342);
  cursor: pointer;
  font-size: large;
}

.note2 {
  margin-top: 10px;
  position: relative;
  background: #0c0c0c;
  border-radius: 8px;
  max-width: 100%;
  text-align: center;
  padding: 12px;
  color: rgb(249, 249, 249);
}

.note2:before {
  content: "";
  position: absolute;
  top: 0;
  right: 0;
  border-width: 0 16px 16px 0;
  border-style: solid;
  border-color: #ffffff #fcfcfc #eaf3edcb #d8dadb;
  background: #c7d0d0;
  display: block;
  width: 0;
}
</style>
