import { formatTimer } from "./timer";

/**
 * Remove a target object from array
 * @param {array} array
 * @param {object} target
 */

const deleteElement = (array, target) => {
  return array.filter(item => {
    return item != target;
  });
};

/**
 * Insert initial songs params
 * @param {array} songs
 */

const threatSongs = songs => {
  return songs.map(song => {
    song["isPlaying"] = false;
    song["percent"] = 0;
    song["currentlyTimer"] = "00:00";
    song["totalTimer"] = formatTimer(song.seconds);

    return song;
  });
};

/**
 * Shuffle songs.
 * @param {array} array
 */

function shuffleArray(array) {
  for (let i = array.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [array[i], array[j]] = [array[j], array[i]];
  }

  return array;
}
function compareScore(a,b){
  if(a.score < b.score){
    return 1;
    }
    if(a.score > b.score){
      return -1;
      }
    return 0;
};
function sortNew(a,b){
  if(a.modifiedDate < b.modifiedDate){
    return 1;
    }
    if(a.modifiedDate > b.modifiedDate){
      return -1;
      }
    return 0;
};
export { deleteElement, threatSongs, shuffleArray, compareScore, sortNew };
