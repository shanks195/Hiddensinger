<template>
  <div id="app">
    <form id="demo-2">
        <input type="search" placeholder="Search">
    </form>
    <div class="category-play">
        <div class="category-music"><h1>KOREA</h1></div>
        <main>
        <section class="player">
        </section>
        </main>
        <section class="playlist">
        <!-- <h3>Now Playing <span> 🎵 </span></h3> -->
        <ul>
            <li v-for="song in songs" :key="song.src" class="song">
            <div class="cover-playlist">
                <img class="cover" :src="song.cover" />
            </div>
            <div class="details" @click="play(song), show=1">
                <h2 class="song-title">
                {{ song.title }}
                </h2>
                <p class="artist">{{ song.artist }}</p>
                <KProgress
                v-if="song.isPlaying"
                :color="['#df83f1', '#82279f', '#53cfe0']"
                :show-text="false"
                class="progress-bar-wrapper"
                v-bind:percent="song.percent"
                />
            </div>
            <!-- <div class="actions">
                <button @click="removeSongFromPlaylist(song)" class="delete">
                <font-awesome-icon :icon="['fas','times']" />
                </button>
            </div> -->
            </li>
        </ul>
        </section>
    </div>
    <div class="category-play">
        <div class="category-music"><h1>USA</h1></div>
        <main>
        <!-- <section class="player">
            <div class="cover-wrapper">
            <img v-bind:class="coverObject" :src="currenttest.cover" />
            </div>
            <div class="song-details">
            <h2 class="song-title">
                {{ currenttest.title }}
            </h2>
            <p class="artist">{{ currenttest.artist }}</p>
            <KProgress
                :show-text="false"
                class="progress-bar-wrapper"
                v-bind:percent="currenttest.percent"
                :color="['#df83f1', '#82279f', '#53cfe0']"
            />
            <div class="timer">
                <p class="start">{{ currentlyTimer }}</p>
                <p class="end">
                {{ currenttest.totalTimer }}
                </p>
            </div>
            </div>
            <div class="controls">
            <button class="prev" @click="prev" v-if="songtest.length > 1">
                <font-awesome-icon icon="step-backward" />
            </button>
            <button class="play" v-if="!isPlaying" @click="play">
                <font-awesome-icon icon="play" />
            </button>
            <button class="pause" v-else @click="pause">
                <font-awesome-icon icon="pause" />
            </button>
            <button class="next" @click="next" v-if="songs.length > 1">
                <font-awesome-icon icon="step-forward" />
            </button>
            </div>
            <div class="footer">
            <p>Powered by Soundcloud</p>
            <a
                href="https://github.com/Davigl/vue-music-player"
                alt="Give a Star"
                title="Give a Star"
            >
                <font-awesome-icon :icon="['fab', 'github']" />
            </a>
            </div>
        </section> -->
        </main>
        <section class="playlist">
        <!-- <h3>Now Playing <span> 🎵 </span></h3> -->
        <ul>
            <li v-for="song in songtest" :key="song.src" class="song">
            <div class="cover-playlist">
                <img class="cover" :src="song.cover" />
            </div>
            <div class="details" @click="play(song), show=1, list2=1">
                <h2 class="song-title">
                {{ song.title }}
                </h2>
                <p class="artist">{{ song.artist }}</p>
                <KProgress
                v-if="song.isPlaying"
                :color="['#df83f1', '#82279f', '#53cfe0']"
                :show-text="false"
                class="progress-bar-wrapper"
                v-bind:percent="song.percent"
                />
            </div>
            
            </li>
        </ul>
        </section>
    </div>
    <!-- <div class="category-play">
        <div class="category-music"><h1>CHINA</h1></div>
        <main>
        <section class="player">
            <div class="cover-wrapper">
            <img v-bind:class="coverObject" :src="current.cover" />
            </div>
            <div class="song-details">
            <h2 class="song-title">
                {{ current.title }}
            </h2>
            <p class="artist">{{ current.artist }}</p>
            <KProgress
                :show-text="false"
                class="progress-bar-wrapper"
                v-bind:percent="current.percent"
                :color="['#df83f1', '#82279f', '#53cfe0']"
            />
            <div class="timer">
                <p class="start">{{ currentlyTimer }}</p>
                <p class="end">
                {{ current.totalTimer }}
                </p>
            </div>
            </div>
            <div class="controls">
            <button class="prev" @click="prev" v-if="songs.length > 1">
                <font-awesome-icon icon="step-backward" />
            </button>
            <button class="play" v-if="!isPlaying" @click="play">
                <font-awesome-icon icon="play" />
            </button>
            <button class="pause" v-else @click="pause">
                <font-awesome-icon icon="pause" />
            </button>
            <button class="next" @click="next" v-if="songs.length > 1">
                <font-awesome-icon icon="step-forward" />
            </button>
            </div>
            <div class="footer">
            <p>Powered by Soundcloud</p>
            <a
                href="https://github.com/Davigl/vue-music-player"
                alt="Give a Star"
                title="Give a Star"
            >
                <font-awesome-icon :icon="['fab', 'github']" />
            </a>
            </div>
        </section>
        </main>
        <section class="playlist">
        <h3>Now Playing <span> 🎵 </span></h3>
        <ul>
            <li v-for="song in songs" :key="song.src" class="song">
            <div class="cover-playlist">
                <img class="cover" :src="song.cover" />
            </div>
            <div class="details" @click="play(song)">
                <h2 class="song-title">
                {{ song.title }}
                </h2>
                <p class="artist">{{ song.artist }}</p>
                <KProgress
                v-if="song.isPlaying"
                :color="['#df83f1', '#82279f', '#53cfe0']"
                :show-text="false"
                class="progress-bar-wrapper"
                v-bind:percent="song.percent"
                />
            </div>
            <div class="actions">
                <button @click="removeSongFromPlaylist(song)" class="delete">
                <font-awesome-icon icon="times" />
                </button>
            </div>
            </li>
        </ul>
        </section>

    </div> -->
