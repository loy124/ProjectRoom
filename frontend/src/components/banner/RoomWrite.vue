<template>
  <div>
    <div class="room-write-notification-wrapper">
      <ul class="room-write-wrapper">
        <li>등록한 매물은 30일 동안 노출됩니다.</li>
        <li>글을 작성할시 마다 글쓰기 횟수가 차감됩니다.</li>
        <li>고양이</li>
      </ul>
    </div>
    <div class="room-write-type-container">
      <div class="room-write-type-header">매물 종류</div>
      <div class="room-write-type-wrapper">
        <div class="room-write-type-title">종류 선택</div>
        <div class="room-write-type-selctor">
          <div class="room-write-type">원룸</div>
          <div class="room-write-type">투룸</div>
          <div class="room-write-type">쓰리룸</div>
          <div class="room-write-type">오피스텔</div>
          <div class="room-write-type">아파트</div>
        </div>
      </div>
      <div class="room-write-type-wrapper">
        <div class="room-write-type-title">건물 유형</div>
        <div class="room-write-type-selctor">
          <div class="room-write-type">단독주택</div>
          <div class="room-write-type">다가구주택</div>
          <div class="room-write-type">빌라/연립/다세대</div>
          <div class="room-write-type">상가주택</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.room-write-notification-wrapper {
  margin-top: 30px;
  border: 1px solid #dddddd;
  padding: 20px 40px;
  box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 5px 0px;
}
.room-write-wrapper > li {
  color: #222222;
  list-style: none;
  font-size: 15px;
  position: relative;
  font-weight: 100;
}
.room-write-wrapper > li:not(:first-child) {
  margin-top: 8px;
}

.room-write-wrapper > li::before {
  content: '';
  width: 3px;
  height: 3px;
  background-color: rgb(34, 34, 34);
  position: absolute;
  top: 50%;
  left: -10px;
  transform: translateY(-50%);
  border-radius: 50%;
}
.room-write-type-container {
  border: 1px solid #bbbbbb;
  box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 5px 0px;
  color: #222222;
}

.room-write-information-wrapper {
  margin-top: 20px;
}

.room-write-type-header {
  text-align: center;
  border-bottom: 1px solid #bbbbbb;
  height: 60px;
  line-height: 60px;
  font-size: 18px;
}

.room-write-type-wrapper {
  height: 70px;
  display: flex;
  align-items: center;
}
.room-write-type-wrapper:not(:last-child) {
  border-bottom: 0.8px solid #dddddd;
  box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 5px 0px;
}
.room-write-type-title {
  width: 150px;
  height: 100%;
  font-size: 15px;
  line-height: 70px;
  text-align: center;
  background-color: rgb(249, 249, 249);
  font-weight: 400;
}

.room-write-type-selctor {
  display: flex;
  padding-left: 10px;
}
.room-write-type {
  text-align: center;
  min-width: 82px;
  height: 46px;
  padding: 0 15px;
  font-size: 15px;
  line-height: 46px;
  border: 1px solid #dddddd;
  border-radius: 5px;
}
.room-write-type:not(:first-child) {
  margin-left: 10px;
}
</style>
