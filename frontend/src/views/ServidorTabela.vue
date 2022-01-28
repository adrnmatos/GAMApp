<template>
  <div>
    <table>
      <caption>
        Tabela de Servidores Cadastrados
      </caption>
      <thead>
        <tr>
          <th>matricula</th>
          <th>nome</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="user of users" v-bind:key="user">
          <td>{{ user.matricula }}</td>
          <td>{{ user.name }}</td>
        </tr>
      </tbody>
      <tfoot>
        <p>Lorem ipsum dolor sit amet.</p>
      </tfoot>
    </table>
  </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
  computed: {
    ...mapState(['users']),
  },
  beforeMount() {
    this.$store.dispatch('getAllUsers');
  },
};
</script>