<ToolBar v-if="show==1" :current="current" :songs="songs" :songtest="songtest" :isPlaying="isPlaying" :currentlyTimer="currentlyTimer" :player="player"></ToolBar>

  </div>
</template>

<script>


import KProgress from "k-progress";

import { formatTimer } from "../helpers/timer";
import { deleteElement, threatSongs, shuffleArray } from "../helpers/utils";
import songs from "../mocks/songs";
import songtest from "../mocks/songtest";
import ToolBar from '../components/ToolBar'
export default {
  components: { KProgress, ToolBar },
  name: "App",
  data() {
    return {
      show:0,
      list2:0,
      current: {},
      coverObject: { cover: true, animated: false },
      index: 0,
      isPlaying: false,
      currentlyTimer: "00:00",
      songs: shuffleArray(songs),
      songtest: shuffleArray(songtest),
      player: new Audio()
    };
  },
  methods: {
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
    },
    pause() {
      this.player.pause();
      this.isPlaying = false;
    },
    // next() {
    //   this.current.isPlaying = false;
    //   this.index = this.songs.indexOf(this.current);
    //   this.index++;
    //   if (this.index > this.songs.length - 1) {
    //     this.index = 0;
    //   }
    //   this.setCurrentSong();
    // },
    // prev() {
    //   this.current.isPlaying = false;
    //   this.index = this.songs.indexOf(this.current);
    //   this.index--;
    //   if (this.index < 0) {
    //     this.index = this.songs.length - 1;
    //   }
    //   this.setCurrentSong();
    // },
    // removeSongFromPlaylist(song) {
    //   if (this.songs.length > 1) {
    //     if (this.index > 0) {
    //       this.index--;
    //     }
    //     this.current.isPlaying = false;
    //     this.songs = deleteElement(this.songs, song);
    //     this.setCurrentSong();
    //   }
    // }
  },
  mounted() {
    this.songs = threatSongs(this.songs);
    this.songtest = threatSongs(this.songtest);
    this.current = this.songs[this.index];
    
    this.player.src = this.current.src;
  },
  computed:{
    changeList(){
      if(this.list2 ==1){
        this.current = this.songtest[this.index]
      }else{
        this.current = this.songs[this.index];
        
      }
    }
    
  }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Muli&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lato&display=swap');

