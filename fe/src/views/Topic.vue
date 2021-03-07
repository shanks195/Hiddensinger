<template>
    <div class="topic">
        <Topic1 @clicked-something="handleClickInParent" :isPlaying1="isPlaying" :list="list"></Topic1>
        <Topic2 @clicked-something="handleClickInParent" :isPlaying2="isPlaying" :list="list"></Topic2>

        <ToolBar v-if="list!=0" @pause="pause" @play="play" :coverObject="coverObject" :current="current" :songs="songs"  
        :player="player" :isPlaying="isPlaying" :currentlyTimer="currentlyTimer"></ToolBar>
        <Suggestion  :current="current"></Suggestion>
    
    </div>
</template>
<script>
import Topic1 from '../components/Topic1'
import Topic2 from '../components/Topic2'
import ToolBar from '../components/ToolBar'
import songs from '../mocks/songs'
import EventBus from '../components/bus'
import Suggestion from '../components/Suggestion'
export default {
    components:{
        Topic1,
        Topic2,
        Suggestion,
        ToolBar
    },
    created(){
        
    },
    data(){
        return{
            coverObject:'',
            current:'',
            songs:'',
            player:'',
            isPlaying:false,
            currentlyTimer:'',
            list:'',
            abc:''
        }
    },
    methods:{
        handleNext(data){
            this.current=data.current;
            this.currentlyTimer=data.currentlyTimer;
        },
        handleClickInParent(coverObject,current, songs, player, isPlaying,currentlyTimer, list){
            this.coverObject = coverObject
            this.current = current
            this.songs = songs
            this.player = player
            this.isPlaying = isPlaying
            this.currentlyTimer = currentlyTimer
            this.list =list
        },
        pause(isPlaying){
            this.isPlaying = isPlaying
        },
        play(isPlaying){
            this.isPlaying = isPlaying
        }

    },
    created(){

    }
}
</script>