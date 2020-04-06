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
      <div class="radio-wrap"></div>

      <div class="room-write-type-header">매물 종류</div>
      <div class="room-write-type-wrapper">
        <div class="room-write-type-title">종류 선택</div>
        <div class="room-write-type-selctor">
          <label class="room-write-type">
            <input type="radio" v-model="roomCount" value="one" />
            <p>원룸</p>
          </label>
          <label class="room-write-type">
            <input type="radio" v-model="roomCount" value="two" />
            <p>투룸</p>
          </label>
          <label class="room-write-type">
            <input type="radio" v-model="roomCount" value="three" />
            <p>쓰리룸</p>
          </label>
          <label class="room-write-type">
            <input type="radio" v-model="roomCount" value="four" />
            <p>포룸</p>
          </label>
          <label class="room-write-type">
            <input type="radio" v-model="roomCount" value="more" />
            <p>그 이상</p>
          </label>
        </div>
      </div>
      <div class="room-write-type-wrapper">
        <div class="room-write-type-title">건물 유형</div>
        <div class="room-write-type-selctor">
          <label class="room-write-type">
            <input type="radio" v-model="roomType" value="apartment" />
            <p>아파트</p>
          </label>
          <label class="room-write-type">
            <input type="radio" v-model="roomType" value="studio" />
            <p>오피스텔</p>
          </label>
          <label class="room-write-type">
            <input type="radio" v-model="roomType" value="house" />
            <p>단독주택</p>
          </label>
          <label class="room-write-type">
            <input type="radio" v-model="roomType" value="multiunit" />
            <p>빌라/연립/다세대</p>
          </label>
          <label class="room-write-type">
            <input type="radio" v-model="roomType" value="flatwithshop" />
            <p>상가주택</p>
          </label>
        </div>
      </div>
    </div>
    <div class="room-location-container">
      <div class="room-location-title-wrapper">
        <div></div>
        <div class="room-location-title">위치 정보</div>
        <div class="room-location-sub-title">*등기부등본 상의 주소를 입력해주세요</div>
      </div>
      <div class="room-location-content-container">
        <div class="room-location-content-title">주소</div>
        <div class="room-location-content-wrapper">
          <div class="room-location-content">
            <div class="room-location-content-notification">도로명 건물명 지번에 대해 통합검색이 가능합니다.</div>
            <div class="room-location-input-wrapper">
              <input
                class="room-location-input"
                v-model="locationSearch"
                type="text"
                placeholder="예)번동 10-1,강북구 번동"
              />
              <div @click="sample5_execDaumPostcode()" class="room-location-search-button">주소검색</div>
            </div>
            <div class="room-location-search-result" id="sample5_address">{{sample5_address}}</div>
            <div class="room-location-result-detail-wrapper">
              <diV v-if="!checkDong" class="room-location-result-detail">
                <input class="room-location-result-detail-input" placeholder="예)101동" />
                <div class="room-location-result-detail-sub">동</div>
              </diV>
              <diV class="room-location-result-detail">
                <input class="room-location-result-detail-input" placeholder="예)201호" />
                <div class="room-location-result-detail-sub">호</div>
              </diV>
            </div>
            <label class="room-location-dong-check-wrapper room-checkbox checkbox">
              <input v-model="checkDong" type="checkbox" />
              <span>등본에 동정보가 없는경우 선택해주세요</span>
            </label>
          </div>
        </div>
        <div class="room-location-map-wrapper">
          <div class="room-location-map" id="map" ref="map">
            <div class="room-location-img-wrapper">
              <img src="../../assets/gps.png" />
            </div>
            <div>주소 검색을 하시면</div>
            <div>해당 위치가 지도에 표시됩니다.</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import { kakaoMap } from "../../util/kakaoMap";