* {
  box-sizing: border-box;
  user-select: none;
  overflow-wrap: break-word;
  margin: 0px;
  padding: 0px;
}

::-webkit-scrollbar-track
{
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
	background-color: #F5F5F5;
}

::-webkit-scrollbar
{
	width: 10px;
	background-color: #F5F5F5;
}

::-webkit-scrollbar-thumb
{
	background-color: #ba83ca;	
	background-image: -webkit-linear-gradient(45deg,
	                                          rgba(255, 255, 255, .2) 25%,
											  transparent 25%,
											  transparent 50%,
											  rgba(255, 255, 255, .2) 50%,
											  rgba(255, 255, 255, .2) 75%,
											  transparent 75%,
											  transparent)
}

ul {
  list-style: none;
}

body {
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  font-family: Lato, sans-serif;
  background: rgb(223,131,241);
  background: linear-gradient(90deg, rgba(223,131,241,1) 0%, rgba(130,39,159,1) 35%, rgba(83,207,224,1) 100%);
  background-size: 400% 400%;
  animation: gradient 15s ease infinite;
  -webkit-font-smoothing: antialiased;
}

/* Demo 2 */
input[type=search] {
  background: #ededed url(https://static.tumblr.com/ftv85bp/MIXmud4tx/search-icon.png) no-repeat 9px center;
  border: solid 1px #ccc;
  padding: 9px 10px 9px 32px;
  width: 55px;
  
  -webkit-border-radius: 10em;
  -moz-border-radius: 10em;
  border-radius: 10em;
  
  -webkit-transition: all .5s;
  -moz-transition: all .5s;
  transition: all .5s;
}
input[type=search]:focus {
  width: 130px;
  background-color: #fff;
  border-color: #66CC75;
  
  -webkit-box-shadow: 0 0 5px rgba(109,207,246,.5);
  -moz-box-shadow: 0 0 5px rgba(109,207,246,.5);
  box-shadow: 0 0 5px rgba(109,207,246,.5);
}


input:-moz-placeholder {
  color: #999;
}
input::-webkit-input-placeholder {
  color: #999;
}
#demo-2 input[type=search] {
  width: 50px;
  height:50px;
  padding-left: 10px;
  color: transparent;
  cursor: pointer;
}
#demo-2 input[type=search]:hover {
  background-color: #fff;
}
#demo-2 input[type=search]:focus {
    outline:none;
  width: 491px;
  padding-left: 32px;
  color: #000;
  background-color: #fff;
  cursor: auto;
}
#demo-2 input:-moz-placeholder {
  color: transparent;
}
#demo-2 input::-webkit-input-placeholder {
  color: transparent;
}

/* end search */
main {
  display: flex;
  flex-direction: column;
  flex-wrap: nowrap;
  width: 100%;
  max-width: 375px;
  max-height: 623px;
  margin: 0 auto;
  padding: 25px;
  background-color: #fff;
  border-radius: 15px;
  animation: scale-up-center 1s cubic-bezier(0.390, 0.575, 0.565, 1.000) both;
}

button {
  appearance: none;
  background: none;
  border: none;
  outline: none;
  cursor: pointer;
}

button:hover {
  opacity: 0.8;
  transform: scale(1.1);
}

.song-details {
  margin-top: 25px;
}

.cover-playlist {
  height: 50px;
  width: 50px;
}

.cover-wrapper {
  width: 100%;
  margin-top: 30px;
  height: 270px;
  text-align: center;
}

