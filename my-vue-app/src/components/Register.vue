<template>
  <div>
    <h2>註冊</h2>
    <form @submit.prevent="register">
      <div>
        <label for="account">帳號:</label>
        <input v-model="account" type="text" id="account" required />
      </div>
      <div>
        <label for="password">密碼:</label>
        <input v-model="password" type="password" id="password" required />
      </div>
      <div>
        <label for="email">信箱:</label>
        <input v-model="email" type="email" id="email" required />
      </div>
      <div>
        <label for="name">暱稱:</label>
        <input v-model="name" type="text" id="name" required />
      </div>
      <div>
        <label for="gender">性別:</label>
        <select v-model="gender" id="gender" required>
          <option value="0">女生</option>
          <option value="1">男生</option>
        </select>
      </div>
      <div>
        <label for="phone">電話:</label>
        <input v-model="phone" type="text" id="phone" required />
      </div>
      <div>
        <label for="birthday">生日:</label>
        <input v-model="birthday" type="date" id="birthday" required />
      </div>
      <button type="submit">註冊</button>
      <p v-if="errorMessage" style="color: red;">{{ errorMessage }}</p>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Register',
  data() {
    return {
      account: '',
      password: '',
      email: '',
      name: '',
      gender: '0', // 默認設置為女生
      phone: '',
      birthday: '',
      errorMessage: ''
    };
  },
  methods: {
    async register() {
      try {
        // 格式化日期為 yyyy-MM-dd'T'HH:mm:ss
        const formattedBirthday = new Date(this.birthday).toISOString();

        const response = await axios.post('http://localhost:8080/user/register', {
          account: this.account,
          password: this.password,
          email: this.email,
          name: this.name,
          gender: this.gender,
          phone: this.phone,
          birthday: formattedBirthday
        });

        console.log(response.data);
        alert('註冊成功');
        // 重置表單或進行其他操作
      } catch (error) {
        console.error(error);
        this.errorMessage = '註冊失敗，請檢查您的輸入或稍後再試';
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

input, select {
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
