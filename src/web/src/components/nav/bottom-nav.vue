<template>
  <nav class="w-auto flex justify-evenly items-center px-1 h-10 text-2xl md:h-15 lg:text-3xl">
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
  background-color: #4636FC;
  color: #a69efa;
  border-radius: 15px;
}
.active {
  color: #ffffff;
}

@media (max-width: 767px) {
  nav {
    position: absolute;
    bottom: 0;
    left: 0;
    width: calc(100%);
    border-radius: 0;
  }
}
</style>
