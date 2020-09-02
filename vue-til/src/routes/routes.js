import Vue from 'vue';
import VueRouter from 'vue-router';

// 플러그인 사용하기 위해 설정.
Vue.use(VueRouter);

export default new VueRouter({
	mode: 'history',
	routes: [
		{
			path: '/',
			redirect: '/login',
		},
		{
			path: '/login',
			component: () => import('@/views/LoginPage.vue'),
		},
		{
			path: '/signup',
			component: () => import('@/views/SignupPage.vue'),
		},
		{
			path: '/chart',
			component: () => import('@/views/Chart.vue'),
		},
		{
			path: '/main',
			component: () => import('@/views/MainPage.vue'),
		},
		{
			path: '*',
			component: () => import('@/views/NotFoundPage.vue'),
		},
	],
});
