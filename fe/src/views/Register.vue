<template>
    <div class="div-register">
        <div id="container-register">
            <h1>Register</h1>
            <form @submit.prevent="submit" class="form-register">
               <div class="form-group " :class="{ 'form-group--error': $v.form.fullName.$error }" >
                    <label class="form__label">Your fullname</label>
                    <input class="form__input" required v-model.trim="$v.form.fullName.$model"/>
                    <div class="error" v-if="!$v.form.fullName.minLength">Fullname must have at least  {{ $v.form.fullName.$params.minLength.min }} characters.</div>
                </div>
                <div class="form-group" :class="{ 'form-group--error': $v.form.username.$error }">
                    <label class="form__label">Your username</label>
                    <input  required class="form__input" v-model.trim="$v.form.username.$model"  />
                    <div class="error" v-if="!$v.form.username.minLength">Username must have at least  {{ $v.form.username.$params.minLength.min }} characters.</div>
                </div>
                <div class="form-group" :class="{ 'form-group--error': $v.form.password.$error }">
                    <label class="form__label">Your password</label>
                    <input class="form__input" required v-model.trim="$v.form.password.$model" type="password" />
                    <div class="error" v-if="!$v.form.password.minLength">Password must have at least {{ $v.form.password.$params.minLength.min }} characters.</div>
                </div>
                <div class="form-group">
                    <label class="form__label">Your gender</label>
                    <b-form-select v-model="form.gender" class="mb-3" >
                      <b-form-select-option value=null>Please select an gender option</b-form-select-option>
                      <b-form-select-option value="females">Females</b-form-select-option>
                      <b-form-select-option value="males">Males</b-form-select-option>
                    </b-form-select>
                </div>
                <div class="form-group" :class="{ 'form-group--error': $v.form.email.$error }">
                    <label class="form__label">Your email</label>
                    <input required class="form__input" v-model.trim="$v.form.email.$model" type="email"/>
                    <div class="error" v-if="!$v.form.email.minLength">Email must have at least {{$v.form.email.$params.minLength.min}} letters.</div>
                </div>
                <div class="form-group" :class="{ 'form-group--error': $v.form.phone.$error }">
                    <label class="form__label">Your phone</label>
                    <input class="form__input" required v-model.trim="$v.form.phone.$model"/>
                    <div class="error" v-if="!$v.form.phone.maxLength">Phone not later than {{$v.form.phone.$params.maxLength.max}} letters.</div>
                    <div class="error" v-if="!$v.form.phone.minLength">Phone not later than {{$v.form.phone.$params.minLength.max}} letters.</div>
                    <div class="error" v-if="!$v.form.phone.vnf_regex">Name must have at least {{$v.form.phone.$params.vnf_regex}} letters.</div>
                </div>
                <div class="formgroup">
                  <a href="./login">Login?</a>
                  <a href="#">Forgot password?</a>
                </div>
                <button class="button" type="submit" :disabled="submitStatus === 'PENDING'">Submit!</button>
                <p class="typo__p" v-if="submitStatus === 'OK'">Thanks for your submission!</p>
                <p class="typo__p" v-if="submitStatus === 'ERROR'">Please fill or select the form correctly.</p>
                <p class="typo__p" v-if="submitStatus === 'PENDING'">Sending...</p>
            </form>
            <!-- <pre>{{ $v }}</pre> -->
        </div>
    </div>
</template>

<script>
import {PATH} from '../index/index.js'
import { required, minLength, helpers, maxLength} from "vuelidate/lib/validators";
const vnf_regex = helpers.regex('09.....',/((09|03|07|08|05)+([0-9]{8})\b)/g)
export default {
   data() {
    return {
      form: {
        username: '',
        password: '',
        gender: null,
        email: '',
        phone: '',
        fullName: ''
      },
      submitStatus: null
    }
  },
  validations: {
    form: {
      username: {
        required,
        minLength: minLength(4),
      },
      password: {
        required,
        minLength: minLength(6)
      },
      gender: {
        required,
      },
      email: {
        required,
        minLength: minLength(5),
      },
      phone: {
        required,
        maxLength: maxLength(10),
        minLength: minLength(10),
        vnf_regex
      },
      fullName: {
        required,
        minLength: minLength(5)
      }
    }
    
  },
  methods: {
    submit() {
      console.log('submit!')
      this.$v.$touch()
      if (this.$v.$invalid) {
        this.submitStatus = 'ERROR'
      } else {
        // do your submit logic here
        this.register(this.form)
            this.submitStatus = 'PENDING'
            setTimeout(() => {
            this.submitStatus = 'OK'
            }, 500)
      }
    },
    register(form) {
      console.log(form)
      fetch(`${PATH}api/auth/signup`,
      {  method: 'POST',
          headers: { 
              'Content-Type': 'application/json'  
          },
          body: JSON.stringify(form)
      })
      .then(response => { 
        console.log(response)
          if(!response.ok){
            alert("Username already exists")
          }else{
            alert("You have successfully registered")
            this.$router.push("/login")
          }
        })
      .catch(error => {
            console.log(error)
      });
    }
  }
}
</script>

<style scoped lang="scss">
.div-register{
    width: 100%;
    height: 100vh;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;

    #container-register {
      box-shadow: 10px 10px 5px #1ac7b6;
      background-color: #eeeeee;
    h1 {
            color: #1dbfaf;
            margin-bottom: 30px;
            font-weight: 900;
            text-align: center;
        }
        .form-register{
            width: 400px;
            height: 500px;
            padding: 0 20px;
            display: flex;
            border-radius: 5px;
            flex-direction: column;
            justify-content: center;
            
            .form-group{
                display: flex;
                margin-bottom: 12px;
                flex-direction: column;
                height: 60px;
                position: relative;
                label{
                    display: inline-block;
                    position: absolute;
                    top: -22px;
                }
                .error{
                  text-align: left;
                  font-size: 0.8rem;
                  margin: 0;
                  margin-bottom: 16px;
                  color: rgb(248, 23, 23);
                }
                .form__input{
                    height: 30px;
                    padding: 8px 12px;
                    border: 1px solid #b3b3b3;
                    border-radius: 3px;
                    outline: none;
                    font-size: 1.2rem;
                }
                .form-control:hover {
                    border-color: #1ac7b6;
                }
                
            }
            
        }
        .button {
            outline: none;
            background-color:  #1ac7b6;
            margin-top: 12px;
            padding: 12px 16px;
            font-weight: 600;
            color: #fff;
            border: none;
            width: 100%;
            font-size: 14px;
            border-radius: 8px;
            cursor: pointer;
            transition: all 0.3s;
            margin-bottom: 10px;
         
            :hover {
                color: #1ac7b6;
                background-color: #fff;
            }
        }
      .formgroup{
          display: flex;
          align-items: center;
          flex-direction: row;
          justify-content: space-between;

        a{
            text-decoration: none;
            color: #b3b3b3;
        }
      } 
    }
}
</style>