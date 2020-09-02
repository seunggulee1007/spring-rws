import axios from 'axios';
import { setInterceptors } from '@/api/common/index';

function createInstance() {
	const instance = axios.create({
		baseURL: process.env.VUE_APP_API_URL,
	});
	return setInterceptors(instance);
}

const instance = createInstance();

function registerUser(data) {
	return doAxios('/signUp', 'post', data);
}

function loginUser(data) {
	return doAxios('/signIn', 'post', data);
}

function fetchPosts() {
	return doAxios('/posts/a@a.com', 'get');
}

function doAxios(url, method, params, config) {
	return instance({
		url,
		method,
		params,
		config,
	});
}
export { registerUser, loginUser, fetchPosts };
