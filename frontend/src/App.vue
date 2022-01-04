<template>
  <div id="main">
    <header>
      <nav>
        <router-link to="/">Home</router-link> |
        <router-link to="/servidor">Servidor</router-link>
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
