<template>
  <!-- news 본문 내용이 들어가는 vue -->
  <b-container class="center-block col-8 justify-content-center">
    <div>
      <h1>
        <strong
          ><img src="https://img.icons8.com/doodle/48/000000/news.png" /> 오늘의
          뉴스</strong
        >
      </h1>
    </div>
    <!-- 뉴스 리스트 들어가는 곳-->
    <div class="mt-5">
      <b-card header="📢 제목을 누르시면 더 자세한 내용 확인하실 수 있어요">
        <b-list-group
          v-for="(news, index) in newsList"
          :key="news.title"
          v-bind="news"
          class="mt-1"
        >
          <b-list-group-item id="show-btn" class="border rounded py-3 px-4">
            <b-tr>
              <b-td>
                <a :href="news.link" target="_blank">
                  <h5>{{ index + 1 }}. &nbsp; {{ news.title | dataFormat }}</h5>
                </a>
                <br />
                {{ news.pubDate.substr(0, 16) }}
              </b-td>
            </b-tr>
          </b-list-group-item>
        </b-list-group>
      </b-card>
    </div>
  </b-container>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      newsList: [],
    };
  },
  mounted() {},
  created() {
    // const URL = "/v1/search/news.json?query=%EC%A7%91"; // 집이라는 단어로 뉴스 검색
    //기존 URL에 파라메터들을 동적으로 받는 cURL 선언

    const clientId = "tgbWeJJZmxeORhSZIyWP";
    const clientSecret = "t4RWjeaXxu";
    axios
      .get(
        "/v1/search/news.json?query=%EB%B6%80%EB%8F%99%EC%82%B0", // URL로 API요청
        {
          headers: {
            Accept: "application/json",
            "X-Naver-Client-Id": clientId,
            "X-Naver-Client-Secret": clientSecret,
          },
        }
      )
      .then((response) => {
        // 실제 API를 요청한다/
        this.newsList = this.newsList.concat(response.data.items);
      });
  },
  filters: {
    dataFormat(data) {
      return data
        .replaceAll("&quot;", "")
        .replaceAll("<b>", "")
        .replaceAll("</b>", "");
    },
  },
};
</script>
