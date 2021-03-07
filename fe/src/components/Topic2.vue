<template>
    <div class="category-play">
        <div class="category-music"><h1>Category 2</h1></div>
        <section class="playlist">
        <ul>
            <li v-for="song in songtest" :key="song.src" class="song">
            <div class="cover-playlist" @click="play(song)">
                <img @click=" play(song)" class="cover" :src="song.cover"  />
            </div>
            <div class="details" @click="play(song)">
                <h2 class="song-title" @click="play(song)">{{ song.title }}{{currentlyTimer}}{{isPlaying}}</h2>
                <p class="artist" @click="play(song)">{{ song.artist }}{{list}}</p>
            </div>
            </li>
        </ul>
        </section>
    </div>
</template>
<script>
import KProgress from "k-progress";
import { formatTimer } from "../helpers/timer";
import { deleteElement, threatSongs, shuffleArray } from "../helpers/utils";
import songtest from "../mocks/songtest";
import EventBus from '../components/bus.js'
export default {
  props:['isPlaying2','list'],
  components: { KProgress },
  name: "App",
  data() {
    return {
        list2:0,
        current: {},
        coverObject: { cover: true, animated: false },
        index: 0,
        isPlaying: this.isPlaying2,
        currentlyTimer: "00:00",
        songtest: shuffleArray(songtest),
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
        this.$emit('clicked-something', this.coverObject, this.current, this.songtest, this.player, this.isPlaying, this.currentlyTimer, this.list2)
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
      this.current = this.songtest[this.index];
      this.play(this.current);
      this.setCover();
    },
    play(song) {
      if (typeof song.src !== "undefined") {
        this.current.isPlaying = false;
        this.index = this.songtest.indexOf(this.current);
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
        this.index = this.songtest.indexOf(this.current);
        this.index++;
        if (this.index > this.songtest.length - 1) {
          this.index = 0;
        }
        this.setCurrentSong();
      }
      
    },
    prev() {
      if(this.list==2){
        this.pause()
        this.current.isPlaying = false;
        this.index = this.songtest.indexOf(this.current);
        this.index--;
        if (this.index < 0) {
          this.index = this.songtest.length - 1;
        }
        this.setCurrentSong();
      }
   
    },
  },
  mounted() {
    this.songtest = threatSongs(this.songtest);
    this.current = this.songtest[this.index];
    this.player.src = this.current.src;
  },
 created(){
   EventBus.$on('pauseAnother1', this.pause);
   EventBus.$on('clickNext', this.next);
   EventBus.$on('clickPrev', this.prev);
 }
  
};
</script>

<style scoped src="../assets/css/topic.css"></style>
