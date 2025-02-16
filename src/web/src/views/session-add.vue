<template>
  <h1>session-add</h1>
  <div>
    <label for="muscle-group">Muscle Group</label>
    <select id="muscle-group">
      <option v-for="muscleGroup in muscleGroups" :key="muscleGroup">{{muscleGroup}}</option>
    </select>
  </div>
</template>

<script setup lang="ts">
import {type Ref, ref} from "vue";

const muscleGroups: Ref<string[]> = ref<string[]>([
  "Chest",
  "Back",
  "Legs",
  "Shoulders",
  "Arms",
  "Core",
  "Cardio",
  "Other"
]);



</script>

<style scoped>

</style>
