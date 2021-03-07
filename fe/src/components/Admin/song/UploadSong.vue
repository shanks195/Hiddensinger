<template>
  <div class="upload">
    <div class="upload-files">
      <header>
        <p>
          <i class="fa fa-cloud-upload" aria-hidden="true"></i>
          <span class="up">up</span>
          <span class="load">load</span>
        </p>
        <form action="" id="form-song">
          <div class="form-group">
            <label for="lyric">Lyric</label>
            <br /><textarea name="lyric" id="lyric" class="form-control" placeholder="Input lyric"></textarea>
          </div>
          <div class="form-group">Category<br />
          <select  name="category" id="category">
            <option v-for="(category, index) in categories" v-bind:key="index" v-bind:value="category.name">{{category.name}}</option>
          </select>
        </div>
        </form>
      </header>
      <div class="body" id="drop">
        <i class="fa fa-file-text-o pointer-none" aria-hidden="true"></i>
        <p class="pointer-none">
          <b>Drag and drop</b> files here <br />
          or <a href="" id="triggerFile">browse</a> to begin the upload
        </p>
          <input type="file" multiple="multiple" />
      </div>
      <footer>
        <div class="divider">
          <span>FILES</span>
        </div>
        <div class="list-files">
          <!--   template   -->
        </div>
        <button class="importar">UPDATE FILES</button>
      </footer>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import {PATH} from '../../../index/index.js'
import { uploadTemplate } from "../../../assets/template_admin/upload/upload";
export default {
  data(){
    return {
      categories:[],
    }
  },
  created(){
    axios.get(`${PATH}api/category/get`)
    .then(response => {
      this.categories = response.data
    }).catch(e => {
      this.errors.push(e)
    })
  },
  mounted() {
    uploadTemplate();
  },
};
</script>

<style scoped src= "../../../assets/template_admin/upload/upload.css"></style>
<style scoped lang="css">
.file-wrapper {
  position: relative;
}
#lyric{
  resize: none;
  width: 100%;
  height: 300px;
  padding: 0;
  box-sizing: border-box;
}
</style>