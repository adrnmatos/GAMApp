import ApiFactory from '../../api/ApiFactory';

const client = ApiFactory.get('processApi');

const state = () => ({
  processes: [],
});

const actions = {
  async getAllProcess(context) {
    const processes = await client.get();
    context.commit('SET_ALL_PROCESS', processes.data);
  },
};

const mutations = {
  SET_ALL_PROCESS(state, allProcess) {
    state.processes = allProcess;
  },
};

export default {
  namespaced: true,
  state,
  actions,
  mutations,
};
