<template>
  <div class="app-header hidden-lg-up white lt box-shadow-z1">
    <div class="navbar">
      <a href="/discover" class="navbar-brand md">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 48 48" width="32" height="32">
          <circle cx="24" cy="24" r="24" fill="rgba(255,255,255,0.2)" />
          <circle cx="24" cy="24" r="22" fill="#1c202b" class="brand-color" />
          <circle cx="24" cy="24" r="10" fill="#ffffff" />
          <circle cx="13" cy="13" r="2" fill="#ffffff" class="brand-animate" />
          <path d="M 14 24 L 24 24 L 14 44 Z" fill="#FFFFFF" />
          <circle cx="24" cy="24" r="3" fill="#000000" />
        </svg>
        <img src="images/logo.png" alt="." class="hide" />
        <span class="hidden-folded inline">Hidden Singer</span>
      </a>
      <ul class="nav navbar-nav pull-right">
        <li class="nav-item">
          <a data-toggle="modal" data-target="#aside" class="nav-link" @click="res()">
            <i class="material-icons">menu</i>
          </a>
        </li>
      </ul>
    </div>
  </div>
</template>
<script>
import EventBus from '../components/bus'
export default {
    data(){
        return{
        }
    },
    methods:{
        res(){
            EventBus.$emit('responsive')
        }
    }
}
</script>
<style scoped src="../assets/template_frontend/css/animate.css/animate.min.css"></style>
<style scoped src="../assets/template_frontend/css/glyphicons/glyphicons.css"></style>
<style scoped src="../assets/template_frontend/css/font-awesome/css/font-awesome.min.css"></style>
<style rel="stylesheet" scoped src="../assets/template_frontend/css/material-design-icons/material-design-icons.css"></style>
<style scoped src="../assets/template_frontend/css/bootstrap/dist/css/bootstrap.min.css"></style>
<style scoped src="../assets/template_frontend/css/styles/app.css"></style>