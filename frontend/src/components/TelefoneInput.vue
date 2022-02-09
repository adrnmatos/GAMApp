<template>
  <div>
    <label for="tel-input">telefone</label>
    <input
      type="tel"
      id="tel-input"
      v-model="telData"
      @beforeinput="filter($event)"
      @input="format()"
      min="11"
      max="12"
    />
  </div>
</template>
<script>
export default {
  name: 'TelefoneInput',

  data() {
    return {
      telData: '',
      numData: '',
    };
  },

  methods: {
    //   allow digits, delete and backspace only
    filter($event) {
      if (!isFinite($event.data)) {
        $event.preventDefault();
      } else if (this.numData.length > 11) {
        if ($event.data != null) $event.preventDefault();
      }
    },

    format() {
      this.numData = this.telData.replace(/\D/g, '');
      const numLength = this.numData.length;

      if (numLength > 3 && numLength <= 7)
        this.telData =
          '(' + this.numData.slice(0, 3) + ')' + ' ' + this.numData.slice(3);
      else if (numLength > 7 && numLength <= 11)
        this.telData =
          '(' +
          this.numData.slice(0, 3) +
          ')' +
          ' ' +
          this.numData.slice(3, 7) +
          '-' +
          this.numData.slice(7);
      else if (numLength > 11)
        this.telData =
          '(' +
          this.numData.slice(0, 3) +
          ')' +
          ' ' +
          this.numData.slice(3, 4) +
          ' ' +
          this.numData.slice(4, 8) +
          '-' +
          this.numData.slice(8);
      this.$emit('change', this.numData);
    },
  },
};
</script>
