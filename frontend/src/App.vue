<template>
  <div id="main">
    <header>
      <nav>
        <router-link :to="{ name: 'Home' }">Home</router-link> |
        <router-link :to="{ name: 'ServidoresCreate' }">Servidor</router-link>
        <router-link :to="{ name: 'ServidoresIndex' }"
          >TabelaServidor</router-link
        >
        <router-link :to="{ name: 'ProcessosCreate' }">Processo</router-link>
        <router-link :to="{ name: 'ProcessosIndex' }"
          >TabelaProcesso</router-link
        >
      </nav>
    </header>
    <main>
      <router-view />
    </main>
    <footer>
      <p>
        Lorem ipsum dolor, sit amet consectetur adipisicing elit. Eos, corporis?
      </p>
    </footer>
  </div>
</template>
