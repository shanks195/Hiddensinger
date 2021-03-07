<template>
        <div id="content" class="app-content white bg box-shadow-z2" role="main">
            <div class="app-body" id="view">
                <div class="page-content">
                    <div class="row-col">
                        <div class="col-lg-9 b-r no-border-md">
                            <div class="padding">
                                <div class="page-title m-b">
                                    <h1 class="inline m-a-0">Charts</h1>
                                    <div class="dropdown inline"><button
                                            class="btn btn-sm no-bg h4 m-y-0 v-b dropdown-toggle text-primary"
                                            data-toggle="dropdown">Last week</button>
                                        <div class="dropdown-menu"><a href="#" class="dropdown-item active">Last
                                                week</a> <a href="#" class="dropdown-item">Last month</a> <a href="#"
                                                class="dropdown-item">Last year</a> <a href="#"
                                                class="dropdown-item">All the time</a></div>
                                    </div>
                                </div>
                                <div class="row item-list item-list-md item-list-li m-b">
                                    <template v-for="song in topSongs">
                                        <div class="col-xs-12" :key="song.id">
                                        <div class="item r" data-id="item-8"
                                            data-src="http://api.soundcloud.com/tracks/236288744/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="/detail?id=1"
                                                    class="item-media-content b7"
                                                    ></a>
                                                <div class="item-overlay center"><button @click="play(song)"
                                                        class="btn-playpause">Play</button></div>
                                            </div>
                                            <div class="item-info">
                                                <div class="item-overlay bottom text-right"><a href="#"
                                                        class="btn-favorite"><i class="fa fa-heart-o"></i></a> <a
                                                        href="#" class="btn-more" data-toggle="dropdown"><i
                                                            class="fa fa-ellipsis-h"></i></a>
                                                    <div class="dropdown-menu pull-right black lt"></div>
                                                </div>
                                                <div class="item-title text-ellipsis"><a href="/detail?id=1">{{song.name}}</a></div>
                                                <div class="item-author text-sm text-ellipsis"><a
                                                        href="/detail?id=1" class="text-muted">{{song.username}}</a></div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-stats text-xs item-meta-right"><i
                                                            class="fa fa-play text-muted"></i> 400 <i
                                                            class="fa fa-heart m-l-sm text-muted"></i> 220</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    </template>
                                    
                                    <!-- <div class="col-xs-12">
                                        <div class="item r" data-id="item-11"
                                            data-src="http://api.soundcloud.com/tracks/218060449/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="/detail?id=1"
                                                    class="item-media-content b10"
                                                    ></a>
                                                <div class="item-overlay center"><button
                                                        class="btn-playpause">Play</button></div>
                                            </div>
                                            <div class="item-info">
                                                <div class="item-overlay bottom text-right"><a href="#"
                                                        class="btn-favorite"><i class="fa fa-heart-o"></i></a> <a
                                                        href="#" class="btn-more" data-toggle="dropdown"><i
                                                            class="fa fa-ellipsis-h"></i></a>
                                                    <div class="dropdown-menu pull-right black lt"></div>
                                                </div>
                                                <div class="item-title text-ellipsis"><a
                                                        href="/detail?id=1">Spring</a></div>
                                                <div class="item-author text-sm text-ellipsis"><a
                                                        href="/detail?id=1" class="text-muted">Pablo Nouvelle</a>
                                                </div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-stats text-xs item-meta-right"><i
                                                            class="fa fa-play text-muted"></i> 4500 <i
                                                            class="fa fa-heart m-l-sm text-muted"></i> 2310</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-10"
                                            data-src="http://api.soundcloud.com/tracks/237514750/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="/detail?id=1"
                                                    class="item-media-content b9"
                                                    ></a>
                                                <div class="item-overlay center"><button
                                                        class="btn-playpause">Play</button></div>
                                            </div>
                                            <div class="item-info">
                                                <div class="item-overlay bottom text-right"><a href="#"
                                                        class="btn-favorite"><i class="fa fa-heart-o"></i></a> <a
                                                        href="#" class="btn-more" data-toggle="dropdown"><i
                                                            class="fa fa-ellipsis-h"></i></a>
                                                    <div class="dropdown-menu pull-right black lt"></div>
                                                </div>
                                                <div class="item-title text-ellipsis"><a href="/detail?id=1">The
                                                        Open Road</a></div>
                                                <div class="item-author text-sm text-ellipsis"><a
                                                        href="/detail?id=1" class="text-muted">Postiljonen</a>
                                                </div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-stats text-xs item-meta-right"><i
                                                            class="fa fa-play text-muted"></i> 860 <i
                                                            class="fa fa-heart m-l-sm text-muted"></i> 240</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-9"
                                            data-src="http://api.soundcloud.com/tracks/264094434/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="/detail?id=1"
                                                    class="item-media-content b8"
                                                    ></a>
                                                <div class="item-overlay center"><button
                                                        class="btn-playpause">Play</button></div>
                                            </div>
                                            <div class="item-info">
                                                <div class="item-overlay bottom text-right"><a href="#"
                                                        class="btn-favorite"><i class="fa fa-heart-o"></i></a> <a
                                                        href="#" class="btn-more" data-toggle="dropdown"><i
                                                            class="fa fa-ellipsis-h"></i></a>
                                                    <div class="dropdown-menu pull-right black lt"></div>
                                                </div>
                                                <div class="item-title text-ellipsis"><a href="/detail?id=1">All I
                                                        Need</a></div>
                                                <div class="item-author text-sm text-ellipsis"><a
                                                        href="/detail?id=1" class="text-muted">Pablo Nouvelle</a>
                                                </div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-stats text-xs item-meta-right"><i
                                                            class="fa fa-play text-muted"></i> 4500 <i
                                                            class="fa fa-heart m-l-sm text-muted"></i> 2310</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-6"
                                            data-src="http://api.soundcloud.com/tracks/236107824/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="/detail?id=1"
                                                    class="item-media-content b5"
                                                    ></a>
                                                <div class="item-overlay center"><button
                                                        class="btn-playpause">Play</button></div>
                                            </div>
                                            <div class="item-info">
                                                <div class="item-overlay bottom text-right"><a href="#"
                                                        class="btn-favorite"><i class="fa fa-heart-o"></i></a> <a
                                                        href="#" class="btn-more" data-toggle="dropdown"><i
                                                            class="fa fa-ellipsis-h"></i></a>
                                                    <div class="dropdown-menu pull-right black lt"></div>
                                                </div>
                                                <div class="item-title text-ellipsis"><a href="/detail?id=1">Body
                                                        on me</a></div>
                                                <div class="item-author text-sm text-ellipsis"><a
                                                        href="/detail?id=1" class="text-muted">Rita Ora</a></div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-stats text-xs item-meta-right"><i
                                                            class="fa fa-play text-muted"></i> 330 <i
                                                            class="fa fa-heart m-l-sm text-muted"></i> 220</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-7"
                                            data-src="http://api.soundcloud.com/tracks/245566366/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="/detail?id=1"
                                                    class="item-media-content b6"
                                                    ></a>
                                                <div class="item-overlay center"><button
                                                        class="btn-playpause">Play</button></div>
                                            </div>
                                            <div class="item-info">
                                                <div class="item-overlay bottom text-right"><a href="#"
                                                        class="btn-favorite"><i class="fa fa-heart-o"></i></a> <a
                                                        href="#" class="btn-more" data-toggle="dropdown"><i
                                                            class="fa fa-ellipsis-h"></i></a>
                                                    <div class="dropdown-menu pull-right black lt"></div>
                                                </div>
                                                <div class="item-title text-ellipsis"><a
                                                        href="/detail?id=1">Reflection (Deluxe)</a></div>
                                                <div class="item-author text-sm text-ellipsis"><a
                                                        href="/detail?id=1" class="text-muted">Fifth Harmony</a>
                                                </div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-stats text-xs item-meta-right"><i
                                                            class="fa fa-play text-muted"></i> 200 <i
                                                            class="fa fa-heart m-l-sm text-muted"></i> 510</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-1"
                                            data-src="http://api.soundcloud.com/tracks/269944843/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="/detail?id=1"
                                                    class="item-media-content b0"
                                                    ></a>
                                                <div class="item-overlay center"><button
                                                        class="btn-playpause">Play</button></div>
                                            </div>
                                            <div class="item-info">
                                                <div class="item-overlay bottom text-right"><a href="#"
                                                        class="btn-favorite"><i class="fa fa-heart-o"></i></a> <a
                                                        href="#" class="btn-more" data-toggle="dropdown"><i
                                                            class="fa fa-ellipsis-h"></i></a>
                                                    <div class="dropdown-menu pull-right black lt"></div>
                                                </div>
                                                <div class="item-title text-ellipsis"><a href="/detail?id=1">Pull
                                                        Up</a></div>
                                                <div class="item-author text-sm text-ellipsis"><a
                                                        href="/detail?id=1" class="text-muted">Summerella</a>
                                                </div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-stats text-xs item-meta-right"><i
                                                            class="fa fa-play text-muted"></i> 3200 <i
                                                            class="fa fa-heart m-l-sm text-muted"></i> 210</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-12"
                                            data-src="http://api.soundcloud.com/tracks/174495152/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="/detail?id=1"
                                                    class="item-media-content b11"
                                                    ></a>
                                                <div class="item-overlay center"><button
                                                        class="btn-playpause">Play</button></div>
                                            </div>
                                            <div class="item-info">
                                                <div class="item-overlay bottom text-right"><a href="#"
                                                        class="btn-favorite"><i class="fa fa-heart-o"></i></a> <a
                                                        href="#" class="btn-more" data-toggle="dropdown"><i
                                                            class="fa fa-ellipsis-h"></i></a>
                                                    <div class="dropdown-menu pull-right black lt"></div>
                                                </div>
                                                <div class="item-title text-ellipsis"><a href="/detail?id=1">Happy
                                                        ending</a></div>
                                                <div class="item-author text-sm text-ellipsis"><a
                                                        href="/detail?id=1" class="text-muted">Postiljonen</a>
                                                </div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-stats text-xs item-meta-right"><i
                                                            class="fa fa-play text-muted"></i> 860 <i
                                                            class="fa fa-heart m-l-sm text-muted"></i> 240</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-3"
                                            data-src="http://api.soundcloud.com/tracks/79031167/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="/detail?id=1"
                                                    class="item-media-content b2"
                                                    ></a>
                                                <div class="item-overlay center"><button
                                                        class="btn-playpause">Play</button></div>
                                            </div>
                                            <div class="item-info">
                                                <div class="item-overlay bottom text-right"><a href="#"
                                                        class="btn-favorite"><i class="fa fa-heart-o"></i></a> <a
                                                        href="#" class="btn-more" data-toggle="dropdown"><i
                                                            class="fa fa-ellipsis-h"></i></a>
                                                    <div class="dropdown-menu pull-right black lt"></div>
                                                </div>
                                                <div class="item-title text-ellipsis"><a href="/detail?id=1">I
                                                        Wanna Be In the Cavalry</a></div>
                                                <div class="item-author text-sm text-ellipsis"><a
                                                        href="/detail?id=1" class="text-muted">Jeremy Scott</a>
                                                </div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-stats text-xs item-meta-right"><i
                                                            class="fa fa-play text-muted"></i> 300 <i
                                                            class="fa fa-heart m-l-sm text-muted"></i> 10</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-2"
                                            data-src="http://api.soundcloud.com/tracks/259445397/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="/detail?id=1"
                                                    class="item-media-content b1"
                                                    ></a>
                                                <div class="item-overlay center"><button
                                                        class="btn-playpause">Play</button></div>
                                            </div>
                                            <div class="item-info">
                                                <div class="item-overlay bottom text-right"><a href="#"
                                                        class="btn-favorite"><i class="fa fa-heart-o"></i></a> <a
                                                        href="#" class="btn-more" data-toggle="dropdown"><i
                                                            class="fa fa-ellipsis-h"></i></a>
                                                    <div class="dropdown-menu pull-right black lt"></div>
                                                </div>
                                                <div class="item-title text-ellipsis"><a
                                                        href="/detail?id=1">Fireworks</a></div>
                                                <div class="item-author text-sm text-ellipsis"><a
                                                        href="/detail?id=1" class="text-muted">Kygo</a></div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-stats text-xs item-meta-right"><i
                                                            class="fa fa-play text-muted"></i> 30 <i
                                                            class="fa fa-heart m-l-sm text-muted"></i> 10</span></div>
                                            </div>
                                        </div>
                                    </div> -->
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 w-xxl w-auto-md">
                            <div class="padding" style="bottom: 60px" data-ui-jp="stick_in_parent">
                                <h6 class="text text-muted">5 Likes</h6>
                                <div class="row item-list item-list-sm m-b">
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-8"
                                            data-src="http://api.soundcloud.com/tracks/236288744/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="/detail?id=1"
                                                    class="item-media-content b7"
                                                    ></a></div>
                                            <div class="item-info">
                                                <div class="item-title text-ellipsis"><a href="/detail?id=1">Simple
                                                        Place To Be</a></div>
                                                <div class="item-author text-sm text-ellipsis"><a
                                                        href="/detail?id=1" class="text-muted">RYD</a></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-3"
                                            data-src="http://api.soundcloud.com/tracks/79031167/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="/detail?id=1"
                                                    class="item-media-content b2"
                                                    ></a></div>
                                            <div class="item-info">
                                                <div class="item-title text-ellipsis"><a href="/detail?id=1">I
                                                        Wanna Be In the Cavalry</a></div>
                                                <div class="item-author text-sm text-ellipsis"><a
                                                        href="/detail?id=1" class="text-muted">Jeremy Scott</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-6"
                                            data-src="http://api.soundcloud.com/tracks/236107824/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="/detail?id=1"
                                                    class="item-media-content b5"
                                                    ></a></div>
                                            <div class="item-info">
                                                <div class="item-title text-ellipsis"><a href="/detail?id=1">Body
                                                        on me</a></div>
                                                <div class="item-author text-sm text-ellipsis"><a
                                                        href="/detail?id=1" class="text-muted">Rita Ora</a></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-10"
                                            data-src="http://api.soundcloud.com/tracks/237514750/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="/detail?id=1"
                                                    class="item-media-content b9"
                                                    ></a></div>
                                            <div class="item-info">
                                                <div class="item-title text-ellipsis"><a href="/detail?id=1">The
                                                        Open Road</a></div>
                                                <div class="item-author text-sm text-ellipsis"><a
                                                        href="/detail?id=1" class="text-muted">Postiljonen</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-12"
                                            data-src="http://api.soundcloud.com/tracks/174495152/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="/detail?id=1"
                                                    class="item-media-content b11"
                                                   ></a></div>
                                            <div class="item-info">
                                                <div class="item-title text-ellipsis"><a href="/detail?id=1">Happy
                                                        ending</a></div>
                                                <div class="item-author text-sm text-ellipsis"><a
                                                        href="/detail?id=1" class="text-muted">Postiljonen</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <h6 class="text text-muted">Go mobile</h6>
                                <div class="btn-groups"><a href="#" class="btn btn-sm dark lt m-r-xs"
                                        style="width: 135px"><span class="pull-left m-r-sm"><i
                                                class="fa fa-apple fa-2x"></i></span> <span
                                            class="clear text-left l-h-1x"><span class="text-muted text-xxs">Download on
                                                the</span> <b class="block m-b-xs">App Store</b></span></a> <a href="#"
                                        class="btn btn-sm dark lt" style="width: 133px"><span
                                            class="pull-left m-r-sm"><i class="fa fa-play fa-2x"></i></span> <span
                                            class="clear text-left l-h-1x"><span class="text-muted text-xxs">Get it
                                                on</span> <b class="block m-b-xs m-r-xs">Google Play</b></span></a>
                                </div>
                                <div class="b-b m-y"></div>
                                <div class="nav text-sm _600"><a href="#" class="nav-link text-muted m-r-xs">About</a>
                                    <a href="#" class="nav-link text-muted m-r-xs">Contact</a> <a href="#"
                                        class="nav-link text-muted m-r-xs">Legal</a> <a href="#"
                                        class="nav-link text-muted m-r-xs">Policy</a></div>
                                <p class="text-muted text-xs p-b-lg">&copy; Copyright 2016</p>
                            </div>
                        </div> 
                    </div>
                </div>
            </div>
        </div>
