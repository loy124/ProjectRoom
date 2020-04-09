<template>
  <EtcContainer>
    <div slot="banner">
      <div class="search-option-container">
        <div class="search-option-wrapper1">
          <div class="search-option-search-input-wrapper">
            <input placeholder="신림동 원룸" />
          </div>
          <div class="search-option-option search-option-option1">원룸</div>
          <div class="search-option-option search-option-option2">월세전세매매</div>
          <div class="search-option-option search-option-option3">가격대</div>
          <div class="search-option-option search-option-option4">방크기</div>
          <div class="search-option-option search-option-option5">추가옵션</div>
        </div>
        <div class="search-option-wrapper2">
          <div>전체필터</div>
          <div>초기화</div>
        </div>
      </div>
      <div class="search-result-container">
        <div class="search-room-list-container">
          <div class="search-room-list-all-count">전체방 1111개</div>
          <div class="search-room-list-wrapper">
            <!-- v-for로 묶을부분 -->
            <div v-for="l in 10" :key="l" class="search-room-list">
              <div class="search-room-image-wrapper">
                <img class="search-room-image" src alt="이미지없음" />

                <img class="heart-image" src="../assets/fillHeart.png" alt />
                <!-- <img
            v-else
            class="heart-image"
            src="../assets/heart.png"
            @click="heartClick(recentData)"
            alt
                />-->
              </div>
              <div class="search-room-list-check">
                <!-- <div>플러스+</div> -->
                <div class="search-room-list-certification">공인중개사 확인</div>
              </div>
              <div class="search-room-list-type">원룸</div>
              <div class="search-room-pay-type">월세 30/32</div>
              <div class="search-room-detail">2층. 23.14m2</div>
              <div class="search-room-content">방3화장실2 아주 넓은 베란다 넓은 우리집 넓은 역세권</div>
            </div>
          </div>
          <div>페이지 표시</div>
        </div>
        <div class="search-room-map-container">지도</div>
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
.search-option-container {
  color: #222222;
  display: flex;
  align-items: center;
  height: 66px;
  /* position: fixed;
  top: 66px; */
  width: 100%;
  border: 1px solid #dddddddd;
  box-shadow: rgba(0, 0, 0, 0.2) 0px 3px 1px -2px;
}
.search-option-wrapper1 {
  display: flex;
  align-items: center;
  height: 100%;
}
.search-option-wrapper2 {
  margin-left: auto;
  display: flex;
}
.search-result-container {
  color: #222222;
  display: flex;
}

.search-room-list-container {
  flex: 6;
  padding-left: 15px;
}

.search-room-list-all-count {
  padding: 33px 0 20px;
  margin-left: 30px;
  font-size: 19px;
  border-bottom: 1px solid #dddddd;
}
.search-room-map-container {
  flex: 4;
}
.search-option-search-input-wrapper {
  width: 248px;
  height: 100%;
}

.search-option-search-input-wrapper > input {
  width: 248px;
  height: 100%;
  border: none;
  border-right: 1px solid #dddddd;
  padding: 0 30px;
  font-size: 16px;
}

.search-option-option {
  margin-left: 15px;
}
.search-room-list-wrapper {
  margin-left: 20px;
  padding-top: 20px;
  display: flex;
  flex-wrap: wrap;
  overflow-x: hidden;
  overflow-y: auto;
  height: 500px;
}

.search-room-list {
  width: 210px;
  font-size: 14px;
  padding-left: 15px;
  margin-bottom: 50px;
  position: relative;
}
.search-room-image-wrapper {
  height: 145px;
}
.search-room-image {
  width: 100%;
  height: 100%;
}

.search-room-list-check {
  margin-top: 10px;
  display: flex;
}

.search-room-list-type {
  margin-top: 6px;
}

.search-room-pay-type {
  margin-top: 10px;
  font-size: 20px;
  font-weight: bold;
}

.search-room-detail {
  color: #666666;
  font-size: 14px;
  margin-top: 10px;
  font-weight: 100;
}
.search-room-content {
  color: #666666;
  font-size: 14px;
  width: 100%;

  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.search-room-list-certification {
  border: 1px solid #326cf9;
  color: #326cf9;
  font-weight: bold;
  font-size: 11px;
  padding: 3px;
}
</style>
