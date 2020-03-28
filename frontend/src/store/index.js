import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        loginData: '',
        loginModal: false,
        registerModal: false,
    },
    mutations: {
        SET_LOGIN(state, data) {
            state.loginData = data;
        },
        SET_LOGIN_MODAL(state, data) {
            state.loginModal = data;
            state.registerModal = false;
        },
        SET_REGISTER_MODAL(state, data) {
            //로그인 창 닫기
            state.loginModal = false;
            //회원가입창 열어주기
            state.registerModal = data;
        },
    },
    actions: {},
    modules: {},
});