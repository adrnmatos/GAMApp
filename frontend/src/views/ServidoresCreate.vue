<template>
  <div>
    <div class="crud-servidor">
      <h1>Cadastro de Servidor</h1>
      <fieldset>
        <legend><span>1</span> Nome, Matricula & Data de admissão</legend>
        <div class="inner-wrap">
          <label for="matricula">matricula</label>
          <input type="text" id="matricula" v-model="user.matricula" />
          <label for="name">nome</label>
          <input type="text" id="name" v-model="user.nome" />
          <label id="dataAdmissao">Data de admissão </label>
          <input type="date" id="dataAdmissao" v-model="user.dataAdmissao" />
        </div>
        <input type="checkbox" id="check-ativo" v-model="user.ehAtivo" />
        <label for="check-ativo">ativo</label>
      </fieldset>

      <fieldset>
        <legend><span>2</span> Email & Telefone</legend>
        <div class="inner-wrap">
          <label for="email">email</label>
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
import { mapState, mapActions } from 'vuex';

export default {
  name: 'ServidoresCreate',
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

  beforeCreate() {
    this.$store.dispatch('user/getCargos');
    this.$store.dispatch('user/getFuncoes');
    this.$store.dispatch('user/getFormacoes');
  },

  computed: {
    ...mapState('user', {
      cargos: (state) => state.cargos,
      funcoes: (state) => state.funcoes,
      formacoes: (state) => state.formacoes,
    }),
  },

  methods: {
    ...mapActions('user', ['criarUsuario']),

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
      this.criarUsuario(userObj);
    },
  },
};
</script>

<style scoped>
h1 {
  font: normal 30px 'Bitter', serif;
  text-align: center;
}

.crud-servidor {
  width: 50%;
  margin: 50px auto;
  padding: 30px;
  background: #f0f0f0;
  display: grid;
  grid-template-columns: 1fr;
  gap: 5px;
}

.crud-servidor > fieldset {
  border: 1px solid #2a88ad;
  margin-bottom: 30px;
  padding: 30px;
}

.crud-servidor > fieldset > legend {
  padding-left: 50px;
}

fieldset > legend > span {
  background: #2a88ad;
  padding: 5px 10px 5px 10px;
  border-radius: 50%;
  font-size: 14px;
  margin-left: -45px;
  color: #fff;
  margin-top: -3px;
}

.crud-servidor .inner-wrap {
  border-radius: 6px;
  display: flex;
  justify-content: space-between;
}

.crud-servidor label {
  font: 13px Arial, Helvetica, sans-serif;
  margin: 5px;
}

.crud-servidor input[type='text'],
.crud-servidor input[type='date'],
.crud-servidor input[type='email'],
.crud-servidor input[type='ckeckbox'] {
  display: inline;
  padding: 8px;
  border: 2px solid #fff;
  border-radius: 6px;
  box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.33);
}

.crud-servidor button {
  background: #2a88ad;
  padding: 8px 20px 8px 20px;
  border: 1px solid #257c9e;
  border-radius: 5px;
  box-shadow: inset 0px 2px 2px 0px rgba(255, 255, 255, 0.17);
  font: normal 30px 'Bitter', serif;
  font-size: 15px;
  color: #fff;
  text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.12);
}

.crud-servidor button:hover {
  background: #2a6881;
  box-shadow: inset 0px 2px 2px 0px rgba(255, 255, 255, 0.28);
}
</style>
