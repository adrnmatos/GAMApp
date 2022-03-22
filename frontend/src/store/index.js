import { createStore } from 'vuex';
import user from './modules/user';
import process from './modules/process';

export default createStore({
  modules: {
    user,
    process,
  },
});
