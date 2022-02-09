import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Watch from "@/views/Watch";

const routes = [
  {
    path: '/:catchAll(.*)',
    redirect: { name: 'Home' }
  },
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/:title',
    name: 'Watch',
    component: Watch
  },
  {
    path: '/:title/:episode',
    name: 'WatchEpisode',
    component: Watch
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
