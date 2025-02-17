<template>
  <h1 class="f-montserrat fw-400 text-4xl py-5">NIEUWE WORKOUT</h1>
  <h2 class="f-montserrat fw-400 text-3">SELECTEER GROEPEN</h2>
  <div class="grid grid-cols-2 gap-1">
    <div
      class="group-container p-3 f-mono fw-400 text-center cursor-pointer"
      :class="selectedMuscleGroups.includes(muscle) ? 'active' : '' " v-for="muscle in muscleGroups"
      @click="() => {selectMuscleGroup(muscle)}">
      {{ muscle.toUpperCase() }}
    </div>
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
const selectedMuscleGroups: Ref<string[]> = ref<string[]>([]);

const selectMuscleGroup = (muscleGroup: string) => {
  if (selectedMuscleGroups.value.includes(muscleGroup)) {
    selectedMuscleGroups.value = selectedMuscleGroups.value.filter((group) => group !== muscleGroup);
  } else {
    selectedMuscleGroups.value.push(muscleGroup);
  }
  console.log(selectedMuscleGroups);
}


</script>

<style scoped>
.group-container {
  border: 1.5px solid var(--primary-color);
}

.group-container.active {
  background-color: #4636FC;
  color: white;
}
</style>


<script setup lang="ts">

</script>

<style scoped>

</style>
