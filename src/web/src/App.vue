<script setup lang="ts">
import {RouterLink, RouterView} from 'vue-router'
import TopNav from "@/components/nav/top-nav.vue";
import BottomNav from "@/components/nav/bottom-nav.vue";
import DefaultPhone from "@/components/template/default-phone.vue";
</script>

<template>
  <div class="viewport-wrapper">
    <main class="container p-3 flex-col md:w-1/2 xl:w-1/3">
      <RouterView />
      <BottomNav />
    </main>
  </div>
</template>

<style scoped>
.viewport-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
}

main {
  display: flex;
  justify-content: space-between;
  background-color: #4636FC;
  min-height: 100vh;
}
</style>
