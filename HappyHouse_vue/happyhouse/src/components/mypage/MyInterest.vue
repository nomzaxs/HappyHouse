<template>
  <!-- news 본문 내용이 들어가는 vue -->
  <b-container fluid class="center-block col-8 justify-content-center">
    <div>
      <h3>
        <strong
          ><img src="https://img.icons8.com/doodle/48/000000/reminders.png" />
          관심아파트
        </strong>
      </h3>
    </div>
    <!-- 뉴스 리스트 들어가는 곳-->
    <div class="mt-5">
      <b-card header="관심아파트 목록">
        <b-list-group
          v-for="(interest, index) in interestList"
          :key="interest.interestno"
          class="mt-1"
        >
          <b-list-group-item id="show-btn" class="border rounded py-3 px-4">
            <b-tr>
              <b-td>
                <h5>
                  <b-button
                    class="ml-2"
                    style="margin-left: 100px"
                    @click="onDelete($event, interest.interestno)"
                    size="md"
                    >삭제</b-button
                  >
                  &nbsp; &nbsp; &nbsp; &nbsp; {{ index + 1 }}. &nbsp;
                  {{ interest.no }}&nbsp;&nbsp;
                  {{ interest.aptName }} &nbsp;&nbsp;
                </h5>
              </b-td>
            </b-tr>
          </b-list-group-item>
        </b-list-group>
      </b-card>
    </div>
  </b-container>
</template>

<script>
import { listInterest, deleteInterest } from "@/api/interest.js";

export default {
  data() {
    return {
      interestList: [],
    };
  },
  created() {
    let username = this.$store.state.auth.user.username;
    listInterest(
      username,
      (response) => {
        this.interestList = response.data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods: {
    onDelete(event, interestno) {
      deleteInterest(
        interestno,
        (response) => {
          console.log(response);
          alert("성공적으로 삭제되었습니다.");
        },
        (error) => {
          console.log(error);
        }
      );
      this.$router.go();
    },
  },
};
</script>
<!-- //
  writeInterest,
  deleteInterest,
  getAddress,// -->
