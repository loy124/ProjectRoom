<template>
  <EtcContainer>
    <div slot="banner">
      <div class="search-option-container">
        <div class="search-option-wrapper1">
          <div @mousedown="closeEvent" class="search-option-search-input-wrapper">
            <input placeholder="신림동 원룸" />
          </div>
          <div
            :class="{ 'search-option-active' : optionModalType.option1}"
            class="search-option-option search-option-option1"
          >
            <span @click="openEvent('option1')" class="search-option-option-wrapper">원룸, 투·쓰리룸, 오피스텔</span>
            <i @click="openEvent('option1')" class="search-option-option-arrow-wrapper">
              <img v-if="!optionModalType.option1" src="../assets/down-arrow.png" />
              <img v-else src="../assets/up-arrow.png" />
            </i>
            <div>
              <div v-if="optionModalType.option1" class="option-modal-wrapper">
                <div class="option-modal-type-title">방종류</div>
                <div class="option-modal-type-sub-title">중복선택이 가능합니다</div>
                <div class="option-modal-type-wrapper">
                  <div class="option-modal-check-wrapper">
                    <label class="login-check checkbox">
                      <input v-model="roomTypeOption" type="checkbox" value="one" />
                      <span>원룸</span>
                    </label>
                    <label class="login-check checkbox">
                      <input v-model="roomTypeOption" type="checkbox" value="twoOrThree" />
                      <span>투·쓰리룸</span>
                    </label>
                    <label class="login-check checkbox">
                      <input v-model="roomTypeOption" type="checkbox" value="officetel" />
                      <span>오피스텔</span>
                    </label>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div
            :class="{ 'search-option-active' : optionModalType.option2}"
            class="search-option-option search-option-option2"
          >
            <span @click="openEvent('option2')" class="search-option-option-wrapper">월세,전세,매매</span>
            <i @click="openEvent('option2')" class="search-option-option-arrow-wrapper">
              <img v-if="!optionModalType.option2" src="../assets/down-arrow.png" />
              <img v-else src="../assets/up-arrow.png" />
            </i>
            <div>
              <div v-if="optionModalType.option2" class="option-modal-wrapper">
                <div class="option-modal-type-title">매물 종류</div>
                <div class="option-modal-type-sub-title">중복선택이 가능합니다</div>
                <div class="option-modal-type-wrapper">
                  <div class="option-modal-check-wrapper">
                    <label class="login-check checkbox">
                      <input v-model="roomPayOption" type="checkbox" value="one" />
                      <span>월세</span>
                    </label>
                    <label class="login-check checkbox">
                      <input v-model="roomPayOption" type="checkbox" value="twoOrThree" />
                      <span>전세</span>
                    </label>
                    <label class="login-check checkbox">
                      <input v-model="roomPayOption" type="checkbox" value="officetel" />
                      <span>매매</span>
                    </label>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div
            :class="{ 'search-option-active' : optionModalType.option3}"
            class="search-option-option search-option-option3"
          >
            <span @click="openEvent('option3')" class="search-option-option-wrapper">가격대</span>
            <i @click="openEvent('option3')" class="search-option-option-arrow-wrapper">
              <img v-if="!optionModalType.option3" src="../assets/down-arrow.png" />
              <img v-else src="../assets/up-arrow.png" />
            </i>
            <div>
              <div v-if="optionModalType.option3" class="option-modal-wrapper1">
                <div class="option-modal-type-wrapper">
                  <div class="option-modal-check-wrapper">
                    <div class="option-modal-type-pay-wrapper">
                      <label class="login-check checkbox">
                        <div class="option-modal-type-title option-modal-type-title-pay">
                          전세
                          <span class="option-modal-pay-text">({{ lease }}만원)</span>
                        </div>
                      </label>
                      <vue-slider :min="0" :max="100000" v-model="lease"></vue-slider>
                    </div>

                    <div class="option-modal-type-pay-wrapper">
                      <label class="login-check checkbox">
                        <div class="option-modal-type-title option-modal-type-title-pay">
                          보증금
                          <span
                            class="option-modal-pay-text"
                          >({{ deposit > 9999 ? '1억원' : deposit + '만원' }})</span>
                        </div>
                      </label>

                      <vue-slider :min="0" :max="10000" v-model="deposit"></vue-slider>
                    </div>
                    <div class="option-modal-type-pay-wrapper">
                      <label class="login-check checkbox">
                        <div class="option-modal-type-title option-modal-type-title-pay">
                          월세
                          <span class="option-modal-pay-text">({{ monthRent }}만원)</span>
                        </div>
                      </label>
                      <vue-slider :min="0" :max="1000" v-model="monthRent"></vue-slider>
                    </div>
                    <div>
                      <div class="option-modal-delete-option-wrapper">
                        <div class="option-modal-delete-option" @click="deleteOption">조건 삭제</div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div
            :class="{ 'search-option-active' : optionModalType.option4}"
            class="search-option-option search-option-option4"
          >
            <span @click="openEvent('option4')" class="search-option-option-wrapper">방크기</span>
            <i @click="openEvent('option4')" class="search-option-option-arrow-wrapper">
              <img v-if="!optionModalType.option4" src="../assets/down-arrow.png" />
              <img v-else src="../assets/up-arrow.png" />
            </i>
            <div>
              <div v-if="optionModalType.option4" class="option-modal-wrapper2">
                <div class="option-modal-type-wrapper">
                  <div class="option-modal-check-wrapper">
                    <div class="option-modal-type-pay-wrapper">
                      <label class="login-check checkbox">
                        <div class="option-modal-type-title option-modal-type-title-pay">
                          방크기
                          <span class="option-modal-pay-text">({{ roomSpace }}평)</span>
                        </div>
                      </label>
                      <vue-slider :min="0" :max="300" v-model="roomSpace"></vue-slider>
                    </div>
                    <div class="option-modal-delete-option-wrapper">
                      <div class="option-modal-delete-option" @click="deleteRoomOption">조건 삭제</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <!-- <div class="search-option-option search-option-option5">추가옵션</div> -->
        </div>
        <div class="search-option-wrapper2">
          <!-- <div>전체필터</div>
          <div>초기화</div>-->
        </div>
      </div>
      <div @click="closeEvent" class="search-result-container">
        <div class="search-room-list-container">
          <div class="search-room-list-all-count">전체방 {{roomLists.length}}개</div>
          <div class="search-room-list-wrapper-wrapper">
            <div class="search-room-list-wrapper">
              <!-- v-for로 묶을부분 -->

              <!-- 동적 라우팅 -->
              <router-link
                v-for="(roomList, index) in roomLists"
                :key="index"
                class="search-room-list"
                :id="roomList.id"
                :to="`detail/${roomList.id}`"
                style="text-decoration:none; outline: none; color:#222222;"
              >
                <div class="search-room-image-wrapper">
                  <img
                    v-if="roomList.room_picture_dto_list[0]"
                    class="search-room-image"
                    :src="roomList.room_picture_dto_list[0].file_name"
                    alt="이미지없음"
                  />
                  <img v-else class="search-room-image" src="../assets/room1.jpg" />

                  <img
                    @click.prevent.stop="clickImage(roomList.id)"
                    class="heart-image"
                    src="../assets/fillHeart.png"
                    alt
                  />
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
                <!-- 타입 처리부분  -->
                <div v-if="roomList.room_type === 'apartment'" class="search-room-list-type">아파트</div>
                <div v-if="roomList.room_type === 'studio'" class="search-room-list-type">오피스텔</div>
                <div v-if="roomList.room_type === 'house'" class="search-room-list-type">단독주택</div>
                <div
                  v-if="roomList.room_type === 'multiunit'"
                  class="search-room-list-type"
                >빌라/연립/다세대</div>
                <div v-if="roomList.room_type === 'flatwithshop'" class="search-room-list-type">상가주택</div>

                <div class="search-room-pay-type">월세 {{roomList.deposit}}/{{roomList.month_rent}}</div>
                <div class="search-room-detail">{{roomList.floor}}층. {{roomList.room_space}}평</div>
                <div class="search-room-content">{{roomList.content}}</div>
              </router-link>
            </div>
            <div>페이지 표시</div>
          </div>
        </div>
        <div class="search-room-map-container">지도</div>
      </div>
    </div>
  </EtcContainer>
