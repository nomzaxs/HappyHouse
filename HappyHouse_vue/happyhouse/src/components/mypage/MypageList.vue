<template>
  <!-- news 본문 내용이 들어가는 vue -->
  <b-container class="center-block col-8 justify-content-center">
    <div>
      <h1>
        <img
          src="https://img.icons8.com/doodle/48/000000/menu.png"
        />&nbsp;<strong>사용자 목록</strong>
      </h1>
    </div>
    <!-- 사용자 리스트 들어가는 곳-->
    <div class="mt-5">
      <b-card header="📢 관리자만 접근 가능합니다. 삭제시 복구가 안됩니다!!">
        <b-list-group
          v-for="user in uesrList"
          :key="user.username"
          v-bind="user"
          class="mt-1"
        >
          <b-list-group-item id="show-btn" class="border rounded py-3 px-4">
            <b-tr>
              <b-td>
                <b-button
                  type="submit"
                  variant="outline-danger"
                  size="md"
                  @click="onDelete($event, user)"
                  class="btn_notice ml-3 mr-3"
                  >삭제</b-button
                >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                {{ user.username }} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                {{ user.email }}
              </b-td>
            </b-tr>
          </b-list-group-item>
        </b-list-group>
      </b-card>
    </div>
  </b-container>
</template>

<script>
import { getUser, deleteUser } from "@/api/user.js";

export default {
  data() {
    return {
      uesrList: [],
    };
  },
  created() {
    getUser(
      (response) => {
        this.uesrList = response.data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods: {
    onDelete(event, user) {
      event.preventDefault();
      // Reset our form values
      deleteUser(
        user.email,
        ({ data }) => {
          console.log(data);
          alert("삭제가 완료되었습니다.");
          this.$router.go();
        },
        (error) => {
          console.log(error);
          alert("삭제 중 문제가 발생하였습니다. 원래 페이지로 돌아갑니다.");
        }
      );
    },
  },
};
</script>

<style></style>
