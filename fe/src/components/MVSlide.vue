<template>
      <div class="bv-example-row main">
        <div class="video_component">
                  <h2>Play List</h2>

          <div class="video" cols="8">
            <div class="information_video">
              <div id="vue-core-video-player-box" class="example-player">
                <iframe width="100%" height="100%" :src="currentMovie.cover3" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
              </div>
              <div class="movie-detail">
                <h1 class="title">{{currentMovie.title}}</h1>
                <div class="date">{{currentMovie.author}} - {{currentMovie.date}}</div>
                <div class="desc">{{currentMovie.desc}} </div>
              </div>
            </div>  
            <div class="playlist">
                <div cols="4" class="play-list">
                  <MovieItem v-for="movie in movieList" :key="movie.cover" :item="movie"></MovieItem>
                </div>
            </div>
            
              <div class="bottom_video">
                <div class="recommend-list">
                  <RecommendedItem v-for="movie in recommendList" :key="movie.cover" :item="movie"></RecommendedItem>  
                </div>
                
              </div>
           
          </div>
          
        </div>
      </div>  
</template>
<script>
import VueCoreVideoPlayer from 'vue-core-video-player'
import Vue from 'vue'
Vue.use(VueCoreVideoPlayer)
import MovieItem from './MovieItem.vue'
import RecommendedItem from './Recommended.vue'
import DATA from '../mocks/data'

let movie = DATA[2]

if (location.search) {
  var vid = location.search.split('=')[1]
  DATA.forEach(item => {
    if (item.id === vid) {
      movie = item
    }
  })
}


export default {
  name: 'MVSlide',
  components: {
    MovieItem,
    RecommendedItem
  },
  data() {
    return {
      title: '',
      movieList: DATA,
      recommendList: [DATA[2], DATA[4], DATA[1], DATA[0]],
      currentMovie: movie
       
    }
  },
  methods: {
    open() {
      window.open('https://github.com/core-player/vue-core-video-player-examples')
    }
  },
}
</script>

<style scoped>
.video {
    display: grid;
    gap: 1rem;
    grid-template-columns: 2fr 1fr;
}

.slide {
    display: grid;
    gap: 1rem;
    grid-template-columns: 1fr 1fr;
}
.checkout {
    margin-bottom: 52px;
    
    border: 1px solid #ebebeb;
    padding: 5%;
}
 .des{
    display: grid;
    grid-template-columns: 1fr 3fr;
    column-gap: 20px;
    margin-top: 20px;
  }
  .des img{
    width: 100%;
    border-radius: 30px;
  }
  h4, h5{
    margin: 0;
  }
.mv-slide{
    display: grid;
    justify-content: center;
  }
  .mv-slide h2 {
    font-weight: 600;
    font-size: 26px;
  }
  .slide-mv .thumb-mv{
    position: relative;
  }
  .thumb-mv .overlay{
    
    width: 100%;
    position: absolute;
    top: 0%;
    left: 0%;
    height: 100%;
    display: grid;
    align-items: center;
    justify-items: center;
    /* opacity: .5; */
    bottom: 0;
  }
  .thumb-mv{
    overflow: hidden;
  }
  .thumb-mv .overlay h1{
    display: none;
    opacity: 0.6;
  }
  .thumb-mv:hover .overlay h1{
    display: block;
    cursor: pointer;
  }
    .thumb-mv img{
      transition: transform .5s ease;
      border-radius: 10px;
    }
  .thumb-mv:hover img{
    transform: scale(1.5);
    border-radius: 10px;
  }
.thumb-mv:hover .overlay{
    background-color: rgba(0, 0, 0, 0.5);
}
.checkout {
    
}
/* -----------------start overlay mv--------------- */
.overlay-mv{
  position: fixed;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  background: white;
  z-index: 3;
  transform: translateY(100%);
  transition: all linear 0.3s;
}
#mv-hot:checked ~ .overlay-mv{
  transform: translateY(0%) !important;

}
.overlay-mv svg{
  width: 25px;
  height: 25px;
}
/* -----------------end overlay mv--------------- */

.example-player {
    position: relative;
    height: 410px;
    background-color: #000;
    font-weight: normal;
  }
  .movie-detail{
    padding-top: 20px;
    color: rgba(0,0,0, .65);
  }
  .movie-detail h1{
    font-size: 20px;
    color: #000;
  }
  .movie-detail .date {
    font-size: 20px;
  }
  .movie-detail .desc {
    font-size: 20px;
    padding: 10px 20px 10px 0;
  }
  .movie-detail .btn-wrap {
    padding-right: 20px;
    text-align: right;
  }
  .play-list h2 {
    font-size: 20px;
    color: rgba(0,0,0, .85);
    padding-bottom: 10px;
  }
  .recommend-list {
    margin-top: 40px;
    padding-top: 40px;
    padding-bottom: 40px;
    border-top: 1px solid #ddd;
  }
  .thanks {
    padding: 20px 0 40px;
    color: rgba(0, 0, 0, .25);
    font-size: 20px;
    text-align: center;
  }
  .recommend-list:after{
    content: '';
    display: block;
    clear: both;
  }
  .example-player {
    position: relative;
    height: 410px;
    background-color: #000;
    font-weight: normal;
  }
  .movie-detail{
    padding-top: 20px;
    color: rgba(0,0,0, .65);
  }
  .movie-detail h1{
    font-size: 30px;
    color: #000;
  }
  .movie-detail .date {
    font-size: 22px;
  }
  .movie-detail .desc {
    font-size: 20px;
    padding: 10px 20px 10px 0;
  }
  .movie-detail .btn-wrap {
    padding-right: 20px;
    text-align: right;
  }
  .play-list h2 {
    font-size: 30px;
    color: rgba(0,0,0, .85);
    padding-bottom: 10px;
  }
  .recommend-list {
    margin-top: 40px;
    padding-top: 40px;
    padding-bottom: 40px;
    border-top: 1px solid #ddd;
  }
  .thanks {
    padding: 20px 0 40px;
    color: rgba(0, 0, 0, .25);
    font-size: 20px;
    text-align: center;
  }
  .recommend-list:after{
    content: '';
    display: block;
    clear: both;
  }
</style>
