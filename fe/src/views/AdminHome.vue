<template>
  <div id="container-admin-menu">
    <aside id="left-panel" class="left-panel">
      <nav class="navbar navbar-expand-sm navbar-default">
        <div class="navbar-header">
          <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#main-menu"
            aria-controls="main-menu"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <i class="fa fa-bars"></i>
          </button>
          <a class="navbar-brand" href="../"
            ><h1>{{ roleName }}</h1></a>
          <a class="navbar-brand hidden" href="./"
            ><h1>{{ roleName.slice(0,1) }}</h1></a>
        </div>

        <div id="main-menu" class="main-menu collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active">
              <a href="./home">
                <i class="menu-icon fa fa-home"></i>Home
              </a>
            </li>
            <h3 class="menu-title">Management</h3>
            <!-- /.menu-title -->
            <li class="menu-item-has-children dropdown">
              <a
                href="#"
                class="dropdown-toggle"
                data-toggle="dropdown"
                aria-haspopup="true"
                aria-expanded="false"
              >
                <i class="menu-icon fa fa-user-secret"></i>Account</a
              >
              <ul class="sub-menu children dropdown-menu">
                <li>
                  <i class="fa fa-users"></i
                  ><a href="./list-account">List</a>
                </li>
                <li>
                  <i class="fa fa-user-plus"></i
                  ><a href="tables-data.html">Insert</a>
                </li>
              </ul>
            </li>
            <li class="menu-item-has-children dropdown">
              <a
                href="#"
                class="dropdown-toggle"
                data-toggle="dropdown"
                aria-haspopup="true"
                aria-expanded="false"
              >
                <i class="menu-icon fa fa-file-audio-o"></i>Song</a
              >
              <ul class="sub-menu children dropdown-menu">
                <li>
                  <i class="fa fa-table"></i
                  ><a href="tables-basic.html">Basic Table</a>
                </li>
                <li>
                  <i class="fa fa-table"></i
                  ><a href="tables-data.html">Data Table</a>
                </li>
              </ul>
            </li>
            <li class="menu-item-has-children dropdown">
              <a
                href="#"
                class="dropdown-toggle"
                data-toggle="dropdown"
                aria-haspopup="true"
                aria-expanded="false"
              >
                <i class="menu-icon fa fa-file-video-o"></i>Video</a
              >
              <ul class="sub-menu children dropdown-menu">
                <li>
                  <i class="fa fa-table"></i
                  ><a href="tables-basic.html">Basic Table</a>
                </li>
                <li>
                  <i class="fa fa-table"></i
                  ><a href="tables-data.html">Data Table</a>
                </li>
              </ul>
            </li>
          </ul>
        </div>
        <!-- /.navbar-collapse -->
      </nav>
    </aside>
    <div id="right-panel" class="right-panel">
      <!-- Header-->
      <header id="header" class="header">
        <div class="header-menu">
          <div class="col-sm-7">
            <a id="menuToggle" class="menutoggle pull-left"
              ><i class="fa fa fa-tasks"></i
            ></a>
            <div class="header-left">
              
            </div>
          </div>

          <div class="col-sm-5">
            <div class="user-area dropdown float-right">
              <a
                href="#"
                class="dropdown-toggle"
                data-toggle="dropdown"
                aria-haspopup="true"
                aria-expanded="false"
              >
                <img
                  class="user-avatar rounded-circle"
                  src="../assets/template_admin/images/admin.jpg"
                  alt="User Avatar"
                />
              </a>

              <div class="user-menu dropdown-menu">
                <a class="nav-link" href="#"
                  ><i class="fa fa-user"></i> My Profile</a
                >

                <a class="nav-link" href="../login"
                  ><i class="fa fa-power-off"></i> Logout</a
                >
              </div>
            </div>
          </div>
        </div>
      </header>
        <div class="col-sm-12">
            
        </div>
    </div>
  </div>
</template>
<script>
// @ is an alias to /src
import removeUserLocalStorage from '../assets/template_admin/js/RemoveUserLocalStorage';
import reloadScript from '../assets/template_admin/js/ReloadScript'
import {menuToggleClick,
        searchCloseClick,
        navbarButtonClick,
        showSubmenuChildren,
        showUserArea} from '../assets/template_admin/js/Main'
export default {
  name: "MenuAdmin",
  data(){
    return {
      roleName:'ThePlayer'
    }
  },
  beforeCreate:function (){
    var roles = localStorage.getItem('roles');
    if(roles){
      
    }else{
      window.location='../login';
    }
  },
  mounted() {
    document.body.style.margin=0;
    showUserArea();
    showSubmenuChildren();
    navbarButtonClick();
    searchCloseClick();
    menuToggleClick();
    setTimeout(function(){
        removeUserLocalStorage();
    },600000)
  },
  
  methods: {},
}
</script>
<style scoped src= "../assets/template_admin/vendors/bootstrap/dist/css/bootstrap.min.css"></style>
<style scoped src= "../assets/template_admin/vendors/font-awesome/css/font-awesome.min.css"></style>
<style scoped src= "../assets/template_admin/vendors/themify-icons/css/themify-icons.css"></style>
<style scoped src= "../assets/template_admin/vendors/flag-icon-css/css/flag-icon.min.css"></style>
<style scoped src= "../assets/template_admin/vendors/selectFX/css/cs-skin-elastic.css"></style>
<style scoped src= "../assets/template_admin/vendors/jqvmap/dist/jqvmap.min.css"></style>
<style scoped src= "../assets/template_admin/assets/css/style.css"></style>
<style lang="css" scoped>
#container-admin-menu {
  display: flex;
}
#left-panel{
    width: 300px;
}
#right-panel{
    flex: 1;
}
.header-left{
    text-align: initial;
}

.navbar .navbar-nav[data-v-f89f3da0] {
  text-align: initial;
}
<<<<<<< HEAD:fe/src/views/AdminHome.vue
=======
.col-sm-12{
  height: 100%;
  padding: 1rem;
  overflow-y: auto;
}
@media screen and (max-width: 62em) and (min-width:45em){
    
}

@media screen and (max-width: 45em) and (min-width:36em){
    
}

@media screen and (max-width:36em){
  #container-admin-menu {
  flex-direction: column;
  width: 100%;
}
.navbar-nav[data-v-54c38a05]{
  width: 100%;
}
    #left-panel{
    width: 100%;
}
}
>>>>>>> 20465969a690261768bed905d109cade28c5deb9:fe/src/views/Admin.vue
</style>