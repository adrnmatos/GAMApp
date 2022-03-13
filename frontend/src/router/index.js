import { createRouter, createWebHashHistory } from 'vue-router';
import Home from '../views/Home.vue';
import ServidorTabela from '../views/ServidorTabela';
import Processos from '../views/Processo';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/servidor',
    name: 'Servidor',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ '../views/Servidor.vue'),
  },
  {
    path: '/tabela',
    name: 'TabelaServidor',
    component: ServidorTabela,
  },
  {
    path: '/Processos',
    name: 'Processos',
    component: Processos,
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
