<template>
  <div class="detail-song">
    <div class="wrapper">
      <div class="player">
        <div class="player__top">
          <div class="player-cover">
            <div class="player-cover__item">
              <img src="../../assets/images/music.jpg" alt="" />
            </div>
          </div>
          <div class="player-controls">
            <div
              v-if="checkAuth()"
              class="player-controls__item -add"
              :class="{ active: added }"
              v-on:click="add"
            >
              <i class="fa fa-plus" aria-hidden="true"></i>
            </div>
            <div
              v-if="checkAuth()"
              class="player-controls__item -like"
              :class="{ active: liked }"
              v-on:click="like"
            >
              <font-awesome-icon :icon="['fas', 'thumbs-up']" />
            </div>
            <div
              v-if="checkAuth()"
              class="player-controls__item -dislike"
              :class="{ active: disliked }"
              v-on:click="dislike"
            >
              <font-awesome-icon :icon="['fas', 'thumbs-down']" />
            </div>
            <div class="player-controls__item" @click="prevTrack">
              <font-awesome-icon :icon="['fas', 'step-backward']" />
            </div>
            <div class="player-controls__item" @click="nextTrack">
              <font-awesome-icon :icon="['fas', 'step-forward']" />
            </div>
            <div class="player-controls__item -xl js-play" @click="play">
              <div class="icon">
                <font-awesome-icon
                  :icon="['fas', 'pause']"
                  v-if="isTimerPlaying"
                />
                <font-awesome-icon :icon="['fas', 'play']" v-else />
              </div>
            </div>
          </div>
        </div>
        <div class="progress" ref="progress">
          <div class="progress__top">
            <div class="album-info" v-if="currentTrack">
              <div class="album-info__name">
                {{ currentTrack.username ? currentTrack.username : "Unknow" }}
              </div>
              <div class="album-info__track">{{ currentTrack.name }}</div>
            </div>
            <div class="progress__duration">{{ duration }}</div>
          </div>
          <div class="progress__bar" @click="clickProgress">
            <div class="progress__current" :style="{ width: barWidth }"></div>
          </div>
          <div class="progress__time">{{ currentTime }}</div>
        </div>
        <div v-cloak></div>
      </div>
      <div id="playlist-container" class="player">
        <h2>Playlist</h2>
        <div class="playlist-song">
          <div class="song-container">
            <div
              class="song"
              v-for="(song, index) in playlist"
              v-bind:key="index"
              :class="{ active: song.id == currentTrack.id }"
            >
              <p v-on:click="onClickSong(song)">{{ song.name }}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="player">
      <h2>Lyric</h2>
      <div class="lyric-container">
        <div class="lyric-container__header"></div>
        <div class="lyric-container__footer">
          <textarea
            cols="30"
            rows="10"
            placeholder="Waiting for updates"
            readonly="true"
            v-model="currentTrack.lyric"
          >
          </textarea>
        </div>
      </div>
    </div>
    <div class="player">
      <h2>Comment</h2>
      <div class="comment-container">
        <div
          class="comment-list"
          v-if="commentSong != null && commentSong.length > 0"
        >
          <div
            class="comment-item"
            v-for="item in commentSong"
            v-bind:key="item.id"
            :class="{ right: item.username == username }"
          >
            <div class="comment-item__container">
              <div class="user-info">
                <img
                  class="icon-user"
                  src="../../assets/images/user-icon.jpg"
                  alt=""
                />
                <div class="user-info__item">
                  <h3>{{ item.username }}</h3>
                </div>
              </div>
              <div class="user-comment__content">
                {{ item.content }}
              </div>
            </div>
          </div>
        </div>
        <div class="comment-content">
          <textarea
            class="comment"
            rows="5"
            cols="20"
            wrap="hard"
            placeholder="Comment...."
            v-model="comment"
          >
          </textarea>
          <div class="comment-button">
            <div class="button-comment" :class="{ show: comment }">
              <button @click="submitComment" class="button-submit">
                Submit-comment
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { requestHeader, PATH } from "../../index/index.js";
import {
  postRating,
  getListRating,
  deleteArrRating,
  checkButtonComment,
  postComment,
  postSongToPlaylist,
  deletePlaylistByUsernameAndSongId,
} from "../../assets/web/song_detail/detail.js";
import axios from "axios";
import A1 from "../../assets/template_music/music/A1.mp3";
import A2 from "../../assets/template_music/music/A2.mp3";
import switchButton from "../../components/switch-button.vue";
export default {
  components: { switchButton },
  props: {},
  name: "DetailSong",
  data() {
    return {
      audio: new Audio(),
      circleLeft: null,
      barWidth: null,
      duration: null,
      currentTime: null,
      isTimerPlaying: false,
      currentTrack: {},
      currentTrackIndex: 0,
      transitionName: null,
      listRating: null,
      added: false,
      liked: false,
      disliked: false,
      comment: "",
      commentSong: null,
      username: this.checkAuth(),
      playlist: [],
    };
  },
  created() {
    let vm = this;
    const cre = function() {
      vm.setPlaylist();
      var songId = window.location.search
        .replace("?", "")
        .split("&")[0]
        .split("=")[1];
      let username = window.localStorage.getItem("username");
      if (songId) {
        vm.setSong(songId);
        vm.getComment(songId);
      }
      if (username) {
        vm.setListRatings();
      }
    }();
    this.addSongToPlaylist();
  },
  mounted() {
    checkButtonComment();
  },
  methods: {
    addSongToPlaylist(){
      let check = true;
      for(let i = 0; i<this.playlist.length;i++){
        if(this.currentTrack.id == song.id){
          check = false;
        }
      }
      if(check){
        this.playlist.unshift(this.currentTrack);
      }
      this.checkAdded();
    },
    checkAdded() {
      for (let i = 0; i < this.playlist.length; i++) {
        if (this.currentTrack.id == this.playlist[i].id) {
          this.added = true;
        } else {
          this.added = false;
        }
      }
    },
    getComment(songId) {
      fetch(`${PATH}api/comment?songid=${songId}`, requestHeader())
        .then((response) => {
          return response.json();
        })
        .then((response) => {
          this.commentSong = response;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    setSong(songId) {
      fetch(`${PATH}api/song/detail?id=${songId}`)
        .then((response) => {
          return response.json();
        })
        .then((response) => {
          this.currentTrack = response;
          this.autoPlayAudio();
        });
    },
    setListRatings() {
      let username = this.checkAuth();
      fetch(
        `${PATH}api/rating?username=${username}`,
        requestHeader()
      )
        .then((response) => {
          return response.json();
        })
        .then((response) => {
          this.listRating = response;
          this.checkRating(this.currentTrack);
        });
    },
    setPlaylist() {
      var username = this.checkAuth();
      if (username) {
        fetch(`${PATH}api/playlist?username=${username}`, requestHeader())
          .then((response) => {
            return response.json();
          })
          .then((response) => {
            this.playlist.push(...response.songs);
          });
      }
    },
    submitComment(event) {
      event.preventDefault();
      if (this.comment.trim()) {
        let comment = {};
        comment.songId = window.location.search
          .replace("?", "")
          .split("&")[0]
          .split("=")[1];
        comment.username = this.checkAuth();
        comment.content = this.comment;
        postComment(comment);
        this.comment = "";
        this.commentSong.unshift(comment);
      }
    },
    checkAuth() {
      return window.localStorage.getItem("username");
    },
    autoPlayAudio() {
      let vm = this;
      this.audio.src = this.currentTrack.url;
      this.checkRating(this.currentTrack);
      this.audio.ontimeupdate = function () {
        vm.generateTime();
      };
      this.audio.onloadedmetadata = function () {
        vm.generateTime();
      };
      this.audio.onended = function () {
        vm.nextTrack();
        vm.isTimerPlaying = true;
      };
    },
    checkRating(song) {
      this.liked=false;
      this.disliked=false;
      if (this.listRating != null) {
        const list = this.listRating;
        for (let i = 0; i < list.length; i++) {
          if (song.id == list[i].songId) {
            this.liked = false;
            this.disliked = false;
            if (list[i].subRating == "like") {
              this.liked = true;
            } else if (list[i].subRating == "dislike") {
              this.disliked = true;
            }
            break;
          }
        }
      }
    },
    onClickSong(song) {
      this.currentTrack = song;
      this.autoPlayAudio();
    },
    play() {
      if (this.audio.paused) {
        this.audio.play();
        this.isTimerPlaying = true;
      } else {
        this.audio.pause();
        this.isTimerPlaying = false;
      }
    },
    generateTime() {
      let width = (100 / this.audio.duration) * this.audio.currentTime;
      this.barWidth = width + "%";
      this.circleLeft = width + "%";
      let durmin = Math.floor(this.audio.duration / 60);
      let dursec = Math.floor(this.audio.duration - durmin * 60);
      if (durmin < 10) {
        durmin = "0" + durmin;
      }
      if (dursec < 10) {
        dursec = "0" + dursec;
      }
      let curmin = Math.floor(this.audio.currentTime / 60);
      let cursec = Math.floor(this.audio.currentTime - curmin * 60);
      if (curmin < 10) {
        curmin = "0" + curmin;
      }
      if (cursec < 10) {
        cursec = "0" + cursec;
      }
      this.duration = durmin + ":" + dursec;
      this.currentTime = curmin + ":" + cursec;
    },
    updateBar(x) {
      let progress = this.$refs.progress;
      let maxduration = this.audio.duration;
      let position = x - progress.offsetLeft;
      let percentage = (100 * position) / progress.offsetWidth;
      if (percentage > 100) {
        percentage = 100;
      }
      if (percentage < 0) {
        percentage = 0;
      }
      this.barWidth = percentage + "%";
      this.circleLeft = percentage + "%";
      this.audio.currentTime = (maxduration * percentage) / 100;
      this.audio.play();
    },
    clickProgress(e) {
      this.isTimerPlaying = true;
      this.audio.pause();
      this.updateBar(e.pageX);
    },
    prevTrack() {
      this.transitionName = "scale-in";
      if (this.currentTrackIndex > 0) {
        this.currentTrackIndex--;
      } else {
        this.currentTrackIndex = this.playlist.length - 1;
      }
      this.currentTrack = this.playlist[this.currentTrackIndex];
      this.resetPlayer();
    },
    nextTrack() {
      this.transitionName = "scale-out";
      if (this.currentTrackIndex < this.playlist.length - 1) {
        this.currentTrackIndex++;
      } else {
        this.currentTrackIndex = 0;
      }
      this.currentTrack = this.playlist[this.currentTrackIndex];
      this.resetPlayer();
    },
    resetPlayer() {
      this.barWidth = 0;
      this.circleLeft = 0;
      this.audio.currentTime = 0;
      this.audio.src = this.currentTrack.url;
      setTimeout(() => {
        if (this.isTimerPlaying) {
          this.audio.play();
        } else {
          this.audio.pause();
        }
      }, 300);
    },
    like() {
      if (this.checkAuth()) {
        this.liked = !this.liked;
        if (!this.liked && !this.disliked) {
          const list = Array.from(this.listRating);
          for (let i = 0; i < list.length; i++) {
            if (this.currentTrack.id == list[i].songId) {
              deleteArrRating(list[i].id);
              this.listRating.splice(i, 1);
            }
          }
        } else if (this.liked) {
          this.disliked = false;
          var rating = {};
          rating.subRating = "like";
          rating.username = this.checkAuth();
          rating.songId = this.currentTrack.id;
          postRating(rating);
          this.setListRatings();
          this.checkRating(this.currentTrack);
        }
      }
    },
    dislike() {
      if (this.checkAuth()) {
        this.disliked = !this.disliked;
        if (!this.disliked && !this.liked) {
          const list = Array.from(this.listRating);
          for (let i = 0; i < list.length; i++) {
            if (this.currentTrack.id == list[i].songId) {
              deleteArrRating(list[i].id);
              this.listRating.splice(i, 1);
            }
          }
        } else if (this.disliked) {
          this.liked = false;
          var rating = {};
          rating.subRating = "dislike";
          rating.username = this.checkAuth();
          rating.songId = this.currentTrack.id;
          postRating(rating);
          this.setListRatings();
          this.checkRating(this.currentTrack);
        }
      }
    },
    add() {
      if (this.checkAuth()) {
        var username = this.checkAuth();
        var songId = window.location.search
          .replace("?", "")
          .split("&")[0]
          .split("=")[1];
        this.added = !this.added;
        if (!this.added) {
          for (let i = 0; i < this.playlist.length; i++) {
            if (this.currentTrack.id == this.playlist[i].id) {
              this.playlist.splice(i, 1);
              deletePlaylistByUsernameAndSongId(username, this.currentTrack.id);
              break;
            }
          }
        } else {
          var playlist = {};
          playlist.username = username;
          playlist.songId = this.currentTrack.id;
          postSongToPlaylist(playlist);
        }
      }
    },
  },
};
</script>
<style lang="css" scoped>
.button-submit {
  border: none;
  background-color: #acb8cc;
}
a {
  text-decoration: none;
}
p {
  margin: 0;
}
.detail-song {
  padding-left: 12.5rem;
}
@media screen and (max-width: 991px) {
  .detail-song {
    padding-left: 0;
  }
}
.playlist-song {
  height: 100%;
  box-shadow: 0px 15px 35px -5px rgba(50, 88, 130, 0.32);
  border-radius: 15px;
  background-color: #acb8cc;
  padding: 1em;
  display: flex;
  flex-direction: column;
}
.song-container {
  height: 100%;
  overflow-y: auto;
}
.song:hover {
  opacity: 0.7;
}
.song.active {
  color: #532ab9;
}
.song > p {
  margin: 0.5em 0;
  cursor: pointer;
}
#playlist-container {
  display: flex;
  flex-direction: column;
  min-width: 300px;
  min-height: 500px;
  padding: 1em;
}
@media screen and (max-width: 80em) {
  #playlist-container {
    padding: 0;
    margin-top: 2em;
    min-height: 0;
  }
}
.lyric-container,
.comment-container {
  display: flex;
  flex-direction: column;
  padding: 2em;
}

.lyric-container__footer {
  width: 100%;
  height: 300px;
  background-color: thistle;
}
.lyric-container__footer.hidden {
  overflow: hidden;
}
.lyric-container__footer.show {
  min-height: 300px;
  overflow: auto;
  height: auto;
}
textarea {
  width: 100%;
  height: 100%;
  resize: none;
  box-sizing: border-box;
  padding: 0;
}
.comment-list {
  background-color: #acb8cc;
  height: 300px;
  display: flex;
  flex-direction: column;
  padding: 1em;
  margin-bottom: 2em;
  overflow-x: hidden;
  overflow-y: scroll;
}
.comment-item {
  padding: 5px;
  display: flex;
  flex-direction: column;
}
.comment-item.right {
}
.comment-item__container {
  display: flex;
}
.comment-item__container > div {
}
.comment-item.right > .comment-item__container {
  justify-content: flex-end;
}
.user-info {
  display: flex;
}
.icon-user {
  height: 50px;
}
.user-info__item {
}
.user-comment__content {
  background-color: #eef3f7;
  padding: 15px;
  border-radius: 15px;
}
</style>
<style src="../../assets/template_admin/vendors/font-awesome/css/font-awesome.min.css" scoped></style>
<style lang="scss" scoped>
* {
  box-sizing: border-box;
}

.icon {
  display: inline-block;
  width: 1em;
  height: 1em;
  stroke-width: 0;
  stroke: currentColor;
  fill: currentColor;
}

.wrapper {
  width: 100%;
  min-width: 22em;
  padding: 1em;
  display: flex;
  @media screen and (max-width: 80em) {
    flex-direction: column;
  }
}

.player {
  background: #eef3f7;
  width: 100%;
  box-shadow: 0px 15px 35px -5px rgba(50, 88, 130, 0.32);
  border-radius: 15px;
  padding: 1em;
  display: flex;
  flex-direction: column;
  @media screen and (max-width: 20em) {
    padding: 1em;
  }
  &__top {
    display: flex;
    flex-direction: row;
    @media screen and (max-width: 50em) {
      flex-wrap: wrap;
      justify-content: space-around;
    }
    & > div {
      flex-basis: 100px;
      @media screen and (max-width: 50em) {
        flex: 1;
      }
    }
  }

  &-cover {
    flex: 1;
    border-radius: 15px;

    @media screen and (max-width: 20em) {
    }

    &__item {
      & > img {
        width: 100%;
        object-fit: contain;
        min-width: 36em;
        border-radius: 15px;
      }
    }

    &__img {
      object-fit: cover;
      border-radius: 15px;
      box-shadow: 0px 10px 40px 0px rgba(76, 70, 124, 0.5);
      user-select: none;
      pointer-events: none;
    }
  }

  &-controls {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
    padding: 15px;
    @media screen and (max-width: 50em) {
      flex-direction: row;
      width: 100%;
    }

    &__item {
      display: inline-flex;
      font-size: 2em;
      padding: 5px;
      color: #acb8cc;
      cursor: pointer;
      width: 50px;
      height: 50px;
      align-items: center;
      justify-content: center;
      transition: all 0.3s ease-in-out;

      @media screen and (max-width: 20em) {
        font-size: 1.5em;
        padding: 5px;
        color: #acb8cc;
        cursor: pointer;
        width: 40px;
        height: 40px;
        margin-bottom: 0;
      }

      @media screen and (min-width: 500px) {
        &:hover {
          color: #532ab9;
        }
      }

      @media screen and (max-width: 20em) {
        &:hover {
          color: #532ab9;
        }
      }

      .icon {
        position: relative;
        z-index: 2;
      }

      &.-xl {
        margin-bottom: 0;
        font-size: 95px;
        filter: drop-shadow(0 11px 6px rgba(172, 184, 204, 0.45));
        color: #fff;
        width: auto;
        height: auto;
        display: inline-flex;
        @media screen and (max-width: 20em) {
          margin-left: auto;
          font-size: 75px;
          margin-right: 0;
        }
        &:before {
          display: none;
        }
      }

      &.-add {
        &.active {
          color: red;
        }
      }
      &.-like {
        &.active {
          color: red;
        }
      }
      &.-dislike {
        &.active {
          color: red;
        }
      }
    }
  }
}
.player-controls__item.active {
  color: #532ab9;
}
[v-cloak] {
  display: none;
}
[v-cloak] > * {
  display: none;
}
.progress {
  width: 100%;
  display: flex;
  flex-direction: column;
  flex-basis: 130px;
  padding: 1em;
  border-radius: 15px;
  user-select: none;
  &__top {
    display: flex;
    align-items: flex-end;
    justify-content: space-between;
  }

  &__duration {
    color: #71829e;
    font-weight: 700;
    font-size: 20px;
    opacity: 0.5;
  }
  &__time {
    margin-top: 2px;
    color: #71829e;
    font-weight: 700;
    font-size: 16px;
    opacity: 0.7;
  }
}
.progress__bar {
  height: 6px;
  width: 100%;
  cursor: pointer;
  background-color: #d0d8e6;
  display: inline-block;
  border-radius: 10px;
}
.progress__current {
  height: inherit;
  width: 0%;
  background-color: #a3b3ce;
  border-radius: 10px;
}

.album-info {
  color: #71829e;
  flex: 1;
  padding-right: 60px;
  user-select: none;

  @media screen and (max-width: 20em) {
    padding-right: 30px;
  }

  &__name {
    font-size: 20px;
    font-weight: bold;
    line-height: 1.3em;
    @media screen and (max-width: 20em) {
      font-size: 18px;
      margin-bottom: 9px;
    }
  }
  &__track {
    font-weight: 400;
    font-size: 20px;
    opacity: 0.7;
    line-height: 1.3em;
    min-height: 52px;
    @media screen and (max-width: 20em) {
      font-size: 18px;
      min-height: 50px;
    }
  }
}

.github-btn {
  position: absolute;
  right: 40px;
  bottom: 50px;
  text-decoration: none;
  padding: 15px 25px;
  border-radius: 4px;
  box-shadow: 0px 4px 30px -6px rgba(36, 52, 70, 0.65);
  background: #24292e;
  color: #fff;
  font-weight: bold;
  letter-spacing: 1px;
  font-size: 16px;
  transition: all 0.3s ease-in-out;

  @media screen and (min-width: 500px) {
    &:hover {
      transform: scale(1.1);
      box-shadow: 0px 17px 20px -6px rgba(36, 52, 70, 0.36);
    }
  }

  @media screen and (max-width: 700px) {
    position: relative;
    bottom: auto;
    right: auto;
    margin-top: 20px;

    &:active {
      transform: scale(1.1);
      box-shadow: 0px 17px 20px -6px rgba(36, 52, 70, 0.36);
    }
  }
}

// //scale out

.scale-out-enter-active {
  transition: all 0.35s ease-in-out;
}
.scale-out-leave-active {
  transition: all 0.35s ease-in-out;
}
.scale-out-enter {
  transform: scale(0.55);
  pointer-events: none;
  opacity: 0;
}
.scale-out-leave-to {
  transform: scale(1.2);
  pointer-events: none;
  opacity: 0;
}

.scale-in-enter-active {
  transition: all 0.35s ease-in-out;
}
.scale-in-leave-active {
  transition: all 0.35s ease-in-out;
}
.scale-in-enter {
  transform: scale(1.2);
  pointer-events: none;
  opacity: 0;
}
.scale-in-leave-to {
  transform: scale(0.55);
  pointer-events: none;
  opacity: 0;
}
</style>
