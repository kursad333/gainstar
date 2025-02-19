<template>
  <h1 class="f-montserrat fw-400 text-4xl py-5">NIEUWE WORKOUT</h1>
  <h2 class="f-montserrat fw-400 text-3">SELECTEER GROEPEN</h2>
  <div class="grid grid-cols-2 gap-1">
    <div
      class="group-container p-3 f-mono fw-400 text-center cursor-pointer"
      :class="selectedMuscleGroups.includes(muscle) ? 'active' : '' "
      v-for="muscle in allMuscleGroups"
      :key="muscle.id"
      @click="() => {selectMuscleGroup(muscle)}">
      {{ muscle.toUpperCase() }}
    </div>
  </div>
</template>

<script setup lang="ts">
import {onMounted, type Ref, ref} from "vue";
import type {MuscleGroup} from "@/model/MuscleGroup.ts";
import {sessionService} from "@/service/SessonService.ts";

const selectedMuscleGroups: Ref<number[]> = ref<number[]>([]);
const allMuscleGroups: Ref<MuscleGroup[]> = ref<MuscleGroup[]>([]);
const isLoading: Ref<boolean> = ref(false);

onMounted(() => {
  fetchAllMuscleGroups()
  console.log(allMuscleGroups)
})

function fetchAllMuscleGroups(): void {
  sessionService.getAllMuscleGroups()
      .then((response: MuscleGroup[]) => {
        console.log(response)
        allMuscleGroups.value = response;
        isLoading.value = false;
      })
      .catch((error: string) => {
        console.log(error);
      });
  console.log("done fetching")
}

const selectMuscleGroup = (muscleGroupId: id) => {
  if (selectedMuscleGroups.value.includes(muscleGroupId)) {
    selectedMuscleGroups.value = selectedMuscleGroups.value.filter((group) => group !== muscleGroupId);
  } else {
    selectedMuscleGroups.value.push(muscleGroupId);
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

<style scoped>

</style>
