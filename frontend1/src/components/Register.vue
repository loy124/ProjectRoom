<template>
  <ModalRegister>
    <div slot="header">
      <div class="register-header">회원가입</div>
    </div>
    <hr />
    <div slot="body">
      <div class="register-information-container">
        <div class="register-information-wrapper">
          <div class="register-title">이메일(아이디)</div>
          <div class="register-input-wrapper">
            <input class="register-input register-email" />
            <span class="space">@</span>
            <input v-if="selectEtc" class="register-email-domain-input" />
            <select v-model="selectedDomain" class="register-input register-email-domain">
              <option value disabled selected>선택해주세요</option>
              <option>{{emailDomain.naver}}</option>
              <option>{{emailDomain.google}}</option>
              <option>{{emailDomain.daum}}</option>
              <option>{{emailDomain.hanmail}}</option>
              <option>{{emailDomain.etc}}</option>
            </select>
          </div>
        </div>

        <div class="register-information-wrapper">
          <div class="register-title">비밀번호</div>
          <div class="register-input-wrapper">
            <input class="register-input" />
          </div>
        </div>
        <div class="register-information-wrapper">
          <div class="register-title">비밀번호확인</div>
          <div class="register-input-wrapper">
            <input class="register-input" />
          </div>
        </div>

        <div class="register-information-wrapper">
          <div class="register-title">이름</div>
          <div class="register-input-wrapper">
            <input class="register-input" />
          </div>
        </div>

        <div class="register-information-wrapper">
          <div class="register-title">나이</div>
          <div class="register-input-wrapper">
            <input class="register-input" />
          </div>
        </div>
        <div class="register-information-wrapper">
          <div class="register-title">휴대폰 번호</div>
          <div class="register-input-wrapper">
            <input class="register-input register-input-phone" value="010" />
            <span class="space">-</span>
            <input class="register-input register-input-phone" />
            <span class="space">-</span>
            <input class="register-input register-input-phone" />
          </div>
        </div>

        <!-- <div class="register-information-wrapper">
          <div class="register-title">이메일</div>
          <div class="register-input-wrapper">
            <input class="register-input" />
          </div>
        </div>-->
      </div>
    </div>
    <div slot="footer">
      <button class="register-button">이메일 회원가입</button>
    </div>
  </ModalRegister>
</template>

<script>
import ModalRegister from "./ModalRegister";
export default {
  components: {
    ModalRegister
  },
  data() {
    return {
      selectedDomain: "",

      emailDomain: {
        naver: "naver.com",
        google: "gmail.com",
        daum: "daum.net",
        hanmail: "hanmail.com",
        etc: "직접입력"
      }
    };
  },
  computed: {
    selectEtc() {
      return this.selectedDomain === "직접입력" ? true : false;
    }
  },
  methods: {}
};
</script>

<style>
* {
  color: black;
}

.register-header {
  text-align: left;
  margin-bottom: 20px;
  padding-bottom: 5px;
  font-size: 22px;
}
.register-information-container {
  border-top: 1px solid rgba(210, 210, 210);
  padding-top: 5px;
}

.register-information-wrapper {
  display: flex;
  margin-top: 20px;
  align-items: center;
}
.register-title {
  display: flex;
  align-items: center;
  width: 120px;
  height: 46px;
  font-size: 14px;
  /* line-height: 46px; */
  color: #222222;
}
.space {
  margin: 0 7px;
  font-size: 14px;
  color: #888888;
}

.register-input-wrapper {
  margin-left: 10px;
  display: flex;
  align-items: center;
  width: 100%;
}
.register-input {
  width: 100%;
  height: 46px;
  padding: 4px 8px;
}

.register-email {
  width: 45%;
}

select {
  width: 200px;
  padding: 0.8em 0.5em;
  border: 1px solid #999;
  font-family: inherit;
  background: url("../assets/arrow.jpeg") no-repeat 95% 50%;
  background-size: 25px;
  border-radius: 0px;
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
}

select::-ms-expand {
  display: none;
}

.register-email-domain {
}

.register-email-domain-input {
  width: 60%;
  height: 46px;
  margin-right: 15px;
  padding: 4px 8px;
}

.register-input-phone {
  text-align: center;
}

.register-button {
  width: 100%;
  height: 70px;
  background-color: #1a5ae8;
  color: white;
  font-size: 17px;
  margin: 0;
}
</style>
