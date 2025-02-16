<template>
  <main class="container p-3 flex-col md:w-1/2 xl:w-1/3">
    <slot name="content"></slot>
    <slot name="btm-nav"></slot>
  </main>
</template>

<script setup lang="ts">

</script>

<style scoped>
main {
  display: flex;
  justify-content: space-between;
  background-color: #4636FC;
  min-height: 100vh;
}
</style>
