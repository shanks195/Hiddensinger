<template>
    <div id="content" class="app-content white bg box-shadow-z2" role="main">
      <div class="app-body" id="view">
        <div class="page-content">
          <div class="row-col">
            <div class="col-lg-9 b-r no-border-md">
              <div class="padding">
                <div class="page-title m-b">
                  <h1 class="inline m-a-0">New</h1>
                  <div class="dropdown inline"><button
                      class="btn btn-sm no-bg h4 m-y-0 v-b dropdown-toggle text-primary"
                      data-toggle="dropdown">All</button>
                    <div class="dropdown-menu"><a href="#" class="dropdown-item active">All</a> <a href="#"
                        class="dropdown-item">acoustic</a> <a href="#" class="dropdown-item">ambient</a> <a href="#"
                        class="dropdown-item">blues</a> <a href="#" class="dropdown-item">classical</a> <a href="#"
                        class="dropdown-item">country</a> <a href="#" class="dropdown-item">electronic</a> <a href="#"
                        class="dropdown-item">emo</a> <a href="#" class="dropdown-item">folk</a> <a href="#"
                        class="dropdown-item">hardcore</a> <a href="#" class="dropdown-item">hip hop</a> <a href="#"
                        class="dropdown-item">indie</a> <a href="#" class="dropdown-item">jazz</a> <a href="#"
                        class="dropdown-item">latin</a> <a href="#" class="dropdown-item">metal</a> <a href="#"
                        class="dropdown-item">pop</a> <a href="#" class="dropdown-item">pop punk</a> <a href="#"
                        class="dropdown-item">punk</a> <a href="#" class="dropdown-item">reggae</a> <a href="#"
                        class="dropdown-item">rnb</a> <a href="#" class="dropdown-item">rock</a> <a href="#"
                        class="dropdown-item">soul</a> <a href="#" class="dropdown-item">world</a></div>
                  </div>
                </div>
                <div data-ui-jp="jscroll" class="jscroll-loading-center" data-ui-options="{
            autoTrigger: true,
            loadingHtml: '<i class=\'fa fa-refresh fa-spin text-md text-muted\'></i>',
            padding: 50,
            nextSelector: 'a.jscroll-next:last'
          }">
                  <div class="row">
                    <template v-for="song in songs">
                      <div class="col-xs-4 col-sm-4 col-md-3" :key="song.id">
                        <div class="item r" data-id="item-5" data-src="http://streaming.radionomy.com/JamendoLounge">
                          <div class="item-media"><a :href="'/detail?id='+song.id" class="item-media-content b4"
                              ><img  src="../assets/images/music.jpg"></a>
                            <div class="item-overlay center"><button class="btn-playpause" @click="play(song), isPlaying=true" v-if="isPlaying==false">Play</button></div>
                            <div class="item-overlay center"><button class="btn-playpause is-playing" v-if="isPlaying==true" @click="pause(), isPlaying=false">Pause</button></div>
                          </div>
                          <div class="item-info">
                            <div class="item-overlay bottom text-right"><a href="#" class="btn-favorite"><i
                                  class="fa fa-heart-o"></i></a> <a href="#" class="btn-more" data-toggle="dropdown"><i
                                  class="fa fa-ellipsis-h"></i></a>
                              <div class="dropdown-menu pull-right black lt"></div>
                            </div>
                            <div class="item-title text-ellipsis"><a href="#" >{{song.name}}</a></div>
                          </div>
                        </div>
                    </div>
                    </template>
                  </div>
                  <div class="text-center"><a href="scroll.item.html" class="btn btn-sm white rounded jscroll-next">Show
                      More</a></div>
                </div>
              </div>
            </div>
           <div class="col-lg-3 w-xxl w-auto-md">
              <div class="padding" style="bottom: 60px" data-ui-jp="stick_in_parent">
                <h6 class="text text-muted">5 Likes</h6>
                <div class="row item-list item-list-sm m-b">
                  <div class="col-xs-12">
                    <div class="item r" data-id="item-9"
                      data-src="http://api.soundcloud.com/tracks/264094434/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                      <div class="item-media"><a href="track.detail.html" class="item-media-content b8"
                          ></a></div>
                      <div class="item-info">
                        <div class="item-title text-ellipsis"><a href="track.detail.html">All I Need</a></div>
                        <div class="item-author text-sm text-ellipsis"><a href="artist.detail.html"
                            class="text-muted">Pablo Nouvelle</a></div>
                      </div>
                    </div>
                  </div>
                  <div class="col-xs-12">
                    <div class="item r" data-id="item-8"
                      data-src="http://api.soundcloud.com/tracks/236288744/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                      <div class="item-media"><a href="track.detail.html" class="item-media-content b7"
                          ></a></div>
                      <div class="item-info">
                        <div class="item-title text-ellipsis"><a href="track.detail.html">Simple Place To Be</a></div>
                        <div class="item-author text-sm text-ellipsis"><a href="artist.detail.html"
                            class="text-muted">RYD</a></div>
                      </div>
                    </div>
                  </div>
                  <div class="col-xs-12">
                    <div class="item r" data-id="item-7"
                      data-src="http://api.soundcloud.com/tracks/245566366/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                      <div class="item-media"><a href="track.detail.html" class="item-media-content b6"
                          ></a></div>
                      <div class="item-info">
                        <div class="item-title text-ellipsis"><a href="track.detail.html">Reflection (Deluxe)</a></div>
                        <div class="item-author text-sm text-ellipsis"><a href="artist.detail.html"
                            class="text-muted">Fifth Harmony</a></div>
                      </div>
                    </div>
                  </div>
                  <div class="col-xs-12">
                    <div class="item r" data-id="item-10"
                      data-src="http://api.soundcloud.com/tracks/237514750/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                      <div class="item-media"><a href="track.detail.html" class="item-media-content b9"
                          ></a></div>
                      <div class="item-info">
                        <div class="item-title text-ellipsis"><a href="track.detail.html">The Open Road</a></div>
                        <div class="item-author text-sm text-ellipsis"><a href="artist.detail.html"
                            class="text-muted">Postiljonen</a></div>
                      </div>
                    </div>
                  </div>
                  <div class="col-xs-12">
                    <div class="item r" data-id="item-5" data-src="http://streaming.radionomy.com/JamendoLounge">
                      <div class="item-media"><a href="track.detail.html" class="item-media-content b4" 
                          ></a></div>
                      <div class="item-info">
                        <div class="item-title text-ellipsis"><a href="track.detail.html">Live Radio</a></div>
                        <div class="item-author text-sm text-ellipsis"><a href="artist.detail.html"
                            class="text-muted">Radionomy</a></div>
                      </div>
                    </div>
                  </div>
                </div>
                <h6 class="text text-muted">Go mobile</h6>
                <div class="btn-groups"><a href="#" class="btn btn-sm dark lt m-r-xs" style="width: 135px"><span
                      class="pull-left m-r-sm"><i class="fa fa-apple fa-2x"></i></span> <span
                      class="clear text-left l-h-1x"><span class="text-muted text-xxs">Download on the</span> <b
                        class="block m-b-xs">App Store</b></span></a> <a href="#" class="btn btn-sm dark lt"
                    style="width: 133px"><span class="pull-left m-r-sm"><i class="fa fa-play fa-2x"></i></span> <span
                      class="clear text-left l-h-1x"><span class="text-muted text-xxs">Get it on</span> <b
                        class="block m-b-xs m-r-xs">Google Play</b></span></a></div>
                <div class="b-b m-y"></div>
                <div class="nav text-sm _600"><a href="#" class="nav-link text-muted m-r-xs">About</a> <a href="#"
                    class="nav-link text-muted m-r-xs">Contact</a> <a href="#"
                    class="nav-link text-muted m-r-xs">Legal</a> <a href="#"
                    class="nav-link text-muted m-r-xs">Policy</a></div>
                <p class="text-muted text-xs p-b-lg">&copy; Copyright 2016</p>
              </div>
            </div> 
          </div>
        </div>
      </div>
      <div class="bottom"></div>
    </div>
