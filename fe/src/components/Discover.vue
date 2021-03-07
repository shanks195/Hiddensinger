<template>
    <div id="content" class="app-content white bg box-shadow-z2" role="main">
		<!-- <div class="app-header hidden-lg-up white lt box-shadow-z1">
			<div class="navbar"><a href="/discover" class="navbar-brand md"><svg
							xmlns="http://www.w3.org/2000/svg" viewBox="0 0 48 48" width="32" height="32">
							<circle cx="24" cy="24" r="24" fill="rgba(255,255,255,0.2)" />
							<circle cx="24" cy="24" r="22" fill="#1c202b" class="brand-color" />
							<circle cx="24" cy="24" r="10" fill="#ffffff" />
							<circle cx="13" cy="13" r="2" fill="#ffffff" class="brand-animate" />
							<path d="M 14 24 L 24 24 L 14 44 Z" fill="#FFFFFF" />
							<circle cx="24" cy="24" r="3" fill="#000000" /></svg> <img src="images/logo.png" alt="."
							class="hide"> <span class="hidden-folded inline">Hidden Singer</span></a>
				<ul class="nav navbar-nav pull-right">
					<li class="nav-item"><a data-toggle="modal" data-target="#aside" class="nav-link"><i
								class="material-icons">menu</i></a></li>
				</ul>
			</div>
		</div> -->
			<div class="app-body" id="view">
				<div class="page-content">
					<div class="padding p-b-0">
						<div class="page-title m-b">
							<h1 class="inline m-a-0">Discover</h1>
						</div>
						<h2 class="widget-title h4 m-b">Contest Rules</h2>
						<div class="rules">
							<div>
								<h2>Who can enter:</h2>
								<p>To be eligible to participate in this contest, contestant must be a current user of Hidden Singer.</p>
								<h2>How to enter</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quamquam tu hanc copiosiorem etiam soles dicere. Nihil illinc huc pervenit. Verum hoc idem saepe faciamus. Quid ad utilitatem tantae pecuniae? Utram tandem linguam nescio? Sed hoc sane concedamus.</p>
								<h2>The prize</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quamquam tu hanc copiosiorem etiam soles dicere. Nihil illinc huc pervenit. Verum hoc idem saepe faciamus. Quid ad utilitatem tantae pecuniae? Utram tandem linguam nescio? Sed hoc sane concedamus.</p>
						
							</div>
							
						</div>
						<h2 class="widget-title h4 m-b category" >Category</h2>
						<div class="row row-sm item-masonry item-info-overlay">
							<template v-for="cat in (listCate)">
								<div class="col-sm-3 col-xs-6" :key="cat.id">
								<div class="item r" data-id="item-1"
									data-src="http://api.soundcloud.com/tracks/269944843/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
									<div class="item-media"><a href="#" class="item-media-content b0"
											></a>
										<div class="item-overlay center"><button class="btn-playpause">Play</button>
										</div>
									</div>
									<div class="item-info">
										<div class="item-overlay bottom text-right"><a href="#" class="btn-favorite"><i
													class="fa fa-heart-o"></i></a> <a href="#" class="btn-more"
												data-toggle="dropdown"><i class="fa fa-ellipsis-h"></i></a>
											<div class="dropdown-menu pull-right black lt"></div>
										</div>
										<div class="item-title text-ellipsis"><a :href="'/categoryDetail?id='+cat.id"
										>{{cat.name}}</a>
										</div>
									</div>
								</div>
							</div>
							</template>
							
							
						</div>
					</div>
					<div class="row-col">
						<div class="col-lg-9 b-r no-border-md">
							<div class="padding">
								<h2 class="widget-title h4 m-b">New</h2>
								<div class="row">
									<template v-for="song in newSongs">
										<div class="col-xs-4 col-sm-4 col-md-3" :key="song.id">
											<div class="item r" data-id="item-3"
												data-src="http://api.soundcloud.com/tracks/79031167/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
												<div class="item-media"><a :href="'/detail?id='+song.id"
														class="item-media-content b2"
														></a>
													<div class="item-overlay center"><button @click="play(song)"
															class="btn-playpause">Play</button></div>
												</div>
												<div class="item-info">
													<div class="item-overlay bottom text-right"><a :href="'/detail?id='+song.id"
															class="btn-favorite"><i class="fa fa-heart-o"></i></a> <a
															href="#" class="btn-more" data-toggle="dropdown"><i
																class="fa fa-ellipsis-h"></i></a>
														<div class="dropdown-menu pull-right black lt"></div>
													</div>
													<div class="item-title text-ellipsis"><a :href="'/detail?id='+song.id">{{song.name}}</a></div>
												</div>
											</div>
										</div>
									</template>
	
								</div>
								<h2 class="widget-title h4 m-b">Recommand for you</h2>
								<div class="row item-list item-list-md m-b">
									<template v-for="song in recommandSongs">
										<div class="col-sm-6" :key = song.id>
											<div class="item r" data-id="item-3"
												data-src="http://api.soundcloud.com/tracks/79031167/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
												<div class="item-media"><a href="#"
														class="item-media-content b2"
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
													<div class="item-title text-ellipsis"><a :href="'/detail?id='+song.id">{{song.name}}</a></div>
													
												</div>
											</div>
										</div>
									</template>
									
									
								</div>
							</div>
						</div>
											<div class="col-lg-3 w-xxl w-auto-md">
							<div class="padding" style="bottom: 60px" data-ui-jp="stick_in_parent">
								<h6 class="text text-muted">5 Likes</h6>
								<div class="row item-list item-list-sm m-b">
									<div class="col-xs-12">
										<div class="item r" data-id="item-3"
											data-src="http://api.soundcloud.com/tracks/79031167/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
											<div class="item-media"><a href="#"
													class="item-media-content b2"
													></a></div>
											<div class="item-info">
												<div class="item-title text-ellipsis"><a href="#">I
														Wanna Be In the Cavalry</a></div>
												<div class="item-author text-sm text-ellipsis"><a
														href="#" class="text-muted">Jeremy Scott</a>
												</div>
											</div>
										</div>
									</div>
									<div class="col-xs-12">
										<div class="item r" data-id="item-2"
											data-src="http://api.soundcloud.com/tracks/259445397/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
											<div class="item-media"><a href="#"
													class="item-media-content b1"
													></a></div>
											<div class="item-info">
												<div class="item-title text-ellipsis"><a
														href="#">Fireworks</a></div>
												<div class="item-author text-sm text-ellipsis"><a
														href="#" class="text-muted">Kygo</a></div>
											</div>
										</div>
									</div>
									<div class="col-xs-12">
										<div class="item r" data-id="item-1"
											data-src="http://api.soundcloud.com/tracks/269944843/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
											<div class="item-media"><a href="#"
													class="item-media-content b0"
													></a></div>
											<div class="item-info">
												<div class="item-title text-ellipsis"><a href="#">Pull
														Up</a></div>
												<div class="item-author text-sm text-ellipsis"><a
														href="#" class="text-muted">Summerella</a>
												</div>
											</div>
										</div>
									</div>
									<div class="col-xs-12">
										<div class="item r" data-id="item-7"
											data-src="http://api.soundcloud.com/tracks/245566366/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
											<div class="item-media"><a href="#"
													class="item-media-content b6"
													></a></div>
											<div class="item-info">
												<div class="item-title text-ellipsis"><a
														href="#">Reflection (Deluxe)</a></div>
												<div class="item-author text-sm text-ellipsis"><a
														href="#" class="text-muted">Fifth Harmony</a>
												</div>
											</div>
										</div>
									</div>
									<div class="col-xs-12">
										<div class="item r" data-id="item-6"
											data-src="http://api.soundcloud.com/tracks/236107824/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
											<div class="item-media"><a href="#"
													class="item-media-content b5"
													></a></div>
											<div class="item-info">
												<div class="item-title text-ellipsis"><a href="#">Body
														on me</a></div>
												<div class="item-author text-sm text-ellipsis"><a
														href="#" class="text-muted">Rita Ora</a></div>
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
			<div class="bottom"></div>
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
.c1{
    background-image: url('../assets/template_frontend/images/c1.jpg') !important;
}
.c2{
    background-image: url('../assets/template_frontend/images/c2.jpg') !important;
}
.c3{
    background-image: url('../assets/template_frontend/images/c3.jpg') !important;
}
.rules{
	background-image: url('../assets/template_frontend/images/b8.jpg') !important;
	width: 100%;
	height: 400px;
	color: #ffffffde;
	display: grid;
	align-items: center;
	overflow-y:auto ;
}
.rules p{
	font-size: 22px;
}
.category{
	margin-top: 30px;
}
.rules div{
	padding: 20px;
}
.bottom{
	height: 100px;
}
</style>
<script>
import axios from 'axios'
import {requestHeader,PATH} from '../index/index.js'
import EventBus from '../components/bus'
import { deleteElement, threatSongs, shuffleArray, sortNew } from "../helpers/utils";
export default {
	data(){
		return{
			newSongs:'',
			recommandSongs:'',
			listCate:''
		}
	},
	created(){
		axios.get(`${PATH}api/song/list`)
		.then(rs=>{
			this.newSongs = rs.data.listResult.sort(sortNew)
			// this.recommandSongs = shuffleArray(rs.data.listResult)
			
		})
		axios.get(`${PATH}api/song/list`)
		.then(rs=>{
			this.recommandSongs = shuffleArray(rs.data.listResult)
		})
		 axios.get(`${PATH}api/category/get`)
        .then(rs=>{
            this.listCate = rs.data
            ;
		})
		
		
  },
  methods:{
	play(song){
      EventBus.$emit('playmusicD', song)
    },
    pause(){
      EventBus.$emit('pausemusicD')
    }
  }
}
</script>