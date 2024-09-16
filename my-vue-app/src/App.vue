<template>
  <div id="app">
    <Login v-if="!showRegister" />
    <Register v-else />
    <button @click="toggleForm">{{ showRegister ? '切換到登入' : '切換到註冊' }}</button>
  </div>
</template>

<script>
import Login from './components/Login.vue';
import Register from './components/Register.vue';
import { ref } from 'vue';

export default {
  components: {
    Login,
    Register
  },
  setup() {
    const showRegister = ref(false);

    const toggleForm = () => {
      showRegister.value = !showRegister.value;
    };

    return { showRegister, toggleForm };
  }
};
</script>

<style>
/* 簡單的樣式 */
#app {
  text-align: center;
  margin-top: 60px;
}
</style>
