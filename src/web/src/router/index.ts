import { createRouter, createWebHistory } from 'vue-router'
import HelloWorld from '../components/HelloWorld.vue'
import SessionCurrent from "@/views/session-current.vue";
import SessionCreate from "@/views/session-create.vue";
import SessionAdd from "@/views/session-add.vue";
import Welcome from "@/views/welcome.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Welcome,
    },
    {
      path: '/session',
      name: 'session',
      component: SessionCurrent
    },
    {
      path: '/session/create',
      name: 'session-create',
      component: SessionCreate
    },
    {
      path: '/session/add',
      name: 'session-add',
      component: SessionAdd
    }
  ],
})

export default router
