<template>
  <div class="toprank">
      <div class="title">
        <h2>Ranking</h2>
        <router-link to="/topranking" class="show">
            <h2 class="show">Show all ranking</h2>
        </router-link>
      </div>
  <div class="lists">
    <template v-for="(song, id) in songs" >
      <div class="list" :key="song.src" :id="`item${id+1}`">
      <div :class="{number:true, numberCircle:true, top1: id==0, top2: id==1, top3: id==2}">{{id+1}}</div>
      <div class="info" >
        <div class="img" >
          <img :src="song.cover" @click="play(song)">
        </div>
        <div class="info-right" @click=" play(song)">
          <div @click="play(song)">
            {{song.title}}
          </div>
          <div @click="play(song)">
            {{song.artist}}
          </div>
        </div>
      </div>
      </div>
    </template> 
  </div>

  </div> 
</template>
<style scoped>
*{
  font-family: 'Roboto Slab', serif;
  color: white;
}
.toprank{
  padding: 0 20px;
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

button{
  outline: none;
}
  .list{
    display: grid;
    grid-template-columns: 1fr 5fr 80px ;
    margin: 15px 0;
    align-items: center;
    justify-items: center;
    height: 80px;
    overflow: hidden;
    column-gap: 10px;
  }
 .lists{
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
 }
 #item1{
   grid-area: 1 / 1 / 2 / 2;
 }
  #item2{
   grid-area: 2 / 1 / 3 / 2;
 }
  #item3{
   grid-area: 3 / 1 / 4 / 2;
 }
  #item4{
   grid-area: 1 / 2 / 2 / 3;
 }
  #item5{
   grid-area: 2 / 2 / 3 / 3;
 }
  #item6{
   grid-area: 3 / 2 / 4 / 3;
 }
  #item7{
   grid-area: 1 / 3 / 2 / 4;
 }
  #item8{
   grid-area: 2 / 3 / 3 / 4;
 }
  #item9{
   grid-area: 3 / 3 / 4 / 4;
 }
  .number{
    display: grid;
    align-items: center;
    justify-items: center;
  }
  .info{
    display: grid;
    grid-template-columns: 1fr 2fr;
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

<script>
// @ is an alias to /src
import KProgress from "k-progress";
import { formatTimer } from "../helpers/timer";
import { deleteElement, threatSongs, shuffleArray, compareScore } from "../helpers/utils";
import songs from "../mocks/songs";
import EventBus from '../components/bus.js'
export default {
  components: { KProgress },
  props:['isPlaying1','list'],
  data() {
     return {
      list1:0,
      current: {},
      coverObject: { cover: true, animated: false },
      index: 0,
      isPlaying: this.isPlaying1,
      currentlyTimer: "00:00",
      songs: songs.slice(0,9),
      player: new Audio(),
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
      this.choosePlaylist();
      this.changeCurrentlyTimer()
      this.list1 = 1
      this.pauseAnother1()
    },
    pause() {
      this.player.pause();
      this.isPlaying = false;
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
    }
  },
  mounted() {
    this.songs = threatSongs(this.songs);
    this.current = this.songs[this.index];
    this.player.src = this.current.src;
  },
  computed:{
    
  },
  created() {
    EventBus.$on('pauseAnother2', this.pause);
    EventBus.$on('clickNext', this.next);
    EventBus.$on('clickPrev', this.prev);   
  },
  destroyed() {
    // Stop listening the event hello with handler
  },
};
</script>
