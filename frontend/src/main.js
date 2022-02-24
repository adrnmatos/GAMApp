import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';

import plugin from '@adrnmatos/telefone-input-component';

createApp(App).use(store).use(router).use(plugin).mount('#app');
