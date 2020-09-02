<template>
	<div class="contents">
		<div class="form-wrapper form-wrapper-sm">
			<form class="form">
				<div>
					<label for="userId">id :</label>
					<input type="text" id="userId" v-model="userId" />
				</div>
				<div>
					<label for="password">pw : </label>
					<input type="password" id="password" v-model="password" />
				</div>
				<div>
					<label for="userNm">name : </label>
					<input type="text" id="userNm" v-model="userNm" />
				</div>
				<button type="button" class="btn" @click="join">회원가입</button>
			</form>
		</div>
	</div>
</template>

<script>
import { registerUser } from '@/api/api';
export default {
	data() {
		return {
			userId: '',
			password: '',
			userNm: '',
			logMessage: '',
		};
	},
	methods: {
		async join() {
			const userData = {
				userId: this.userId,
				password: this.password,
				userNm: this.userNm,
			};

			try {
				console.log(userData);
				let { data } = await registerUser(userData);
				console.log(data);
				this.logMessage = `${data.userNm}님이 로그인 하셨습니다.`;
				this.initForm();
			} catch (e) {
				console.log(e);
			}
		},
		initForm() {
			this.userId = '';
			this.password = '';
			this.userNm = '';
		},
	},
};
</script>

<style></style>
