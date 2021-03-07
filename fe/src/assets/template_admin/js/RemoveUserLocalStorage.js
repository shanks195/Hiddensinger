function removeUserLocalStorage(){
    localStorage.removeItem('username');
    localStorage.removeItem('accessToken');
    localStorage.removeItem('roles');
}
export default removeUserLocalStorage;