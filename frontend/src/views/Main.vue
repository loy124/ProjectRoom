<template>
  <div id="app">
    <!-- //footer -->
    <AppContainer>
      <div slot="banner" class="container">
        <MainBanner />
      </div>
      <div slot="content1" class="container">
        <EasySearchRoom />
      </div>
      <div slot="content2" class="container">
        <div class="room-selector">
          <router-link class="room-selector1" :to="`/`">최근 본방</router-link>
          <div class="line-divider"></div>
          <router-link class="room-selector2" :to="`/keep`">찜한 방</router-link>
        </div>
        <div class="room-selector-title">최근에 본 방과 찜한 방을 볼 수 있어요</div>
        <router-view />
      </div>
      <div slot="content3" class="container">aa3</div>
    </AppContainer>
  </div>
</template>
<script>
import AppContainer from "./AppContainer";
import MainBanner from "../components/banner/MainBanner";
import EasySearchRoom from "../components/content1/EasySearchRoom";
export default {
  name: "app",
  components: {
    AppContainer,
    MainBanner,
    EasySearchRoom
  },
  data() {
    return {
      clickedSelector: true
    };
  },
  methods: {
    clickSelector() {
      !this.clickedSelector;
    }
  },
  mounted() {}
};
</script>
<style scoped>
.room-selector {
  border-top: 1px solid #cccccc;
  padding-top: 80px;
  display: flex;
  align-items: center;
  width: 1100px;
  margin: 0 auto;
}
.room-selector1 {
  text-decoration: none;
  color: #cccccc;
  font-size: 28px;
}

.line-divider {
  display: block;
  width: 1px;
  height: 30px;
  background-color: #cccccc;
  content: "";
  margin: 0 20px;
}

.room-selector2 {
  text-decoration: none;
  color: #cccccc;
  font-size: 28px;
}
.router-link-exact-active {
  color: black;
  font-weight: bold;
}
.room-selector-title {
  margin-top: 8px;
  color: black;
  font-weight: 100;
  font-size: 16px;
}
</style>
