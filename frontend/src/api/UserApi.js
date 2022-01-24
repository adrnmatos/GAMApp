import Client from './services/axios';

const resource = '/api/users';

export default {
  get() {
    return Client.get(`${resource}`);
  },

  create(payload) {
    return Client.post(`${resource}`, payload);
  },

  getCargos() {
    return Client.get(`${resource}/cargos`);
  },

  getFuncoes() {
    return Client.get(`${resource}/funcoes`);
  },

  getFormacoes() {
    return Client.get(`${resource}/formacoes`);
  },
};
