<template>
  <Modal>
    <div slot="header">
      <div @click="SET_REGISTER_MODAL(false)" class="close-button">
        <img src="../assets/close.png" />
      </div>
      <div class="login-title">로그인</div>
    </div>
    <div slot="body">
      <div class="login-input-wrapper">
        <input class="login-id" placeholder="아이디" />
        <input class="login-password" placeholder="비밀번호" />
      </div>
      <div class="login-check-wrapper">
        <div>
          <input type="checkbox" />아이디저장
        </div>
        <button class="find-password-button">비밀번호 찾기</button>
      </div>
      <div class="login-button-wrapper">
        <div>
          <button class="login-button">로그인</button>
        </div>
        <div>
          <!-- <button>로그인</button>
          <button>로그인</button>-->
        </div>
        <div class="register-wrapper">
          아직 회원이 아니세요?
          <button @click="SET_REGISTER_MODAL(true)" class="register-button">이메일로 회원가입</button>
        </div>
      </div>
    </div>
    <div slot="footer">
      <div class="move-broker">
        방을 판매하세요?
        <div>
          <button class="move-broker-button">네 팝니다</button>
        </div>
      </div>
    </div>
  </Modal>
</template>

<script>
import Modal from "./Modal";
import { mapSate, mapMutations } from "vuex";
export default {
  components: {
    Modal
  },
  data() {
    return {};
  },
  computed: {},
  methods: {
    ...mapMutations(["SET_REGISTER_MODAL"])
  }
};
</script>

<style scoped>
* {
  color: black;
}
.close-button {
  text-align: right;
  cursor: pointer;
}
.close-button > img {
  width: 20px;
  height: auto;
}

.login-input-wrapper {
  margin: 0 auto;
}
.login-title {
  text-align: center;
  margin-bottom: 20px;
}
.login-id {
  padding: 0 15px;
  width: 100%;
  height: 46px;
}
.login-password {
  margin-top: 8px;
  padding: 0 15px;
  width: 100%;
  height: 46px;
}

.login-check-wrapper {
  display: flex;
  justify-content: space-between;
  margin: 18px 0;
  border: 0;
}

.login-check-wrapper > * {
  color: #888888;
  font-size: 14px;
}
.find-password-button {
  cursor: pointer;
  border: 0;
  color: #444444;
}

.login-button {
  cursor: pointer;
  width: 100%;
  height: 60px;
  background-color: #1a5ae8;
  border: 0;
  color: #fff;
}

.register-wrapper {
  text-align: center;
  color: #888888;
  padding: 24px 0 40px;
  font-size: 14px;
}

.register-button {
  cursor: pointer;
  margin-left: 6px;
  color: #1564f9;
  border: 0;
}

.move-broker {
  color: #888888;
  text-align: center;
}
.move-broker-button {
  cursor: pointer;
  margin-top: 10px;
  padding: 10px 20px;
  border: 1px solid #888888;
  /* border: 0; */
}
</style>
