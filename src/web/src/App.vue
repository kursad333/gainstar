<script setup lang="ts">
import {RouterLink, RouterView} from 'vue-router'
import MobileContainer from "@/components/template/mobile-container.vue";
import BottomNav from "@/components/nav/bottom-nav.vue";
</script>

<template>
  <mobile-container>
    <main class="pb-12">
      <RouterView />
    </main>
    <bottom-nav/>
  </mobile-container>
</template>

<style scoped>

</style>
