<template>
	<div class="contents">
		<div class="form-wrapper form-wrapper-sm">
			<form class="form">
				<div>
					<label for="userId">id :</label>
					<input type="text" id="userId" v-model="userId" />
					<p class="validation-text">
						<span class="warning" v-if="!isIdValid && userId">
							Please enter an email address
						</span>
					</p>
				</div>
				<div>
					<label for="password">pw : </label>
					<input type="password" id="password" v-model="password" />
				</div>
				<button
					:disabled="!isIdValid || !password"
					type="button"
					@click="login"
					class="btn"
				>
					로그인
				</button>
				<p class="log">{{ logMessage }}</p>
			</form>
		</div>
	</div>
</template>

<script>
import { loginUser } from '@/api/api';
import { validateEmail } from '@/utils/validation';
export default {
	data() {
		return {
			userId: '',
			password: '',
			logMessage: '',
		};
	},
	computed: {
		isIdValid() {
			return validateEmail(this.userId);
		},
	},
	methods: {
		async login() {
			const params = {
				userId: this.userId,
				password: this.password,
			};
			try {
				let res = await loginUser(params);
				this.logMessage = `${res.data.data.user.userNm} 님 환영합니다.`;
				console.log(res);
				if (res.data.result == 0) {
					this.$router.push('/main');
					this.$store.commit('setUserNm', res.data.data.user.userNm);
					this.$store.commit('setToken', res.data.data.authToken);
				}
			} catch (e) {
				console.log(e);
				this.logMessage = e.response.data.resultMsg;
			}
		},
	},
};
</script>

<style>
.btn {
	color: white;
}
</style>
