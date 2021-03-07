import { createRouter, createWebHistory } from 'vue-router'
import Vue from 'vue'
import VueRouter from 'vue-router'
import NewMusics from '../views/NewMusics.vue'
import videomusics from '../views/VideoMusics.vue'
import AdminHome from '../views/Admin.vue'
import FileUpload from '../views/FileUpload'
import Home2 from '../views/Home2.vue'
import Topic from '../views/Topic.vue'

Vue.use(VueRouter)
const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../views/Index.vue'),
  },
  {
    path: '/user',
    component: () => import( '../views/Home.vue'),
    children: [
      {
        path: '/discover',
        component: () => import('../components/Discover.vue')
      },
      {
        path: '/new',
        component: () => import('../components/New.vue')
      },
      {
        path: '/chart',
        component: () => import('../components/Chart.vue')
      },
      {
        path: '/artist',
        component: () => import('../components/Artist.vue')
      },
      {
        path: '/profile',
        component: () => import('../components/Profile.vue')
      },
      {
        path:'/category',
        component: ()=> import('../components/Category')
      },
      {
        path:'/search',
        component:()=> import('../components/Search')
      },
      {
        path: '/home',
        name: 'home',
        component: Home2,
      },
      {
        path: '/upload',
        name: 'Upload',
        component: FileUpload,
      },
      {
        path: '/playlist/NewMusics',
        name: 'NewMusics',
        component: NewMusics
      },
      {
      path: '/video',
      name: 'videomusics',
      component: videomusics
      },
      {
        path: '/playlist/topic',
        name: 'topic',
        component: Topic
        },
      {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
      },
      
      {
        path: '/detail',
        name: 'detail',
        component: () => import('../components/web/DetailSong.vue')
      }
      ,
      {
        path: '/topranking',
        name: 'topranking',
        component: ()=> import('../views/TopRanking.vue')
      },
      {
        path: '/categoryDetail',
        component: () => import ('../components/DetailCategory')
      }
      
      
    ]
  }

  ,
  {
    path: '/admin',
    name: 'Admin',
    component: AdminHome,
    children: [
      {
        path: '/admin/home',
        name: 'AdminHome',
        component: () => import('../components/Admin/Home.vue')
    
      },
      {
        path: '/admin/list-account',
        name: 'ListAccount',
        component: () => import( '../components/Admin/account/List.vue')
    
      },
      {
        path: '/admin/insert',
        component: () => import( '../components/Admin/account/Insert.vue')
    
      },
      {
        path: '/admin/upload-song',
        name: 'uploadSong',
        component: ()=> import('../components/Admin/song/UploadSong.vue')
      },
      {
        path: '/admin/list-song',
        name: 'ListSong',
        component: ()=> import('../components/Admin/song/ListSong.vue')
      },
      {
        path: '/admin/list-video',
        name: 'ListVideo',
        component: ()=> import('../components/Admin/video/ListVideo.vue')
      },
    ]
    
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue')

  },
  {
    path: '/register',
    name: 'Register',
    component: () => import('../views/Register.vue')

  },
  {
    path: '/profile',
    name: 'profile',
    component: () => import('../views/MyAccount.vue')

  }

      
  ]

  


const router = new VueRouter({
    mode:'history',
    base: (process.env.BASE_URL),
    routes
})

router.beforeEach((to, from, next) => {
  // redirect to login page if not logged in and trying to access a restricted page
  const publicPages = ['/', '/login', '/register'];
  const authRequired = !publicPages.includes(to.path);
  const loggedIn = localStorage.getItem('username');

  if (authRequired && !loggedIn) {

  }
  next();
})

export default router
