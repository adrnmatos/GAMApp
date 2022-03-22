<template>
  <div>
    <domain-table :domain="processos"></domain-table>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import DomainTable from '../components/DomainTable.vue';

export default {
  name: 'ProcessosIndex',
  components: {
    DomainTable,
  },

  data() {
    return {};
  },

  beforeMount() {
    this.$store.dispatch('process/getAllProcess');
  },

  computed: {
    ...mapState('process', {
      processos: (state) => state.processes,
    }),
  },
};
</script>

<style scoped></style>
