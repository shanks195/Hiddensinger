<template>
     <div class="app-footer app-player grey bg" v-if="current.id>0">
       <KProgress
                :show-text="false"
                class="progress-bar-wrapper"
                v-bind:percent="current.percent"
                :color="['#df83f1', '#82279f', '#53cfe0']"
                margin="0 !important" padding="0 !important"
                 /> 
        <div class="playlist mejs-inner" style="width:100%">
      
            <div class="left">
                <div><img src="../assets/images/music.jpg"></div>
                <div>
                    <div class="name">{{current.name}}</div>
                    <div class="username">{{current.username}}</div>
                </div>
               
            </div>
            <div class="ct">
           
                <div class="centerr mejs-controls">
                <div class="mejs-button mejs-previous-button mejs-previous"><button type="button" aria-controls="mep_0" title="Previous Track"></button></div>
                <div class="mejs-button mejs-playpause-button mejs-play"><button type="button" aria-controls="mep_0" title="Pause" aria-label="Play" v-if="!isPlaying" @click="play"></button></div>
                <div class="mejs-button mejs-playpause-button mejs-pause"><button type="button" aria-controls="mep_0" title="Play" aria-label="Pause" v-if="isPlaying" @click="pause()"></button></div>
                <div class="mejs-button mejs-next-button mejs-next"><button type="button" aria-controls="mep_0" title="Next Track"></button></div>
               
                <div class="time">
                    <div class="time-start"></div>
                    <div class="time-end">{{currentlyTimer}}/{{this.current.duration}}</div>
                </div> 
                
            </div>
            </div>
 
            <div class="right mejs-controls">
                <input type="range" id="vol" name="vol" min="0" max="100" v-model="value" step="1" @change="change()">
            </div>
           
        </div>
      </div> 
</template>
<style scoped>
.left{
  display: grid;
  grid-template-columns: 1.5fr 5fr;
  column-gap: 30px;
}
  .mejs-innner{
    padding: 0 !important;
  }
    .playlist{
        display: grid;
        grid-template-columns: 3fr 7fr 3fr;
        padding: 0 !important;
    }
    .left img{
        width: 100%;
        height: 100%;
    }
    .centerr{
        display: grid;
        grid-template-columns: 1fr;
        align-items: center;
        justify-items: center;
    }
    .k-progress{
        width: 100%;
    }
    .right{
        display: grid;
        align-items: center;
        justify-items: center;
    }
    .time{
      width: 100%;
      display: grid;
      grid-template-columns: 1fr 1fr;
    }
    .time-end{
      display: grid;
      justify-content: end;
      color: #ffffffde;
    }
    .active{
      display: none;
    }
    .mejs-previous button, .mejs-next button{
      background: #363c43 !important;
      color: #ffffffde;
    }
    .ct{
      display: grid;
      align-items: center;
    }
    
    .app-footer .k-progress-outer{
      width: 100%;
      margin: 0 !important;
      padding: 0 !important;
    }
    .app-footer .k-progress div{
      width: 100%;
      margin: 0 !important;
      padding: 0 !important;
    }
</style>


<style>

@media only screen and (max-width: 360px){
  .playlist{
    height: 50px;
  }
  .left img{
    display: none;
  }
  .left{
    column-gap: 0 !important;
    overflow: hidden;

  }
  .ct{
    overflow: hidden;
  }
  .right{
    overflow: hidden;
  }
  .right input{
    transform: rotate(270deg);
  }
  .centerr{
    position: relative;
    height: 100%;
  }
  .ct .centerr .mejs-previous-button{
    display: block !important;
    top: 10% !important;
    left: 69% !important;
  }
  .mejs-button{
    top: 10%;
  }
  .time .time-end{
    position: absolute !important;
    top: 67% !important;
    right: 52% !important;
  }
  .img{
    display: none;
  }
  .inf{
    height: 55px !important;
    display: grid !important;
    grid-template-columns: 1fr !important;
    overflow: hidden !important;
    width: 60px !important;
    margin-left: 10px !important;
  }
  .name{
   white-space: nowrap !important;
    width: 60px !important;
    overflow: hidden !important;
    text-overflow: ellipsis !important;
  }
  .username{
    white-space: nowrap !important;
    width: 80px v;
    overflow: hidden !important;
    text-overflow: ellipsis !important;
  }
}

