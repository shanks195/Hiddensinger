<template>
<div id="aside" :class="{'app-aside':true, 'modal':true, 'fade':true, 'nav-dropdown':true, 'in':res==1}">
			<div class="left navside grey dk" data-layout="column">
				<div class="navbar no-radius"><router-link  to="/" class="navbar-brand md"><svg
							xmlns="http://www.w3.org/2000/svg" viewBox="0 0 48 48" width="32" height="32">
							<circle cx="24" cy="24" r="24" fill="rgba(255,255,255,0.2)" />
							<circle cx="24" cy="24" r="22" fill="#1c202b" class="brand-color" />
							<circle cx="24" cy="24" r="10" fill="#ffffff" />
							<circle cx="13" cy="13" r="2" fill="#ffffff" class="brand-animate" />
							<path d="M 14 24 L 24 24 L 14 44 Z" fill="#FFFFFF" />
							<circle cx="24" cy="24" r="3" fill="#000000" /></svg> <img src="images/logo.png" alt="."
							class="hide"> <span class="hidden-folded inline">Hidden Singer</span></router-link></div>
				<div data-flex class="hide-scroll">
					<nav class="scroll nav-stacked nav-active-primary">
						<ul class="nav" data-ui-nav>
							<li class="nav-header hidden-folded"><span class="text-xs text-muted">Main</span></li>
							<li :class="{'active':active_tab=='discover'}" @click="active_tab='discover'"><router-link to="discover" ><span class="nav-icon"><i class="material-icons">play_circle_outline</i></span> <span
										class="nav-text">Discover</span></router-link></li>
							<li :class="{'active':active_tab=='new'}" @click="active_tab='new'"><router-link to="new" ><span class="nav-icon"><i class="material-icons">sort</i></span>
									<span class="nav-text">New</span></router-link></li>
							<li :class="{'active':active_tab=='chart'}" @click="active_tab='chart'"><router-link to="chart"><span class="nav-icon"><i
											class="material-icons">trending_up</i></span> <span
										class="nav-text">Charts</span></router-link></li>
								<!-- <li :class="{'active':active_tab=='category'}" @click="active_tab='category'"><router-link to="category"><span class="nav-icon">
									<span class="material-icons">list</span></span> <span
										class="nav-text">Category</span></router-link></li>		 -->
								<li :class="{'active':active_tab=='video'}" @click="active_tab='video'"><router-link to="video"><span class="nav-icon">
									<i class="material-icons">queue_music</i></span> <span
										class="nav-text">Videos</span></router-link></li>			
							<li :class="{'active':active_tab=='artist'}" @click="active_tab='artist'"><router-link to="artist"><span class="nav-icon"><i
											class="material-icons">portrait</i></span> <span
										class="nav-text">Artist</span></router-link></li>
							<!-- <li><a data-toggle="modal" data-target="#search-modal" @><span class="nav-icon"><i
											class="material-icons">search</i></span> <span
										class="nav-text">Search</span></a></li> -->
										<input placeholder="Search" id="search" :onkeyup="search()" v-model="searchName">
										<li class="search-div" :class="{showSearch: searchName.trim()}">
												<a v-for="list in listSearch" :key="list.id" :href="`/detail?id=`+`${list.id}`" >
													{{list.name}} - {{list.username}}
												</a>
												<a v-if="listSearch==null||listSearch==[]||listSearch==''">No search results</a>
										</li>
					
							<li class="nav-header hidden-folded m-t"><span class="text-xs text-muted">Your
									collection</span></li>
							<li :class="{'active':active_tab=='track'}" @click="active_tab='track'">
								<router-link to="profile" @click="clickProfile()">
									<span class="nav-label"><b class="label" >8</b></span>
									<span class="nav-icon"><i class="material-icons">list</i></span>
									<span class="nav-text"  @click="active='track', clickProfile()">Tracks</span>
								</router-link>
							</li>
							<li :class="{'active':active_tab=='playlist'}" @click="active_tab='playlist'">
								<router-link to="profile" @click="clickProfile()">
									<span class="nav-label"><b class="label" >8</b></span>
									<span class="nav-icon"><i class="material-icons">queue_music</i></span>
									<span class="nav-text"  @click="active='playlist', clickProfile()">Playlists</span>
								</router-link>
							</li>
							<!-- <li :class="{'active':active_tab=='playlist'}" @click="active_tab='playlist'"><router-link to="/profile" @click="clickProfile()"><span class="nav-icon"><i
											class="material-icons">queue_music</i></span> <span
										class="nav-text"  @click="active='playlist',clickProfile()">Playlists</span></router-link></li> -->
							<li :class="{'active':active_tab=='like'}" @click="active_tab='like'"><router-link to="/profile" @click="clickProfile()"><span class="nav-icon"><i
											class="material-icons">thumb_up</i></span> <span
										class="nav-text"  @click="active='like',clickProfile()">Likes</span></router-link></li>
							<li v-show="username!==null" :class="{'active':active_tab=='profile'}" @click="active_tab='profile'"><router-link to="/profile" @click="clickProfile()"><span class="nav-icon"><i
											class="material-icons">account_box</i></span> <span
										class="nav-text"  @click="active='profile',clickProfile()">Profile</span></router-link></li>
							<li v-show="username!==null" :class="{'active':active_tab=='upload'}" @click="active_tab='upload'"><router-link to="/profile" @click="clickProfile()"><span class="nav-icon"><i
											class="material-icons">backup</i></span> <span
										class="nav-text"  @click="active='upload',clickProfile()">Upload song</span></router-link></li>
							<li v-show="username!==null" :class="{'active':active_tab=='studio'}" @click="active_tab='studio'"><router-link to="/profile" @click="clickProfile()"><span class="nav-icon"><i
											class="material-icons">settings</i></span> <span
										class="nav-text"  @click="active='studio',clickProfile()">Your Studio</span></router-link></li>
							<li v-show="username!==null" ><a @click="logout" ><span class="nav-icon"> <b-icon icon="door-closed" aria-hidden="true"></b-icon></span>
								<span class="nav-text">Logout</span></a>
							</li>
						</ul>
					</nav>
				</div>
			</div>
			<div :class="{overlay:res==1}" @click="res=0">

			</div>
		</div>
