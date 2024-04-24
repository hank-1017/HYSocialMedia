<template>

  <nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
      <router-link to="/">
        <a class="navbar-brand">Simple-Project</a>
      </router-link>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
              aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">

          <li class="nav-item">
            <router-link to="/">
              <a class="nav-link active" aria-current="page">用戶資訊</a>
            </router-link>
          </li>

          <li class="nav-item">
            <router-link to="/post/add">
              <a class="nav-link">新增文章</a>
            </router-link>
          </li>

          <li class="nav-item">
            <router-link to="/post/show">
              <a class="nav-link">全部文章</a>
            </router-link>
          </li>

          <li class="nav-item">
            <router-link to="/register">
              <a class="nav-link">註冊</a>
            </router-link>
          </li>

          <li class="nav-item">
            <router-link to="/login">
              <a class="nav-link">登入</a>
            </router-link>
          </li>

          <a class="nav-link" @click="logout" href="">登出</a>

        </ul>
      </div>
    </div>
  </nav>

  <div class="container">
  <router-view/>
  </div>
</template>

<script setup>
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from "axios";
import {useRouter} from 'vue-router';
const URL = import.meta.env.VITE_API_JAVAURL;
const router = useRouter();
const logout = async () => {
  const response = await axios.get(`${URL}user/logout`, {withCredentials: true});
  if (response.data === "Y") {
    alert("已登出")
  }
}

</script>


