

 import KProgress from "k-progress"; 
 import { formatTimer } from "../helpers/timer"; 
 import { deleteElement, threatSongs, shuffleArray,compareScore } from "../helpers/utils"; 
 import songs from "../mocks/songs"; 

    var current = {};
    var coverObject = { cover: true, animated: false }
    var index= 0
    var isPlaying= false
    var currentlyTimer= "00:00"
    var songs1=songs.sort(compareScore).slice(0,10)
    var player= new Audio()

 function listenersWhenPlay() {
      player.addEventListener("timeupdate", () => {
        var playerTimer = player.currentTime;

        currentlyTimer = formatTimer(playerTimer);
        current.percent = (playerTimer * 100) / current.seconds;
        current.isPlaying = true;
      });
      player.addEventListener(
        "ended",
        function() {
          next();
        }.bind(this)
      )
    }

 function  setCover() {
        coverObject.animated = true;
  
        setTimeout(() => {
          coverObject.animated = false;
        }, 1000);
      }
   function  setCurrentSong() {
        current = songs[index];
        play(current);
        setCover();
      }
   function play(song) {
    if (typeof song.src !== "undefined") {
        this.current.isPlaying = false;
        this.index = this.songs.indexOf(this.current);
        this.current = song;
        this.player.src = this.current.src;
      }

      this.player.play();
      this.isPlaying = true;

      this.setCover();
      this.listenersWhenPlay();
      }
   function  pause() {
        player.pause();
        isPlaying = false;
      }
    function  next() {
        current.isPlaying = false;
        index = songs.indexOf(current);
        index++;
        if (index > songs.length - 1) {
          index = 0;
        }
        setCurrentSong();
      }

    function  prev() {
        current.isPlaying = false;
        index = songs.indexOf(current);
        index--;
        if (index < 0) {
          index = songs.length - 1;
        }
        setCurrentSong();
      }
   function  removeSongFromPlaylist(song) {
        if (songs.length > 1) {
          if (index > 0) {
            index--;
          }
          current.isPlaying = false;
          songs = deleteElement(songs, song);
          setCurrentSong();
        }
      }
      
 export {index,current,coverObject, isPlaying, currentlyTimer, songs1, player,
    listenersWhenPlay, setCurrentSong, play, pause, next, prev, removeSongFromPlaylist, setCover
}  ;
   