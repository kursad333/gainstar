<template>
  <nav class="w-auto flex justify-evenly items-center px-1 h-15 text-2xl">
    <router-link to="/"
                 active-class="active" class="w-10 text-center">
      <i class="bi bi-house-fill"/>
    </router-link>
    <router-link to="/history"
                 active-class="active" class="w-10 text-center">
      <i class="bi bi-clock-history"/>
    </router-link>
    <router-link to="/session/create"
                 active-class="active" class="w-10 text-center">
      <i class="bi bi-plus-square-fill"/>
    </router-link>
    <router-link to="/profile"
                 active-class="active" class="w-10 text-center">
      <i class="bi bi-person-fill"/>
    </router-link>
  </nav>
</template>

<script setup lang="ts">

</script>

<style scoped>
nav {
  background-color: #8c81fd;
  color: #ffffff;
}

.active {
  color: #4636FC;
}
</style>
