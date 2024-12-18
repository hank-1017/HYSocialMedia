<template>
  <h1>登入</h1>
  <br>
  <div class="card">
    <div class="card-header">請輸入帳號密碼</div>
    <div class="card-body">
      <form @submit.prevent="submitForm" style="box-sizing: border-box;">
        <div class="input-group" style="width: 100%;">
          <label style="padding: 5px 0;">帳號：</label>
          <input class="form-control" name="username" id="username" v-model="username"
                 style="flex: 0 1 70%; margin-left: 10px;"
                 required/>
        </div>

        <br>
        <div class="input-group" style="width: 100%;">
          <label style="padding: 5px 0;">密碼：</label>
          <input class="form-control" name="password" id="password" v-model="password" type="password"
                 style="flex: 0 1 70%;  margin-left: 10px" required/>
        </div>
        <br>
        <button type="submit" class="btn btn-outline-primary">送出</button>
      </form>
    </div>
  </div>

</template>

<script setup>
import axios from "axios";
import {ref} from "vue";

const username = ref('');
const password = ref('');
const URL = import.meta.env.VITE_API_JAVAURL;

const submitForm = async () => {
  try {
    const formData = new FormData();
    formData.append('username', username.value);
    formData.append('password', password.value);
    const response = await axios.post(`${URL}user/login`, formData, {withCredentials: true});
    console.log("Login result: " + response.data);

    if (response.data === "Y") {
      alert("用戶:" + username.value + " 登入成功!!")
      window.location.href = `/`;
    }
    if (response.data === "N") {
      alert("帳號或密碼錯誤")
    }
  } catch (error) {
    console.error('AJAX error:', error);
  }
};

</script>


<style scoped>

</style>