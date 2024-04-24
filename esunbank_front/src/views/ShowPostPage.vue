<template>
  <h1>全部文章</h1>
  <br>
  <div v-for="post in posts">
    <div class="card">
      <div class="card-header">
        發文者：{{ post.user.userName }} 時間：<span>{{ post.createdTime }}</span>
        <span>
        <button class="btn btn-outline-danger btn-sm float-right" @click="deletePost(post.postID)">刪除</button>
        <button class="btn btn-outline-success btn-sm float-right" @click="editPost(post)">編輯</button>          |
          </span>
      </div>
      <div class="card-body">
        <textarea class="form-control" disabled>{{ post.content }}</textarea>
        <br>
        <span v-for=" comment in post.comment">
          <span>{{ comment.user.userName }}: {{ comment.content }}</span>
          <span class=" float-right">{{
              format(new Date(comment.createdTime), "a hh 時 mm 分 ss 秒 ## yyyy 年 MM 月 dd 日 EEEE", {locale: zhTW})
            }}</span>
          <br>
        </span>
        <br>
        <div v-if="post.commentOpen">
          留言: <input type="text" class="form-control" v-model="comment"/>
          <button class="btn btn-outline-primary btn-sm" @click="sendComment(post.postID)">送出</button>
        </div>
        <div v-else>
          <button class="btn btn-outline-primary btn-sm" @click="post.commentOpen = !post.commentOpen">留言</button>
        </div>

      </div>
    </div>
    <br>
  </div>

</template>

<script setup>
import axios from "axios";
import {onMounted, ref} from "vue";
import {format} from 'date-fns'
import {zhTW} from 'date-fns/locale'

const posts = ref([]);
const comment = ref('');
const URL = import.meta.env.VITE_API_JAVAURL;

onMounted(() => {
  getPosts();
});

const getPosts = async () => {
  try {
    const response = await axios.get(`${URL}post/show`, {withCredentials: true});
    console.log("posts: " + response.data);
    posts.value = response.data.map(post => ({
      ...post,
      createdTime: format(new Date(post.createdTime), "a hh 時 mm 分 ss 秒 ## yyyy 年 MM 月 dd 日 EEEE", {locale: zhTW}),
      commentOpen: false,
    })).reverse();
  } catch (error) {
    console.error('AJAX error:', error);
  }
}

const editPost = async (post) => {
  try {
    const response = await axios.post(`${URL}post/edit`, {withCredentials: true});
    console.log("edit post: " + response.data);
    if (response.data === "Y") {
      alert("文章已更新!!")
      await getPosts();
    } else {
      alert("系統錯誤")
    }

  } catch (error) {
    console.error('AJAX error:', error);
  }
}

const deletePost = async (id) => {
  try {
    const response = await axios.delete(`${URL}post/delete/${id}`, {withCredentials: true});
    console.log("delete post: " + response.data);
    if (response.data === "Y") {
      alert("文章已刪除!!")
      await getPosts();
    }
  } catch (error) {
    console.error('AJAX error:', error);
  }
}

const sendComment = async (postID) => {
  try {
    const formData = new FormData();
    formData.append('postid', postID);
    formData.append('content', comment.value);
    const response = await axios.post(`${URL}comment/add`, formData, {withCredentials: true});
    console.log("send comment: " + response.data);
    if (response.data === "Y") {
      alert("留言已送出!!")
      await getPosts();
    } else {
      alert("請先登入")
    }
  } catch (error) {
    console.error('AJAX error:', error);
  }
}


</script>


<style scoped>
.float-right {
  float: right;
}
</style>