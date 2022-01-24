import { createStore } from 'vuex';
import apiFactory from '../api/ApiFactory';

const client = apiFactory.get('user');

export default createStore({
  state: {
    user: {},
    cargos: [],
    funcoes: [],
    formacoes: [],
  },

  mutations: {
    SET_USER(state, newUser) {
      state.user = newUser;
    },

    SET_CARGOS(state, cargos) {
      state.cargos = cargos;
    },

    SET_FUNCOES(state, funcoes) {
      state.funcoes = funcoes;
    },

    SET_FORMACOES(state, formacoes) {
      state.formacoes = formacoes;
    },
  },

  actions: {
    async criarUsuario(context, userObj) {
      const newUser = await client.create(userObj);
      context.commit('SET_USER', newUser);
    },

    async getCargos(context) {
      const cargos = await client.getCargos();
      context.commit('SET_CARGOS', cargos.data);
    },

    async getFuncoes(context) {
      const funcoes = await client.getFuncoes();
      context.commit('SET_FUNCOES', funcoes.data);
    },

    async getFormacoes(context) {
      const formacoes = await client.getFormacoes();
      context.commit('SET_FORMACOES', formacoes.data);
    },
  },

  modules: {},
});
