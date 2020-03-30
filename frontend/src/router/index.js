import Vue from 'vue';
import VueRouter from 'vue-router';
import Main from '../views/Main.vue';
import RecentSearchRoom from '../components/content2/RecentSearchRoom.vue';
import KeepRoom from '../components/content2/KeepRoom.vue';
import Toasted from 'vue-toasted';
import VueTypedJs from 'vue-typed-js';

Vue.use(Toasted);
Vue.use(VueRouter);
Vue.use(VueTypedJs);

const routes = [{
        path: '/',
        name: 'Main',
        component: Main,
        children: [{
                path: '/',
                component: RecentSearchRoom,
            },
            {
                path: '/keep',
                component: KeepRoom,
            },
        ],
    },
    {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/About.vue'),
    },
    {
        path: '/*',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/About.vue'),
    },
];

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes,
});

export default router;