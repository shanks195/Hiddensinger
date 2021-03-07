import Vue from 'vue'
import App from './App.vue'
import router from './router'
import VueSplide from '@splidejs/vue-splide';
import store from './store'
import Vuelidate from 'vuelidate'
import { BootstrapVue, IconsPlugin, FormDatepickerPlugin } from 'bootstrap-vue'
Vue.use(Vuelidate)
Vue.use(VueSplide)
Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.use(FormDatepickerPlugin)


// icon
import {library} from '@fortawesome/fontawesome-svg-core'
import {faHeart, faExternalLinkAlt, faStepForward, faStepBackward, faPlay, faPause, faThumbsDown, faThumbsUp,faTimes, faUser, faEnvelope, faLock, faAddressBook, faTransgender, faPhone
} from '@fortawesome/free-solid-svg-icons'
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome'
library.add(faHeart, faExternalLinkAlt, faStepForward, faStepBackward, faPause, faPlay, faThumbsUp, faThumbsDown, faTimes, faUser, faEnvelope, faLock, faAddressBook, faTransgender, faPhone)
Vue.component('font-awesome-icon', FontAwesomeIcon)


Vue.config.productionTip = false
new Vue({
    router,
    store,
    render:h=>h(App)
}).$mount('#app')

