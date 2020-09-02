<template>
	<li>
		<div class="post-title">
			{{ post.title }}
		</div>
		<div class="post-contents">
			{{ post.contents }}
		</div>
		<div class="post-time">
			{{ post.crtDtm }}
		</div>
	</li>
</template>

<script>
export default {
	props: {
		post: {
			type: Object,
			required: true,
		},
	},
};
</script>

<style></style>
