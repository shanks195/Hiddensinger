<template>
    <div class="page_video">
        <MVSlide></MVSlide>
        <div class="bottom"></div>
    </div>
</template>
<script>
import MVSlide from '../components/MVSlide'
export default {
    components:{
        MVSlide
    }
}
</script>
<style >
    .bottom{
        height: 100px;
    }
    .page_video{
        margin-left: 15rem;
    }
</style>