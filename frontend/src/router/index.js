import Vue from 'vue';
import VueRouter from 'vue-router';
import Main from '../views/Main.vue';
import Toasted from 'vue-toasted';
import VueTypedJs from 'vue-typed-js';

Vue.use(Toasted);
Vue.use(VueRouter);
Vue.use(VueTypedJs);

const routes = [{
        path: '/',
        name: 'Main',
        component: Main,
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
];

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes,
});

export default router;