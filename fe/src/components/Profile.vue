<template>
            <div id="content" class="app-content white bg box-shadow-z2" role="main">
           
            <div class="app-body" id="view">
                <!-- <div class="page-bg a3" data-stellar-ratio="2"></div> -->
                <div class="page-content">
                    <div class="padding b-b">
                        <div class="row-col">
                            <div class="col-sm w w-auto-xs m-b">
                                <div class="item w rounded">
                                    <div class="item-media">
                                        <div class="item-media-content a3">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm">
                                <div class="p-l-md no-padding-xs">
                                    <h1 class="page-title" v-show="username!==null"><span class="h1 _800">{{username}}</span></h1>
                                    <p class="page-title" v-show="username==null"><span class="h1 _800">Please register for an account for a better experience</span>
                                        <br><a href="/register">Register</a><a href="/login"> / Login</a>
                                    </p>
                                    <!-- <p class="item-desc text-ellipsis text-muted" data-ui-toggle-class="text-ellipsis">
                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quamquam tu hanc
                                        copiosiorem etiam soles dicere. Nihil illinc huc pervenit. Verum hoc idem saepe
                                        faciamus. Quid ad utilitatem tantae pecuniae? Utram tandem linguam nescio? Sed
                                        hoc sane concedamus.</p>
                                    <div class="block clearfix m-b"><span>9</span> <span
                                            class="text-muted">Albums</span>, <span>23</span> <span
                                            class="text-muted">Tracks</span></div> -->
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row-col">
                        <div class="col-lg-9 b-r no-border-md">
                            <div class="padding p-y-0 m-b-md">
                                <div class="nav-active-border b-primary bottom m-b-md m-t">
                                    <ul class="nav l-h-2x" data-ui-jp="taburl">
                                         <li class="nav-item m-r inline"><a :class="{'nav-link':true, 'active':active=='track'}" @click="active='track'"
                                                data-toggle="tab" data-target="#track">Tracks</a></li>
                                        <li class="nav-item m-r inline"><a :class="{'nav-link':true, 'active':active=='playlist'}"  data-toggle="tab" @click="active='playlist'"
                                                data-target="#playlist">Playlists</a></li>
                                        <li class="nav-item m-r inline"><a :class="{'nav-link':true, 'active':active=='like'}"  data-toggle="tab" @click="active='like'"
                                                data-target="#like">Likes</a></li>
                                        <li class="nav-item m-r inline" v-show="username!==null"><a :class="{'nav-link':true, 'active':active=='profile'}"  data-toggle="tab" @click="active='profile'"
                                                data-target="#profile">Profile</a></li>
                                        <li class="nav-item m-r inline" v-show="username!==null"><a :class="{'nav-link':true, 'active':active=='upload'}"  data-toggle="tab" @click="active='upload'"
                                                data-target="#profile">Upload song</a></li>
                                        <li class="nav-item m-r inline" v-show="username!==null"><a :class="{'nav-link':true, 'active':active=='studio'}"  data-toggle="tab" @click="active='studio'"
                                                data-target="#profile">Your Studio</a></li>
                                    </ul>
                                </div>
                                <div class="tab-content">
                                    <div :class="{'tab-pane':true, 'active':this.active=='track'}" id="track">
                                        <div class="row item-list item-list-by m-b">
                                            <div class="col-xs-12">
                                                <div class="item r" data-id="item-7"
                                                    data-src="http://api.soundcloud.com/tracks/245566366/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                                    <div class="item-media"><a href="track.detail.html"
                                                            class="item-media-content b6"
                                                            ></a>
                                                        <div class="item-overlay center"><button
                                                                class="btn-playpause">Play</button></div>
                                                    </div>
                                                    <div class="item-info">
                                                        <div class="item-overlay bottom text-right"><a href="#"
                                                                class="btn-favorite"><i class="fa fa-heart-o"></i></a>
                                                            <a href="#" class="btn-more" data-toggle="dropdown"><i
                                                                    class="fa fa-ellipsis-h"></i></a>
                                                            <div class="dropdown-menu pull-right black lt"></div>
                                                        </div>
                                                        <div class="item-title text-ellipsis"><a
                                                                href="track.detail.html">Reflection (Deluxe)</a></div>
                                                        <div class="item-author text-sm text-ellipsis hide"><a
                                                                href="artist.detail.html" class="text-muted">Fifth
                                                                Harmony</a></div>
                                                        <div class="item-meta text-sm text-muted"><span
                                                                class="item-meta-category"><a href="browse.html"
                                                                    class="label">Pop</a></span> <span
                                                                class="item-meta-date text-xs">05.05.2016</span></div>
                                                        <div
                                                            class="item-except visible-list text-sm text-muted h-2x m-t-sm">
                                                            Quid ad utilitatem tantae pecuniae? Utram tandem linguam
                                                            nescio? Sed hoc sane concedamus.</div>
                                                        <div class="item-action visible-list m-t-sm"><a href="#"
                                                                class="btn btn-xs white">Edit</a> <a href="#"
                                                                class="btn btn-xs white" data-toggle="modal"
                                                                data-target="#delete-modal">Delete</a></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="item r" data-id="item-11"
                                                    data-src="http://api.soundcloud.com/tracks/218060449/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                                    <div class="item-media"><a href="track.detail.html"
                                                            class="item-media-content b10"
                                                            ></a>
                                                        <div class="item-overlay center"><button
                                                                class="btn-playpause">Play</button></div>
                                                    </div>
                                                    <div class="item-info">
                                                        <div class="item-overlay bottom text-right"><a href="#"
                                                                class="btn-favorite"><i class="fa fa-heart-o"></i></a>
                                                            <a href="#" class="btn-more" data-toggle="dropdown"><i
                                                                    class="fa fa-ellipsis-h"></i></a>
                                                            <div class="dropdown-menu pull-right black lt"></div>
                                                        </div>
                                                        <div class="item-title text-ellipsis"><a
                                                                href="track.detail.html">Spring</a></div>
                                                        <div class="item-author text-sm text-ellipsis hide"><a
                                                                href="artist.detail.html" class="text-muted">Pablo
                                                                Nouvelle</a></div>
                                                        <div class="item-meta text-sm text-muted"><span
                                                                class="item-meta-category"><a href="browse.html"
                                                                    class="label">Indie</a></span> <span
                                                                class="item-meta-date text-xs">09.03.2016</span></div>
                                                        <div
                                                            class="item-except visible-list text-sm text-muted h-2x m-t-sm">
                                                            Saepe faciamus. Quid ad utilitatem tantae pecuniae? Utram
                                                            tandem linguam nescio? Sed hoc sane concedamus.</div>
                                                        <div class="item-action visible-list m-t-sm"><a href="#"
                                                                class="btn btn-xs white">Edit</a> <a href="#"
                                                                class="btn btn-xs white" data-toggle="modal"
                                                                data-target="#delete-modal">Delete</a></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="item r" data-id="item-3"
                                                    data-src="http://api.soundcloud.com/tracks/79031167/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                                    <div class="item-media"><a href="track.detail.html"
                                                            class="item-media-content b2"
                                                            ></a>
                                                        <div class="item-overlay center"><button
                                                                class="btn-playpause">Play</button></div>
                                                    </div>
                                                    <div class="item-info">
                                                        <div class="item-overlay bottom text-right"><a href="#"
                                                                class="btn-favorite"><i class="fa fa-heart-o"></i></a>
                                                            <a href="#" class="btn-more" data-toggle="dropdown"><i
                                                                    class="fa fa-ellipsis-h"></i></a>
                                                            <div class="dropdown-menu pull-right black lt"></div>
                                                        </div>
                                                        <div class="item-title text-ellipsis"><a
                                                                href="track.detail.html">I Wanna Be In the Cavalry</a>
                                                        </div>
                                                        <div class="item-author text-sm text-ellipsis hide"><a
                                                                href="artist.detail.html" class="text-muted">Jeremy
                                                                Scott</a></div>
                                                        <div class="item-meta text-sm text-muted"><span
                                                                class="item-meta-category"><a href="browse.html"
                                                                    class="label">DJ</a></span> <span
                                                                class="item-meta-date text-xs">09.04.2016</span></div>
                                                        <div
                                                            class="item-except visible-list text-sm text-muted h-2x m-t-sm">
                                                            Tantae pecuniae? Utram tandem linguam nescio? Sed hoc sane
                                                            concedamus.</div>
                                                        <div class="item-action visible-list m-t-sm"><a href="#"
                                                                class="btn btn-xs white">Edit</a> <a href="#"
                                                                class="btn btn-xs white" data-toggle="modal"
                                                                data-target="#delete-modal">Delete</a></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="item r" data-id="item-1"
                                                    data-src="http://api.soundcloud.com/tracks/269944843/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                                    <div class="item-media"><a href="track.detail.html"
                                                            class="item-media-content b0"
                                                            ></a>
                                                        <div class="item-overlay center"><button
                                                                class="btn-playpause">Play</button></div>
                                                    </div>
                                                    <div class="item-info">
                                                        <div class="item-overlay bottom text-right"><a href="#"
                                                                class="btn-favorite"><i class="fa fa-heart-o"></i></a>
                                                            <a href="#" class="btn-more" data-toggle="dropdown"><i
                                                                    class="fa fa-ellipsis-h"></i></a>
                                                            <div class="dropdown-menu pull-right black lt"></div>
                                                        </div>
                                                        <div class="item-title text-ellipsis"><a
                                                                href="track.detail.html">Pull Up</a></div>
                                                        <div class="item-author text-sm text-ellipsis hide"><a
                                                                href="artist.detail.html"
                                                                class="text-muted">Summerella</a></div>
                                                        <div class="item-meta text-sm text-muted"><span
                                                                class="item-meta-category"><a href="browse.html"
                                                                    class="label">Blue</a></span> <span
                                                                class="item-meta-date text-xs">30.05.2016</span></div>
                                                        <div
                                                            class="item-except visible-list text-sm text-muted h-2x m-t-sm">
                                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                                                            Quamquam tu hanc copiosiorem etiam soles dicere. Nihil
                                                            illinc huc pervenit.</div>
                                                        <div class="item-action visible-list m-t-sm"><a href="#"
                                                                class="btn btn-xs white">Edit</a> <a href="#"
                                                                class="btn btn-xs white" data-toggle="modal"
                                                                data-target="#delete-modal">Delete</a></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="item r" data-id="item-9"
                                                    data-src="http://api.soundcloud.com/tracks/264094434/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                                    <div class="item-media"><a href="track.detail.html"
                                                            class="item-media-content b8"
                                                            ></a>
                                                        <div class="item-overlay center"><button
                                                                class="btn-playpause">Play</button></div>
                                                    </div>
                                                    <div class="item-info">
                                                        <div class="item-overlay bottom text-right"><a href="#"
                                                                class="btn-favorite"><i class="fa fa-heart-o"></i></a>
                                                            <a href="#" class="btn-more" data-toggle="dropdown"><i
                                                                    class="fa fa-ellipsis-h"></i></a>
                                                            <div class="dropdown-menu pull-right black lt"></div>
                                                        </div>
                                                        <div class="item-title text-ellipsis"><a
                                                                href="track.detail.html">All I Need</a></div>
                                                        <div class="item-author text-sm text-ellipsis hide"><a
                                                                href="artist.detail.html" class="text-muted">Pablo
                                                                Nouvelle</a></div>
                                                        <div class="item-meta text-sm text-muted"><span
                                                                class="item-meta-category"><a href="browse.html"
                                                                    class="label">Jazz</a></span> <span
                                                                class="item-meta-date text-xs">02.04.2016</span></div>
                                                        <div
                                                            class="item-except visible-list text-sm text-muted h-2x m-t-sm">
                                                            Tandem linguam nescio? Sed hoc sane concedamus.</div>
                                                        <div class="item-action visible-list m-t-sm"><a href="#"
                                                                class="btn btn-xs white">Edit</a> <a href="#"
                                                                class="btn btn-xs white" data-toggle="modal"
                                                                data-target="#delete-modal">Delete</a></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="item r" data-id="item-6"
                                                    data-src="http://api.soundcloud.com/tracks/236107824/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                                    <div class="item-media"><a href="track.detail.html"
                                                            class="item-media-content b5"
                                                            ></a>
                                                        <div class="item-overlay center"><button
                                                                class="btn-playpause">Play</button></div>
                                                    </div>
                                                    <div class="item-info">
                                                        <div class="item-overlay bottom text-right"><a href="#"
                                                                class="btn-favorite"><i class="fa fa-heart-o"></i></a>
                                                            <a href="#" class="btn-more" data-toggle="dropdown"><i
                                                                    class="fa fa-ellipsis-h"></i></a>
                                                            <div class="dropdown-menu pull-right black lt"></div>
                                                        </div>
                                                        <div class="item-title text-ellipsis"><a
                                                                href="track.detail.html">Body on me</a></div>
                                                        <div class="item-author text-sm text-ellipsis hide"><a
                                                                href="artist.detail.html" class="text-muted">Rita
                                                                Ora</a></div>
                                                        <div class="item-meta text-sm text-muted"><span
                                                                class="item-meta-category"><a href="browse.html"
                                                                    class="label">Nature</a></span> <span
                                                                class="item-meta-date text-xs">09.04.2016</span></div>
                                                        <div
                                                            class="item-except visible-list text-sm text-muted h-2x m-t-sm">
                                                            Tantae pecuniae? Utram tandem linguam nescio? Sed hoc sane
                                                            concedamus.</div>
                                                        <div class="item-action visible-list m-t-sm"><a href="#"
                                                                class="btn btn-xs white">Edit</a> <a href="#"
                                                                class="btn btn-xs white" data-toggle="modal"
                                                                data-target="#delete-modal">Delete</a></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="item r" data-id="item-4"
                                                    data-src="http://api.soundcloud.com/tracks/230791292/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                                    <div class="item-media"><a href="track.detail.html"
                                                            class="item-media-content b3"
                                                            ></a>
                                                        <div class="item-overlay center"><button
                                                                class="btn-playpause">Play</button></div>
                                                    </div>
                                                    <div class="item-info">
                                                        <div class="item-overlay bottom text-right"><a href="#"
                                                                class="btn-favorite"><i class="fa fa-heart-o"></i></a>
                                                            <a href="#" class="btn-more" data-toggle="dropdown"><i
                                                                    class="fa fa-ellipsis-h"></i></a>
                                                            <div class="dropdown-menu pull-right black lt"></div>
                                                        </div>
                                                        <div class="item-title text-ellipsis"><a
                                                                href="track.detail.html">What A Time To Be Alive</a>
                                                        </div>
                                                        <div class="item-author text-sm text-ellipsis hide"><a
                                                                href="artist.detail.html" class="text-muted">Judith
                                                                Garcia</a></div>
                                                        <div class="item-meta text-sm text-muted"><span
                                                                class="item-meta-category"><a href="browse.html"
                                                                    class="label">Electro</a></span> <span
                                                                class="item-meta-date text-xs">04.05.2016</span></div>
                                                        <div
                                                            class="item-except visible-list text-sm text-muted h-2x m-t-sm">
                                                            Verum hoc idem saepe faciamus inguam nescio? Sed hoc sane
                                                            concedamus.</div>
                                                        <div class="item-action visible-list m-t-sm"><a href="#"
                                                                class="btn btn-xs white">Edit</a> <a href="#"
                                                                class="btn btn-xs white" data-toggle="modal"
                                                                data-target="#delete-modal">Delete</a></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="item r" data-id="item-12"
                                                    data-src="http://api.soundcloud.com/tracks/174495152/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                                    <div class="item-media"><a href="track.detail.html"
                                                            class="item-media-content b11"
                                                            ></a>
                                                        <div class="item-overlay center"><button
                                                                class="btn-playpause">Play</button></div>
                                                    </div>
                                                    <div class="item-info">
                                                        <div class="item-overlay bottom text-right"><a href="#"
                                                                class="btn-favorite"><i class="fa fa-heart-o"></i></a>
                                                            <a href="#" class="btn-more" data-toggle="dropdown"><i
                                                                    class="fa fa-ellipsis-h"></i></a>
                                                            <div class="dropdown-menu pull-right black lt"></div>
                                                        </div>
                                                        <div class="item-title text-ellipsis"><a
                                                                href="track.detail.html">Happy ending</a></div>
                                                        <div class="item-author text-sm text-ellipsis hide"><a
                                                                href="artist.detail.html"
                                                                class="text-muted">Postiljonen</a></div>
                                                        <div class="item-meta text-sm text-muted"><span
                                                                class="item-meta-category"><a href="browse.html"
                                                                    class="label">Latin</a></span> <span
                                                                class="item-meta-date text-xs">09.06.2016</span></div>
                                                        <div
                                                            class="item-except visible-list text-sm text-muted h-2x m-t-sm">
                                                            Utilitatem tantae pecuniae? Utram tandem linguam nescio? Sed
                                                            hoc sane concedamus.</div>
                                                        <div class="item-action visible-list m-t-sm"><a href="#"
                                                                class="btn btn-xs white">Edit</a> <a href="#"
                                                                class="btn btn-xs white" data-toggle="modal"
                                                                data-target="#delete-modal">Delete</a></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="item r" data-id="item-8"
                                                    data-src="http://api.soundcloud.com/tracks/236288744/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                                    <div class="item-media"><a href="track.detail.html"
                                                            class="item-media-content b7"
                                                            ></a>
                                                        <div class="item-overlay center"><button
                                                                class="btn-playpause">Play</button></div>
                                                    </div>
                                                    <div class="item-info">
                                                        <div class="item-overlay bottom text-right"><a href="#"
                                                                class="btn-favorite"><i class="fa fa-heart-o"></i></a>
                                                            <a href="#" class="btn-more" data-toggle="dropdown"><i
                                                                    class="fa fa-ellipsis-h"></i></a>
                                                            <div class="dropdown-menu pull-right black lt"></div>
                                                        </div>
                                                        <div class="item-title text-ellipsis"><a
                                                                href="track.detail.html">Simple Place To Be</a></div>
                                                        <div class="item-author text-sm text-ellipsis hide"><a
                                                                href="artist.detail.html" class="text-muted">RYD</a>
                                                        </div>
                                                        <div class="item-meta text-sm text-muted"><span
                                                                class="item-meta-category"><a href="browse.html"
                                                                    class="label">Radio</a></span> <span
                                                                class="item-meta-date text-xs">09.04.2016</span></div>
                                                        <div
                                                            class="item-except visible-list text-sm text-muted h-2x m-t-sm">
                                                            Ad utilitatem tantae pecuniae? Utram tandem linguam nescio?
                                                            Sed hoc sane concedamus.</div>
                                                        <div class="item-action visible-list m-t-sm"><a href="#"
                                                                class="btn btn-xs white">Edit</a> <a href="#"
                                                                class="btn btn-xs white" data-toggle="modal"
                                                                data-target="#delete-modal">Delete</a></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="item r" data-id="item-5"
                                                    data-src="http://streaming.radionomy.com/JamendoLounge">
                                                    <div class="item-media"><a href="track.detail.html"
                                                            class="item-media-content b4"
                                                            ></a>
                                                        <div class="item-overlay center"><button
                                                                class="btn-playpause">Play</button></div>
                                                    </div>
                                                    <div class="item-info">
                                                        <div class="item-overlay bottom text-right"><a href="#"
                                                                class="btn-favorite"><i class="fa fa-heart-o"></i></a>
                                                            <a href="#" class="btn-more" data-toggle="dropdown"><i
                                                                    class="fa fa-ellipsis-h"></i></a>
                                                            <div class="dropdown-menu pull-right black lt"></div>
                                                        </div>
                                                        <div class="item-title text-ellipsis"><a
                                                                href="track.detail.html">Live Radio</a></div>
                                                        <div class="item-author text-sm text-ellipsis hide"><a
                                                                href="artist.detail.html"
                                                                class="text-muted">Radionomy</a></div>
                                                        <div class="item-meta text-sm text-muted"><span
                                                                class="item-meta-category"><a href="browse.html"
                                                                    class="label">Electro</a></span> <span
                                                                class="item-meta-date text-xs">09.05.2016</span></div>
                                                        <div
                                                            class="item-except visible-list text-sm text-muted h-2x m-t-sm">
                                                            Verum hoc idem saepe faciamus. Quid ad utilitatem tantae
                                                            pecuniae? Utram tandem linguam nescio? Sed hoc sane
                                                            concedamus.</div>
                                                        <div class="item-action visible-list m-t-sm"><a href="#"
                                                                class="btn btn-xs white">Edit</a> <a href="#"
                                                                class="btn btn-xs white" data-toggle="modal"
                                                                data-target="#delete-modal">Delete</a></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="item r" data-id="item-2"
                                                    data-src="http://api.soundcloud.com/tracks/259445397/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                                    <div class="item-media"><a href="track.detail.html"
                                                            class="item-media-content b1"
                                                            ></a>
                                                        <div class="item-overlay center"><button
                                                                class="btn-playpause">Play</button></div>
                                                    </div>
                                                    <div class="item-info">
                                                        <div class="item-overlay bottom text-right"><a href="#"
                                                                class="btn-favorite"><i class="fa fa-heart-o"></i></a>
                                                            <a href="#" class="btn-more" data-toggle="dropdown"><i
                                                                    class="fa fa-ellipsis-h"></i></a>
                                                            <div class="dropdown-menu pull-right black lt"></div>
                                                        </div>
                                                        <div class="item-title text-ellipsis"><a
                                                                href="track.detail.html">Fireworks</a></div>
                                                        <div class="item-author text-sm text-ellipsis hide"><a
                                                                href="artist.detail.html" class="text-muted">Kygo</a>
                                                        </div>
                                                        <div class="item-meta text-sm text-muted"><span
                                                                class="item-meta-category"><a href="browse.html"
                                                                    class="label">Jazz</a></span> <span
                                                                class="item-meta-date text-xs">02.05.2016</span></div>
                                                        <div
                                                            class="item-except visible-list text-sm text-muted h-2x m-t-sm">
                                                            Hidem saepe faciamus. Quid ad utilitatem tantae pecuniae?
                                                            Utram tandem linguam nescio? Sed hoc sane concedamus.</div>
                                                        <div class="item-action visible-list m-t-sm"><a href="#"
                                                                class="btn btn-xs white">Edit</a> <a href="#"
                                                                class="btn btn-xs white" data-toggle="modal"
                                                                data-target="#delete-modal">Delete</a></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="item r" data-id="item-10"
                                                    data-src="http://api.soundcloud.com/tracks/237514750/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                                    <div class="item-media"><a href="track.detail.html"
                                                            class="item-media-content b9"
                                                            ></a>
                                                        <div class="item-overlay center"><button
                                                                class="btn-playpause">Play</button></div>
                                                    </div>
                                                    <div class="item-info">
                                                        <div class="item-overlay bottom text-right"><a href="#"
                                                                class="btn-favorite"><i class="fa fa-heart-o"></i></a>
                                                            <a href="#" class="btn-more" data-toggle="dropdown"><i
                                                                    class="fa fa-ellipsis-h"></i></a>
                                                            <div class="dropdown-menu pull-right black lt"></div>
                                                        </div>
                                                        <div class="item-title text-ellipsis"><a
                                                                href="track.detail.html">The Open Road</a></div>
                                                        <div class="item-author text-sm text-ellipsis hide"><a
                                                                href="artist.detail.html"
                                                                class="text-muted">Postiljonen</a></div>
                                                        <div class="item-meta text-sm text-muted"><span
                                                                class="item-meta-category"><a href="browse.html"
                                                                    class="label">Soul</a></span> <span
                                                                class="item-meta-date text-xs">02.04.2016</span></div>
                                                        <div
                                                            class="item-except visible-list text-sm text-muted h-2x m-t-sm">
                                                            Litatem tantae pecuniae? Utram tandem linguam nescio? Sed
                                                            hoc sane concedamus.</div>
                                                        <div class="item-action visible-list m-t-sm"><a href="#"
                                                                class="btn btn-xs white">Edit</a> <a href="#"
                                                                class="btn btn-xs white" data-toggle="modal"
                                                                data-target="#delete-modal">Delete</a></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div><a href="#" class="btn btn-sm white rounded">Show More</a>
                                    </div>
                                    <div :class="{'tab-pane':true, 'active':this.active=='playlist'}" id="playlist">
                                        <div class="row m-b">
                                            <template v-for="song in songs">
                                                <div class="col-xs-4 col-sm-4 col-md-3" :key="song.id">
                                                    <div class="item r" data-id="item-8"
                                                        data-src="http://api.soundcloud.com/tracks/236288744/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                                        <div class="item-media"><a href="track.detail.html"
                                                                class="item-media-content b7"
                                                                ></a>
                                                            <div class="item-overlay center"><button
                                                                    class="btn-playpause">Play</button></div>
                                                        </div>
                                                        <div class="item-info">
                                                            <div class="item-overlay bottom text-right"><a href="#"
                                                                    class="btn-favorite"><i class="fa fa-heart-o"></i></a>
                                                                <a href="#" class="btn-more" data-toggle="dropdown"><i
                                                                        class="fa fa-ellipsis-h"></i></a>
                                                                <div class="dropdown-menu pull-right black lt"></div>
                                                            </div>
                                                            <div class="item-title text-ellipsis"><a
                                                                    href="#">{{song.name}}</a></div>
                                                            <!-- <div class="item-author text-sm text-ellipsis hide"><a
                                                                    href="artist.detail.html" class="text-muted">RYD</a>
                                                            </div> -->
                                                            <div class="item-meta text-sm text-muted"><span
                                                                    class="item-meta-stats text-xs"><i
                                                                        class="fa fa-play text-muted"></i> 400 <i
                                                                        class="fa fa-heart m-l-sm text-muted"></i>
                                                                    220</span></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </template>
                                            <!-- <div class="col-xs-4 col-sm-4 col-md-3">
                                                <div class="item r" data-id="item-12"
                                                    data-src="http://api.soundcloud.com/tracks/174495152/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                                    <div class="item-media"><a href="track.detail.html"
                                                            class="item-media-content b11"
                                                            ></a>
                                                        <div class="item-overlay center"><button
                                                                class="btn-playpause">Play</button></div>
                                                    </div>
                                                    <div class="item-info">
                                                        <div class="item-overlay bottom text-right"><a href="#"
                                                                class="btn-favorite"><i class="fa fa-heart-o"></i></a>
                                                            <a href="#" class="btn-more" data-toggle="dropdown"><i
                                                                    class="fa fa-ellipsis-h"></i></a>
                                                            <div class="dropdown-menu pull-right black lt"></div>
                                                        </div>
                                                        <div class="item-title text-ellipsis"><a
                                                                href="track.detail.html">Happy ending</a></div>
                                                        <div class="item-author text-sm text-ellipsis hide"><a
                                                                href="artist.detail.html"
                                                                class="text-muted">Postiljonen</a></div>
                                                        <div class="item-meta text-sm text-muted"><span
                                                                class="item-meta-stats text-xs"><i
                                                                    class="fa fa-play text-muted"></i> 860 <i
                                                                    class="fa fa-heart m-l-sm text-muted"></i>
                                                                240</span></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-4 col-sm-4 col-md-3">
                                                <div class="item r" data-id="item-6"
                                                    data-src="http://api.soundcloud.com/tracks/236107824/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                                    <div class="item-media"><a href="track.detail.html"
                                                            class="item-media-content b5"
                                                            ></a>
                                                        <div class="item-overlay center"><button
                                                                class="btn-playpause">Play</button></div>
                                                    </div>
                                                    <div class="item-info">
                                                        <div class="item-overlay bottom text-right"><a href="#"
                                                                class="btn-favorite"><i class="fa fa-heart-o"></i></a>
                                                            <a href="#" class="btn-more" data-toggle="dropdown"><i
                                                                    class="fa fa-ellipsis-h"></i></a>
                                                            <div class="dropdown-menu pull-right black lt"></div>
                                                        </div>
                                                        <div class="item-title text-ellipsis"><a
                                                                href="track.detail.html">Body on me</a></div>
                                                        <div class="item-author text-sm text-ellipsis hide"><a
                                                                href="artist.detail.html" class="text-muted">Rita
                                                                Ora</a></div>
                                                        <div class="item-meta text-sm text-muted"><span
                                                                class="item-meta-stats text-xs"><i
                                                                    class="fa fa-play text-muted"></i> 330 <i
                                                                    class="fa fa-heart m-l-sm text-muted"></i>
                                                                220</span></div>
                                                    </div>
                                                </div>
                                            </div> -->
                                        </div>
                                    </div>
                                    <div :class="{'tab-pane':true, 'active':this.active=='like'}" id="like">
                                        <div class="row m-b">
                                            <div class="col-xs-4 col-sm-4 col-md-3">
                                                <div class="item r" data-id="item-6"
                                                    data-src="http://api.soundcloud.com/tracks/236107824/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                                    <div class="item-media"><a href="track.detail.html"
                                                            class="item-media-content b5"
                                                            ></a>
                                                        <div class="item-overlay center"><button
                                                                class="btn-playpause">Play</button></div>
                                                    </div>
                                                    <div class="item-info">
                                                        <div class="item-overlay bottom text-right"><a href="#"
                                                                class="btn-favorite"><i class="fa fa-heart-o"></i></a>
                                                            <a href="#" class="btn-more" data-toggle="dropdown"><i
                                                                    class="fa fa-ellipsis-h"></i></a>
                                                            <div class="dropdown-menu pull-right black lt"></div>
                                                        </div>
                                                        <div class="item-title text-ellipsis"><a
                                                                href="track.detail.html">Body on me</a></div>
                                                        <div class="item-author text-sm text-ellipsis hide"><a
                                                                href="artist.detail.html" class="text-muted">Rita
                                                                Ora</a></div>
                                                        <div class="item-meta text-sm text-muted"><span
                                                                class="item-meta-stats text-xs"><i
                                                                    class="fa fa-play text-muted"></i> 330 <i
                                                                    class="fa fa-heart m-l-sm text-muted"></i>
                                                                220</span></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-4 col-sm-4 col-md-3">
                                                <div class="item r" data-id="item-12"
                                                    data-src="http://api.soundcloud.com/tracks/174495152/stream?client_id=a10d44d431ad52868f1bce6d36f5234c">
                                                    <div class="item-media"><a href="track.detail.html"
                                                            class="item-media-content b11"
                                                            ></a>
                                                        <div class="item-overlay center"><button
                                                                class="btn-playpause">Play</button></div>
                                                    </div>
                                                    <div class="item-info">
                                                        <div class="item-overlay bottom text-right"><a href="#"
                                                                class="btn-favorite"><i class="fa fa-heart-o"></i></a>
                                                            <a href="#" class="btn-more" data-toggle="dropdown"><i
                                                                    class="fa fa-ellipsis-h"></i></a>
                                                            <div class="dropdown-menu pull-right black lt"></div>
                                                        </div>
                                                        <div class="item-title text-ellipsis"><a
                                                                href="track.detail.html">Happy ending</a></div>
                                                        <div class="item-author text-sm text-ellipsis hide"><a
                                                                href="artist.detail.html"
                                                                class="text-muted">Postiljonen</a></div>
                                                        <div class="item-meta text-sm text-muted"><span
                                                                class="item-meta-stats text-xs"><i
                                                                    class="fa fa-play text-muted"></i> 860 <i
                                                                    class="fa fa-heart m-l-sm text-muted"></i>
                                                                240</span></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div v-show="username!==null" :class="{'tab-pane':true, 'active':this.active=='profile'}" id="profile">
                                            <MyAccount/>
                                    </div>
                                    <div v-show="username!==null" :class="{'tab-pane':true, 'active':this.active=='upload'}" id="upload">
                                            <UploadSong/>
                                    </div>
                                    <div v-show="username!==null" :class="{'tab-pane':true, 'active':this.active=='studio'}" id="studio">
                                            <MyStudio :key="$route.path"/>
                                    </div>
                                </div>
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
.a3{
    background-image: url('../assets/template_frontend/images/a3.jpg') !important;
}
.item-media {
    border-radius: 500px !important;
}
</style>
<script>

