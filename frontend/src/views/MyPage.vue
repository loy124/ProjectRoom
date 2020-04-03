<template>
  <EtcContainer class="container">
    <div slot="banner">
      <div class="mypage-container">
        <div class="mypage-title">MY 구해방</div>
        <div class="mypage-select-wrapper">
          <!-- <div class="mypage-select-item">최근본방</div> -->
          <router-link class="mypage-select-item" :to="`/mypage/`">정보수정</router-link>
          <router-link class="mypage-select-item" :to="`aa`">연락한 부동산</router-link>
          <router-link class="mypage-select-item" :to="`bb`">내가 쓴 리뷰</router-link>
          <!-- <div class="mypage-select-item">찜한 방</div> -->
        </div>
        <!-- router view 넣기 -->
        <router-view />
      </div>
    </div>
  </EtcContainer>
</template>
<script scoped>
import EtcContainer from "./EtcContainer";
export default {
  name: "app",
  components: {
    EtcContainer
  },
  data() {
    return {};
  },
  mounted() {}
};
</script>
<style>
.mypage-container {
  margin-top: 60px;
  padding-bottom: 80px;
}
.mypage-title {
  color: black;
  text-align: center;
  font-size: 33px;
}
.mypage-select-wrapper {
  margin-top: 40px;
  display: flex;
  justify-content: space-between;

  /* border-bottom: 1px solid #dddddd; */
}

.mypage-select-item {
  color: black;
  text-decoration: none;
  font-weight: 100;
  margin: 0 auto;
  border-bottom: 1px solid #dddddd;
  width: 100%;
  text-align: center;
  padding-bottom: 12px;
  font-size: 16px;
}
.router-link-exact-active {
  color: black;
  font-weight: bold;
  border-bottom: 1.5px solid rgb(72, 72, 72);
}
</style>