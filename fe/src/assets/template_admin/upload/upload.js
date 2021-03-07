//DOM
import {requestHeader,PATH} from "../../../index/index.js"
function uploadTemplate() {
  //Init
  function handleFileSelect(evt) {
    let files = evt.target.files; // FileList object
    console.log(evt.target);
    let username = localStorage.getItem('username');
    if(username){
      //files template
      let template = `${Object.keys(files).
      map(file => `<div class="file file--${file}">
       <div class="name"><span>${files[file].name}</span></div>
       <div class="progress active"></div>
       <div class="done">
      <a href="" target="_blank">
        <svg width="20" height="20" x="0px" y="0px" viewBox="0 0 1000 1000">
      <g><path id="path" d="M500,10C229.4,10,10,229.4,10,500c0,270.6,219.4,490,490,490c270.6,0,490-219.4,490-490C990,229.4,770.6,10,500,10z M500,967.7C241.7,967.7,32.3,758.3,32.3,500C32.3,241.7,241.7,32.3,500,32.3c258.3,0,467.7,209.4,467.7,467.7C967.7,758.3,758.3,967.7,500,967.7z M748.4,325L448,623.1L301.6,477.9c-4.4-4.3-11.4-4.3-15.8,0c-4.4,4.3-4.4,11.3,0,15.6l151.2,150c0.5,1.3,1.4,2.6,2.5,3.7c4.4,4.3,11.4,4.3,15.8,0l308.9-306.5c4.4-4.3,4.4-11.3,0-15.6C759.8,320.7,752.7,320.7,748.4,325z"</g>
      </svg>
              </a>
       </div>
      </div>`).
      join("")}`;
  
      document.querySelector("#drop").classList.add("hidden");
      document.querySelector("footer").classList.add("hasFiles");
      document.querySelector(".importar").classList.add("active");
      setTimeout(() => {
        document.querySelector(".list-files").innerHTML = template;
      }, 1000);
  
      Object.keys(files).forEach(file => {
        let load = 2000 + file * 2000; // fake load
        setTimeout(() => {
          let fileEl = document.querySelector(`.file--${file}`);
          fileEl.querySelector(".progress").classList.remove("active");
          fileEl.querySelector(".done").classList.add("anim");
        }, load);
      });
      let newFiles = (Object.keys(files).
      map(function(file){
        let date = new Date();
        console.log(files[file])
        let fileNames = files[file].name.split(".");
        if(fileNames[1]=="mp3"){
          const fileName = `${fileNames[0]}--${date.getTime()}.${fileNames[1]}`;
          const myFile = new File([(files[file])], fileName);
          return myFile;
        }
      }));
      document.querySelector(".importar").addEventListener("click",()=>{
        if(newFiles){
          document.querySelector(".list-files").innerHTML = "";
          document.querySelector("footer").classList.remove("hasFiles");
          document.querySelector(".importar").classList.remove("active");
          setTimeout(() => {
            document.querySelector("#drop").classList.remove("hidden");
          }, 500);
          newFiles.forEach(file=>{
            var formData = new FormData();
            formData.append('file', file)
            var rq = new Request(`${PATH}uploadFile`,{
              method: 'POST',
              headers: {
                'Authorization':`Bearer ${localStorage.getItem('accessToken')}`
              },
              body: formData
            });
            return fetch(rq).then(response => {
              if (!response.ok) {
                console.log("upload fail")
              }else {
                return response.json();
              }
            }).then(response =>{
              const formSong = document.querySelector('#form-song');
              const formLyric = formSong.querySelector('#lyric');
              const formCategory = formSong.querySelector('#category')
              let song ={};
              song.url = response.fileDownloadUri;
              let nameSong = response.fileName.split(".")[0].split("--")[0];
              song.username = username;
              song.name = nameSong;
              song.lyric = formLyric.value;
              song.categoryName=formCategory.value;
              getSong(song);
            }).catch(function(error) {
              console.log(error);
            });
          });
          
        }
      });
    }
  }

  

  // trigger input
  document.querySelector("#triggerFile").addEventListener("click", evt => {
    evt.preventDefault();
    document.querySelector("input[type=file]").click();
  });

  // drop events
  document.querySelector("#drop").ondragleave = evt => {
    document.querySelector("#drop").classList.remove("active");
    evt.preventDefault();
  };
  document.querySelector("#drop").ondragover = document.querySelector("#drop").ondragenter = evt => {
    document.querySelector("#drop").classList.add("active");
    evt.preventDefault();
  };
  document.querySelector("#drop").ondrop = evt => {
    document.querySelector("input[type=file]").files = evt.dataTransfer.files;
    document.querySelector("footer").classList.add("hasFiles");
    document.querySelector("#drop").classList.remove("active");
    evt.preventDefault();
  };

  //upload more
  document.querySelector(".importar").addEventListener("click", () => {
    document.querySelector(".list-files").innerHTML = "";
    document.querySelector("footer").classList.remove("hasFiles");
    document.querySelector(".importar").classList.remove("active");
    setTimeout(() => {
      document.querySelector("#drop").classList.remove("hidden");
    }, 500);
  });

  // input change
  document.querySelector("input[type=file]").addEventListener("change", handleFileSelect);

  function getSong(data){
    let request = new Request(`${PATH}api/song`,{
      method: 'POST',
      headers: requestHeader().headers,
      body: JSON.stringify(data)
    });
    return fetch(request).then(response => {
      if (!response.ok) {
      throw Error(response.statusText);
      }else {
        return response.json();
      }
    }).catch(function(error) {
      console.log(error);
    });
  }
}
export {uploadTemplate};