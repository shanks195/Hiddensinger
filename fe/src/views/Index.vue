<template>
    <div class="app dk" id="app">
    <div id="content" class="app-content" role="main">
      <div class="app-header navbar-md black box-shadow-z1">
        <div class="navbar" data-pjax>
            <a data-toggle="collapse" data-target="#navbar" class="navbar-item pull-right hidden-md-up m-r-0 m-l">
              <i class="material-icons">menu</i>
            </a> 
            <router-link to="/discover" class="navbar-brand md">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 48 48" width="32" height="32">
                <circle cx="24" cy="24" r="24" fill="rgba(255,255,255,0.2)" />
                <circle cx="24" cy="24" r="22" fill="#1c202b" class="brand-color" />
                <circle cx="24" cy="24" r="10" fill="#ffffff" />
                <circle cx="13" cy="13" r="2" fill="#ffffff" class="brand-animate" />
                <path d="M 14 24 L 24 24 L 14 44 Z" fill="#FFFFFF" />
                <circle cx="24" cy="24" r="3" fill="#000000" /></svg> <img src="images/logo.png" alt="." class="hide">
              <span class="hidden-folded inline">Hidden Singer</span>
            </router-link>
            <div class="collapse navbar-toggleable-sm l-h-0 text-center" id="navbar">
              <ul class="nav navbar-nav nav-md inline text-primary-hover">
                <li class="nav-item"><a href="/discover" class="nav-link"><span class="nav-text">Home</span></a></li>
                <li class="nav-item" v-show="username==null"><a href="register" class="nav-link">Signup</a></li>
                <li class="nav-item" v-show="username==null"><a href="login" class="nav-link"><span class="btn btn-sm rounded primary _600">Signin</span></a></li>
                <li class="nav-item" v-show="username!==null"><a href="profile" class="nav-link"><i class="material-icons">account_circle</i></a></li>
              </ul>
            </div>    
            
        </div>
      </div>
      <div class="app-body">
        <div class="owl-carousel black owl-theme owl-dots-bottom-center" data-ui-jp="owlCarousel" data-ui-options="{
             items: 1
            ,loop: true
            ,autoplay: true
            ,nav: true
          }">
          <div class="row-col">
            <div class="col-lg-2"></div>
            <div class="col-lg-8 text-center">
              <div class="p-a-lg">
                <h2 class="display-4 m-y-lg">A simple, fast and responsive music template</h2>
                <h6 class="text-muted m-b-lg">HTML5 Music Template</h6><a href="/discover"
                  class="btn circle btn-outline b-primary m-b-lg p-x-md">Get it now</a>
              </div>
            </div>
            <div class="col-lg-2"></div>
          </div>
          <div class="row-col">
            <div class="col-lg-2"></div>
            <div class="col-lg-8 text-center">
              <div class="p-a-lg">
                <h2 class="display-4 m-y-lg">Bootstrap 4 CSS framework</h2>
                <h6 class="text-muted m-b-lg">Responsive layout</h6><a href="/discover"
                  class="btn circle btn-outline b-primary m-b-lg p-x-md">View App</a>
              </div>
            </div>
            <div class="col-lg-2"></div>
          </div>
          <div class="row-col">
            <div class="col-lg-2"></div>
            <div class="col-lg-8 text-center">
              <div class="p-a-lg">
                <h2 class="display-4 m-y-lg">Ajax powered page switch with great experience</h2>
                <h6 class="text-muted m-b-lg">No refresh page when switching pages</h6><a href="/discover"
                  class="btn circle btn-outline b-primary m-b-lg p-x-md">Get RTL</a>
              </div>
            </div>
            <div class="col-lg-2"></div>
          </div>
        </div>
        <div class="row-col">
          <div class="col-sm-6">
            <div class="black cover cover-gd b1" >
              <div class="p-a-lg text-center">
                <h3 class="display-3 m-y-lg">Music</h3>
                <p class="text-muted text-md m-b-lg">Get ready for high sound quality.</p><a href="/discover"
                  class="btn circle white m-b-lg p-x-md">Try Free</a>
              </div>
            </div>
          </div>
          <div class="col-sm-6 black lt">
            <div class="black cover cover-gd b7" >
              <div class="p-a-lg text-center">
                <h3 class="display-3 m-y-lg">Artists</h3>
                <p class="text-muted text-md m-b-lg">Listen to your favorite Artists.</p><a href="/artist"
                  class="btn circle white m-b-lg p-x-md">View Artists</a>
              </div>
            </div>
          </div>
        </div>
        <div class="row-col dark-white">
          <div class="col-md-3"></div>
          <div class="col-md-6">
            <div class="p-a-lg text-center">
              <h3 class="display-4 m-y-lg">Light, Grey, Dark, Black themes</h3>
              <p class="text-muted text-md m-b-lg">Config any blocks with any colors</p><a href="home.html"
                class="btn circle btn-outline b-black m-b-lg p-x-md">Try Settings</a>
            </div>
          </div>
          <div class="col-md-3"></div>
        </div>
        <div class="black cover" data-stellar-background-ratio="0.5" style="background-image: url('images/b10.jpg')">
          <div class="row-col">
            <div class="col-md-4">
              <div class="p-a-lg text-center">
                <h4 class="m-y-lg">One Css framework, Unlimited options &amp; variables</h4>
                <p class="text-muted text-md m-b-lg">Colors, layouts, components and widgets. we pre-build them for you.
                </p>
              </div>
            </div>
            <div class="col-md-4">
              <div class="p-a-lg text-center">
                <h4 class="m-y-lg">Two layouts, Horizontal and side navigation</h4>
                <p class="text-muted text-md m-b-lg">With the flexiable layout options, you can build responsive
                  layouts.</p>
              </div>
            </div>
            <div class="col-md-4">
              <div class="p-a-lg text-center">
                <h4 class="m-y-lg">Three templates, Landing, App, Site templates</h4>
                <p class="text-muted text-md m-b-lg">Choose the suitable one for your needs.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="white dk pos-rlt">
        <div class="p-a-md">
          <div class="footer p-y-md text-primary-hover">
            <div class="row">
              <div class="col-md-3">
                <div class="clearfix m-b-lg"><a href="/discover" class="navbar-brand md"><svg
                      xmlns="http://www.w3.org/2000/svg" viewBox="0 0 48 48" width="32" height="32">
                      <circle cx="24" cy="24" r="24" fill="rgba(255,255,255,0.2)" />
                      <circle cx="24" cy="24" r="22" fill="#1c202b" class="brand-color" />
                      <circle cx="24" cy="24" r="10" fill="#ffffff" />
                      <circle cx="13" cy="13" r="2" fill="#ffffff" class="brand-animate" />
                      <path d="M 14 24 L 24 24 L 14 44 Z" fill="#FFFFFF" />
                      <circle cx="24" cy="24" r="3" fill="#000000" /></svg> <img src="images/logo.png" alt="."
                      class="hide"> <span class="hidden-folded inline">Hidden Singer</span></a></div>
              </div>
              <div class="col-sm-2 col-xs-6">
                <h6 class="text-u-c m-b text-muted">About</h6>
                <div class="m-b-md">
                  <ul class="nav l-h-2x _600">
                    <li class="nav-item"><a class="nav-link" href="#">About us</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Mobile apps</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Blog</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Jobs</a></li>
                  </ul>
                </div>
              </div>
              <div class="col-sm-2 col-xs-6">
                <h6 class="text-u-c m-b text-muted">Links</h6>
                <div class="m-b-md">
                  <ul class="nav l-h-2x _600">
                    <li class="nav-item"><a class="nav-link" href="#">Help</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Support</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Legal</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Copyright</a></li>
                  </ul>
                </div>
              </div>
              <div class="col-sm-2 col-xs-6">
                <h6 class="text-u-c m-b text-muted">Connect</h6>
                <div class="m-b-md">
                  <ul class="nav l-h-2x _600">
                    <li class="nav-item"><a class="nav-link" href="#">Facebook</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Twitter</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Google+</a></li>
                  </ul>
                </div>
              </div>
              <div class="col-md-3 col-xs-6">
                <h6 class="text-u-c m-b text-muted">Subscribe</h6>
                <p>Do not want to miss our newsletter?</p>
                <form class="m-b-lg"><input type="text" class="form-control" placeholder="Your email"> <button
                    type="submit" class="btn btn-sm btn-outline b-dark rounded m-t">Subscribe</button></form>
              </div>
            </div>
            <div class="b b-b m-b m-t-lg"></div>
            <div class="row">
              <div class="col-sm-8"><a href="#" class="text-muted text-sm">Cookies</a></div>
              <div class="col-sm-4">
                <div class="text-sm-right text-xs-left"><small class="text-muted">&copy; Copyright. All rights
                    reserved.</small></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data(){
    return{
      username: localStorage.username || null
    }
  },
  computed:{
    checkUsername(){
        if(username=null){
        isCheck = false
      }else{
        isCheck = true
      }
    }
      
  }
  
}
</script>


<style scoped src="../assets/template_frontend/css/animate.css/animate.min.css"></style>
<style scoped src="../assets/template_frontend/css/glyphicons/glyphicons.css"></style>
<style scoped src="../assets/template_frontend/css/font-awesome/css/font-awesome.min.css"></style>
<style scoped src="../assets/template_frontend/css/material-design-icons/material-design-icons.css"></style>
<style scoped src="../assets/template_frontend/css/bootstrap/dist/css/bootstrap.min.css"></style>
<style scoped src="../assets/template_frontend/css/styles/app.css"></style>

<style lang="scss" scoped>

.b7{
    background-image: url('../assets/template_frontend/images/b7.jpg') !important;
}
.b1{
    background-image: url('../assets/template_frontend/images/b1.jpg') !important;
}
.navbar{
  // display: grid;
  // grid-template-columns: 1fr 1fr 1fr;
  div{
    // .pull-right{
    //   display: grid;
    //   grid-template-columns: 1fr 1fr;
    // }
  }
}

.l-h-2x{
  display: grid;
}
</style>


