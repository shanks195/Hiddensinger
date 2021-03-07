function setStorageUser(account){
    localStorage.setItem('username',account.username);
    localStorage.setItem('accessToken',account.accessToken);
    localStorage.setItem('roles',account.roles.join());
}
export default setStorageUser;