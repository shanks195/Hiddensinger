<template>
  <div id="div-login">
    <div class="error-login">
      <p>Incorrect User or Password!</p>
    </div>
    <div id="container-login">
      <h1>LOGIN</h1>
      <form action="" id="form-login">
        <div class="form-group">
          User name<br /><input
            id="user-name"
            class="form-control"
            type="text"
            placeholder="Input user name"
          />
          <p class="message"></p>
        </div>
        <div class="form-group">
          Password<br /><input
            id="password"
            type="password"
            class="form-control"
            placeholder="Input password"
          />
          <p class="message"></p>
        </div>
        <div class="form-group">
          <a href="./register">Sign-Up?</a>
          <a href="#">Forgot password?</a>
        </div>
        <button class="form-submit">Login</button>
       
      </form>
    </div>
  </div>
</template>

<script>
import requesLogin from '../assets/template_admin/js/RequesLogin'
import removeUserLocalStorage from '../assets/template_admin/js/RemoveUserLocalStorage'
export default {
  name: "Login",
  data() {
    return {
      
    };
  },
  mounted() {
    removeUserLocalStorage();
    Validator({
      form: "#form-login",
      divInput:".form-group",
      errorSelector: ".message",
      rules: [
        isRequired("#user-name"),
        isRequired("#password"),
        minLength("#password", 6)
      ],
      
    });
    function Validator(option) {
      var selectorRules = {};
      function validate(inputElement, rule) {
        var errorMessage;
        var errorElement = inputElement.parentElement.querySelector(
          option.errorSelector
        );
        var rules = selectorRules[rule.selector];
        for (var i = 0; i < rules.length; i++) {
          errorMessage = rules[i](inputElement.value);
          if (errorMessage) {
            errorElement.innerText = errorMessage;
            inputElement.parentElement.classList.add("invalid");
            break;
          } else {
            errorElement.innerText = "";
            inputElement.parentElement.classList.remove("invalid");
          }
        }
        return errorMessage;
      }

      function inputEvent(inputElement) {
        var errorElement = inputElement.parentElement.querySelector(
          option.errorSelector
        );
        errorElement.innerText = "";
        inputElement.parentElement.classList.remove("invalid");
      }

      var formElement = document.querySelector(option.form);
      if (formElement) {
        var formValid = true;
        formElement.onsubmit = function (e) {
          e.preventDefault();
          option.rules.forEach(function (rule) {
            var inputElement = formElement.querySelector(rule.selector);
            var isValid = validate(inputElement, rule);
            if (isValid) {
              formValid = false;
            }
          });
          if (formValid) {
            var account = {};
            account.username=formElement.querySelector('#user-name').value;
            account.password=formElement.querySelector('#password').value;
            //post data login
            var responseLogin = requesLogin(account);
          } else {
            console.log("nhap chua chinh xac");//error
            formValid = true;
          }
        };
        option.rules.forEach(function (rule) {
          if (Array.isArray(selectorRules[rule.selector])) {
            selectorRules[rule.selector].push(rule.test);
          } else {
            selectorRules[rule.selector] = [rule.test];
          }
          var inputElement = formElement.querySelector(rule.selector);
          if (inputElement) {
            inputElement.onblur = function () {
              validate(inputElement, rule);
            };
            inputElement.oninput = function () {
              inputEvent(inputElement);
            };
          }
        });
      }
    }

    function isRequired(selector) {
      return {
        selector: selector,
        test: function (value, message) {
          return value.trim()
            ? undefined
            : message || "Please input field!";
        },
      };
    }
    
    function minLength(selector, min) {
      return {
        selector: selector,
        test: function (value, message) {
          return value.length >= min
            ? undefined
            : message || `Input min to ${min} chars!`;
        },
      };
    }
    
  },
  methods: {},
};
</script>

<style scoped lang="css">

a {
  text-decoration: none;
  color: #b3b3b3;
}

.form-group{
  display: flex;
  justify-content: space-between;
}

#div-login {
  width: 100%;
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.error-login{
  width: 100%;
  text-align: center;
  color: #f33a58;
  background-color: #1ac7b6;
  position: absolute;
  top: 0;
  display: none;
}
#container-login {
  box-shadow: 10px 10px 5px #1ac7b6;
  background-color: rgb(238, 238, 238);
}
#container-login > h1 {
  color: #1dbfaf;
  margin-top: 20px;
  font-weight: 900;
  text-align: center;
}
#form-login {
  width: 400px;
  height: 400px;
  padding: 0 20px;
  display: flex;
  border-radius: 5px;
  flex-direction: column;
  justify-content: center;
}
.form-group {
  display: flex;
  margin-bottom: 16px;
  flex-direction: column;
  height: 80px;
}
.message {
  text-align: left;
  font-size: 1rem;
  margin: 0;
}

.form-control {
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

.form-group.invalid .form-control {
  border-color: #f33a58;
}

.form-group.invalid .message {
  color: #f33a58;
}
.form-group:nth-child(3) {
  height: initial;
  display: flex;
  align-items: center;
  flex-direction: row;
  height: initial;
}
.form-group:nth-child(3) > .form-control {
  margin-left: 0.5rem;
  margin-right: 2rem;
}

.form-submit {
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
  border: 1px solid #1ac7b6;
}

.form-submit:hover {
  color: #1ac7b6;
  background-color: #fff;
}

.spacer {
  margin-top: 36px;
}
</style>
