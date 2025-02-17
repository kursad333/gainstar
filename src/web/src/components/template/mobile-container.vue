<template>
  <div class="container p-3 flex flex-col justify-between content-center md:w-2/3 xl:w-2/5">
    <slot></slot>
  </div>
</template>

<script setup lang="ts">
</script>

<style scoped>
@media (min-width: 768px) {
  .container {
    border: 2px solid black;
    border-radius: 15px;
    margin: 3px 0 3px 0;
    min-height: calc(100vh - 6px);
  }
}


</style>
