import { createStore } from 'vuex'
import apiFactory from '../api/ApiFactory'

const client = apiFactory.get('user')

export default createStore({
  state: {
    user: {}
  },
  mutations: {
    setUser (state, newUser) {
      state.user = newUser
    }
  },
  actions: {
    async criarUsuario (context, userName) {
      const newUser = await client.create({ name: userName })
      context.commit('setUser', newUser)
    }
  },
  modules: {}
})
