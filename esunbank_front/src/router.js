import {createRouter, createWebHistory} from 'vue-router'
import HomePage from '../src/views/HomePage.vue';
import Register from '../src/views/RegisterPage.vue';
import LoginPage from '../src/views/LoginPage.vue';
import AddPostPage from "./views/AddPostPage.vue";
import ShowPostPage from "./views/ShowPostPage.vue";
import Navbar from '../src/components/Navbar.vue';


const routes = [

    {
        path: '/',
        component: Navbar ,
        children: [
            {
                path: '/',
                component: HomePage,
            },
            {
              path: 'register',
              component: Register,
            },
            {
              path: 'login',
              component: LoginPage,
            },
            {
              path: 'post/add',
              component: AddPostPage,
            },
            {
              path: 'post/show',
              component: ShowPostPage,
            },

        ]
    },
]


const router = createRouter({
    history: createWebHistory(),
    routes
})


export default router