<template>
        <div id="content" class="app-content white bg box-shadow-z2" role="main">
      <div class="app-footer app-player grey bg">
        <div class="playlist" style="width:100%"></div>
      </div>
      <div class="app-body" id="view">
        <div class="page-content">
          <div class="row-col">
            <div class="col-lg-9 b-r no-border-md">
              <div class="padding">
                <div class="page-title m-b">
                  <h1 class="inline m-a-0">Artists</h1>
                  <div class="dropdown inline"><button
                      class="btn btn-sm no-bg h4 m-y-0 v-b dropdown-toggle text-primary" data-toggle="dropdown">By
                      name</button>
                    <div class="dropdown-menu"><a href="#" class="dropdown-item active">By name</a> <a href="#"
                        class="dropdown-item">Songs</a></div>
                  </div>
                </div>
                <div data-ui-jp="jscroll" data-ui-options="{
            autoTrigger: false,
            loadingHtml: '<i class=\'fa fa-refresh fa-spin text-md text-muted\'></i>',
            padding: 50,
            nextSelector: 'a.jscroll-next:last'
          }">
                  <div class="row row-lg">
                    <div class="col-xs-4 col-sm-4 col-md-3">
                      <div class="item">
                        
                        <div class="item-info text-center">
                          <div class="item-title text-ellipsis"><a href="#">OlsJesse Russell</a>
                            <div class="text-sm text-muted">23 songs</div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-3">
                      <div class="item">
                        
                        <div class="item-info text-center">
                          <div class="item-title text-ellipsis"><a href="#">Richard Carr</a>
                            <div class="text-sm text-muted">6 songs</div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-3">
                      <div class="item">
                        <div class="item-info text-center">
                          <div class="item-title text-ellipsis"><a href="#">Judy Woods</a>
                            <div class="text-sm text-muted">23 songs</div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-3">
                      <div class="item">
                        <div class="item-info text-center">
                          <div class="item-title text-ellipsis"><a href="#">Jean Schneider</a>
                            <div class="text-sm text-muted">8 songs</div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-3">
                      <div class="item">
                        <div class="item-info text-center">
                          <div class="item-title text-ellipsis"><a href="#">Melissa Garza</a>
                            <div class="text-sm text-muted">20 songs</div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-3">
                      <div class="item">
                        <div class="item-info text-center">
                          <div class="item-title text-ellipsis"><a href="#">Douglas Torres</a>
                            <div class="text-sm text-muted">20 songs</div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-3">
                      <div class="item">
                        <div class="item-info text-center">
                          <div class="item-title text-ellipsis"><a href="#">Crystal Guerrero</a>
                            <div class="text-sm text-muted">12 songs</div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-3">
                      <div class="item">
                        <div class="item-info text-center">
                          <div class="item-title text-ellipsis"><a href="#">James Garcia</a>
                            <div class="text-sm text-muted">9 songs</div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-3">
                      <div class="item">
                        <div class="item-info text-center">
                          <div class="item-title text-ellipsis"><a href="#">Sara King</a>
                            <div class="text-sm text-muted">14 songs</div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-3">
                      <div class="item">
                        <div class="item-info text-center">
                          <div class="item-title text-ellipsis"><a href="#">Joe Holmes</a>
                            <div class="text-sm text-muted">24 songs</div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-3">
                      <div class="item">
                        <div class="item-info text-center">
                          <div class="item-title text-ellipsis"><a href="#">Judith Garcia</a>
                            <div class="text-sm text-muted">13 songs</div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-3">
                      <div class="item">
                        <div class="item-info text-center">
                          <div class="item-title text-ellipsis"><a href="#">Jeremy Scott</a>
                            <div class="text-sm text-muted">14 songs</div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div><a href="scroll.author.html" class="btn btn-sm white rounded jscroll-next">Show More</a>
                </div>
              </div>
            </div>
            <!-- <div class="col-lg-3 w-xxl w-auto-md">
              <div class="padding" style="bottom: 60px" data-ui-jp="stick_in_parent">
                <h6 class="text text-muted">5 Likes</h6>
                <div class="row item-list item-list-sm m-b">
                  <div class="col-xs-12">
                    <div class="item r" data-id="item-11"
                      data-src="http://api.soundcloud.com/tracks/218060449/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                      <div class="item-media"><a href="track.detail.html" class="item-media-content b10"
                          ></a></div>
                      <div class="item-info">
                        <div class="item-title text-ellipsis"><a href="track.detail.html">Spring</a></div>
                        <div class="item-author text-sm text-ellipsis"><a href="#"
                            class="text-muted">Pablo Nouvelle</a></div>
                      </div>
                    </div>
                  </div>
                  <div class="col-xs-12">
                    <div class="item r" data-id="item-7"
                      data-src="http://api.soundcloud.com/tracks/245566366/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                      <div class="item-media"><a href="track.detail.html" class="item-media-content b6"
                          ></a></div>
                      <div class="item-info">
                        <div class="item-title text-ellipsis"><a href="track.detail.html">Reflection (Deluxe)</a></div>
                        <div class="item-author text-sm text-ellipsis"><a href="#"
                            class="text-muted">Fifth Harmony</a></div>
                      </div>
                    </div>
                  </div>
                  <div class="col-xs-12">
                    <div class="item r" data-id="item-2"
                      data-src="http://api.soundcloud.com/tracks/259445397/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                      <div class="item-media"><a href="track.detail.html" class="item-media-content b1"
                          ></a></div>
                      <div class="item-info">
                        <div class="item-title text-ellipsis"><a href="track.detail.html">Fireworks</a></div>
                        <div class="item-author text-sm text-ellipsis"><a href="#"
                            class="text-muted">Kygo</a></div>
                      </div>
                    </div>
                  </div>
                  <div class="col-xs-12">
                    <div class="item r" data-id="item-1"
                      data-src="http://api.soundcloud.com/tracks/269944843/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                      <div class="item-media"><a href="track.detail.html" class="item-media-content b0"
                          ></a></div>
                      <div class="item-info">
                        <div class="item-title text-ellipsis"><a href="track.detail.html">Pull Up</a></div>
                        <div class="item-author text-sm text-ellipsis"><a href="#"
                            class="text-muted">Summerella</a></div>
                      </div>
                    </div>
                  </div>
                  <div class="col-xs-12">
                    <div class="item r" data-id="item-10"
                      data-src="http://api.soundcloud.com/tracks/237514750/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                      <div class="item-media"><a href="track.detail.html" class="item-media-content b9"
                          ></a></div>
                      <div class="item-info">
                        <div class="item-title text-ellipsis"><a href="track.detail.html">The Open Road</a></div>
                        <div class="item-author text-sm text-ellipsis"><a href="#"
                            class="text-muted">Postiljonen</a></div>
                      </div>
                    </div>
                  </div>
                </div>
                <h6 class="text text-muted">Go mobile</h6>
                <div class="btn-groups"><a href="#" class="btn btn-sm dark lt m-r-xs" style="width: 135px"><span
                      class="pull-left m-r-sm"><i class="fa fa-apple fa-2x"></i></span> <span
                      class="clear text-left l-h-1x"><span class="text-muted text-xxs">Download on the</span> <b
                        class="block m-b-xs">App Store</b></span></a> <a href="#" class="btn btn-sm dark lt"
                    style="width: 133px"><span class="pull-left m-r-sm"><i class="fa fa-play fa-2x"></i></span> <span
                      class="clear text-left l-h-1x"><span class="text-muted text-xxs">Get it on</span> <b
                        class="block m-b-xs m-r-xs">Google Play</b></span></a></div>
                <div class="b-b m-y"></div>
                <div class="nav text-sm _600"><a href="#" class="nav-link text-muted m-r-xs">About</a> <a href="#"
                    class="nav-link text-muted m-r-xs">Contact</a> <a href="#"
                    class="nav-link text-muted m-r-xs">Legal</a> <a href="#"
                    class="nav-link text-muted m-r-xs">Policy</a></div>
                <p class="text-muted text-xs p-b-lg">&copy; Copyright 2016</p>
              </div>
            </div> -->
          </div>
        </div>
      </div>
    </div>
