import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        loginData: '',
    },
    mutations: {
        SET_LOGIN(state, data) {
            state.loginData = data;
        },
    },
    actions: {},
    modules: {},
});