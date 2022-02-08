import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Watch from "@/views/Watch";

const routes = [
  {
    path: '/',
    name: 'RedirectHome',
    redirect: { name: 'Home' }
  },
  {
    path: '/Home',
    name: 'Home',
    component: Home
  },
  {
    path: '/:title',
    name: 'Watch',
    component: Watch
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
