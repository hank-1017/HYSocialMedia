<template>
  <h1>首頁</h1>
  <br>
  <div class="card">
    <div class="card-header">用戶資訊</div>
    <div class="card-body" v-if="!loggedIn">
      <h2>請先登入</h2>
    </div>
    <div class="card-body" v-else>
      <p>用戶帳號：{{ username }}</p>
      <p>用戶Email：{{ email }}</p>
      <p>用戶自我介紹：{{ biography }}</p>
    </div>
  </div>
</template>

<script setup>
import axios from "axios";
import {onMounted, ref} from "vue";

const username = ref('');
const email = ref('');
const biography = ref('');
const loggedIn = ref(false);
const URL = import.meta.env.VITE_API_JAVAURL;

onMounted(() => {
  getLoginState();
});

const getLoginState = async () => {
  try {
    const response = await axios.get(`${URL}user/getLoginUser`, {withCredentials: true});
    console.log("user info: " + response.data);
    if (response.data === '') {
      loggedIn.value = false;
    } else {
      loggedIn.value = true;
      username.value = response.data.userName;
      email.value = response.data.email;
      biography.value = response.data.biography;
    }
  } catch (error) {
    console.error('AJAX error:', error);
  }
}


</script>

<style scoped>

</style>