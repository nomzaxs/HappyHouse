<template>
  <b-container class="center-block col-7 justify-content-center">
    <div class="mb-5">
      <h1>
        <strong
          ><img src="https://img.icons8.com/doodle/96/000000/pinguin.png" />
          ABOUT US</strong
        >
      </h1>
    </div>
    <div class="mt-4">
      <b-card-group deck>
        <b-card style="padding: 30px" tag="article" class="mb-2">
          <h1>
            박상현 &nbsp;<img
              src="https://img.icons8.com/doodle/48/000000/homer-simpson.png"
            />
          </h1>
          <div class="mt-4">
            <b-card-text
              >기능 구현
              <ul>
                <li>회원 가입</li>
                <li>로그인/로그아웃</li>
                <li>관리자 페이지</li>
                <li>뉴스 크롤링</li>
              </ul></b-card-text
            >
            <b-button
              href="https://github.com/nomzaxs"
              target="_blank"
              variant="outline-dark"
              class="mt-5"
              ><img
                src="https://img.icons8.com/doodle/48/000000/github--v1.png"
              />
              <h5>Visit our site!</h5></b-button
            >
          </div>
        </b-card>

        <b-card style="padding: 30px" tag="article" class="mb-2"
          ><h1>
            정호진&nbsp;<img
              src="https://img.icons8.com/doodle/48/000000/totoro.png"
            />
          </h1>
          <div class="mt-4">
            <b-card-text
              >기능 구현
              <ul>
                <li>공지사항</li>
                <li>FAQ</li>
                <li>카카오 지도 API</li>
                <li>공공데이터 활용한 매물정보</li>
                <li>프론트 화면 디자인</li>
              </ul></b-card-text
            >
            <b-button
              href="https://github.com/junghojin"
              target="_blank"
              variant="outline-dark"
              class="mt-4"
              ><img
                src="https://img.icons8.com/doodle/48/000000/github--v1.png"
              />
              <h5>Visit our site!</h5></b-button
            >
          </div>
        </b-card>
      </b-card-group>
    </div>
  </b-container>
</template>

<script>
export default {};
</script>

<style scoped>
h1 {
  text-decoration-thickness: 10px;
  text-decoration-line: underline;
  text-decoration-color: #fae404;
}
</style>
