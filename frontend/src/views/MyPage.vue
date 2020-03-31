<template>
  <EtcContainer class="container">
    <div slot="banner">
      <div class="attention-container">
        <div class="attention-title">관심목록</div>
        <div class="attention-select-wrapper">
          <!-- <div class="attention-select-item">최근본방</div> -->
          <router-link class="attention-select-item" :to="`/attention`">최근 본방</router-link>
          <router-link class="attention-select-item" :to="`/attention/keep`">최근 본방</router-link>
          <!-- <div class="attention-select-item">찜한 방</div> -->
        </div>
        <!-- router view 넣기 -->
        <router-view />
      </div>
    </div>
  </EtcContainer>
</template>
<script>
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
</style>