</template>
<script scoped>
import EtcContainer from "./EtcContainer";
import { request } from "../util/axios";
import { error } from "../util/notification";
export default {
  name: "app",
  components: {
    EtcContainer
  },
  computed: {
    //데이터 처리
    // roomType(element) {
    //   console.log(element);
    //   if (element === "apartment") {
    //     return "아파트";
    //   } else if (element === "studio") {
    //     return "오피스텔";
    //   } else if (element === "house") {
    //     return "단독주택";
    //   } else if (element === "multiunit") {
    //     return "빌라/연립/다세대";
    //   } else if (element === "flatwithshop") {
    //     return "상가주택";
    //   }
    // }
  },
  data() {
    return {
      roomTypeOption: [],
      roomPayOption: [],
      optionModalType: {
        option1: false,
        option2: false,
        option3: false,
        option4: false,
        option5: false
      },
      deposit: 0, //보증금
      lease: 0, //전세
      monthRent: 0, //월세
      roomSpace: 0, //몇평
      roomLists: []
    };
  },
  mounted() {
    this.getRoomList();
    console.log("aa");
  },
  methods: {
    openEvent(element) {
      if (this.optionModalType[element] === true) {
        this.closeEvent();
      } else {
        this.closeEvent();
        this.optionModalType[element] = true;
      }
    },
    closeEvent() {
      this.optionModalType.option1 = false;
      this.optionModalType.option2 = false;
      this.optionModalType.option3 = false;
      this.optionModalType.option4 = false;
      this.optionModalType.option5 = false;
    },
    deleteOption() {
      this.deposit = this.lease = this.monthRent = 0;
    },
    deleteRoomOption() {
      this.roomSpace = 0;
    },
    getRoomList() {
      request("post", "room/getRoomMapList")
        .then(res => {
          console.log(res);
          //리스트를 data안에 집어넣기
          this.roomLists = res;
        })
        .catch(error => console.log(error));
    },
    clickImage(id) {
      console.log("heart click");
    }
  }
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
  flex: 6.8;
  padding-left: 15px;
}

