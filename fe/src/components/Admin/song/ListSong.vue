<template>
  <div class="container-list-song">
    <div class="content mt-3">
      <div class="animated fadeIn">
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header">
                <div class="row">
                    <div class="col-sm-12 col-md-6">
                      <div
                        id="bootstrap-data-table-export_filter"
                        class="dataTables_filter"
                      >
                        <label
                          >Search:<input
                            v-on:keyup="search"
                            type="search"
                            class="form-control form-control-sm"
                            placeholder="name song"
                            aria-controls="bootstrap-data-table-export"
                        /></label>
                      </div>
                    </div>
                  </div>
              </div>
              <div class="card-body">
                <div
                  id="bootstrap-data-table-export_wrapper"
                  class="dataTables_wrapper dt-bootstrap4 no-footer"
                >
                  
                  <div class="row">
                    <div class="col-sm-12">
                      <table
                        id="bootstrap-data-table-export"
                        class="table table-striped table-bordered dataTable no-footer"
                        role="grid"
                        aria-describedby="bootstrap-data-table-export_info"
                      >
                        <thead>
                          <tr role="row">
                            <th
                              class="sorting_asc"
                              tabindex="0"
                              aria-controls="bootstrap-data-table-export"
                              rowspan="1"
                              colspan="1"
                              aria-sort="ascending"
                              aria-label="Name: activate to sort column descending"
                              style="width: 179px"
                            >
                              User's name
                            </th>
                            <th
                              class="sorting"
                              tabindex="0"
                              aria-controls="bootstrap-data-table-export"
                              rowspan="1"
                              colspan="1"
                              aria-label="Song name: activate to sort column ascending"
                              style="width: 301px"
                            >
                              Name
                            </th>
                            <th
                              class="sorting"
                              tabindex="0"
                              aria-controls="bootstrap-data-table-export"
                              rowspan="1"
                              colspan="1"
                              aria-label="Office: activate to sort column ascending"
                              style="width: 131px"
                            >
                              Category
                            </th>
                            <th
                              class="sorting"
                              tabindex="0"
                              aria-controls="bootstrap-data-table-export"
                              rowspan="1"
                              colspan="1"
                              aria-label="Salary: activate to sort column ascending"
                              style="width: 102px"
                            >
                              Views
                            </th>
                            <th
                              class="sorting"
                              tabindex="0"
                              aria-controls="bootstrap-data-table-export"
                              rowspan="1"
                              colspan="1"
                              aria-label="Salary: activate to sort column ascending"
                              style="width: 102px"
                            >
                              Acction
                            </th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr v-for="(item, index) in pageSong" v-bind:key="index" role="row" class="odd">
                            <td class="sorting_1">{{item.fullname}}</td>
                            <td>{{item.name}}</td>
                            <td>{{item.categoryName}}</td>
                            <td>{{item.view}}</td>
                            <td>
                              <button v-bind:title="index" v-on:click="playAudio"><i v-bind:title="index" v-on:click="playAudio" class="fa fa-headphones" aria-hidden="true"/></button>
                              <button v-bind:title="index" v-on:click="editSong"><i v-bind:title="index" v-on:click="editSong" class="fa fa-info-circle" aria-hidden="true"></i></button>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-12 col-md-5">
                      <div
                        class="dataTables_info"
                        id="bootstrap-data-table-export_info"
                        role="status"
                        aria-live="polite"
                      >
                        Showing {{(page-1)*limit+1}} to {{page*limit>totalSongLength?totalSongLength:page*limit}} of {{totalSongLength}} entries
                      </div>
                    </div>
                    <div class="col-sm-12 col-md-7">
                      <div
                        class="dataTables_paginate paging_simple_numbers"
                        id="bootstrap-data-table-export_paginate"
                      >
                        <ul class="pagination">
                          <li
                            class="paginate_button page-item previous disabled"
                            id="bootstrap-data-table-export_previous"
                          >
                            <a
                              href="#"
                              aria-controls="bootstrap-data-table-export"
                              data-dt-idx="0"
                              tabindex="0"
                              class="page-link"
                              >Previous</a
                            >
                          </li>
                          <li v-for="(item, index) in totalPageSong" :key="index" 
                          v-on:click="changePage"
                          class="paginate_button page-item">
                            <a
                              href="#"
                              aria-controls="bootstrap-data-table-export"
                              data-dt-idx="1"
                              tabindex="0"
                              class="page-link"
                              >{{index+1}}</a
                            >
                          </li>
                          
                          <li
                            class="paginate_button page-item next"
                            id="bootstrap-data-table-export_next"
                          >
                            <a
                              href="#"
                              aria-controls="bootstrap-data-table-export"
                              data-dt-idx="7"
                              tabindex="0"
                              class="page-link"
                              >Next</a
                            >
                          </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- .animated -->
    </div>
    <div class="detail-song__container hidden">
        <form action="" class="detail-song__form">
          <div v-on:click="closeDetail" class="form-control"><i class="fa fa-window-close" aria-hidden="true"></i></div>
          <div class="form-control"><label>URL</label><input class="form-input" type="text" v-bind:value="songDetail.url" readonly="true"/></div>
          <div class="form-control"><label>Name</label><input class="form-input" type="text" v-bind:value="songDetail.name" readonly="true"/></div>
          <div class="form-control"><label>Category</label><input class="form-input" type="text" v-bind:value="songDetail.categoryName" readonly="true"/></div>
          <div class="form-control"><label>Singer</label><input class="form-input" type="text" v-bind:value="songDetail.username" readonly="true"/></div>
          <div class="form-control" id="form-textarea"><label>Lyric</label><textarea class="form-input" v-bind:value="songDetail.lyric"></textarea></div>
          <div class="form-control"><label>Views</label><input class="form-input" type="text" v-bind:value="songDetail.view" readonly="true"/></div>         
        </form>
    </div>
    <toolbar-player v-bind:playAudio="playAudio" v-bind:song="song" />
  </div>
