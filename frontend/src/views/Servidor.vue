<template>
  <div>
    <div class="crud-servidor">
      <h1>Cadastro de Servidor</h1>
      <fieldset>
        <legend><span>1</span> Nome, Matricula & Data de admissão</legend>
        <div class="inner-wrap">
          <label for="matricula">Matricula </label>
          <input type="text" id="matricula" v-model="user.matricula" />
          <label for="name">Nome Completo </label>
          <input type="text" id="name" v-model="user.nome" />
          <label id="dataAdmissao">Data de admissão</label>
          <input type="date" id="dataAdmissao" v-model="user.dataAdmissao" />
          <!-- <span class="privacy-policy"> -->
          <input type="checkbox" id="check-ativo" v-model="user.ehAtivo" />
          <label for="check-ativo">ativo</label>
          <!-- </span> -->
        </div>
      </fieldset>

      <fieldset>
        <legend><span>2</span> Email & Telefone</legend>
        <div class="inner-wrap">
          <label for="email">Email</label>
          <input type="email" id="email" v-model="user.email" />
          <telefone-input @change="telefoneUpdateListener"></telefone-input>
        </div>
      </fieldset>

      <fieldset>
        <legend><span>3</span> Cargo, Função & Formação</legend>
        <div class="inner-wrap">
          <label for="cargo">Cargo</label>
          <select id="cargo" v-model="user.cargo">
            <option v-for="cargo of cargos" v-bind:key="cargo">
              {{ cargo }}
            </option>
          </select>
          <label for="funcao">Função</label>
          <select id="funcao" v-model="user.funcao">
            <option v-for="funcao of funcoes" v-bind:key="funcao">
              {{ funcao }}
            </option>
          </select>

          <label for="formacao">Formação</label>
          <select id="formacao" v-model="user.formacao">
            <option v-for="formacao of formacoes" v-bind:key="formacao">
              {{ formacao }}
            </option>
          </select>
        </div>
      </fieldset>
      <div class="button-section">
        <button @click="criar">Criar</button>
      </div>
    </div>
  </div>
</template>

<script>
import TelefoneInput from '../components/TelefoneInput.vue';
import { mapState, mapActions } from 'vuex';

export default {
  name: 'Servidor',
  data() {
    return {
      user: {
        nome: '',
        matricula: '',
        dataAdmissao: '',
        email: '',
        telefone: '',
        ehAtivo: '',
        cargo: '',
        funcao: '',
        formacao: '',
      },
    };
  },

  components: {
    'telefone-input': TelefoneInput,
  },

  beforeCreate() {
    this.$store.dispatch('getCargos');
    this.$store.dispatch('getFuncoes');
    this.$store.dispatch('getFormacoes');
  },

  computed: {
    ...mapState(['cargos', 'funcoes', 'formacoes']),
  },

  methods: {
    ...mapActions(['criarUsuario']),

    telefoneUpdateListener(event) {
      this.user.telefone = event;
    },
    criar: function () {
      const userObj = {
        name: this.user.nome,
        matricula: this.user.matricula,
        dataAdmissao: this.user.dataAdmissao,
        email: this.user.email,
        telefone: this.user.telefone,
        ehAtivo: this.user.ehAtivo,
        cargo: this.user.cargo,
        funcao: this.user.funcao,
        formacao: this.user.formacao,
      };
      console.log(userObj);
      this.criarUsuario(userObj);
    },
  },
};
</script>