.search-room-list-all-count {
  padding: 33px 0 20px;
  margin-left: 30px;
  font-size: 19px;
  border-bottom: 1px solid #dddddd;
}
.search-room-map-container {
  flex: 3.2;
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
  height: 36px;
  font-size: 14px;
  display: flex;
  align-items: center;
  border: 1px solid #dddddd;
  padding: 0 10px;
  border-radius: 5px;
}

.search-option-option:hover {
  /* background-color: #eeeeee; */
}

.search-option-option1 {
  width: 150px;
  position: relative;
}
.search-option-option2 {
  width: 130px;
  position: relative;
}
.search-option-option3 {
  width: 82px;
  position: relative;
}
.search-option-option4 {
  width: 82px;
  position: relative;
}
.search-option-option5 {
  width: 82px;
  position: relative;
}

.search-option-option-arrow-wrapper {
  margin-left: 8px;
  width: 8px;
}
.search-option-option-arrow-wrapper > img {
  width: 100%;
}

.search-option-option-wrapper {
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
}
.search-option-active {
  background-color: #006cff;
  color: #fff;
  border: none;
}

.option-modal-wrapper {
  position: absolute;
  border: 1px solid #dddddd;
  top: 40px;
  left: -10px;
  width: 250px;
  height: 250px;
  background-color: #fff;
  z-index: 101;
  box-shadow: rgba(0, 0, 0, 0.25) 0px 15px 18px -10px;
  padding: 20px 30px 0;
  color: #222222;
}

.option-modal-wrapper1 {
  position: absolute;
  border: 1px solid #dddddd;
  top: 40px;
  left: -10px;
  width: 450px;
  height: 490px;
  background-color: #fff;
  z-index: 101;
  box-shadow: rgba(0, 0, 0, 0.25) 0px 15px 18px -10px;
  padding: 20px 30px 0;
  color: #222222;
}

.option-modal-wrapper2 {
  position: absolute;
  border: 1px solid #dddddd;
  top: 40px;
  left: -10px;
  width: 350px;
  height: 230px;
  background-color: #fff;
  z-index: 101;
  box-shadow: rgba(0, 0, 0, 0.25) 0px 15px 18px -10px;
  padding: 20px 30px 0;
  color: #222222;
}
.option-modal-type-title {
  font-size: 20px;
}

.option-modal-type-sub-title {
  margin-top: 5px;
  font-weight: 100;
  font-size: 13px;
  color: #aaaaaa;
}

.option-modal-check-wrapper {
  margin-top: 20px;
}
.search-room-list-wrapper-wrapper {
  overflow-x: hidden;
  overflow-y: auto;
  height: 80vh;

  /* z-index: 101; */
}
.search-room-list-wrapper {
  margin-left: 20px;
  padding-top: 20px;
  display: flex;
  flex-wrap: wrap;
}

.search-room-list {
  width: 240px;
  font-size: 14px;
  padding-left: 15px;
  margin-bottom: 50px;
  position: relative;
  cursor: pointer;
}
.search-room-image-wrapper {
  height: 145px;
}
.search-room-image {
  width: 100%;
  height: 100%;
  position: relative;
  z-index: 99;
}
.search-room-image:hover {
  opacity: 0.5;
}
.heart-image {
  position: relative;
  z-index: 100;
}

.search-room-list-check {
  margin-top: 10px;
  display: flex;
}

.search-room-list-type {
  margin-top: 6px;
}

.search-room-pay-type {
  margin-top: 5px;
  font-size: 20px;
  font-weight: bold;
}

.search-room-detail {
  color: #666666;
  font-size: 14px;
  margin-top: 5px;
  font-weight: 100;
}
.search-room-content {
  margin-top: 2px;
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

.option-modal-type-pay-wrapper {
  padding-top: 20px;
  padding-bottom: 50px;
  border-bottom: 1px solid #dddddd;
}

.option-modal-type-title-pay {
  margin-bottom: 15px;
}

.option-modal-pay-text {
  color: #666666;
  font-size: 16px;
}

.option-modal-delete-option-wrapper {
  margin-top: 10px;
  text-align: right;
  display: flex;
  justify-content: flex-end;
}

.option-modal-delete-option {
  width: 80px;
  height: 30px;
  line-height: 30px;
  text-align: center;
  border: 1px solid #dddddd;
  font-size: 13px;
  cursor: pointer;
}
.option-modal-delete-option:hover {
  opacity: 0.5;
}
</style>