import MyStudio from '../components/MyStudio.vue'
import UploadSong from '../components/Admin/song/UploadSong.vue'
import EventBus from '../components/bus'
import {requestHeader,PATH} from '../index/index.js'
import axios from "axios"
import MyAccount from '../views/MyAccount.vue'
export default {
    components:{
        UploadSong,
        MyStudio,
        MyAccount
    },
    data(){
        return{
            username: localStorage.username || null,
            active:'track',
            myPlaylist:'',
            idMyPlaylist:[],
            songs:'',
        }
    },
    methods:{
        play(song){
            EventBus.$emit('playmusicP', song)
        },
        pause(){
            EventBus.$emit('pausemusicP')
        }
        ,
        handler(e){
            this.active = e
        },
       
       
    },
    created(){
        EventBus.$on('hello', this.handler);
        
        axios.get(`${PATH}api/playlist?username=${window.localStorage.getItem('username')}`,{
            headers:{
            'Content-Type': 'application/json',
            'Authorization':`Bearer ${localStorage.getItem('accessToken')}`
          }
        })
        .then(rs=>{
            this.myPlaylist = rs.data
            this.myPlaylist.forEach(element => {
                this.idMyPlaylist.push(element.id)
            });
        })

        axios.get(`${PATH}api/song/list`)
            .then(rs=>{
                this.songs = rs.data.listResult
                this.songs = this.songs.filter(e=>
                    this.idMyPlaylist.indexOf(e.id) > -1
                )
                })
        }
    
  
    
}
</script>
