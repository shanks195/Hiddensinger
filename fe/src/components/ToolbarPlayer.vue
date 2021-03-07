<template>
  <div class="player">
    <div class="right">
      <div class="top">
        <a class="song" href="#">{{ song.name }}</a>
        <a class="artist" href="#">{{ song.username }}</a>
      </div>
      <div class="bottom">
        <div class="button-next">
          <i class="fa fa-step-backward" aria-hidden="true"></i>
        </div>
        <div class="button-next">
          <i class="fa fa-step-forward" aria-hidden="true"></i>
        </div>
        <audio
          controls
          autoplay
          name="media"
          v-bind:src="song.url"
          type="audio/mpeg"
        ></audio>
        <div class="icon-hambuger">
          <div></div>
          <div></div>
          <div></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "toolbarPlayer",
  data() {
    return {};
  },
  props: ["song"],
  created() {},
  mounted() {},
  methods: {
    
  },
};
</script>
<style scoped src= "../assets/template_admin/vendors/font-awesome/css/font-awesome.min.css"></style>
<style lang="css" scoped>
body {
  font-family: "Montserrat", sans-serif;
  min-height: 100vh;
  max-height: 100vh;
  margin: 0;
  color: #fff;
  display: -webkit-box;
  display: flex;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
  flex-direction: column;
  background: #222222;
  background: -webkit-linear-gradient(to top, #232526, #414345);
}
body a {
  color: inherit;
}
body a:not(:hover) {
  text-decoration: none;
}
body #link-a-me {
  position: absolute;
  bottom: 80px;
  right: 20px;
  height: 60px;
  width: 60px;
  background: url(https://i.imgur.com/xoxkq1r.png);
  background-size: cover;
  z-index: 1;
  -webkit-animation: pop-in 120s ease-out;
  animation: pop-in 120s ease-out;
}
body .content {
  overflow: hidden;
  -webkit-box-flex: 1;
  flex-grow: 1;
  height: calc(100% - 80px);
}
body .content .lyrics {
  padding: 50vh 0;
  min-height: calc(100vh - 80px);
  width: calc(100% - 40px);
  margin: 0 20px;
  text-align: center;
  -webkit-transition: all 0.25s;
  transition: all 0.25s;
  position: relative;
}
body .content .lyrics > div {
  position: relative;
  font-size: 40px;
  line-height: 80px;
  color: #666;
  -webkit-transition: all 0.25s;
  transition: all 0.25s;
}
body .content .lyrics > div:before {
  content: attr(note);
  position: absolute;
  top: 0px;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  font-size: 18px;
}
body .content .lyrics > div.highlighted {
  color: #fff;
  font-size: 48px;
}
body .player {
  z-index: 10;
  background: #f9f9f9;
  color: #000;
  height: 80px;
  height: 80px;
  display: -webkit-box;
  display: flex;
  -webkit-box-orient: horizontal;
  -webkit-box-direction: normal;
  flex-direction: row;
  position: absolute;
  bottom: 0;
}
.player{
  left: 0;
  width: 100%;
}
body .player .right {
  -webkit-box-flex: 1;
  flex-grow: 1;
  display: -webkit-box;
  display: flex;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
  flex-direction: column;
}
body .player .right .top {
  -webkit-box-flex: 1;
  flex-grow: 1;
  display: -webkit-box;
  display: flex;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
  flex-direction: column;
  -webkit-box-pack: center;
  justify-content: center;
  padding-left: 10px;
}
body .player .right .top .song {
  font-size: 1.2em;
  font-weight: 600;
}
body .player .right .bottom {
  display: -webkit-box;
  display: flex;
}
body .player .right .bottom audio {
  -webkit-box-flex: 1;
  flex-grow: 1;
  height: 32px;
}
.button-next {
  background-color: rgba(26, 26, 26, 0.8);
  color: white;
  width: 32px;
  height: 32px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.button-next:hover {
  color: #48a0f7;
}
@-webkit-keyframes pop-in {
  0%,
  95% {
    -webkit-transform: translateY(100%);
    transform: translateY(100%);
  }
  100% {
    -webkit-transform: translateY(0%);
    transform: translateY(0%);
  }
}

@keyframes pop-in {
  0%,
  95% {
    -webkit-transform: translateY(100%);
    transform: translateY(100%);
  }
  100% {
    -webkit-transform: translateY(0%);
    transform: translateY(0%);
  }
}
.icon-hambuger {
  align-items: center;
  display: flex;
  flex-direction: column;
  justify-content: center;
  width: 32px;
  height: 32px;
  cursor: pointer;
  background-color: rgba(26, 26, 26, 0.8);
}
.icon-hambuger > div {
  margin: 6% 0;
  width: 80%;
  height: 10%;
  background-color: white;
}

.icon-hambuger:hover > div {
  background-color: #48a0f7;
}
</style>