</template>

<style scoped src="../assets/template_frontend/css/animate.css/animate.min.css"></style>
<style scoped src="../assets/template_frontend/css/glyphicons/glyphicons.css"></style>
<style scoped src="../assets/template_frontend/css/font-awesome/css/font-awesome.min.css"></style>
<style scoped src="../assets/template_frontend/css/material-design-icons/material-design-icons.css"></style>
<style scoped src="../assets/template_frontend/css/bootstrap/dist/css/bootstrap.min.css"></style>
<style scoped src="../assets/template_frontend/css/styles/app.css"></style>
<style scoped>
.overlay{
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	opacity: 0.5;
	background: black;

}
.nav{
  display: grid;
}
.app-aside{
	bottom: 0 !important;
}
.search-div{
	width: 100%;
	height: auto;
	overflow-y: auto;
	display: none;
	padding: 5px;
	overflow-x: auto;
}
.search-div a{
	width: 100%;
}
.search-div.showSearch{
	display: grid;
	grid-template-columns: 1fr;
	background-color: white;
	color: #363c43;
}
.in{
	display: block;
    transition: all linear 0.3s;

}
</style>
<script>
import EventBus from './bus'
import axios from "axios"
import {requestHeader,PATH} from '../index/index.js'

import {searchByNameSongg} from '../../src/assets/template_admin/list-song/ListSong.js'
export default {
    data(){
        return{
			active: '',
			active_tab:'',
			songs:'',
			searchName:'',
			listSearch:'',
			username: localStorage.username || null,
			res:0
        }
	},
	methods:{
		clickProfile(){
			EventBus.$emit('hello', this.active);
		},
		logout () {
			localStorage.removeItem('username')
			this.$router.push('/login')

		},
		search(){
			this.listSearch = searchByNameSongg(this.searchName, this.songs)
		},
		resp(){
			this.res = 1
		},
		respEnd(){
			this.res  =0
		}
	},
		created(){
		axios.get(`${PATH}api/song/list`)
		.then(rs=>{
			this.songs = rs.data.listResult
		})
		
       EventBus.$on('responsive', this.resp)

  },
}
</script>