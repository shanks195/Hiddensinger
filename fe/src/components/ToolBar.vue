<template>
    
    <div class="playing">
      <div class="playing-info">
        <div class="cover-wrapper">
          <img :class="{spin:isPlaying}" :src="current.cover" />
        </div>
        <div class="song-details">
            <h2 class="song-title">{{ current.title }}</h2>
            <p class="artist">{{ current.artist }}</p>
        </div>
       </div> 
     <div class="playing-center">
      <div class="controls">
            <button class="next"  @click="prev" v-if="songs.length > 1">
              <font-awesome-icon :icon="['fas','step-backward']" />
            </button>
            <!-- <div></div> -->
            <button class="play" v-if="!isPlaying"  @click="play(song), play">
              <font-awesome-icon :icon="['fas', 'play']" />
            </button>
            <button class="play" v-else @click="pause">
              <font-awesome-icon :icon="['fas', 'pause']" />
            </button>
            <!-- <div></div> -->
            <button class="next"  @click="next" v-if="songs.length > 1">
              <font-awesome-icon :icon="['fas','step-forward']" />
            </button>
        </div>
        <KProgress
                :show-text="false"
                class="progress-bar-wrapper"
                v-bind:percent="current.percent"
                :color="['#df83f1', '#82279f', '#53cfe0']"
            />
             <div class="timer">
                <p class="start">{{ currentlyTimer }}</p>
                <p class="end">{{ current.totalTimer}}</p>
            </div> 
    </div> 
    <div class="add">
      <svg @click="aaa" xmlns="http://www.w3.org/2000/svg" height="24"  fill="white" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M15 6H3v2h12V6zm0 4H3v2h12v-2zM3 16h8v-2H3v2zM17 6v8.18c-.31-.11-.65-.18-1-.18-1.66 0-3 1.34-3 3s1.34 3 3 3 3-1.34 3-3V8h3V6h-5z"/></svg>
    </div>
    </div>  
</template>
<script>
import KProgress from "k-progress";
import { formatTimer } from "../helpers/timer";
import EventBus from './bus'
import { current, index } from '../views/test';
export default {
    data(){
        return{
          abc:0
        }
    },
    props:[
            'current','songs','isPlaying','currentlyTimer','player','coverObject'
    ],
    components:{
      KProgress
    },
    methods:{
      aaa(){
        var sg = document.querySelector('.suggestion')
        if(sg.style.transform == "translateX(0px)"){
          sg.style.transform = "translateX(100%)"
        }else{
          sg.style.transform = "translateX(0px)"
        }
        

      },
      clickNext(){
        EventBus.$emit('clickNext', this.current, this.songs, this.player, this.currentlyTimer, this.coverObject, this.isPlaying)
      },
      clickPrev(){
        EventBus.$emit('clickPrev', this.current, this.songs, this.player, this.currentlyTimer, this.coverObject, this.isPlaying)
      },
      listenersWhenPlay() {
        this.player.addEventListener("timeupdate", () => {
        var playerTimer = this.player.currentTime;
        this.currentlyTimer = formatTimer(playerTimer);
        this.current.percent = (playerTimer * 100) / this.current.seconds;
        this.current.isPlaying = true;
      });
      this.player.addEventListener(
        "ended",
        function() {
          this.next();
        }.bind(this)
      );
    },
    setCover() {
      this.coverObject.animated = true;
      setTimeout(() => {
        this.coverObject.animated = false;
      }, 1000);
    },
    setCurrentSong() {
      this.current = this.songs[this.index];
      this.play(this.current);
      this.setCover();
    },
    play() {
      this.player.play();
      this.isPlaying = true;
      this.setCover();
      this.listenersWhenPlay();
      this.playPlaylist()
    },
    pause() {
      this.player.pause();
      this.isPlaying = false;
      this.pausePlaylist()
    },
    next() {
      this.index = this.songs.indexOf(this.current);
      this.index++;
      if (this.index > this.songs.length - 1) {
        this.index = 0;
      }
      this.setCurrentSong();
      this.clickNext()
    },
    prev() {
      this.current.isPlaying = false;
      this.index = this.songs.indexOf(this.current);
      this.index--;
      if (this.index < 0) {
        this.index = this.songs.length - 1;
      }
      this.setCurrentSong();
      this.clickPrev()
    },
    removeSongFromPlaylist(song) {
      if (this.songs.length > 1) {
        if (this.index > 0) {
          this.index--;
        }
        this.current.isPlaying = false;
        this.songs = deleteElement(this.songs, song);
        this.setCurrentSong();
      }
    },
    handler(e) {
      this.pause()
      this.current = undefined
      this.player = undefined
      this.songs = undefined
    },
    pausePlaylist(){
        this.$emit('pause', this.isPlaying)
      },
      playPlaylist(){
        this.$emit('play', this.isPlaying)
      },
      changeTime(e){
        this.abc =e
      }
    },
    created(){
      EventBus.$on('changeTime', this.play);
      EventBus.$on('hello', this.handler)
    }
}
</script>

