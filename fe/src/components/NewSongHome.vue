<template>
    <div class="newsongs">
        <div class="title">
            <h2>New Release</h2>
            <router-link to="/playlist/NewMusics" class="show">
                <h2 class="show">Show all new songs</h2>
            </router-link>
        </div>
    <template>
      <!-- main slide -->
      <div class="main-slide">
        <template>
          <splide :options="options1">
            <splide-slide v-for="(song, id) in newsongs.slice(0,8)" :key="song.src" @click="play(song)">
              <div class="container">
                <div class="left" @click="play(song)">
                  <img :src="song.cover" @click="play(song)">
                </div>
                <div class="right">
                  <div class="song-title" @click="play(song)">
                    {{song.title}}
                  </div>
                  <div class="artist" @click="play(song)">
                    {{song.artist}}
                  </div>
                  <div class="id" @click="play(song)">
                    #{{id+1}}
                  </div>
                </div>
              </div>
            </splide-slide>
            <splide-slide class="showall">
              See all new song
            </splide-slide>
          </splide>
        </template>
      </div>
    </template>
    <div class="list-new">
      <div class="list-song" v-for="(song) in newsongs" :key="song.src" @click="play(song)">
        <div class="container-list">
                <div class="left">
                  <img :src="song.cover" @click="play(song)">
                </div>
                <div class="right-list">
                  <div class="song-title-list" @click="play(song)">
                    {{song.title}}
                  </div>
                  <div class="artist-list" @click="play(song)">
                    {{song.artist}}
                  </div>
                  
                </div>
              </div>
      </div>
    </div>



    </div>
</template>
<script>
import KProgress from "k-progress";
import { formatTimer } from "../helpers/timer";
import { deleteElement, threatSongs, shuffleArray, compareScore } from "../helpers/utils";
import newsongs from "../mocks/newsongs";
import EventBus from '../components/bus.js'
import { Splide, SplideSlide } from '@splidejs/vue-splide';
import '@splidejs/splide/dist/css/themes/splide-default.min.css';
export default {
  props:['isPlaying2','list'],
  components: { Splide,
        SplideSlide, KProgress},
  data() {
     return {
      options1: {
        rewind : true,
        perPage:3,
        width: 1100,
        gap: '1rem'
      },
      list2:0,
      current: {},
      coverObject: { cover: true, animated: false },
      index: 0,
      isPlaying: this.isPlaying2,
      currentlyTimer: "00:00",
      newsongs: newsongs,
      player: new Audio()
    };
  },
  methods: {
    pauseAnother2(){
      EventBus.$emit('pauseAnother2', 'i hear you');
    },
    changeCurrentlyTimer(){
      EventBus.$emit('changeTime', this.currentlyTimer);
    },
    choosePlaylist(){
        this.$emit('clicked-something', this.coverObject, this.current, this.newsongs, this.player, this.isPlaying, this.currentlyTimer, this.list2)
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
      this.current = this.newsongs[this.index];
      this.play(this.current);
      this.setCover();
    },
    play(song) {
      if (typeof song.src !== "undefined") {
        this.current.isPlaying = false;
        this.index = this.newsongs.indexOf(this.current);
        this.current = song;
        this.player.src = this.current.src;
      }
      this.player.play();
      this.isPlaying = true;
      this.setCover();
      this.listenersWhenPlay();
      this.choosePlaylist()
      this.changeCurrentlyTimer()
      this.list2 =2
      this.pauseAnother2()
    },
    pause() {
      this.player.pause();
      this.isPlaying = false;
    }
    ,
    next() {
      if(this.list==2){
        this.pause()
        this.current.isPlaying = false;
        this.index = this.newsongs.indexOf(this.current);
        this.index++;
        if (this.index > this.newsongs.length - 1) {
          this.index = 0;
        }
        this.setCurrentSong();
      }
      
    },
    prev() {
      if(this.list==2){
        this.pause()
        this.current.isPlaying = false;
        this.index = this.newsongs.indexOf(this.current);
        this.index--;
        if (this.index < 0) {
          this.index = this.newsongs.length - 1;
        }
        this.setCurrentSong();
      }
   
    },
  },
  mounted() {
    this.newsongs = threatSongs(this.newsongs);
    this.current = this.newsongs[this.index];
    this.player.src = this.current.src;
  },
 created(){
   EventBus.$on('pauseAnother1', this.pause);
   EventBus.$on('clickNext', this.next);
   EventBus.$on('clickPrev', this.prev);
 }
  }
</script>
<style scoped>
*{
  font-family: 'Roboto Slab', serif;
  color: white;
}
.list-new{
  margin-top: 20px;
}
.showall{
  display: grid;
  justify-content: center;
  align-content: center;
}
.song-title-list{

}
.list-song:hover{
  background-color: #ffffff1a;
  transition: box-shadow .2s,background-color .3s;
}
.list-song{
  height: 80px;
  margin: 10px 0;
  overflow: hidden;
}
.container-list{
  display: grid;
  grid-template-columns: 1fr 4fr;
  height: 100%;
  column-gap: 5px;
}
.left{
  height: 100%;
}

.list-new{
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
}
.list-new img{
  width: 100%;
  height: 80px;
}
.container{
  display: grid;
  grid-template-columns: 2fr 3fr;
  column-gap: 5px;
  height: 100%;
  width: 100%;
}
.main-slide{
  height: 160px;
}
.main-slide img{
  width: 100%;
}
.right{
  display: grid;
  grid-template-columns: 1fr;
}
.song-title{
  font-size: 25px;
  font-family: 'Roboto Slab', serif;
}
.artist{
  font-size: 24px;
}
.id{
  font-size: 30px;
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
.newsongs{
  padding: 0 20px;
}
 .splide__slide{
   background: #ffffff1a;
   padding: 10px;
   box-sizing: border-box;
   border-radius: 5px;
 }
</style>