export default {
  data() {
    return {
      roomCount: "one",
      roomType: "apartment",
      checkDong: false,
      sample5_address: "",
      address: "",
      map: "",
      locationSearch: ""
    };
  },
  mounted() {
    const script1 = document.createElement("script");
    script1.src =
      "https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js";
    document.head.appendChild(script1);
    // if (window.kakao && window.kakao.maps) {
    //   // this.initMap();
    // } else {
    const script = document.createElement("script");
    /* global kakao */
    script.onload = () => kakao.maps.load();
    script.src =
      "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=0fe1d5fd101ab6d2078168510cdb7237&libraries=services";
    document.head.appendChild(script);
    // }
  },
  methods: {
    sample5_execDaumPostcode() {
      // console.log(this);
      let vueData = this; //vue의 this 값 바인딩 new daum.Postcode에서는 this를 사용시 자체 함수를 가리킨다
      let mapContainer = this.$refs.map;
      // console.log(this.$route);
      let searchKeyword = this.locationSearch;

      new daum.Postcode({
        oncomplete: function(data) {
          // let mapContainer = document.getElementById("map"); // 지도를 표시할 div
          // let mapContainer = this.$refs.map; // 지도를 표시할 div
          let mapOption = {
            center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
            level: 4 // 지도의 확대 레벨
          };
          let map = new daum.maps.Map(mapContainer, mapOption);
          //주소-좌표 변환 객체를 생성
          let geocoder = new daum.maps.services.Geocoder();
          //마커를 미리 생성
          let marker = new daum.maps.Marker({
            position: new daum.maps.LatLng(37.537187, 127.005476),
            map: map
          });
          let addr = data.address; // 최종 주소 변수
          // 주소 정보를 해당 필드에 넣는다.
          // document.getElementById("sample5_address").value = addr;
          // document.getElementById("sample5_address").innerHTML = addr;
          vueData.sample5_address = addr;
          // d.address = addr;
          // 주소로 상세 정보를 검색
          geocoder.addressSearch(data.address, function(results, status) {
            // 정상적으로 검색이 완료됐으면
            if (status === daum.maps.services.Status.OK) {
              let result = results[0]; //첫번째 결과의 값을 활용

              // 해당 주소에 대한 좌표를 받아서
              let coords = new daum.maps.LatLng(result.y, result.x);
              // 지도를 보여준다.
              mapContainer.style.display = "block";
              map.relayout();
              map.setLevel(4);
              // 지도 중심을 변경한다.
              map.setCenter(coords);

              // 마커를 결과값으로 받은 위치로 옮긴다.
              marker.setPosition(coords);
            }
          });
        }
      }).open({
        //검색어 넘기기
        q: this.locationSearch
      });
    }
  }
};
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
  content: "";
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
  margin-top: 50px;
}

.room-write-information-wrapper {
  margin-top: 20px;
}

.room-write-type-header {
  text-align: center;
  border-bottom: 1px solid #cccccc;
  box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 5px 0px;
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
  /* box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 5px 0px; */
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
  padding-left: 20px;
}
.room-write-type {
  text-align: center;
  min-width: 82px;
  height: 46px;
  font-size: 15px;
  line-height: 46px;
  /* border: 0.5px solid #dddddd; */
  border-radius: 5px;
  cursor: pointer;
}
.room-write-type:not(:first-child) {
  margin-left: 10px;
}

.room-write-type > input[type="radio"] {
  position: relative;
  user-select: none;
}

.room-write-type > input[type="radio"],
input[type="radio"]:checked {
  position: absolute;
  appearance: none;
  width: 0.9rem;
  height: 0.9rem;
  border-radius: 100%;
  margin-right: 0.1rem;
}
.room-write-type > p {
  min-width: 82px;
  height: 100%;
  border-radius: 5px;
  padding: 0 15px;
  border: 1px solid #dddddd;
}

.room-write-type > input[type="radio"]:checked + p {
  color: white;
  background-color: #1a5ae8;
  border: 1px solid #1a5ae8;
}

.room-location-container {
  color: #222222;
  margin-top: 30px;
  border: 1px solid #dddddd;
}