<style scoped>
.add{
  display: grid;
  align-content: center;
  justify-content: center;
}
a{
    text-decoration: none;
    color: #2c3e50;
}
.title{
    display: grid;
    grid-template-columns: 1fr 1fr;
}
.show{
    display: grid;
    justify-content: end;
}
.play,
.pause {
  background-image: linear-gradient(to right top,#d16ba5,#c777b9,#ba83ca,#aa8fd8,#9a9ae1,#8aa7ec,#79b3f4,#69bff8,#52cffe,#41dfff,#46eefa,#5ffbf1);
  border-radius: 50%;
  width: 50px;
  height: 50px;
  justify-content: center;
  box-shadow: -1px 17px 24px -6px rgba(0,0,0,.2);
  cursor: pointer;
  font-size: 25px;
  color: #fff;
  margin-left: 20px;
  margin-right: 20px;
}
.next,
.prev {
  border: 0;
  border-radius: 50%;
  font-size: 20px;
  width: 20px;
  height: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  background-color: rgba(0,0,0,.09);
  color: #fff;
  transition: background-color .2s;
  position: relative;
}
/* ---- */
.list{
  height: 80px;
  overflow: hidden;
}
button{
  outline: none;
}
  .list{
    display: grid;
    grid-template-columns: 1fr 5fr 80px 1fr;
    margin: 15px 0;
    align-items: center;
    justify-items: center;
  }
 
  .number{
    display: grid;
    align-items: center;
    justify-items: center;
  }
  .info{
    display: grid;
    grid-template-columns: 1fr 11fr;
    column-gap: 10px;
    
  }
  img{
    width: 100%;
    height: 100%;
  }
  
  .start{
    display: grid;
    justify-content: start;
  }
  .end{
    display: grid;
    justify-content: end;
  }
  .playing{
    height: 100px;
    position: sticky;
    bottom: 0;
    left: 0;
    right: 0;
    z-index: 12;
    background: #2b1742;
    display: grid;
    grid-template-columns: 3fr 7fr 3fr;
    overflow: hidden;
    color: white;
  }
  .playing-info{
    display: grid;
    grid-template-columns: 100px 100px;
  }
  .playing-info .cover-wrapper{
    padding: 20px;
    box-sizing: border-box;
  }
  .playing-info img{
    width: 100%;
    border-radius: 50px;
    
  }
  .playing-info img.spin{
    -webkit-animation:spin 4s linear infinite;
    -moz-animation:spin 4s linear infinite;
    animation:spin 4s linear infinite;
  }
  @-moz-keyframes spin { 100% { -moz-transform: rotate(360deg); } }
  @-webkit-keyframes spin { 100% { -webkit-transform: rotate(360deg); } }
  @keyframes spin { 100% { -webkit-transform: rotate(360deg); transform:rotate(360deg); } }
  .toprank .playing .playing-info .playing-center .k-progress-outer{
    padding: 0 !important;
    margin: 5px 0 !important;
  }
  .timer{
    display: grid;
    grid-template-columns: 1fr 1fr;
  }
  .controls{
    display: grid;
    grid-template-columns: 1fr 2fr 1fr;
    align-items: center;
    justify-items: center;
    margin: 5px 0;
  }
  .song-details{
    display: grid;
    justify-items: start;
    align-items: center;
  }
  .song-details h2,p{
    margin: 0;
  }
  .song-details h2{
    font-size: 15px;
  }
  .song-details p{
    font-size: 12px;
  }
  .numberCircle{
    border-radius: 50%;
    width: 36px;
    height: 36px;
    padding: 8px;

    background: #fff;
    border: 2px solid #666;
    color: #666;
    text-align: center;

    font: 32px Arial, sans-serif;

  }
  .top1{
    border: 2px solid #50e3c2;
    color: #50e3c2;

  }
  .top2{
    border: 2px solid #4a90e2;
    color: #4a90e2;

  }
  .top3{
    border: 2px solid #e35050;
    color: #e35050;

  }

</style>