<template>
  <div id="app">
    <!-- <h1>{{ pageUser.account.username }} Account</h1> -->
    <form class="vue-form" @submit.prevent="submit">
      <div class="form-group row" :class="{ 'form-group--error': $v.pageUser.fullName.$error }">
        <label class="col-sm-3 form-control-label text-muted">Fullname</label>
        <div class="col-sm-9"> 
            <b-input class="form__input col-sm-9" required v-model="pageUser.fullName" />
        </div>
        <div class="error" v-if="!$v.pageUser.fullName.minLength"> Name must have at least {{ $v.pageUser.fullName.$params.minLength.min }} letters.</div>
      </div>

      <div class="form-group row" :class="{ 'form-group--error': $v.pageUser.birthday.$error }" >
        <label class="col-sm-3 form-control-label text-muted">Brithday</label>
        <div class="col-sm-9">
          <b-input class="form__input col-sm-9" required v-model="pageUser.birthday"/>
        </div>
        <div class="error" v-if="!$v.pageUser.birthday.minLength"> Name must have at least {{ $v.pageUser.birthday.$params.minLength.min }} letters.</div>
        <!-- <div class="error" v-if="!$v.pageUser.birthday.date_regex"> Name must have at least YYYY-MM-DD letters.</div> -->
      </div>

      <div class="form-group row">
        <label class="col-sm-3 form-control-label text-muted" >Your gender</label>
        <div class="col-sm-9">
          <b-form-select v-model="pageUser.gender" class="col-sm-9">
            <b-form-select-option value="null" >Please select an gender option</b-form-select-option>
            <b-form-select-option value="females">Females</b-form-select-option>
            <b-form-select-option value="males">Males</b-form-select-option>
          </b-form-select>
        </div>
      </div>
      <div class="form-group row" :class="{ 'form-group--error': $v.pageUser.email.$error }" >
        <label class="col-sm-3 form-control-label text-muted">Email</label>
        <div class="col-sm-9">
          <b-input class="form__input col-sm-9" required type="email"  v-model="pageUser.email" />
        </div>
        <div class="error" v-if="!$v.pageUser.email.minLength"> Name must have at least {{ $v.pageUser.email.$params.minLength.min }} letters.
        </div>
      </div>

      <div class="form-group row" :class="{ 'form-group--error': $v.pageUser.phone.$error }">
        <label class="col-sm-3 form-control-label text-muted">Phone</label>
        <div class="col-sm-9">
          <b-input class="form__input col-sm-9" required v-model="pageUser.phone" />
        </div>
        <div class="error" v-if="!$v.pageUser.phone.minLength"> Name must have at least {{ $v.pageUser.phone.$params.minLength.min }} letters.</div>
        <div class="error" v-if="!$v.pageUser.phone.maxLength">Name must have at least {{$v.pageUser.phone.$params.maxLength.max}} letters.</div>
        <div class="error" v-if="!$v.pageUser.phone.number">Name must only number.</div> 
      </div>

      <div class="form-group row" :class="{ 'form-group--error': $v.pageUser.address.$error }">
        <label class="col-sm-3 form-control-label text-muted">Address</label>
        <div class="col-sm-9">
          <b-input  class="form__input col-sm-9" required v-model="pageUser.address" />
        </div>
        <div class="error" v-if="!$v.pageUser.address.maxLength">Name must have at least {{$v.pageUser.address.$params.maxLength.max}} letters.</div>
      </div>

      <b-button class="button" type="submit" :disabled="submitStatus === 'PENDING'">Save!</b-button>
      <p class="typo__p" v-if="submitStatus === 'OK'">Saved</p>
      <p class="typo__p" v-if="submitStatus === 'ERROR'"> Please fill or select the form correctly. </p>
      <p class="typo__p" v-if="submitStatus === 'PENDING'">Sending...</p>
    </form>
  </div>
</template>

<script>
import { requestHeader, PATH } from "../index/index.js";
import axios from "axios";
import {helpers, required, minLength, maxLength} from "vuelidate/lib/validators";
const date_regex = helpers.regex(/([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))/g)
const number = helpers.regex("only number", /^\d+$/);
export default {
  data() {
    return {
      pageUser: {
        fullName: "",
        birthday: "",
        gender: null,
        email: "",
        phone: "",
        address: "",
        username: localStorage.username,
      },
      submitStatus: null,

    };
  },
  validations: {
    pageUser: {
      fullName: {
        required,
        minLength: minLength(5),
      },
      birthday: {
        required,
        minLength: minLength(4),
        // date_regex
      
      },
      gender: {
        required,
        minLength: minLength(2),
      },
      email: {
        required,
        minLength: minLength(2),
      },
      phone: {
        required,
        minLength: minLength(10),
        maxLength: maxLength(10),
        number
      },
      address: {
        required,
        maxLength: maxLength(100),
      },
    },
  },
  methods: {
    submit() {
      this.$v.$touch();
      if (this.$v.$invalid) {
        this.submitStatus = "ERROR";
      } else {
        // do your submit logic here
        this.save(this.pageUser);
        this.submitStatus = "PENDING";
        setTimeout(() => {
          this.submitStatus = "OK";
        }, 500);
      }
    },
    save(form) {
      console.log(form)
      fetch(`${PATH}api/user/change`, {
        method: "POST",
        headers: requestHeader().headers,
        body: JSON.stringify(form),
      })
        .then((response) => {
          if (!response.ok) {
            alert("cap nhat that bai");
          } else {
            alert("cap nhat thanh cong");
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  created() {
    axios
      .get(`${PATH}api/user/account`, {
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${localStorage.getItem("accessToken")}`,
        },
        params: {
          username: localStorage.username,
        },
      })
      .then((response) => {
        this.pageUser = response.data;
      });
  },
};
</script>

<style lang="scss" scoped>

</style>
