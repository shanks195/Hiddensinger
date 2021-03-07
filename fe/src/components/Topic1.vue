<template>
    <div class="category-play">
      <div class="category-music"><h1>Category 1</h1></div>
      <section class="playlist">
      <!-- <h3>Now Playing <span> 🎵 </span></h3> -->
      <ul>
          <li v-for="song in songs" :key="song.src" class="song">
          <div class="cover-playlist" @click="play(song)">
              <img class="cover" :src="song.cover" @click="play(song)"/>
          </div>
          <div class="details" @click="play(song)">
              <h2 class="song-title" @click=" play(song)">{{ song.title }}{{currentlyTimer}}{{isPlaying}}</h2>
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
import songs from "../mocks/songs";
import EventBus from '../components/bus.js'

export default {
  props:['isPlaying1','list'],
  components: { KProgress },
  name: "App",
  data() {
    return {
      list1:0,
      current: {},
      coverObject: { cover: true, animated: false },
      index: 0,
      isPlaying: this.isPlaying1,
      currentlyTimer: "00:00",
      songs: shuffleArray(songs),
      player: new Audio()
    };
  },
  methods: {
    pauseAnother1(){
      EventBus.$emit('pauseAnother1', 'i hear you');
    },
    changeCurrentlyTimer(){
      EventBus.$emit('changeTime', this.currentlyTimer);
    },
    choosePlaylist(){
        this.$emit('clicked-something', this.coverObject, this.current, this.songs, this.player, this.isPlaying, this.currentlyTimer, this.list1)
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
    play(song) {
      if (typeof song.src !== "undefined") {
        this.current.isPlaying = false;
        this.index = this.songs.indexOf(this.current);
        this.current = song;
        this.player.src = this.current.src;
      }
      this.player.play();
      this.isPlaying = true;
      this.setCover();
      this.listenersWhenPlay();
      this.choosePlaylist()
      this.changeCurrentlyTimer()
      this.list1 = 1
      this.pauseAnother1()
    },
    next() {
      if(this.list ==1){
      this.pause()
      this.current.isPlaying = false;
      this.index = this.songs.indexOf(this.current);
      this.index++;
      if (this.index > this.songs.length - 1) {
        this.index = 0;
      }
      this.setCurrentSong();
      }
    },
    prev() {
      if(this.list==1){
        this.pause()
        this.current.isPlaying = false;
        this.index = this.songs.indexOf(this.current);
        this.index--;
        if (this.index < 0) {
          this.index = this.songs.length - 1;
        }
        this.setCurrentSong();
      }
    },
    pause() {
      this.player.pause();
      this.isPlaying = false;
    },
  },
  mounted() {
    this.songs = threatSongs(this.songs);
    this.current = this.songs[this.index];
    this.player.src = this.current.src;
    
  },
  created(){
   EventBus.$on('pauseAnother2', this.pause);
   EventBus.$on('clickNext', this.next);
   EventBus.$on('clickPrev', this.prev);
 }
 , computed:{
    
 }
};
</script>

<style scoped src="../assets/css/topic.css"></style>
