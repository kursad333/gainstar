import { createRouter, createWebHistory } from 'vue-router'
import SessionCurrent from "@/views/session-current.vue";
import SessionCreate from "@/views/session-create.vue";
import SessionAdd from "@/views/session-add.vue";
import Welcome from "@/views/welcome.vue";
import UserHistory from "@/views/user-history.vue";
import UserProfile from "@/views/user-profile.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Welcome,
    },
    {
      path: '/history',
      name: 'history',
      component: UserHistory
    },
    {
      path: '/profile',
      name: 'profile',
      component: UserProfile
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
