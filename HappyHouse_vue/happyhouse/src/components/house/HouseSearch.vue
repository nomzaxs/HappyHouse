<template>
  <b-container fluid class="center-block col-12 justify-content-center mt-5">
    <b-row>
      <b-col cols="11">
        <house-map :apts="apts"></house-map>
      </b-col>
      <b-col
        ><h1>
          <b-button v-b-toggle.sidebar-border size="lg" pill variant="warning"
            ><img
              src="https://img.icons8.com/doodle/48/000000/binoculars--v1.png"
            />

            <br />매물검색</b-button
          >
        </h1></b-col
      >
      <b-sidebar
        id="sidebar-border"
        sidebar-class="border-right border-danger"
        right
        shadow
        width="30%"
      >
        <div class="ml-2 mt-5">
          <h1>
            <strong
              ><img
                src="https://img.icons8.com/doodle/48/000000/binoculars--v1.png"
              />
              매물검색</strong
            >
          </h1>
        </div>
        <div class="ml-2 mr-2">
          <b-input-group class="justify-content-md-center mt-5">
            <b-form-select
              v-model="sido"
              :options="sidos"
              @change="getGugun"
              style="width: 10%"
              size="md"
            ></b-form-select>
            <b-form-select
              class="ml-1"
              v-model="gugun"
              :options="guguns"
              @change="getDong"
              style="width: 10%"
              size="md"
            ></b-form-select>
            <b-form-select
              class="ml-1"
              v-model="dong"
              :options="dongs"
              style="width: 10%"
              size="md"
            ></b-form-select>
            <b-button
              class="ml-1"
              variant="outline-dark"
              size="md"
              @click="getApt"
              style="height: 35px"
            >
              <b-icon icon="search"></b-icon>
            </b-button>
          </b-input-group>
          <b-input-group class="justify-content-md-center mt-3">
            <b-form-input
              v-model="aptname"
              size="md"
              style="width: 10%"
              placeholder="아파트 이름으로 검색해보세요!"
            ></b-form-input>
            <b-button
              class="ml-1"
              variant="outline-dark"
              size="md"
              @click="getAptsByName"
            >
              <b-icon icon="search"></b-icon>
            </b-button>
          </b-input-group>
          <house-list
            :apts="apts"
            :sidoName="sido"
            :gugunName="gugun"
            class="mt-5"
          ></house-list>
        </div>
      </b-sidebar>
    </b-row>
  </b-container>
</template>

<script>
import HouseList from "@/components/house/HouseList.vue";
import HouseMap from "@/components/house/HouseMap.vue";

import {
  sidoList,
  gugunList,
  dongList,
  aptList,
  aptListByName,
} from "@/api/house.js";

export default {
  name: "HouseSearch",
  components: {
    HouseList,
    HouseMap,
  },
  data() {
    return {
      sido: null,
      gugun: null,
      dong: null,
      aptname: null,
      sidos: [{ text: "시/도", value: null, disabled: true }],
      guguns: [{ text: "구/군", value: null, disabled: true }],
      dongs: [{ text: "동", value: null, disabled: true }],
      apts: [],
    };
  },
  async created() {
    this.apts = [];
    await sidoList(
      (response) => {
        response.data.forEach((item) => {
          this.sidos.push({
            text: item.sidoName,
            value: item.sidoName,
            disabled: false,
          });
        });
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods: {
    async getGugun() {
      this.apts = [];
      this.gugun = null;
      this.guguns.splice(1, this.guguns.length);
      await gugunList(
        this.sido,
        (response) => {
          response.data.forEach((item) => {
            this.guguns.push({
              text: item.gugunName,
              value: item.dongCode,
              disabled: false,
            });
          });
        },
        (error) => {
          alert("구/군 정보를 불러오는데 실패했습니다.");
          // this.$router.go(); // 원래 페이지로 돌아가기
          console.log(error);
        }
      );
    },
    async getDong() {
      this.apts = [];
      this.dong = null;
      this.dongs.splice(1, this.dongs.length);
      await dongList(
        this.gugun,
        (response) => {
          response.data.forEach((item) => {
            this.dongs.push({
              text: item.dongName,
              value: item.dongCode,
              disabled: false,
            });
          });
        },
        (error) => {
          alert("동 정보를 불러오는데 실패했습니다.");
          this.$router.go(); // 원래 페이지로 돌아가기
          console.log(error);
        }
      );
    },
    async getApt() {
      this.apts.splice(0, this.apts.length);
      this.aptname = null;
      await aptList(
        this.dong,
        (response) => {
          response.data.forEach((item) => {
            this.apts.push({
              item,
            });
          });
        },
        (error) => {
          alert("아파트 정보를 불러오는데 실패했습니다.");
          this.$router.go(); // 원래 페이지로 돌아가기
          console.log(error);
        }
      );
    },
    async getAptsByName() {
      this.sido = null;
      this.gugun = null;
      this.dong = null;
      this.guguns = [{ text: "구/군", value: null, disabled: true }];
      this.dongs = [{ text: "동", value: null, disabled: true }];
      this.apts.splice(0, this.apts.length);
      await aptListByName(
        this.aptname,
        (response) => {
          response.data.forEach((item) => {
            this.apts.push({
              item,
            });
          });
        },
        (error) => {
          alert("아파트 정보를 불러오는데 실패했습니다.");
          this.$router.go(); // 원래 페이지로 돌아가기
          console.log(error);
        }
      );
    },
  },
};
</script>

<style scoped>
h1 {
  text-decoration-thickness: 10px;
  text-decoration-line: underline;
  text-decoration-color: #fae404;
}
</style>
