<template>
  <div>
    <h2>Login Page</h2>
    <el-button type="primary" @click="login()">登录</el-button>
  </div>
</template>

<script>
  import mock from '../mock/index.js'
  import Cookies from 'js-cookie'
  import router from '../router'

  export default {
    name: 'Login',
    methods: {
      login () {
        this.$api.login.login().then(function (res) {
          alert(res.data.token)
          //放置token到Cookie
          Cookies.set('token', res.data.token)
          //登录成功，跳转到主页
          router.push('/')
        }).catch(function (res) {
          alert(res)
        })
      }
    }
  }
</script>

<style lang="scss">

</style>
