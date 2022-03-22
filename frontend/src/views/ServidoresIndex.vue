<template>
  <div>
    <domain-table :domain="users"></domain-table>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import DomainTable from '../components/DomainTable.vue';
export default {
  name: 'ServidoresIndex',
  components: { DomainTable },
  data() {
    return {};
  },

  beforeMount() {
    this.$store.dispatch('user/getAllUsers');
  },

  computed: {
    ...mapState('user', {
      users: (state) => state.users,
    }),
  },
};
</script>

<style scoped></style>
