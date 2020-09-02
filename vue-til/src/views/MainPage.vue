<template>
	<div>
		<div class="main list-container contents">
			<h1 class="page-header">today I Learned</h1>
			<LoadingSpinner v-if="isLoading"></LoadingSpinner>
			<ul v-else>
				<PostItemList
					v-for="post in postItems"
					:key="post.postId"
					:post="postItems"
				>
				</PostItemList>
			</ul>
		</div>
	</div>
</template>

<script>
import { fetchPosts } from '@/api/api';
import LoadingSpinner from '@/components/common/LoadingSpinner.vue';
import PostItemList from '@/components/posts/PostListItem.vue';
export default {
	data() {
		return {
			postItems: [],
			isLoading: false,
		};
	},
	created() {
		this.fetchNotes();
	},
	methods: {
		async fetchNotes() {
			this.isLoading = true;
			try {
				let { data } = await fetchPosts();
				this.postItems = data.data;
			} catch (err) {
				console.log(err);
			}
			this.isLoading = false;
		},
	},
	components: {
		PostItemList,
		LoadingSpinner,
	},
};
</script>

<style></style>
