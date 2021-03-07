<template>
  <div class="fileupload">
    <div class="container">
      <!--UPLOAD-->
      <div v-if="roleName=='user'" uploadFieldName='audio'>
        <form enctype="multipart/form-data" novalidate v-if="isInitial || isSaving">
          <h1>Upload music</h1>
          <div class="dropbox">
            <input type="file" multiple :name="uploadFieldName" :disabled="isSaving" @change="filesChange($event.target.name, $event.target.files);  "
              accept="audio/*" class="input-file">
              <p v-if="isInitial">
                Drag your file(s) here to begin<br> or click to browse
              </p>
              <p v-if="isSaving">
                Uploading files...
              </p>
          </div>
        </form>
      </div>
      <div v-if="roleName=='admin'" uploadFieldName='video'>
        <form enctype="multipart/form-data" novalidate v-if="isInitial || isSaving">
          <h1>Upload video</h1>
          <div class="dropbox">
            <input type="file" multiple :name="uploadFieldName" :disabled="isSaving" @change="filesChange($event.target.name, $event.target.files); "
              accept="video/*" class="input-file">
              <p v-if="isInitial">
                Drag your file(s) here to begin<br> or click to browse
              </p>
              <p v-if="isSaving">
                Uploading  files...
              </p>
          </div>
        </form>
      </div>
      <!--SUCCESS--> 
      <div v-if="isSuccess">
        <h2>Uploaded {{ uploadedFiles.length }} file(s) successfully.</h2>
        <p>
          <a href="javascript:void(0)" @click="reset()">Upload again</a>
        </p>
        <ul class="list-unstyled">
          <li v-for="{item,index} in uploadedFiles" :key="index">
            <p>{{item.name}}</p>
          </li>
        </ul>
      </div>
      <!--FAILED-->
      <div v-if="isFailed">
        <h2>Uploaded failed.</h2>
        <p>
          <a href="javascript:void(0)" @click="reset()">Try again</a>
        </p>
        <pre>{{ uploadError }}</pre>
      </div>
  </div>
  </div>
</template>

<script>
// import { upload } from './file-upload.service';
import  axios from "axios";
const BASE_URL = 'http://localhost:8085';
const STATUS_INITIAL = 0, STATUS_SAVING = 1, STATUS_SUCCESS = 2, STATUS_FAILED = 3;
export default {
    name: 'FileUpload',
    data() {
      return {

        uploadedFiles: [],
        uploadError: null,
        currentStatus: null,
        uploadFieldName: null,
        roleName: 'user',
        username: window.localStorage.getItem('username')
    
        
      }
    },
    computed: {
      isInitial() {
        return this.currentStatus === STATUS_INITIAL;
      },
      isSaving() {
        return this.currentStatus === STATUS_SAVING;
      },
      isSuccess() {
        return this.currentStatus === STATUS_SUCCESS;
      },
      isFailed() {
        return this.currentStatus === STATUS_FAILED;
      }
    },
    methods: {
      reset() {
        // reset form to initial state
        this.currentStatus = STATUS_INITIAL;
        this.uploadedFiles = [];
        this.uploadError = null;
      },
      save(formData) {
        // upload data to the server
        this.currentStatus = STATUS_SAVING;

        upload(formData)
          axios({
            url: BASE_URL+'/upload/audio/',
            data: formData,
            method: 'POST',
            headers:{
              'Content-Type': 'multipart/form-data'
            }
          }).then(x => {
            this.uploadedFiles = [].concat(x);
            this.currentStatus = STATUS_SUCCESS;
          })
          .catch(err => {
            this.uploadError = err.response;
            this.currentStatus = STATUS_FAILED;
          });
      },
      filesChange(fieldName, fileList) {
        // handle file changes
       
        const formData = new FormData();

        if (!fileList.length) return;
       
        // append the files to FormData
        Array
          .from(Array(fileList.length).keys())
          .map(x => {
            formData.append(fieldName, fileList[x], fileList[x].name);
          });

        // save it
        this.save(formData);
      }
    },
    mounted() {
      this.reset();
    },
  

}
</script>

<style scoped>
    .dropbox {
    outline: 2px dashed grey; /* the dash box */
    outline-offset: -10px;
    background: lightcyan;
    color: dimgray;
    padding: 10px 10px;
    min-height: 200px; /* minimum height */
    position: relative;
    cursor: pointer;
  }

  .input-file {
    opacity: 0; /* invisible but it's there! */
    width: 100%;
    height: 200px;
    position: absolute;
    cursor: pointer;
  }

  .dropbox:hover {
    background: lightblue; /* when mouse over to the drop zone, change color */
  }

  .dropbox p {
    font-size: 1.2em;
    text-align: center;
    padding: 50px 0;
  }
</style>