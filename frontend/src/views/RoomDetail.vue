<template>
  <EtcContainer class="container">
    <div slot="banner">
      <div class="room-detail-container">
        <div class="room-detail-header">
          <div class="room-detail-header-container">
            <div class="room-detail-header-wrapper">
              <div class="room-detail-header-item">
                <div class="room-detail-header-type">원룸</div>
                <div class="room-detail-header-information">
                  월세 300/36
                  <span class="gray-font-8 money-type">만원</span>
                </div>
              </div>
              <div class="room-detail-header-item">
                <div class="room-detail-header-type">전용면적</div>
                <div class="room-detail-header-information">19.86</div>
              </div>
              <div class="room-detail-header-item">
                <div class="room-detail-header-type">한달 생활비</div>
                <div class="room-detail-header-information blue-font">41만 원 + α</div>
              </div>
            </div>
            <div class="room-detail-broker-info">
              <div class="room-detail-broker-name">이름</div>
              <div class="room-detail-broker-information">연락처 보기</div>
            </div>
          </div>
          <div class="room-detail-header-service">
            <div class="room-detail-icon-wrapper">
              <img src="../assets/fillHeart.png" />
              <span class="room-detail-icon-text">0</span>
            </div>
            <div class="distance-dot">•</div>
            <div class="room-detail-icon-wrapper">
              <img src="../assets/link.png" />
            </div>
            <div class="distance-dot">•</div>
            <div class="room-detail-icon-wrapper">
              <img src="../assets/crisis.png" />
              <span class="room-detail-icon-text">허위매물신고</span>
            </div>
          </div>
        </div>
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
.room-detail-container {
  color: #222222;
}
.room-detail-header-container {
  padding-top: 35px;
  display: flex;
}

.room-detail-header-wrapper {
  display: flex;
}
.room-detail-header-item {
  padding-right: 25px;
  border-right: 1px solid #dddddd;
  min-width: 150px;
}
.room-detail-header-item:not(:first-child) {
  margin-left: 25px;
}

.room-detail-header-type {
  font-size: 14px;
  color: #666666;
}

.room-detail-broker-info {
  margin-left: auto;
}

.room-detail-header-information {
  margin-top: 6px;
  font-size: 30px;
}
.blue-font {
  color: #1476fc;
}
.money-type {
  margin-left: 3px;
}

.gray-font-8 {
  color: #666666;
  font-size: 15px;
}

.room-detail-broker-info {
  display: flex;
  align-items: center;
}
.room-detail-broker-name {
  font-size: 12px;
  color: #666666;
}

.room-detail-broker-information {
  font-size: 12px;
  width: 106px;
  height: 38px;
  border: 1px solid #dddddd;
  border-radius: 40px;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-left: 15px;
}

.room-detail-header-service {
  margin-top: 35px;
  display: flex;
}
.distance-dot {
  display: flex;
  -webkit-box-align: center;
  align-items: center;
  height: 22px;
  color: rgb(34, 34, 34);
  font-size: 15px;
  line-height: 22px;
  position: relative;
  user-select: none;
  margin: 0 12px;
}
.room-detail-icon-wrapper {
  display: flex;
  align-items: center;
  font-size: 15px;
  cursor: pointer;
}
.room-detail-icon-wrapper > img {
  height: 18px;
}
.room-detail-icon-text {
  margin-left: 10px;
}
</style>