</template>
<style scoped src="../assets/template_frontend/css/animate.css/animate.min.css"></style>
<style scoped src="../assets/template_frontend/css/glyphicons/glyphicons.css"></style>
<style scoped src="../assets/template_frontend/css/font-awesome/css/font-awesome.min.css"></style>
<style rel="stylesheet" scoped src="../assets/template_frontend/css/material-design-icons/material-design-icons.css"></style>
<style scoped src="../assets/template_frontend/css/bootstrap/dist/css/bootstrap.min.css"></style>
<style scoped src="../assets/template_frontend/css/styles/app.css"></style>
<style scoped>
.bottom{
  height: 100px;
}
.b0{
    background-image: url('../assets/template_frontend/images/b0.jpg') !important;
}
.b1{
    background-image: url('../assets/template_frontend/images/b1.jpg') !important;
}
.b2{
    background-image: url('../assets/template_frontend/images/b2.jpg') !important;
}
.b3{
    background-image: url('../assets/template_frontend/images/b3.jpg') !important;
}
/* .b4{
    background-image: url('../assets/template_frontend/images/b4.jpg') !important;
} */
.b5{
    background-image: url('../assets/template_frontend/images/b5.jpg') !important;
}
.b6{
    background-image: url('../assets/template_frontend/images/b6.jpg') !important;
}
.b7{
    background-image: url('../assets/template_frontend/images/b7.jpg') !important;
}
.b8{
    background-image: url('../assets/template_frontend/images/b8.jpg') !important;
}
.b9{
    background-image: url('../assets/template_frontend/images/b9.jpg') !important;
}
.b10{
    background-image: url('../assets/template_frontend/images/b10.jpg') !important;
}
.b11{
    background-image: url('../assets/template_frontend/images/b11.jpg') !important;
}
.item-media img{
  max-width: 100%;
  height: 44vh;
  object-fit: cover;
}
</style>
<script>
// import songs from '../mocks/songs'
import { formatTimer } from "../helpers/timer";
import { deleteElement, threatSongs, shuffleArray, sortNew } from "../helpers/utils";
import EventBus from '../components/bus'
import axios from 'axios'
import {requestHeader} from '../index/index.js'
export default {
  data(){
    return{
      songs: '',
      isPlaying: false,
      data:'',
      path:''
    }
  },
  methods:{
    play(song){
      EventBus.$emit('playmusic', song)
    },
    pause(){
      EventBus.$emit('pausemusic')
    }
  },
  created(){
    axios.get(`http://localhost:8081/api/song/list`)
      .then(rs=>{
        this.songs = rs.data.listResult.sort(sortNew)
      })
     this.path= window.location.pathname

  }
}
</script>