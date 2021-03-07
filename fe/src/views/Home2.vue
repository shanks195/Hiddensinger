<template>
  <div class="main-home">
      <MainSlide></MainSlide>  
      <MVSlide2></MVSlide2>  
      <RankHome @clicked-something="handleClickInParent" :isPlaying1="isPlaying" :list="list"></RankHome> 
      <NewSongHome @clicked-something="handleClickInParent" :isPlaying2="isPlaying" :list="list"></NewSongHome>
      <ToolBar @pause="pause" @play="play" :coverObject="coverObject" :current="current" :songs="songs"  
        :player="player" :isPlaying="isPlaying" :currentlyTimer="currentlyTimer"></ToolBar> 

      <Suggestion :current="current" :songCurrent="songs" @clicked-something="handleClickInParent" :isPlaying3="isPlaying" :list="list"></Suggestion>
      <img src="https://zjs.zadn.vn/zmp3-desktop/releases/v0.6.48/static/media/bg-zma.0cc0a7e9.svg" id="bg">

      <Footer></Footer>
  </div>
</template>
 


<script>

// @ is an alias to /src
// import { Splide, SplideSlide } from '@splidejs/vue-splide';
// import '@splidejs/splide/dist/css/themes/splide-default.min.css';
import MainSlide from '../components/MainSlide.vue'
import EventBus from '../components/bus.js'
import MVSlide2 from '../components/MVSlide2'
import RankHome from '../components/RankHome'
import NewSongHome from '../components/NewSongHome'
import Suggestion from '../components/Suggestion'
import ToolBar from '../components/ToolBar'
import Footer from '../components/Footer'
export default {
  name: 'Home2',
  components: {
    MainSlide,
    MVSlide2,
    RankHome,
    NewSongHome,
    ToolBar,
    Suggestion,
    Footer
  },
  data(){
        return{
            coverObject:'',
            current:'',
            songs:'',
            player:'',
            isPlaying:false,
            currentlyTimer:'',
            list:'',
            abc:''
        }
    },
    methods:{
        handleNext(data){
            this.current=data.current;
            this.currentlyTimer=data.currentlyTimer;
        },
        handleClickInParent(coverObject,current, songs, player, isPlaying,currentlyTimer, list){
            this.coverObject = coverObject
            this.current = current
            this.songs = songs
            this.player = player
            this.isPlaying = isPlaying
            this.currentlyTimer = currentlyTimer
            this.list =list
        },
        pause(isPlaying){
            this.isPlaying = isPlaying
        },
        play(isPlaying){
            this.isPlaying = isPlaying
        }
    }
}
</script>
<style scoped>
*{
  color: white
}
#bg{
  z-index: -1;
  position: fixed; 
  top: 0; 
  left: 0; 
  min-width: 100%;
  min-height: 100%;

}
.center{
  overflow-y: auto;
  height: 100vh;
}
</style>