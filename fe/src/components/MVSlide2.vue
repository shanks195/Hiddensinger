<template>
      <div class="bv-example-row main">
        <h2>MV</h2>
        <div class="video_component">
          <div class="video" >
            <div class="information_video">
              <div id="vue-core-video-player-box" class="example-player">
                <iframe width="100%" height="100%" :src="currentMovie.cover3" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
              </div>
            </div>  
          </div>
        </div>
     <div class="main-slide">
      <template>
        <splide :options="options1">
          <splide-slide v-for="movie in movieList" :key="movie.cover">
             <MovieItem  :item="movie"></MovieItem>
          </splide-slide>
          
        </splide>
      </template>
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
import Grid from '@splidejs/splide-extension-grid';
import '@splidejs/splide/dist/css/themes/splide-default.min.css';
import { Splide, SplideSlide } from '@splidejs/vue-splide';


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
    RecommendedItem,
    Splide,
    SplideSlide,
    Grid
  },
  data() {
    return {
      title: '',
      movieList: DATA,
      recommendList: [DATA[2], DATA[4], DATA[1], DATA[0]],
      currentMovie: movie,
       options1: {
              rewind : true,
              width  : 1100,
              gap    : '1rem',
              type: 'loop',
              autoplay: true,
              perPage: 4
        },
       
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

*{
  font-family: 'Roboto Slab', serif;
  color: white !important;
}
.main-slide{
  color: white;
}
.bv-example-row {
  padding: 0 20px
}
img{
  width: 100%;
}

.example-player {
    position: relative;
    height: 512px;
    background-color: #000;
    font-weight: normal;
    margin-bottom: 100px;
  }
.information_video{
  padding: 10px;
}
.main-slide .cover img{
   width: 100%;
   height: 100%;
 }
 
</style>
