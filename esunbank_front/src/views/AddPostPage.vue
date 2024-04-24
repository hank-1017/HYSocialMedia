<template>
  <h1>新增文章</h1>
  <br>
  <div class="card">
    <div class="card-header">請輸入文章內容</div>
    <div class="card-body">
      <form @submit.prevent="submitForm" style="box-sizing: border-box;">
        <div class="input-group" style="width: 100%;">
          <textarea class="form-control" name="content" id="content" v-model="content"
                    style="flex: 0 1 70%; margin-left: 10px;"
                    required/>
        </div>
        <br>
        <button type="submit" class="btn btn-outline-primary">送出</button>
      </form>
    </div>
  </div>

</template>

<script setup>
import {useRouter} from 'vue-router';
import axios from "axios";
import {ref} from "vue";

const router = useRouter();
const content = ref('');
const URL = import.meta.env.VITE_API_JAVAURL;

const submitForm = async () => {
  try {
    const formData = new FormData();
    formData.append('content', content.value);

    const response = await axios.post(`${URL}post/new`, formData, {withCredentials: true});

    if (response.data === "Y") {
      alert("文章已發布!!")
      await router.push('/post/show');
    }
    if (response.data === "N") {
      alert("請先登入")
      await router.push('/login');
    }
  } catch (error) {
    console.error('AJAX error:', error);
  }
};

</script>


<style scoped>

</style>