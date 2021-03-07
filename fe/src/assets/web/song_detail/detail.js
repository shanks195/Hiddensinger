import {requestHeader,PATH} from '../../../index/index.js'
var postRating = function(rating){
    if(rating){
        fetch(`${PATH}api/rating`,{
        method:"POST",
        headers:requestHeader().headers,
        body:JSON.stringify(rating)
        }).then(response=>{
            if(!response.ok){
                console.log("post rating failed");
            }else{
                console.log("post rating success")
            }
        }).catch(error=>{

        });
    }else{
        console.log("rating null");
    }
    
}

var getListRating = function(){
    let listRating = [];
    var getList = function(){
        fetch(`${PATH}api/rating?username=${window.localStorage.getItem(
            "username"
          )}`,requestHeader())
        .then(response => {
            if(!response.ok){
                console.log("get listrating failed");
            }else{
                console.log("get listrating success")
                return response.json();
            }
        })
        .then(response => {
            listRating.push(...response);
        })
        .catch(error=>{
            
        })

    }();
    return listRating;
}

var deleteArrRating = function(arrRating){
    var deleteArr = function(){
        fetch(`${PATH}api/rating/${arrRating}`,{
            method: "delete",
            headers:requestHeader().headers
        })
        .then(response => {
            if(!response.ok){
                console.log("delete rating failed");
            }else{
                console.log("post playlist success")
            }
        })
        .catch(error=>{
            console.log(error);
        });
    }();
}

var postSongToPlaylist = function(playlist){
    var postPlaylist = function(){
        fetch(`${PATH}api/playlist`,{
            method: "POST",
            headers:requestHeader().headers,
            body:JSON.stringify(playlist)
        })
        .then(response => {
            if(!response.ok){
                console.log("post playlist failed");
            }else{
                console.log("post playlist success")
            }
        })
        .catch(error=>{
            console.log(error);
        });
    }();
}

var deletePlaylistByUsernameAndSongId = function(username,songId){
    var deletePlaylist = function(){
        fetch(`${PATH}api/playlist/${username}/${songId}`,{
            method: "DELETE",
            headers:requestHeader().headers
        })
        .then(response => {
            if(!response.ok){
                console.log("delete playlist failed");
            }else{
                console.log("delete playlist success")
            }
        })
        .catch(error=>{
            console.log(error);
        });
    }();
}

var getPlaylistByUsername = function(username){
    let playlist = [];
    var deleteArr = function(){
        fetch(`${PATH}api/playlist?username=${username}`,requestHeader())
        .then(response => {
            if(!response.ok){
                console.log("get playlist failed");
            }else{
                console.log("get playlist success")
                return response.json();
            }
        }).then(response =>{
            playlist.push(...response);
        })
        .catch(error=>{
            console.log(error);
        });
    }();
    return playlist;
}

var postComment = function(comment){
    var post = function(){
        fetch(`${PATH}api/comment`,{
            method: "POST",
            headers:requestHeader().headers,
            body:JSON.stringify(comment)
        })
        .then(response => {
            if(!response.ok){
                console.log("post comment failed");
            }else{
                console.log("post comment success")
            }
        })
        .catch(error=>{
            console.log(error);
        });
    }();
}

function checkButtonComment(){
    let button = document.querySelector('.button-submit');
    const comment = document.querySelector('.comment');
    if(comment.value.trim()){
        button.disabled=false;
    }else{
        button.disabled=true;
    }
    comment.onkeyup=function(){
        if(comment.value.trim()){
            button.disabled=false;
        }else{
            button.disabled=true;
        }
    }
    
}




export {postRating,getListRating,deleteArrRating,checkButtonComment,postComment,postSongToPlaylist,deletePlaylistByUsernameAndSongId};