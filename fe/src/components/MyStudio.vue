<template>
  <b-container fluid>
    <b-row>
      <b-col lg="6" class="my-1">
        <b-form-group
          label="Sort"
          label-for="sort-by-select"
          label-cols-sm="3"
          label-align-sm="right"
          label-size="sm"
          class="mb-0"
          v-slot="{ ariaDescribedby }"
        >
          <b-input-group size="sm">
            <b-form-select
              id="sort-by-select"
              v-model="sortBy"
              :options="sortOptions"
              :aria-describedby="ariaDescribedby"
              class="w-75"
            >
              <template #first>
                <option value="">-- none --</option>
              </template>
            </b-form-select>

            <b-form-select
              v-model="sortDesc"
              :disabled="!sortBy"
              :aria-describedby="ariaDescribedby"
              size="sm"
              class="w-25"
            >
              <option :value="false">Asc</option>
              <option :value="true">Desc</option>
            </b-form-select>
          </b-input-group>
        </b-form-group>
      </b-col>

      <b-col lg="6" class="my-1">
        <b-form-group
          label="Filter"
          label-for="filter-input"
          label-cols-sm="3"
          label-align-sm="right"
          label-size="sm"
          class="mb-0"
        >
          <b-input-group size="sm">
            <b-form-input
              id="filter-input"
              v-model="filter"
              type="search"
              placeholder="Type to Search"
            ></b-form-input>

            <b-input-group-append>
              <b-button :disabled="!filter" @click="filter = ''">Clear</b-button>
            </b-input-group-append>
          </b-input-group>
        </b-form-group>
      </b-col>

       <b-col sm="5" md="6" class="my-1">
        <b-form-group
          label="Per page"
          label-for="per-page-select"
          label-cols-sm="6"
          label-cols-md="4"
          label-cols-lg="3"
          label-align-sm="right"
          label-size="sm"
          class="mb-0"
        >
          <b-form-select
            id="per-page-select"
            v-model="perPage"
            :options="pageOptions"
            size="sm"
          ></b-form-select>
        </b-form-group>
      </b-col>
      <b-col sm="7" md="6" class="my-1">
        <b-pagination
          v-model="currentPage"
          :total-rows="totalRows"
          :per-page="perPage"
          align="fill"
          size="sm"
          class="my-0"
        ></b-pagination>
      </b-col>
    </b-row>

    <!-- Main table element -->
    <b-table
      :items="items"
      :fields="fields"
      :current-page="currentPage"
      :per-page="perPage"
      :filter="filter"
      :filter-included-fields="filterOn"
      :sort-by.sync="sortBy"
      :sort-desc.sync="sortDesc"
      :sort-direction="sortDirection"
      stacked="md"
      show-empty
      small
      @filtered="onFiltered"
    >
      <template #cell(name)="row">
        {{ row.value.first }} {{ row.value.last }}
      </template>

      <template #cell(actions)="row">
        <!-- <b-button size="sm" v-model="row.item.url" @click="playAudio"><b-icon icon="file-play" aria-hidden="true"></b-icon>
        </b-button> -->
        <b-button size="sm" @click="row.toggleDetails">
          {{ row.detailsShowing ? 'Hide' : 'Show' }} Details
        </b-button>
        <b-button size="sm"  @click="deleteSong(row.item)"><b-icon icon="trash" aria-hidden="true"></b-icon>
        </b-button>
      </template>

      <template #row-details="row">
        <b-card>
          <form @submit.prevent="submit(row.item)" class="form-register">
               <div class="form-group col-sm-9">
                    <label class="form__label">Song name</label>
                    <b-form-input class="form__input" required v-model="row.item.name"  maxlength="50" />
                </div>
                <div class="form-group col-sm-9">
                  <b-form-select v-model="row.item.categoryName"  :options="options" ></b-form-select>
                  <div class="mt-3">Selected: <strong>{{ row.item.categoryName }}</strong></div>
                </div>
                <div class="form-group col-sm-9" >
                    <label class="form__label">Song lyric</label>
                    <b-form-textarea class="form__input" required v-model="row.item.lyric" maxlength="5000" />
                </div>
                <div class="form-group col-sm-9" >
                  {{row.item.modifiedDate}}
                </div>
                <b-button class="button" type="submit" :disabled="submitStatus === 'PENDING'">Submit!</b-button>
                <p class="typo__p" v-if="submitStatus === 'OK'">Saved!</p>
                <p class="typo__p" v-if="submitStatus === 'ERROR'">Please fill or select the form correctly.</p>
                <p class="typo__p" v-if="submitStatus === 'PENDING'">Sending...</p>
            </form>
        </b-card> 
      </template>
    </b-table>
    <!-- <toolbarPlayer v-bind:playAudio="playAudio" v-bind:song="song" /> -->
  </b-container>
