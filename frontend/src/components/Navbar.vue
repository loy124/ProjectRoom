<template>
  <!-- 해당 공간은 vue-cli 방식에서 component방식으로 넘겨줘서 spring의 tiles 처럼 해당 부분을 컴포넌트화 시켜서 붙일수 있다.-->
  <div id="app" class="header-container">
    <div id="header-top">
      <div class="header">
        <div class="header-left">
          <div>
            <button>
              <img src="../assets/logo.png" />
            </button>
          </div>
          <div class="header-left-site-button1">
            <button>프로중개사이트</button>
          </div>
          <div class="vertical-line"></div>
          <div class="header-left-site-button2">
            <button>방주인사이트</button>
          </div>
        </div>
      </div>
    </div>
    <div class="header-right">
      <div class="header-menu">
        <div class="header-menu-item header-menu-item1">
          <button>방찾기</button>
        </div>
        <div class="header-menu-item header-menu-item1">
          <button>분양</button>
        </div>
        <div class="header-menu-item header-menu-item2">
          <button>관심목록</button>
        </div>
        <div class="header-menu-item header-menu-item3">
          <button>방내놓기</button>
        </div>
        <div class="header-menu-item header-menu-item4">
          <button>알림</button>
        </div>
      </div>

      <!-- 로그인 세션이 있을시에 -->
      <div v-if="loginData" class="header-login">
        <div class="header-login-item header-login-item2">
          <button>님 환영합니다</button>
        </div>
      </div>

      <!-- 로그인시 -->
      <div v-else class="header-login">
        <div class="header-login-item header-login-item1">
          <button @click="SET_LOGIN_MODAL(true)">회원가입 및 로그인</button>
        </div>
        <!-- <div class="header-login-item header-login-item2">
          <button>로그인</button>
          -->
          <Login v-if="loginModal" />
          <Register v-if="registerModal" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Login from "./Login";
import Register from "./Register";
import axios from "axios";
import { mapState, mapMutations } from "vuex";
export default {
  components: {
    Login,
    Register
  },
  data() {
    //로그인 데이터
    return {};
  },
  mounted() {},
  computed: {
    ...mapState(["loginData", "loginModal", "registerModal"])
    // ...mapMutations(["SET_LOGIN_MODAL"])
  },
  methods: {
    ...mapMutations(["SET_LOGIN", "SET_LOGIN_MODAL", "SET_REGISTER_MODAL"]),
    getLoginData() {
      // this.loginData = localStorage.getItem('login');
      // this.SET_LOGIN(this.loginData);
    }
  }
};
</script>

<style scoped>
.header-container {
  background-color: #fff;
  padding: 0 20px;
  display: flex;
  justify-content: space-between;
  height: 70px;
  color: #888888;
}

.header-left {
  display: flex;
  align-items: center;
}

.header-left-site-button1 {
  margin-left: 20px;
}

.header-left-site-button2 {
}
.vertical-line {
  display: inline-block;
  width: 1px;
  height: 15px;
  background: rgb(221, 221, 221);
  margin: 8px 12px 0 12px;
}

.header-left-site-button1 > button,
.header-left-site-button2 > button {
  color: #888888;
  font-size: 13px;
}

.header-left-site-button2 {
  margin-left: 8px;
}

.header-right {
  display: flex;
  align-items: center;
}

.header-menu {
  display: flex;
}

.header-menu-item {
  margin-left: 35px;
}

.header-menu-item > button {
  color: rgb(34, 34, 34);
}

.header-login {
  display: flex;
  margin-left: 50px;
}
.header-login-item > button {
  margin-left: 8px;
  color: #888888;
  font-size: 13px;
}

button {
  background-color: white;
  border: 0;
}

img {
  height: 63px;
  /* height: auto; */
}
</style>
