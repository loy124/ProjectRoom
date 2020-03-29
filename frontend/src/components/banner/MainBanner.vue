<template>
  <div class="banner-container">
    <div class="banner-type">
      <vue-typed-js
        :strings="[
          '<div style=color:#1a5ae8;>어떤 동네, 어떤방<span style=color:black;>에서</span></div><span style=color:black;>살고 싶으신가요?</span>',
        ]"
      >
        <h1>
          <div style="text-align:center" class="typing"></div>
        </h1>
      </vue-typed-js>
    </div>
    <div class="room-search-wrapper">
      <div class="room-search-icon"><img src="../../assets/search.png" /></div>
      <input />
      <div class="searchButton">방찾기</div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.banner-container {
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.banner-type {
  height: 125px;
}
.typing {
  font-size: 46px;
  font-weight: 100;
}
.room-search-wrapper {
  margin-top: 30px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 800px;
  height: 60px;
  background-color: #fff;
  padding: 0 5px;
  border: 1px solid rgb(208, 210, 214);
}
.room-search-wrapper > input {
  width: 75%;
  height: 75%;
  border: none;
  font-size: 25px;
}
.room-search-icon {
  width: 45px;
  height: 30px;
  padding-left: 5px;

  border-right: 1px solid rgb(208, 210, 214);
}
.room-search-icon > img {
  width: 30px;
}

.searchButton {
  color: white;
  background-color: rgb(19, 116, 248);
  font-size: 16px;
  width: 95px;
  height: 48px;
  line-height: 48px;
  text-align: center;
  cursor: pointer;
}
</style>
