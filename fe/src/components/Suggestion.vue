<template>
    <div class="suggestion">
        <!-- {{this.current}} -->
        <div class="current">
            {{this.current.title}}
        </div>
        <div>
            <button @click="shuff">refresh</button>
        </div>
        list current
        <div class="suggestion-list" v-for="song in songs" :key="song.src">
            {{song.title}}
        </div>
        list suggestion
        <div v-for="song in songCurrent" :key="song.src">
            {{song.title}}
        </div>
        

    </div>

</template>
<style scoped>
.suggestion{
    position: fixed;
    top: 0;
    bottom: 0;
    right: 0;
    width: 300px;
    background-color: #6a39ef;
    z-index: 10;
    transform: translateX(100%);
    transition: all linear 0.3s;

}
</style>
<script>
import suggestionSong from "../mocks/suggestionSong";
import { deleteElement, threatSongs, shuffleArray } from "../helpers/utils";
export default {
    props:['current','songCurrent'],
    data(){
        return{
          songs: suggestionSong.slice(0,5),
        }
    },
    methods:{
        shuff(){
            this.songs = shuffleArray(suggestionSong).slice(0,5)
        }
    }
}
</script>