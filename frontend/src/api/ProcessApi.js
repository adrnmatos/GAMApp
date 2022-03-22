import Client from './services/axios';

const resource = '/api/processes';

export default {
  get() {
    return Client.get(`${resource}`);
  },

  create(payload) {
    return Client.post(`${resource}`, payload);
  },
};
