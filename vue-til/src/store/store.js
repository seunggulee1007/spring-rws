import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
	state: {
		userNm: '',
		token: '',
	},
	getters: {
		isLogin(state) {
			return state.userNm !== '';
		},
	},
	mutations: {
		setUserNm(state, userNm) {
			state.userNm = userNm;
		},
		setToken(state, token) {
			state.token = token;
		},
		clearUserNm(state) {
			state.userNm = '';
		},
	},
});
