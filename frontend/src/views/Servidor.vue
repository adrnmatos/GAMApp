<template>
  <div>
    <h1>Server page</h1>

    <input type="text" v-model="user.name" />
    <button @click="criar">Submit</button>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'Servidor',
  data () {
    return {
      user: {
        name: ''
      }
    }
  },
  methods: {
    ...mapActions(['criarUsuario']),
    criar: function () {
      this.criarUsuario(this.user.name)
    }
  }
}
</script>