@media only screen and (max-width: 375px) and (min-width: 361px){
      .playlist{
    height: 50px;
  }
  .left img{
    display: none;
  }
  .left{
    column-gap: 0 !important;
    overflow: hidden;

  }
  .ct{
    overflow: hidden;
  }
  .right{
    overflow: hidden;
  }
  .right input{
    transform: rotate(270deg);
  }
  .centerr{
    position: relative;
    height: 100%;
  }
  .ct .centerr .mejs-previous-button{
    display: block !important;
    top: 10% !important;
    left: 69% !important;
  }
  .mejs-button{
    top: 10%;
  }
  .time-end{
    position: absolute !important;
    top: 67% !important;
    right: 52% !important;
  }
  .img{
    display: none;
  }
  .inf{
    height: 55px !important;
    display: grid !important;
    grid-template-columns: 1fr !important;
    overflow: hidden !important;
    width: 80px !important;
  }
  .name{
   white-space: nowrap !important;
    width: 80px !important;
    overflow: hidden !important;
    text-overflow: ellipsis !important;
  }
  .username{
    white-space: nowrap !important;
    width: 80px !important;
    overflow: hidden !important;
    text-overflow: ellipsis !important;
  }
}
@media only screen and (max-width: 414px) and (min-width: 376px){
      .playlist{
    height: 50px;
  }
  .left img{
    display: none;
  }
  .left{
    column-gap: 0 !important;
    overflow: hidden;

  }
  .ct{
    overflow: hidden;
  }
  .right{
    overflow: hidden;
  }
  .right input{
    transform: rotate(270deg);
  }
  .centerr{
    position: relative;
    height: 100%;
  }
  .ct .centerr .mejs-previous-button{
    display: block !important;
    top: 10%;
    left: 69%;
  }
  .mejs-button{
    top: 10%;
  }
  .time-end{
    position: absolute !important;
    top: 67% !important;
    right: 52% !important;
  }
  .img{
    display: none;
  }
  .inf{
    height: 55px;
    display: grid;
    grid-template-columns: 1fr;
    overflow: hidden;
    width: 80px;
  }
  .name{
   white-space: nowrap;
    width: 80px;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  .username{
    white-space: nowrap;
    width: 80px;
    overflow: hidden;
    text-overflow: ellipsis;
  }
}
@media only screen and (max-width: 768px) and (min-width: 415px){
      .playlist{
    height: 50px;
  }
  .left img{
    display: none;
  }
  .left{
    column-gap: 0 !important;
    overflow: hidden;

  }
  .ct{
    overflow: hidden;
  }
  .right{
    overflow: hidden;
  }
  .right input{
    /* transform: rotate(270deg); */
  }
  .centerr{
    position: relative;
    height: 100%;
  }
  .ct .centerr .mejs-previous-button{
    display: block !important;
    top: 10% !important;
    left: 42% !important;
  }
  .mejs-button{
    top: 10%;
  }
  .time-end{
    position: absolute !important;
    top: 34% !important;
    right: 3% !important;
  }
  .img{
    display: none;
  }
  .inf{
    height: 55px !important;
    display: grid !important;
    grid-template-columns: 1fr !important;
    overflow: hidden !important;
    width: 80px !important;
  }
  .name{
   white-space: nowrap !important;
    width: 80px !important;
    overflow: hidden !important;
    text-overflow: ellipsis !important;
  }
  .username{
    white-space: nowrap !important;
    width: 80px !important;
    overflow: hidden !important;
    text-overflow: ellipsis !important;
  }
  .inf{
    margin-left: 30px;
  }
}
</style>
<style scoped src="../assets/template_frontend/css/styles/app.css"></style>
<script>
import KProgress from "k-progress";
import { formatTimer } from "../helpers/timer";
import { deleteElement, threatSongs, shuffleArray } from "../helpers/utils";
import EventBus from '../components/bus'
import songs from '../mocks/songs'
export default {
    components:{
        KProgress
    },
    data(){
        return{
        index: 0,
        current:{},
        isPlaying: false,
        currentlyTimer: "00:00",
        // songs: shuffleArray(songs),
        player: new Audio(),
        coverObject: { cover: true, animated: false },
        volume: '',
        value:50,
        abc:'',
        }
  },
  methods:{
    setCover() {
      this.coverObject.animated = true;
      setTimeout(() => {
        this.coverObject.animated = false;
      }, 10);
    },
    setCurrentSong() {
    //   this.current = this.songs[this.index];
      this.play(this.current);
      this.setCover();
    },
    listenersWhenPlay() {
      this.player.addEventListener("timeupdate", () => {
        var playerTimer = this.player.currentTime;
        this.currentlyTimer = formatTimer(playerTimer);
        // this.current.percent = (playerTimer * 100) / this.current.seconds;
        this.current.percent = (playerTimer * 100) /this.player.duration;
        this.current.duration = formatTimer(this.player.duration) 
        this.current.isPlaying = true;
      });
      this.player.addEventListener(
        "ended",
        function() {
          this.next();
        }.bind(this)
      );
    },
    play(song) {
      if (typeof song.url !== "undefined") {
        this.current.isPlaying = false;
        // this.index = this.songs.indexOf(this.current);
        this.current = song;
        this.player.src = this.current.url;
      }
      this.player.play();
      this.isPlaying = true;
      this.setCover();
      this.listenersWhenPlay();
    },
    pause() {
      this.player.pause();
      this.isPlaying = false;
    },
    change(){
        this.player.volume = this.value/100
      },
   
  },
  mounted(){
    this.player.volume = 0.5
    this.volume = this.player.volume 
    // this.songs = threatSongs(this.songs);
    // this.current = this.songs[this.index];
    this.player.src = this.current.url;
  },
  created(){
       EventBus.$on('playmusic', this.play);
       EventBus.$on('pausemusic', this.pause);
       EventBus.$on('playmusicD', this.play);
       EventBus.$on('pausemusicD', this.pause);
       EventBus.$on('playmusicP', this.play);
       EventBus.$on('pausemusicP', this.pause);
       EventBus.$on('playmusicC', this.play);
       EventBus.$on('pausemusicC', this.pause);
  },
  
}
</script>