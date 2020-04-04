import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        loginData: !sessionStorage.getItem('login') ?
            '' :
            JSON.parse(sessionStorage.getItem('login')),
        profileImage: !sessionStorage.getItem('login') ?
            '' :
            JSON.parse(sessionStorage.getItem('login')).profile_image,
        loginModal: false,
        registerModal: false,
        localPath: '/', //경로를 저장,
        searchModal: false,
        selectRegister: '',
    },
    mutations: {
        SET_LOGIN(state, data) {
            state.loginData = data;
        },
        SET_PROFILE_IMAGE(state, data) {
            state.profileImage = data;
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
        SET_LOCAL_PATH(state, data) {
            state.localPath = data;
        },
        SET_SEARCH_MODAL(state, data) {
            state.searchModal = data;
        },
        SET_SELECT_REGISTER(state, data) {
            state.selectRegister = data;
        },
    },
    actions: {},
    modules: {},
});