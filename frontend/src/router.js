import { createRouter, createWebHistory } from 'vue-router';
import HomeView from './views/HomeView.vue';
import UsersView from './views/UsersView.vue';
import AboutView from './views/AboutView.vue';
import UserDetails from './components/UserDetails.vue';


//Definicja tras
const routes = [
    { path: '/', component: Home, name: 'HomeView' },
    { path: '/users', component: Users, name: 'UsersView' },
    { path: '/users/:id', component: UserDetails }
    { path: '/about', component: About, name: 'AboutView' },
];

//Tworzenie routera
const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;