import { createRouter, createWebHashHistory } from 'vue-router';
import Home from '../views/Home.vue';
import ServidorTabela from '../views/ServidoresIndex';
import Processos from '../views/ProcessosCreate';
import ProcessoTabela from '../views/ProcessosIndex';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/servidores/create',
    name: 'ServidoresCreate',
    component: () => import('../views/ServidoresCreate.vue'),
  },
  {
    path: '/servidores',
    name: 'ServidoresIndex',
    component: ServidorTabela,
  },
  {
    path: '/processos/create',
    name: 'ProcessosCreate',
    component: Processos,
  },

  {
    path: '/processos',
    name: 'ProcessosIndex',
    component: ProcessoTabela,
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