.animated {
  animation: appear-smoothly 1s normal both;
  transition: all 0.3s; 
}

.cover {
  height: 100%;
  width: 270px;
  box-shadow: 0 24px 35px -16px rgba(107,179,237,.5);
  border-radius: 5px;
}

.cover-playlist > .cover {
  margin-right: 15px;
  width: 50px;
}

.song-title {
  width: 100%;
  color: #53565a;
  font-size: 1.13em;
  text-align: center;
  margin-bottom: 5px;
}

.artist {
  font-family: Muli;
  width: 100%;
  font-weight: 400;
  text-align: center;
}

.details {
  margin-left: 10px;
  width: 100%;
}

.details > .song-title {
  color: #585858;
  font-size: inherit;
  text-align: left;
}

.details > .artist {
  color: #5d5555;
  text-align: left;
}

.controls {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px 15px;
}

.play,
.pause {
  background-image: linear-gradient(to right top,#d16ba5,#c777b9,#ba83ca,#aa8fd8,#9a9ae1,#8aa7ec,#79b3f4,#69bff8,#52cffe,#41dfff,#46eefa,#5ffbf1);
  border-radius: 50%;
  width: 80px;
  height: 80px;
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
  width: 50px;
  height: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  background-color: rgba(0,0,0,.09);
  color: #fff;
  transition: background-color .2s;
  position: relative;
}

.playlist {
  background-color: #fff;
  overflow-y: auto;
  max-height: 622px;
  border-radius: 5px;
}

.playlist h3 {
  color: #212121;
  font-size: 18px;
  font-weight: 400;
  margin-top: 20px;
  margin-bottom: 20px;
  text-align: center;
}

.playlist .song {
  display: flex;
  padding: 10px;
}

.actions > .delete {
  border-radius: 50%;
  width: 40px;
  height: 40px;
  justify-content: center;
  box-shadow: -1px 17px 24px -6px rgba(0,0,0,.2);
  cursor: pointer;
  font-size: 20px;
  color: #ba83ca;
}

.playlist .song:hover {
  background-color: #ededed;
  transition: box-shadow .2s,background-color .3s;
}

.timer {
  display: flex;
  width: 100%;
  justify-content: space-between;
  padding: 10px;
}
.category-play {
    border: 1px solid #be9c9c;
    grid-template-columns: 1fr;
    display: grid;
    padding: 2%;
    border-radius: 22px;
}

.k-progress-outer {
  margin-top: 15px !important;
  padding-right: 0 !important;
}

.footer {
  display: flex;
  justify-content: space-between;
  font-size: 10px;
}

.footer > a {
  cursor: pointer;
  color: #d4d4d4;
  position: relative;
  top: -10px;
  font-size: 25px;
}

#app {
  display: grid;
  gap: 1rem;
  grid-template-columns: 1fr;
  padding: 20px;
}

@media (max-width: 768px) {
  #app {
    grid-template-columns: 1fr;
  }

  body {
    height: 100%;
    margin-top: 10px;
  }

  .playlist {
    max-height: 200px;
  }
}

/* //annimation css */
@keyframes gradient {
	0% {
		background-position: 0% 50%;
	}
	50% {
		background-position: 100% 50%;
	}
	100% {
		background-position: 0% 50%;
	}
}

@keyframes scale-up-center {
  0% {
    -webkit-transform: scale(0.5);
            transform: scale(0.5);
  }
  100% {
    -webkit-transform: scale(1);
            transform: scale(1);
  }
}

@keyframes flip-in-hor-bottom {
  0% {
    -webkit-transform: rotateX(80deg);
            transform: rotateX(80deg);
    opacity: 0;
  }
  100% {
    -webkit-transform: rotateX(0);
            transform: rotateX(0);
    opacity: 1;
  }
}

@keyframes appear-smoothly {
  0% {
    opacity: 0;
  }
  100% {
    opacity: 1;
  }
}

</style>