</template>
<style scoped src="bootstrap/dist/css/bootstrap.css"></style>
<style scoped src="bootstrap-vue/dist/bootstrap-vue.css"></style>
<script>
// import toolbarPlayer from '../../ToolbarPlayer.vue'
import axios from 'axios';
import { requestHeader, PATH } from "../index/index.js";
  export default {
    // components:{
    //   toolbarPlayer
    // },
    data() {
      return {
        items: null,
        fields: [
          { key: 'name.', label: 'Song name', sortable: true, sortDirection: 'desc',class: 'text-center' },
          { key: 'views', label: 'View', sortable: true, class: 'text-center' },
          { key: 'likes', label: 'Like', sortable: true, class: 'text-center' },
          { key: 'dislikes', label: 'Dislike', sortable: true, class: 'text-center' },
          { key: 'categoryName', label: 'Category', sortable: true, class: 'text-center' },
          // { key: 'modifiedDate', label: 'Modified Date', sortable: true, class: 'text-center'},
          { key: 'actions', label: 'Actions' }
        ],
        options:[
          { value: null, text: 'Please select category song' },
          { value: 'pop', text: 'This is pop' },
          { value: 'rap', text: 'This is rap' },
          { value: 'rock', text: 'This is rock' },
          { value: 'bala', text: 'This is bala'}
        ],
        totalRows: 1,
        currentPage: 1,
        perPage: 5,
        pageOptions: [5, 10, 15, { value: 100, text: "Show a lot" }],
        sortBy: '',
        sortDesc: false,
        sortDirection: 'asc',
        filter: null,
        filterOn: [],
        submitStatus: null,
        form:{
          name: '',
          categoryName: '',
          lyric: '',
          id: '',
          username: localStorage.username
        }
      }
    },
    computed: {
      sortOptions() {
        // Create an options list from our fields
        return this.fields
          .filter(f => f.sortable)
          .map(f => {
            return { text: f.label, value: f.key }
          })
      },
    },
  
    created(){
         this.loadPage()
    },
    methods: {
      onFiltered(filteredItems) {
        // Trigger pagination to update the number of buttons/pages due to filtering
        this.totalRows = filteredItems.length
        this.currentPage = 1
      },
      submit(e) {
          this.form.name = e.name,
          this.form.categoryName = e.categoryName,
          this.form.lyric = e.lyric
          this.form.id =e.id
          this.save(this.form);
          this.submitStatus = "PENDING";
          
      },
      loadPage(){
          axios.get(`${PATH}api/studio/song/list`,{
            headers:{
                  'Content-Type': 'application/json',
                  'Authorization':`Bearer ${localStorage.getItem('accessToken')}`
                },
            params:{username:localStorage.username}
          })
          .then(response=>{
            this.items=response.data;
            this.totalRows =response.data.length
          })
      },
      save(form) {
        fetch(`${PATH}api/studio/song/save`, {
          method: "POST",
          headers: requestHeader().headers,
          body: JSON.stringify(form),
        })
          .then((response) => {
            if (!response.ok) {
              alert("cap nhat that bai");
              this.submitStatus = "ERROR"
            } else {
              alert("cap nhat thanh cong");
              setTimeout(() => {
                this.submitStatus = "OK";
              }, 500);
            }
          })
          .catch((error) => {
            console.log(error);
          });
      },
      deleteSong(e){
          this.form.name = e.name,
          this.form.categoryName = e.categoryName,
          this.form.lyric = e.lyric,
          this.form.id = e.id,
        fetch(`${PATH}api/studio/song/delete`, {
          method: "POST",
          headers: requestHeader().headers,
          body: JSON.stringify(this.form),
        })
          .then((response) => {
            if (!response.ok) {
              alert("delete false");
            } else {
              alert("delete thanh cong");
              this.loadPage();
            }
          })
          .catch((error) => {
            console.log(error);
          });
      }
    }
  }
</script>