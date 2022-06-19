<template>
  <b-container fluid>
    <!-- User Interface controls -->
    <b-row>
      <b-col
        ><h3>
          <img
            src="https://img.icons8.com/doodle/36/000000/city-buildings.png"
          />
          &nbsp;{{ aptName }}
        </h3> </b-col
      ><b-col cols="6">
        <b-button variant="outline" size="lg" @click="like">
          <img
            src="https://img.icons8.com/doodle/20/000000/we-hear-it.png"
          />&nbsp; 관심 아파트 등록
        </b-button>
      </b-col>
    </b-row>
    <b-row>
      <b-col sm="5" md="6" class="my-1">
        <b-form-group
          label="항목수"
          label-for="per-page-select"
          label-cols-sm="6"
          label-cols-md="4"
          label-cols-lg="3"
          label-align-sm="right"
          label-size="sm"
          class="mb-0"
        >
          <b-form-select
            id="per-page-select"
            v-model="perPage"
            :options="pageOptions"
            size="sm"
          ></b-form-select>
        </b-form-group>
      </b-col>

      <b-col sm="7" md="6" class="my-1">
        <b-pagination
          v-model="currentPage"
          :total-rows="totalRows"
          :per-page="perPage"
          align="fill"
          size="sm"
          class="my-0"
        ></b-pagination>
      </b-col>
    </b-row>

    <!-- Main table element -->
    <b-table
      :items="items"
      :fields="fields"
      :current-page="currentPage"
      :per-page="perPage"
      :filter="filter"
      :filter-included-fields="filterOn"
      :sort-by.sync="sortBy"
      :sort-desc.sync="sortDesc"
      :sort-direction="sortDirection"
      stacked="md"
      show-empty
      small
      @filtered="onFiltered"
    >
      <template #cell(name)="row">
        {{ row.value.first }} {{ row.value.last }}
      </template>

      <template #cell(actions)="row">
        <b-button
          size="sm"
          @click="row.toggleDetails"
          variant="outline-secondary"
        >
          상세내용 {{ row.detailsShowing ? "숨기기" : "보기" }}
        </b-button>
      </template>

      <template #row-details="row">
        <b-card>
          <ul>
            <li v-for="(value, key) in row.item" :key="key">
              {{ key }}: {{ value }}
            </li>
          </ul>
        </b-card>
      </template>
    </b-table>
  </b-container>
</template>

<script>
import { aptDeal } from "@/api/house.js";
import { writeInterest } from "@/api/interest.js";

export default {
  name: "DetailModal",
  props: { aptCode: String, aptName: String },
  created() {
    aptDeal(
      this.aptCode,
      (response) => {
        response.data.forEach((item) => {
          this.items.push({
            amount: item.dealAmount,
            area: item.area,
            floor: item.floor,
            year: item.dealYear,
            month: item.dealMonth,
            day: item.dealDay,
          });
        });
      },
      (error) => {
        console.log(error);
      }
    );
  },
  data() {
    return {
      selected_item: {},
      items: [],
      fields: [
        {
          key: "year",
          label: "거래년도",
          sortable: true,
          sortDirection: "desc",
        },
        {
          key: "amount",
          label: "거래금액(만원)",
          sortable: true,
          class: "text-center",
        },
        { key: "actions", label: "" },
      ],
      totalRows: 1,
      currentPage: 1,
      perPage: 5,
      pageOptions: [5, 10, 15, { value: 100, text: "Show a lot" }],
      sortBy: "",
      sortDesc: true,
      sortDirection: "asc",
      filter: null,
      filterOn: [],
      infoModal: {
        id: "info-modal",
        title: "",
        content: "",
      },
    };
  },
  computed: {
    sortOptions() {
      // Create an options list from our fields
      return this.fields
        .filter((f) => f.sortable)
        .map((f) => {
          return { text: f.label, value: f.key };
        });
    },
  },
  updated() {
    // Set the initial number of items
    this.totalRows = this.items.length;
  },
  methods: {
    like() {
      // 좋아요 버튼 (관심아파트 등록)
      let username = this.$store.state.auth.user.username;
      writeInterest(
        {
          userid: username,
          dongcode: this.aptCode,
          aptName: this.aptName,
        },
        (response) => {
          console.log(response);
          alert("관심아파트로 등록되었습니다. 마이페이지에서 확인해보세요~");
        },
        (error) => {
          console.log(error);
        }
      );
      // this.selected_item.title = `Row index: ${index}`;
      // this.selected_item.content = JSON.stringify(item, null, 2);
    },
    resetInfoModal() {
      this.infoModal.title = "";
      this.infoModal.content = "";
    },
    onFiltered(filteredItems) {
      // Trigger pagination to update the number of buttons/pages due to filtering
      this.totalRows = filteredItems.length;
      this.currentPage = 1;
    },
  },
};
</script>