</template>
<style scoped src="../assets/template_frontend/css/animate.css/animate.min.css"></style>
<style scoped src="../assets/template_frontend/css/glyphicons/glyphicons.css"></style>
<style scoped src="../assets/template_frontend/css/font-awesome/css/font-awesome.min.css"></style>
<style rel="stylesheet" scoped src="../assets/template_frontend/css/material-design-icons/material-design-icons.css"></style>
<style scoped src="../assets/template_frontend/css/bootstrap/dist/css/bootstrap.min.css"></style>
<style scoped src="../assets/template_frontend/css/styles/app.css"></style>
<style scoped>
.b0{
    background-image: url('../assets/template_frontend/images/b0.jpg') !important;
}
.b1{
    background-image: url('../assets/template_frontend/images/b1.jpg') !important;
}
.b2{
    background-image: url('../assets/template_frontend/images/b2.jpg') !important;
}
.b3{
    background-image: url('../assets/template_frontend/images/b3.jpg') !important;
}
.b4{
    background-image: url('../assets/template_frontend/images/b4.jpg') !important;
}
.b5{
    background-image: url('../assets/template_frontend/images/b5.jpg') !important;
}
.b6{
    background-image: url('../assets/template_frontend/images/b6.jpg') !important;
}
.b7{
    background-image: url('../assets/template_frontend/images/b7.jpg') !important;
}
.b8{
    background-image: url('../assets/template_frontend/images/b8.jpg') !important;
}
.b9{
    background-image: url('../assets/template_frontend/images/b9.jpg') !important;
}
.b10{
    background-image: url('../assets/template_frontend/images/b10.jpg') !important;
}
.b11{
    background-image: url('../assets/template_frontend/images/b11.jpg') !important;
}
</style>
<script>
import axios from 'axios'
import {requestHeader,PATH} from '../index/index.js'
import EventBus from '../components/bus'
import { deleteElement, threatSongs, shuffleArray, sortNew, compareScore } from "../helpers/utils";
export default {
	data(){
		return{
			topSongs:'',
		}
	},
	created(){
		axios.get(`${PATH}api/song/list`)
		.then(rs=>{
			this.topSongs = rs.data.listResult.sort(compareScore)
		})
		
  },
  methods:{
	play(song){
      EventBus.$emit('playmusicC', song)
    },
    pause(){
      EventBus.$emit('pausemusicC')
    }
  }
}
</script>