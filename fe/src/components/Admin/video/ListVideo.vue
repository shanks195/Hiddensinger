<template>
  <div class="container-list-video">
    <div class="content mt-3">
      <div class="animated fadeIn">
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header">
               
                <strong class="card-title">List Video</strong>
                 <div class="created">
                     <div class="Create">
                        <label  for="mv-hot" class="overlay" >
                            <h3>CREATE</h3>
                        </label>

                        <div class="check_created">
                            <input id="mv-hot" type="checkbox" name="create" hidden>
                            <div for="mv-hot" class="overlay-mv" >
                                    <div>
                                    <label for="mv-hot"> 
                                        <svg  aria-hidden="true" focusable="false" data-prefix="fas" data-icon="times" class="svg-inline--fa fa-times fa-w-11" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 352 512"><path fill="currentColor" d="M242.72 256l100.07-100.07c12.28-12.28 12.28-32.19 0-44.48l-22.24-22.24c-12.28-12.28-32.19-12.28-44.48 0L176 189.28 75.93 89.21c-12.28-12.28-32.19-12.28-44.48 0L9.21 111.45c-12.28 12.28-12.28 32.19 0 44.48L109.28 256 9.21 356.07c-12.28 12.28-12.28 32.19 0 44.48l22.24 22.24c12.28 12.28 32.2 12.28 44.48 0L176 322.72l100.07 100.07c12.28 12.28 32.2 12.28 44.48 0l22.24-22.24c12.28-12.28 12.28-32.19 0-44.48L242.72 256z"></path></svg>
                                    </label>
                                    <div class="video" >
                                        <form>
                                            <div class="information_video">
                                              <div class="i_video">
                                                <h3>Add Video</h3>
                                                <label class="input_doc">Name</label><br><input type="text" name="name" v-model="tableVideo.name" placeholder="name"><br>
                                                <label class="input_doc">url </label><br><input type="text" name="url" v-model="tableVideo.url" placeholder="url"><br>
                                                  
                                              </div>
                                              

                                            </div>
                                            <button  @click="postData"  type="submit" class="btn btn-primary">Add Video Now</button>`
                                        </form>
                                    </div>
                                    
                                    </div>
                            </div>
                        </div>
          
                     </div>

                </div>
              </div>
              
            </div>
          </div>
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
                            placeholder="name video"
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
                              class="sorting"
                              tabindex="0"
                              aria-controls="bootstrap-data-table-export"
                              rowspan="1"
                              colspan="1"
                              aria-label="Salary: activate to sort column ascending"
                              style="width: 102px"
                            >
                              NAME
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
                              CREATE DATE
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
                              CREATED BY
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
                             MODIFIED BY
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
                             MODIFIED DATE
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
                            URL
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
                              actions
                            </th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr v-for="(item, index) in pageVideo" v-bind:key="index" role="row" class="odd">
                            <td class="sorting_1">{{item.name}}</td>
                            <td>{{item.createDate}}</td>
                            <td>{{item.createdBy}}</td>
                             <td>{{item.modifiedBy}}</td>
                             <td>{{item.modifiedDate}}</td>
                            
                            <td>{{item.url}}</td>
                            <td><button  v-bind:title="index" @click="playdetail(item.url)" :id="item.id" ><i class="fa fa-headphones" aria-hidden="true"/></button>
                            <button v-bind:title="index" @click="editVideo"><i v-bind:title="index" v-on:click="editVideo" class="fa fa-info-circle" aria-hidden="true"></i></button>
                            <button @click="deleteData(item.id)"><i class="fa fa-trash"  aria-hidden="true"></i>
</button ></td>
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
                        Showing {{(page-1)*limit+1}} to {{page*limit>totalVideoLength?totalVideoLength:page*limit}} of {{totalVideoLength}} entries
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
                          <li v-for="(item, index) in totalPageVideo" :key="index" 
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
    <div class="detail-video__container hidden">
        <form action="" class="detail-video__form">
          <div v-on:click="closeDetail" class="form-control"><i class="fa fa-window-close" aria-hidden="true"></i></div>
          <h3>Information</h3>
          <div class="form-control"><label>createDate</label><input class="form-input" type="text" v-bind:value="videoDetail.createDate" readonly="true"/></div>
          <div class="form-control"><label>createdBy</label><input class="form-input" type="text" v-bind:value="videoDetail.createdBy" readonly="true"/></div>
          <div class="form-control"><label>modifiedBy</label><input class="form-input" type="text" v-bind:value="videoDetail.modifiedBy" readonly="true"/></div>
          <div class="form-control"><label>modifiedDate</label><input class="form-input" type="text" v-bind:value="videoDetail.modifiedDate" readonly="true"/></div>

          <div class="form-control"><label>URL</label><input class="form-input" type="text" v-bind:value="videoDetail.url" readonly="true"/></div>
          <div class="form-control"><label>Name</label><input class="form-input" type="text" v-bind:value="videoDetail.name" readonly="true"/></div>
          <button type="submit" class="update">Update</button>
          </form>
    </div>
    <div class="detail-video hidden">
        <div v-on:click="closeDetailone" class="form-control"><i class="fa fa-window-close" aria-hidden="true"></i></div>
          <div class="play-video">
            <iframe width="100%" height="100%" :src="url" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>            
        </div>
        <!-- {{this.video[0]}} -->
        </div>
    </div>
</template>

<script>
import {PATH} from '../../../index/index.js'
import VueCoreVideoPlayer from 'vue-core-video-player'
import Vue from 'vue'
Vue.use(VueCoreVideoPlayer)
import { getListVideo, getArrPageAble, searchByNameVideo } from "../../../assets/template_admin/list-video/ListVideo.js";
import axios from 'axios'

export default {
    components:{
    },
    data() {
        return {
            page:1,
            limit:2,
            index:10,
            totalPageVideo:0,
            totalVideoLength:0,
            videoDetail:{},
            video:{},
            allVideos:[],
            tableVideo:{
                "modified_date":'',
                "created_by":'',
                "create_date":'',
                "username": '',
                "name": '',
                "url": ''
            },
            page:1,
            limit:10,
            pageVideo:{},
            url: ''
            
        };
    },
   
    mounted() {
      this.getData();
    },
    methods: {
    removeElement: function (index) {
    this.items.splice(index, 1);
      },
      playdetail(url){
       
        const containerDetail = document.querySelector('.detail-video');
        containerDetail.classList.remove('hidden');
        
        this.url =url
       
      },
       playAudio(event){
        event.stopPropagation();
        event.preventDefault();
        
      },
      pauseAudio(event){
        const audio = event.target.parentElement.querySelector('audio');
        audio.controls;
        audio.pause();
      },
      changePage(event){
        this.page = event.target.innerText;
        this.pageVideo = getArrPageAble(this.page,this.limit,this.AllSongs)
      },
      search(){
        const pageVideoPresent = getArrPageAble(this.page,this.limit,this.allVideos);
        const search = document.querySelector('[type="search"]');
        this.pageVideo = searchByNameVideo(search.value,pageVideoPresent,this.allVideos);
      },
      closeDetailone(event){
        event.preventDefault();
        event.stopPropagation();
        const containerDetail = document.querySelector('.detail-video');
        containerDetail.classList.add('hidden');
        
      },
     closeDetail(event){
        event.preventDefault();
        event.stopPropagation();
        const containerDetail = document.querySelector('.detail-video__container');
        containerDetail.classList.add('hidden');
        this.VideoDetail={};
      },
      editVideo(event){
        event.preventDefault();
        event.stopPropagation();
        const containerDetail = document.querySelector('.detail-video__container');
        containerDetail.classList.remove('hidden');
        this.videoDetail=this.allVideos[Number(event.target.title)];
      }, 
      
      getData(){
        var data = this.tableVideo;
        data.username= localStorage.getItem('username');
          axios.get(`${PATH}api/video/list?page=${this.page}&&limit=${this.limit}`,{
          headers: {
          'Content-Type':'application/json',
          'Authorization': `Bearer ${localStorage.getItem('accessToken')}` 
          }
          }).then(response => {      
            this.pageVideo = response.data.listResult;
            
            this.totalPageVideo = response.data.totalPage;        
          })
          .catch(e => {
          })
            axios.get(`${PATH}api/video/list`,{
          headers: {
          'Content-Type':'application/json',
          'Authorization': `Bearer ${localStorage.getItem('accessToken')}`} 
          })
          .then(response => {    
            this.allVideos = response.data.listResult;
            this.totalVideoLength = this.allVideos.length; 
            this.video =this.allVideos;
              

                
          })
          .catch(e => {
            
          })
      },
      
    postData(){
    var data = this.tableVideo;
    this.username= localStorage.getItem('username');
     axios.post(`${PATH}api/video`,data,{
        headers: {
        'Authorization': `Bearer ${localStorage.getItem("accessToken")}`
        }
        })
      .then(response => {
        this.tableVideo = response.data
      })
      .catch(e => {
        
      })
        e.preventDefault();
    },
deleteData(id){
        axios.delete(`${PATH}api/video/`+id,{
          headers: {
            'Authorization':`Bearer ${localStorage.getItem("accessToken")}`
          }
        })
        .then(() =>{
         
          this.getData();
        
        })
        
      }
    },
    
};
</script>
<style scoped src= "../../../assets/template_admin/vendors/bootstrap/dist/css/bootstrap.min.css"></style>
<style scoped src= "../../../assets/template_admin/vendors/font-awesome/css/font-awesome.min.css"></style>
<style scoped src= "../../../assets/template_admin/vendors/themify-icons/css/themify-icons.css"></style>
<style scoped src= "../../../assets/template_admin/vendors/flag-icon-css/css/flag-icon.min.css"></style>
<style scoped src= "../../../assets/template_admin/vendors/selectFX/css/cs-skin-elastic.css"></style>
<style scoped src= "../../../assets/template_admin/vendors/datatables.net-bs4/css/dataTables.bootstrap4.min.css"></style>

<style lang="css" scoped>
button.btn.btn-primary[data-v-3f589aee] {
    width: 12%;
    position: absolute;
    top: 73%;
    left: 21%;
    background: #007bff;
}
.update {
  background:#007bff ;
  width: 20%;
}
.container-list-video {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
}

.information_video {
    grid-template-columns: 1fr 0fr;
    display: grid;
    column-gap: 20px;
}
.information_video .submit {
  background:red;
}
.upload_file .image {
    width: 100%;
    background: red;
    display: inline-block;
    height: 71%;
}

.upload_file button {
    width: 100%;
    padding: 3%;
    background: orange;
    color: white;
}


input[type="text"]:focus {
    outline-color:white;
}
.i_video h3 {
    color: white;
}
.i_video input[type="text"] {
  outline-color:green;
    width: 100%;
    height: 40%;
    padding: 0% 2%;
    margin-top: 2%;
}
.upload_file .image {
    width: 100%;
    background: red;
    display: inline-block;
    height: 125%;
}

.upload_file button {
    width: 100%;
    padding: 3%;
    background: orange;
    color: white;
}
.search-list-video {
  height: 70px;
  background-color: bisque;
}
.list-video__bottom {
  height: 100%;
  display: flex;
  flex-direction: column;
  background-color: blueviolet;
}
.list-video {
  height: 75vh;
  background-color: turquoise;
}
.video {
    height:500px;
    border: 1px solid #3bebeb;
    margin: 2% 20%;
    
}
button.btn.btn-primary {
   width: 8%;
    position: absolute;
    top: 65%;
    left: 21%;
    background: #007bff;
}
.page-list {
  height: 50px;
  background-color: white;
}
/* -----------------start overlay mv--------------- */
.overlay-mv{
  position: fixed;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  background: #435c70;
  z-index: 3;
  transform: translateY(100%);
  transition: all linear 0.3s;
}
#mv-hot:checked ~ .overlay-mv{
  transform: translateY(0%) !important;

}
.overlay-mv svg{
  width: 25px;
  height: 25px;
}
/* -----------------end overlay mv--------------- */
/* .video {
    display: grid;
    gap: 1rem;
    grid-template-columns: 1fr 1fr;
} */
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
 .i_video label.input_doc {
    margin-top: 2%;
    font-size: 22px;
    color: white;
}
label.overlay {
    border: 1px solid #1111;
    display: inline-block;
    padding: 10px;
    border-radius: 12px;
    margin-top: 20px;
    background: palevioletred;
}

label.overlay h3 {
  color:white;
    font-size: 18px;
}

strong.card-title {
    font-size: 30px;
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
.detail-video {
  margin-bottom: 2%;
  background: white;
  position: absolute;
  width: 100%;
  height:100%;
  display: grid;
  z-index:999;
}
.detail-video.hidden {
   display: none !important;
}
.detail-video__container{
  background-color:#ebebeb;
  position: absolute;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 999;
}
.detail-video__container.hidden{
  display: none !important;
}
.detail-video__form{
  display: flex;
  flex-direction: column;
  width: 700px;
  height: 500px;
  justify-content: space-around;
  box-shadow: 2px 2px 2px 2px #3b3a3a;
}
.detail-video__form>.form-control{
  border-radius: 0;
  flex-basis: 50px;
  flex-shrink: 1;
  display: flex;
  justify-content: space-between;
}
.detail-video__form>.form-control:nth-child(1){
  background-color: transparent;
  border: none;
  flex-basis: 0;
  padding: 0;
  position: relative;
  transition: 0.3s;
}
.detail-video__form>.form-control:nth-child(1)>i{
  position: absolute;
  bottom: 0;
  right: 0;
  font-size: 30px;
}
.detail-video__form>.form-control:nth-child(1):hover{
  opacity: 0.7;
}
.detail-video__form>.form-control:nth-child(6){
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