.room-location-title-wrapper {
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 60px;
  border-bottom: 1px solid #dddddd;
}
.room-location-title-wrapper > div {
  flex: 1;
}
.room-location-title {
  text-align: center;
  font-size: 18px;
}
.room-location-sub-title {
  text-align: right;
  font-size: 14px;
  color: #888888;
  transform: translateX(-7%);
}

.room-location-content-container {
  display: flex;
  height: 370px;
}
.room-location-content-title {
  width: 150px;
  text-align: center;
  line-height: 370px;
  background-color: #f9f9f9;
}
.room-location-content-wrapper {
  padding: 20px;
  display: flex;
  align-items: center;
}

.room-location-content-notification {
  font-size: 14px;
  color: #888888;
}
.room-location-input-wrapper {
  margin-top: 15px;
  display: flex;
  height: 46px;
}
.room-location-input {
  height: 100%;
  width: 430px;
  border: none;
  border: 1px solid #cccccc;
  border-radius: 4px;
  padding: 0 15px;
}
.room-location-search-button {
  height: 100%;
  cursor: pointer;
  margin-left: 10px;
  background-color: #232d4a;
  color: white;
  min-width: 90px;
  font-size: 14px;
  text-align: center;
  line-height: 46px;
  border-radius: 4px;
}

.room-location-search-result {
  display: flex;
  margin-top: 12px;
  width: 528px;
  height: 100px;
  align-items: center;
  border: 1px solid #cccccc;
  padding: 20px 15px;
  font-size: 15px;
  color: #666666;
}

.room-location-result-detail-wrapper {
  margin-top: 10px;
  height: 46px;
  display: flex;
  align-items: center;
}

.room-location-result-detail {
  display: flex;
  height: 46px;
  align-items: center;
}

.room-location-result-detail:not(:first-child) {
  margin-left: 8px;
}
.room-location-result-detail-input {
  border: none;
  border: 1px solid #cccccc;
  width: 212px;
  height: 100%;
  padding: 0 15px;
}
.room-location-result-detail-sub {
  color: #888888;
  font-size: 14px;
  width: 48px;
  height: 100%;
  line-height: 46px;
  text-align: center;
  border: 1px solid #cccccc;
  border-left: none;
}

.room-location-dong-check-wrapper {
  /* margin-top: 5px; */
  display: flex;
  align-items: center;
  font-size: 14px;
}

.checkbox {
  display: inline-flex;
  cursor: pointer;
  position: relative;
}

.checkbox > span {
  /* color: #34495e; */
  padding: 0.5rem 0.25rem;
  margin-left: 5px;
}

.checkbox > input {
  height: 20px;
  width: 20px;
  -webkit-appearance: none;
  -moz-appearance: none;
  -o-appearance: none;
  appearance: none;
  border: 1px solid #dddddd;
  border-radius: 4px;
  outline: none;
  transition-duration: 0.3s;
  background-color: #fff;
  cursor: pointer;
}

.checkbox > input:checked {
  border: 1px solid #1564f9;
  background-color: #1564f9;
}

.checkbox > input:checked + span::before {
  content: "\2713";
  font-size: 15px;
  display: block;
  text-align: center;
  color: #fff;
  position: absolute;
  left: 0.35rem;
  top: 0.4rem;
}
.login-check {
  display: flex;
  align-items: center;
}
.checkbox > input:active {
  border: 2px solid #34495e;
}
.room-location-map-wrapper {
  padding: 20px;
  width: 100%;
  height: 100%;
}
#map {
  width: 100%;
  height: 100%;
}

.room-location-map {
  border: 1px solid #dddddd;
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  color: #888888;
  font-size: 15px;
}
.room-location-map > div {
  margin-top: 5px;
}

.room-location-img-wrapper {
  width: 50px;
  height: 50px;
  border: 1px solid #dddddd;
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.room-location-img-wrapper > img {
  width: 50%;
  height: 50%;
}
</style>