</template>

<script>
import axios from 'axios'
import {PATH} from '../../../index/index.js'
import { getListSong, getArrPageAble, searchByNameSong } from "../../../assets/template_admin/list-song/ListSong.js";
import ToolBar from '../../ToolBar.vue';
import toolbarPlayer from '../../ToolbarPlayer.vue'
export default {
    components:{
      toolbarPlayer
    },
    data() {
        return {
            pageSong:[],
            page:1,
            limit:2,
            totalPageSong:0,
            totalSongLength:0,
            allSongs:[],
            song:{},
            songDetail:{},
            index:10
        };
    },
    created() {
      axios.get(`${PATH}api/song/list?page=${this.page}&&limit=${this.limit}`)
      .then(response => {
        this.pageSong = response.data.listResult;
        this.totalPageSong = response.data.totalPage;
      })
      .catch(e => {
        this.errors.push(e)
      })
      axios.get(`${PATH}api/song/list`)
      .then(response => {
        this.allSongs = response.data.listResult;
        this.totalSongLength = this.allSongs.length;
      })
      .catch(e => {
        this.errors.push(e)
      })
    },
    mounted() {
      
    },
    methods:{
      closeDetail(event){
        event.preventDefault();
        event.stopPropagation();
        const containerDetail = document.querySelector('.detail-song__container');
        containerDetail.classList.add('hidden');
        this.songDetail={};
      },
      editSong(event){
        event.preventDefault();
        event.stopPropagation();
        const containerDetail = document.querySelector('.detail-song__container');
        containerDetail.classList.remove('hidden');
        this.songDetail=this.allSongs[Number(event.target.title)];
      },
      playAudio(event){
        event.stopPropagation();
        event.preventDefault();
        this.song = this.allSongs[event.target.title];
      },
      pauseAudio(event){
        const audio = event.target.parentElement.querySelector('audio');
        audio.controls;
        audio.pause();
      },
      changePage(event){
        this.page = event.target.innerText;
        this.pageSong = getArrPageAble(this.page,this.limit,this.AllSongs)
      },
      search(){
        const pageSongPresent = getArrPageAble(this.page,this.limit,this.allSongs)
        const search = document.querySelector('[type="search"]');
        this.pageSong = searchByNameSong(search.value,pageSongPresent,this.allSongs);
      }
    }
};
</script>
<style scoped src= "../../../assets/template_admin/vendors/bootstrap/dist/css/bootstrap.min.css"></style>
<style scoped src= "../../../assets/template_admin/vendors/font-awesome/css/font-awesome.min.css"></style>
<style scoped src= "../../../assets/template_admin/vendors/themify-icons/css/themify-icons.css"></style>
<style scoped src= "../../../assets/template_admin/vendors/flag-icon-css/css/flag-icon.min.css"></style>
<style scoped src= "../../../assets/template_admin/vendors/selectFX/css/cs-skin-elastic.css"></style>
<style scoped src= "../../../assets/template_admin/vendors/datatables.net-bs4/css/dataTables.bootstrap4.min.css"></style>

<style lang="css" scoped>
.container-list-song {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  position: relative;
}
.search-list-song {
  height: 70px;
  background-color: bisque;
}
.list-song__bottom {
  height: 100%;
  display: flex;
  flex-direction: column;
}
.list-song {
  height: 75vh;
}
.page-list {
  height: 50px;
}
.content.mt-3{
  height: 100%;
}
.animated.fadeIn, .card, #bootstrap-data-table-export_wrapper,.animated.fadeIn>div{
  height: 100%;
}
#bootstrap-data-table-export_wrapper{
  display: flex;
  flex-direction: column;
  position: relative;
  justify-content: space-between;
}
#bootstrap-data-table-export_wrapper>.row{
  margin: 0;
  margin-bottom: 50px;
  padding: 0;
}
#bootstrap-data-table-export_wrapper>.row:nth-child(2){
  height: 50px;
}
button{
  width: 50px;
  height: 30px;
  background-image: linear-gradient(to right,#272c33,#3b3a3a);
  border: 0;
  transition: 0.3s;
  box-shadow: 1px 2px 2px 2px #888888;
  box-sizing: border-box;
}
button>i{
  color: white;
  transition: 0.3s;
}
button:hover{
  opacity: 0.7;
}
button:hover>i{
  opacity: 0.7;
}
.card-body{
  overflow-y: auto;
}
.detail-song__container{
  position: absolute;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 999;
}
.detail-song__container.hidden{
  display: none !important;
}
.detail-song__form{
  display: flex;
  flex-direction: column;
  width: 700px;
  height: 500px;
  justify-content: space-around;
  box-shadow: 2px 2px 2px 2px #3b3a3a;
}
.detail-song__form>.form-control{
  border-radius: 0;
  flex-basis: 50px;
  flex-shrink: 1;
  display: flex;
  justify-content: space-between;
}
.detail-song__form>.form-control:nth-child(1){
  background-color: transparent;
  border: none;
  flex-basis: 0;
  padding: 0;
  position: relative;
  transition: 0.3s;
}
.detail-song__form>.form-control:nth-child(1)>i{
  position: absolute;
  bottom: 0;
  right: 0;
  font-size: 30px;
}
.detail-song__form>.form-control:nth-child(1):hover{
  opacity: 0.7;
}
.detail-song__form>.form-control:nth-child(6){
  overflow-y:auto;
  flex-shrink: 0;
  flex-basis: 300px;
}
.form-input{
  width: 600px;
}
textarea{
  resize: none;
}
</style>