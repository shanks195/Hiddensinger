<template>
  <div>
    <HiddenHeader></HiddenHeader>
    <LeftMenu></LeftMenu>

    <router-view/>
    <ToolBar2></ToolBar2>
    
  </div>
</template>

<script>
// @ is an alias to /src
// import { Splide, SplideSlide } from '@splidejs/vue-splide';
// import '@splidejs/splide/dist/css/themes/splide-default.min.css';
import LeftMenu from '../components/LeftMenu'
import ToolBar2 from '../components/ToolBar2'
import HiddenHeader from '../components/HiddenHeader'
import EventBus from '../components/bus'
export default {
  name: 'Home',
  data(){
    return{
    }
  },
  components: {
    LeftMenu,
    ToolBar2,
    HiddenHeader
  },
  created(){
    } 
  
  
}


</script>
<style>
.k-progress.progress-bar-wrapper .k-progress-outer {
    padding: 0%!important;
}

</style>