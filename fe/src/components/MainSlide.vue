<template>
     <!-- main slide -->
    <div class="main-slide">
      <template>
        <splide :options="options1">
          <splide-slide>
            <div>
              <img class="slide-main" src="../assets/1.jpg">
              <h3>hello</h3>
            </div>
            
          </splide-slide>
          <splide-slide>
            <div>
              <img class="slide-main" src="../assets/1.jpg">
              <h3>hi</h3>
            </div>
          </splide-slide>
         <splide-slide>
            <div>
              <img class="slide-main" src="../assets/1.jpg">
              <h3>hello</h3>
            </div>
          </splide-slide>
          <splide-slide>
            <div>
              <img class="slide-main" src="../assets/1.jpg">
              <h3>how are you ?</h3>
            </div>
          </splide-slide>
        </splide>
      </template>
    </div>
    
  <!-- mv slide -->
</template>

<script>

import { Splide, SplideSlide } from '@splidejs/vue-splide';
import '@splidejs/splide/dist/css/themes/splide-default.min.css';

export default {
    components:{
        Splide,
        SplideSlide,
    },
    data(){
        return{
            options1: {
                rewind : true,
                width  : 900,
                gap    : '1rem',
                padding: {
                right: '5rem',
                left : '5rem',
            },
            type: 'loop',
            autoplay: true,
        },
        }
    }
}
</script>
<style >
.slide-main{
    width: 100%;
    /* height: 50%; */
  }
  .main-slide{
    display: grid;
    justify-content: center;
  }
</style>