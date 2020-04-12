import Vue from 'vue';
import VueRouter from 'vue-router';
import Toasted from 'vue-toasted';
import VueTypedJs from 'vue-typed-js';
import Notifications from 'vue-notification';
import VCalendar from 'v-calendar';
import VueSlider from 'vue-slider-component';
import 'vue-slider-component/theme/default.css';

// import ElementUI from 'element-ui';
// import 'element-ui/lib/theme-chalk/index.css';
// import locale from 'element-ui/lib/locale/lang/ko';

//view 쪽
import Main from '../views/Main.vue';
import Attention from '../views/Attention.vue';
import Mypage from '../views/MyPage.vue';
import SellRoom from '../views/SellRoom.vue';
import SearchView from '../views/SearchView.vue';
import RoomDetail from '../views/RoomDetail.vue';
//컴포넌트쪽
import RecentSearchRoom from '../components/content2/RecentSearchRoom.vue';
import KeepRoom from '../components/content2/KeepRoom.vue';
import KeepRoomBanner from '../components/banner/KeepRoom.vue';
import RecentRoomBanner from '../components/banner/RecentSearchRoom.vue';
import Profile from '../components/banner/Profile.vue';
import RoomWrite from '../components/banner/RoomWrite.vue';

Vue.use(VueRouter);
Vue.use(VueTypedJs);
Vue.use(Toasted);
Vue.use(Notifications);
Vue.use(VCalendar);
Vue.component('VueSlider', VueSlider);
// Vue.use(ElementUI, { locale });

const routes = [{
        path: '/',
        name: 'Main',
        component: Main,
        children: [{
                path: '/',
                component: RecentSearchRoom
            },
            {
                path: '/keep',
                component: KeepRoom
            }
        ]
    },

    {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/About.vue')
    },

    {
        path: '/attention',
        name: Attention,
        component: Attention,
        children: [{
                path: '/',
                component: RecentRoomBanner
            },
            {
                path: '/attention/keep',
                component: KeepRoomBanner
            }
        ]
    },
    {
        path: '/mypage',
        name: 'Mypage',
        component: Mypage,
        children: [{
            path: '/',
            component: Profile
        }]
    },
    {
        path: '/sellRoom',
        name: 'SellRoom',
        component: SellRoom,
        children: [{
            path: '/',
            component: RoomWrite
        }]
    },
    {
        path: '/search',
        name: 'search',
        component: SearchView
    },
    {
        path: '/search/detail/:roomId',
        name: 'detail',
        component: RoomDetail
    },
    {
        path: '/*',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/About.vue')
    }
];

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
});

export default router;