</template>
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
.a0{
    background-image: url('../assets/template_frontend/images/b0.jpg') !important;
}
.a1{
    background-image: url('../assets/template_frontend/images/a1.jpg') !important;
}
.a2{
    background-image: url('../assets/template_frontend/images/a2.jpg') !important;
}
.a3{
    background-image: url('../assets/template_frontend/images/a3.jpg') !important;
}
.a4{
    background-image: url('../assets/template_frontend/images/a4.jpg') !important;
}
.a5{
    background-image: url('../assets/template_frontend/images/a5.jpg') !important;
}
.a6{
    background-image: url('../assets/template_frontend/images/a6.jpg') !important;
}
.a7{
    background-image: url('../assets/template_frontend/images/a7.jpg') !important;
}
.a8{
    background-image: url('../assets/template_frontend/images/a8.jpg') !important;
}
.a9{
   background-image: url('../assets/template_frontend/images/a9.jpg') !important;
}
.rounded{
    border-radius: 500px !important;
}

</style>
<style scoped src="../assets/template_frontend/css/animate.css/animate.min.css"></style>
<style scoped src="../assets/template_frontend/css/glyphicons/glyphicons.css"></style>
<style scoped src="../assets/template_frontend/css/font-awesome/css/font-awesome.min.css"></style>
<style rel="stylesheet" scoped src="../assets/template_frontend/css/material-design-icons/material-design-icons.css"></style>
<style scoped src="../assets/template_frontend/css/bootstrap/dist/css/bootstrap.min.css"></style>
<style scoped src="../assets/template_frontend/css/styles/app.css"></style>