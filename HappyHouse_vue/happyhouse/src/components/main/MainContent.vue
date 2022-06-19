<template>
  <!-- Content -->
  <b-container fluid style="width: 90%">
    <b-jumbotron jumbotron-fluid> </b-jumbotron>

    <!-- Grid -->
    <div class="w3-row-padding" id="plans">
      <div class="w3-center w3-padding-64">
        <span class="w3-xlarge w3-bottombar w3-border-black w3-padding-16"
          >제공서비스</span
        >
      </div>

      <div class="w3-third w3-margin-bottom">
        <ul
          class="w3-ul w3-border w3-center w3-hover-shadow"
          style="border-radius: 10px"
        >
          <li
            class="w3-black w3-xlarge w3-padding-32"
            style="border-radius: 10px 10px 0px 0px"
          >
            오늘의 뉴스
          </li>
          <li class="w3-padding-16">
            <b>최신 부동산 뉴스</b>를 확인해 보세요!
          </li>
          <li>
            <img src="@/assets/news.jpg" width="100%" height="300px" />
          </li>
          <li class="w3-light-grey w3-padding-24" width="100%">
            <button
              class="w3-button w3-outline w3-padding-large"
              @click="$router.push('/news')"
            >
              <h5>바로가기</h5>
            </button>
          </li>
        </ul>
      </div>

      <div class="w3-third w3-margin-bottom">
        <ul
          class="w3-ul w3-border w3-center w3-hover-shadow"
          style="border-radius: 10px 10px 10px 10px"
        >
          <li
            class="w3-xlarge w3-padding-32"
            style="border-radius: 10px 10px 0px 0px"
          >
            매물검색
          </li>
          <li class="w3-padding-16">
            <b>원하는 지역의 매물</b>을 검색해보세요!
          </li>
          <li>
            <img src="@/assets/houseEx.jpg" width="100%" height="300px" />
          </li>
          <li class="w3-light-grey w3-padding-24">
            <button
              class="w3-button w3-padding-large"
              @click="$router.push('/house')"
            >
              <h5>바로가기</h5>
            </button>
          </li>
        </ul>
      </div>

      <div class="w3-third w3-margin-bottom">
        <ul
          class="w3-ul w3-border w3-center w3-hover-shadow"
          style="border-radius: 10px 10px 10px 10px"
        >
          <li
            class="w3-black w3-xlarge w3-padding-32"
            style="border-radius: 10px 10px 0px 0px"
          >
            커뮤니티
          </li>
          <li class="w3-padding-16"><b>서로 다양한 정보</b>를 나눠보세요!</li>
          <li class="w3-xlarge">
            <img src="@/assets/communityEx.jpg" width="100%" height="300px" />
          </li>
          <li class="w3-light-grey w3-padding-24">
            <button
              class="w3-button w3-outline w3-padding-large"
              @click="$router.push('/notice')"
            >
              <h5>바로가기</h5>
            </button>
          </li>
        </ul>
      </div>
    </div>

    <!-- Grid -->
    <div class="w3-row-padding mt-5" id="extra">
      <div class="w3-center w3-padding-64">
        <span class="w3-xlarge w3-bottombar w3-border-black w3-padding-16"
          >부가서비스</span
        >
      </div>

      <div class="w3-third w3-margin-bottom" style="object-fit: cover">
        <ul
          class="w3-ul w3-border w3-center w3-hover-shadow"
          style="border-radius: 10px 10px 10px 10px"
        >
          <li class="w3-white w3-xlarge w3-padding-32">관련 영상</li>
          <li class="w3-padding-50">
            <p class="w3-opacity mt-2">세금 아끼기 위한 꿀팁! 🌞</p>
            <b-embed
              type="iframe"
              aspect="16by9"
              src="https://www.youtube.com/embed/zcCTGHFbr_I"
              height="700"
              class="mt-3"
            ></b-embed>
          </li>
        </ul>
      </div>

      <div class="w3-third w3-margin-bottom">
        <ul
          class="w3-ul w3-border w3-center w3-hover-shadow"
          style="border-radius: 10px 10px 10px 10px"
        >
          <li
            class="w3-black w3-xlarge w3-padding-32"
            style="border-radius: 10px 10px 0px 0px"
          >
            부동산 소식
          </li>
          <li class="mt-4 w3-padding-50">
            <a
              href="https://hometax.go.kr/websquare/websquare.html?w2xPath=/ui/pp/index.xml"
              target="_blank"
              title="이미지를 누르면 링크로 이동합니다"
            >
              <img src="@/assets/save.jpg" width="100%" class="mt-3" />
            </a>
          </li>
        </ul>
      </div>

      <div class="w3-third w3-margin-bottom">
        <ul
          class="w3-ul w3-border w3-center w3-hover-shadow"
          style="border-radius: 10px 10px 10px 10px"
        >
          <li class="w3-white w3-xlarge w3-padding-32">관련용어 검색</li>
          <li class="w3-padding-50">
            <p class="w3-opacity mt-2">부동산 용어를 검색해보세요! 😎</p>
            <b-embed
              type="iframe"
              src="http://m.terms.naver.com"
              allowfullscreen
              class="mt-3"
            ></b-embed>
          </li>
        </ul>
      </div>
    </div>
  </b-container>
</template>
<script>
export default {};
</script>

<style scoped>
.jumbotron {
  background-image: url("@/assets/main.jpg");
  height: 700px;
  background-size: cover;
  border-radius: 30px;
}
</style>
