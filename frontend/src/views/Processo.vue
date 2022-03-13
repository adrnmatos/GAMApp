<template>
  <div>
    {{ processes }}
  </div>
</template>

<script>
export default {
  name: 'Processos',
  data() {
    return {
      processes: [],
    };
  },

  created() {
    fetch('http://localhost:8085/api/processes/')
      .then((response) => {
        return response.json();
      })
      .then((processes) => {
        this.processes = processes;
      });
  },
};
</script>

<style scoped></style>
