<template>
    <!-- nav -->
    <nav>
      <div class="nav-left">
        <div class="search">
          <svg  fill="white"  xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"/></svg>
          <input type="text" placeholder="Search">
        </div>
      </div>
      <div class="nav-right">
        <div class="icon-menu">
          <div class="icon1"></div>
          <div class="icon2" ><router-link to="upload"><svg  fill="white"  xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M5 4v2h14V4H5zm0 10h4v6h6v-6h4l-7-7-7 7z"/></svg></router-link></div>
          <div class="icon3"><svg   aria-hidden="true" focusable="false" data-prefix="fas" data-icon="cog" class="svg-inline--fa fa-cog fa-w-16" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path fill="currentColor" d="M487.4 315.7l-42.6-24.6c4.3-23.2 4.3-47 0-70.2l42.6-24.6c4.9-2.8 7.1-8.6 5.5-14-11.1-35.6-30-67.8-54.7-94.6-3.8-4.1-10-5.1-14.8-2.3L380.8 110c-17.9-15.4-38.5-27.3-60.8-35.1V25.8c0-5.6-3.9-10.5-9.4-11.7-36.7-8.2-74.3-7.8-109.2 0-5.5 1.2-9.4 6.1-9.4 11.7V75c-22.2 7.9-42.8 19.8-60.8 35.1L88.7 85.5c-4.9-2.8-11-1.9-14.8 2.3-24.7 26.7-43.6 58.9-54.7 94.6-1.7 5.4.6 11.2 5.5 14L67.3 221c-4.3 23.2-4.3 47 0 70.2l-42.6 24.6c-4.9 2.8-7.1 8.6-5.5 14 11.1 35.6 30 67.8 54.7 94.6 3.8 4.1 10 5.1 14.8 2.3l42.6-24.6c17.9 15.4 38.5 27.3 60.8 35.1v49.2c0 5.6 3.9 10.5 9.4 11.7 36.7 8.2 74.3 7.8 109.2 0 5.5-1.2 9.4-6.1 9.4-11.7v-49.2c22.2-7.9 42.8-19.8 60.8-35.1l42.6 24.6c4.9 2.8 11 1.9 14.8-2.3 24.7-26.7 43.6-58.9 54.7-94.6 1.5-5.5-.7-11.3-5.6-14.1zM256 336c-44.1 0-80-35.9-80-80s35.9-80 80-80 80 35.9 80 80-35.9 80-80 80z"></path></svg></div>
          <div class="icon4"><svg  fill="white" xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M12 5.9c1.16 0 2.1.94 2.1 2.1s-.94 2.1-2.1 2.1S9.9 9.16 9.9 8s.94-2.1 2.1-2.1m0 9c2.97 0 6.1 1.46 6.1 2.1v1.1H5.9V17c0-.64 3.13-2.1 6.1-2.1M12 4C9.79 4 8 5.79 8 8s1.79 4 4 4 4-1.79 4-4-1.79-4-4-4zm0 9c-2.67 0-8 1.34-8 4v3h16v-3c0-2.66-5.33-4-8-4z"/></svg></div>
          <div class="icon5"></div>
        </div>
      </div>
    </nav>
</template>

<style scoped>
*{
  color: white;
}
 nav{
    position: sticky;
    top: 0;
    background-color: #37075d;
    height: 100px;
    display: grid;
    grid-template-columns: 7fr 3fr;
    z-index: 2;
    box-shadow: 0px 2px rgba(0, 0, 0, 0.06);
    margin-bottom: 50px;
  }
  .search svg{
    position: absolute;
    z-index: 1;
    width: 2rem;
    height: 2rem;
    right: 3px;
    top: 13px;
  }
  .search{
    height: 60%;
    background: rgba(0, 0, 0, 0.05);
    border-radius: 50px;
    position: relative;
    margin-left: 10px;
    padding-left: 50px;
  }
  .search input{
    border: 0;
    width: 95%;
    height: 95%;
    border-radius: 50px;
    background: rgba(0, 0, 0, 0);
    font-size: 20px;
  }
  .search input:focus{
    outline: none;
    border-radius: 50px;
  }
  .nav-left{
    display: grid;
    align-items: center;
  }
  .nav-right{
    display: grid;
    align-items: center;
  }
  .icon-menu{
    display: grid;
    grid-template-columns: 50px 50px 50px 50px 50px;
    align-items: center;
    column-gap: 20px;
  }

  .icon-menu .icon4,.icon3, .icon2{
    border-radius: 50px;
    background-color: rgba(0, 0, 0, 0.05);
    height: 50px;
  }
  .icon-menu div{
      border-radius: 50px;
      height: 50px;
    }
  
  
  .icon2, .icon3, .icon4{
    display: grid;
    justify-items: center;
    align-items: center;
    cursor: pointer;
  }
  .icon3 svg{
    width: 25px;
  }
</style>