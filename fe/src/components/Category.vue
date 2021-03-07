<template>
            <div id="content" class="app-content white bg box-shadow-z2" role="main">
            <div class="app-header hidden-lg-up white lt box-shadow-z1">
                <div class="navbar"><a href="index-2.html" class="navbar-brand md"><svg
                            xmlns="http://www.w3.org/2000/svg" viewBox="0 0 48 48" width="32" height="32">
                            <circle cx="24" cy="24" r="24" fill="rgba(255,255,255,0.2)" />
                            <circle cx="24" cy="24" r="22" fill="#1c202b" class="brand-color" />
                            <circle cx="24" cy="24" r="10" fill="#ffffff" />
                            <circle cx="13" cy="13" r="2" fill="#ffffff" class="brand-animate" />
                            <path d="M 14 24 L 24 24 L 14 44 Z" fill="#FFFFFF" />
                            <circle cx="24" cy="24" r="3" fill="#000000" /></svg> <img src="images/logo.png" alt="."
                            class="hide"> <span class="hidden-folded inline">pulse</span></a>
                    <ul class="nav navbar-nav pull-right">
                        <li class="nav-item"><a data-toggle="modal" data-target="#aside" class="nav-link"><i
                                    class="material-icons">menu</i></a></li>
                    </ul>
                </div>
            </div>
            <!-- <div class="app-footer app-player grey bg">
                <div class="playlist" style="width:100%"></div>
            </div> -->
            <div class="app-body" id="view">
                <div class="pos-rlt">
                    <div class="page-bg" data-stellar-ratio="2" style="background-image: url('images/b0.jpg')"></div>
                </div>
                <!-- {{idCate}}
                {{detailCate[1]}} -->
                <template v-for="cate in nameCate">
                    <div class="page-content" :key="cate">
                    <div class="padding b-b">
                        <div class="row-col">
                            <div class="col-sm">
                                <div class="p-l-md no-padding-xs">
                                    <div class="page-title">
                                        <h1 class="inline">{{cate}}</h1>
                                    </div>
                                    <p class="item-desc text-ellipsis text-muted" data-ui-toggle-class="text-ellipsis">
                                        </p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row-col">
                        <div class="col-lg-9 b-r no-border-md">
                            <div class="padding">
                                <div id="tracks" class="row item-list item-list-xs item-list-li m-b">
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-10"
                                            data-src="http://api.soundcloud.com/tracks/237514750/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="#"
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
                                                <div class="item-title text-ellipsis"><a href="#">The
                                                        Open Road</a></div>
                                                <div class="item-author text-sm text-ellipsis hide"><a
                                                        href="artist.detail.html" class="text-muted">Postiljonen</a>
                                                </div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-right">5:20</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-8"
                                            data-src="http://api.soundcloud.com/tracks/236288744/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="#"
                                                    class="item-media-content"
                                                    style="background-image: url('images/b7.jpg')"></a>
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
                                                <div class="item-title text-ellipsis"><a href="#">Simple
                                                        Place To Be</a></div>
                                                <div class="item-author text-sm text-ellipsis hide"><a
                                                        href="artist.detail.html" class="text-muted">RYD</a></div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-right">4:20</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-7"
                                            data-src="http://api.soundcloud.com/tracks/245566366/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="#"
                                                    class="item-media-content"
                                                    style="background-image: url('images/b6.jpg')"></a>
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
                                                        href="#">Reflection (Deluxe)</a></div>
                                                <div class="item-author text-sm text-ellipsis hide"><a
                                                        href="artist.detail.html" class="text-muted">Fifth Harmony</a>
                                                </div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-right">5:05</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-3"
                                            data-src="http://api.soundcloud.com/tracks/79031167/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="#"
                                                    class="item-media-content"
                                                    style="background-image: url('images/b2.jpg')"></a>
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
                                                <div class="item-title text-ellipsis"><a href="#">I
                                                        Wanna Be In the Cavalry</a></div>
                                                <div class="item-author text-sm text-ellipsis hide"><a
                                                        href="artist.detail.html" class="text-muted">Jeremy Scott</a>
                                                </div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-right">2:50</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-11"
                                            data-src="http://api.soundcloud.com/tracks/218060449/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="#"
                                                    class="item-media-content"
                                                    style="background-image: url('images/b10.jpg')"></a>
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
                                                        href="#">Spring</a></div>
                                                <div class="item-author text-sm text-ellipsis hide"><a
                                                        href="artist.detail.html" class="text-muted">Pablo Nouvelle</a>
                                                </div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-right">3:10</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-6"
                                            data-src="http://api.soundcloud.com/tracks/236107824/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="#"
                                                    class="item-media-content"
                                                    style="background-image: url('images/b5.jpg')"></a>
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
                                                <div class="item-title text-ellipsis"><a href="#">Body
                                                        on me</a></div>
                                                <div class="item-author text-sm text-ellipsis hide"><a
                                                        href="artist.detail.html" class="text-muted">Rita Ora</a></div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-right">3:55</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-1"
                                            data-src="http://api.soundcloud.com/tracks/269944843/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="#"
                                                    class="item-media-content"
                                                    style="background-image: url('images/b0.jpg')"></a>
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
                                                <div class="item-title text-ellipsis"><a href="#">Pull
                                                        Up</a></div>
                                                <div class="item-author text-sm text-ellipsis hide"><a
                                                        href="artist.detail.html" class="text-muted">Summerella</a>
                                                </div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-right">2:50</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-12"
                                            data-src="http://api.soundcloud.com/tracks/174495152/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="#"
                                                    class="item-media-content"
                                                    style="background-image: url('images/b11.jpg')"></a>
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
                                                <div class="item-title text-ellipsis"><a href="#">Happy
                                                        ending</a></div>
                                                <div class="item-author text-sm text-ellipsis hide"><a
                                                        href="artist.detail.html" class="text-muted">Postiljonen</a>
                                                </div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-right">5:20</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-5"
                                            data-src="http://streaming.radionomy.com/JamendoLounge">
                                            <div class="item-media"><a href="#"
                                                    class="item-media-content"
                                                    style="background-image: url('images/b4.jpg')"></a>
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
                                                <div class="item-title text-ellipsis"><a href="#">Live
                                                        Radio</a></div>
                                                <div class="item-author text-sm text-ellipsis hide"><a
                                                        href="artist.detail.html" class="text-muted">Radionomy</a></div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-right">3:35</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="item r" data-id="item-4"
                                            data-src="http://api.soundcloud.com/tracks/230791292/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                            <div class="item-media"><a href="#"
                                                    class="item-media-content"
                                                    style="background-image: url('images/b3.jpg')"></a>
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
                                                <div class="item-title text-ellipsis"><a href="#">What A
                                                        Time To Be Alive</a></div>
                                                <div class="item-author text-sm text-ellipsis hide"><a
                                                        href="artist.detail.html" class="text-muted">Judith Garcia</a>
                                                </div>
                                                <div class="item-meta text-sm text-muted"><span
                                                        class="item-meta-right">6:00</span></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </template>
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
.item.r{
    height: 50px;
}
</style>
<script>
import {PATH} from '../index/index.js'
import axios from 'axios'
import {requestHeader} from '../index/index.js'
export default {
    data(){
        return{
        songs: '',
        nameCate:[],
        idCate:[],
        listCate:'',
        detailCate:[]
        }
  },
      created(){
        axios.get(`${PATH}api/category/get`)
        .then(rs=>{
            this.listCate = rs.data
            this.listCate.forEach(element => {
                this.nameCate.push(element.name)    
            });
        })
        axios.get(`${PATH}api/category/get`)
        .then(rs=>{
            this.listCate = rs.data
            this.listCate.forEach(element => {
            this.idCate.push(element.id)
        })
        for(let i = 0; i< this.idCate.length; i++){
             axios.get(`${PATH}api/song/list?categoryid=${this.idCate[i]}`)
                    .then(rs=>{
                        this.detailCate.push(rs.data.listResult)
                        console.log(`${PATH}api/song/list?categoryid=${this.idCate[i]}`)
                    })
        }
        }) 
  }
}
</script>