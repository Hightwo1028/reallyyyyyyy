<template>
  <div>
    <h2>登入</h2>
    <form @submit.prevent="login">
      <div>
        <label for="account">帳號:</label>
        <input v-model="account" type="text" id="account" required />
      </div>
      <div>
        <label for="password">密碼:</label>
        <input v-model="password" type="password" id="password" required />
      </div>
      <button type="submit">登入</button>
      <p v-if="errorMessage" style="color: red;">{{ errorMessage }}</p>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Login',
  data() {
    return {
      account: '',
      password: '',
      errorMessage: ''
    };
  },
  methods: {
    async login() {
      try {
        const response = await axios.post('http://localhost:8080/user/login', {
          account: this.account,
          password: this.password
        });

        console.log(response.data);
        alert('登入成功');
        // 進行登入後的處理，例如重定向到主頁等
      } catch (error) {
        console.error(error);
        this.errorMessage = '登入失敗，請檢查您的帳號和密碼';
      }
    }
  }
};
</script>

<style scoped>
/* 輸入框和按鈕的簡單樣式 */
form {
  display: flex;
  flex-direction: column;
  width: 300px;
  margin: auto;
}

div {
  margin-bottom: 15px;
}

label {
  margin-bottom: 5px;
  display: block;
}

input {
  width: 100%;
  padding: 8px;
  box-sizing: border-box;
}

button {
  padding: 10px;
  background-color: #007bff;
  color: white;
  border: none;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>
