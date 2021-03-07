import {PATH} from "../../../index/index.js"
function requesLogin(account){
    //post data login
    var errorLogin = document.querySelector(".error-login");
    var rq = new Request(`${PATH}api/auth/signin`,{
    method: 'POST',
    body: JSON.stringify(account),
    headers: new Headers({
        'Content-Type': 'application/json',
        'Authorization':'Basic username:password'
    })
    })
    return fetch(rq)
    .then(response => {
        if (!response.ok) {
        throw Error(response.statusText);
    }
    else {
        return response.json();
    }
    }).then(response =>{
        localStorage.setItem('username',response.username);
        localStorage.setItem('accessToken',response.accessToken)
        localStorage.setItem('roles',response.roles.join())
        errorLogin.style.display = 'none';
        if(response.roles.some((role)=>{
            return role == 'ROLE_ADMIN'||role=='ROLE_MODERATOR';
        })){
            window.location="./admin/home";
        }else{
            window.location="./";
        }
    }).catch(function(error) {
        errorLogin.style.display = 'block';
        console.log('login unsuccessful');
    })
    
            
}
export default requesLogin;
