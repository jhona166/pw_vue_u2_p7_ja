<!-- A base de HTML -->
<template>
  <h2>{{ encabezado }}: {{ valor2 }}</h2>
  <p>{{ numero }} <sup>2</sup> = {{ calcularCuadradoComputed }}</p>
  <p>{{ numero }} <sup>2</sup> = {{ calcularCuadradoComputed }}</p>
 
    <div>
        <button v-on:click="incrementar()">+1</button>
        <button v-on:click="decrementar()">-1</button>
    </div>
 
    <div>
      <h1 v-if="esVerdad">"Feliz Navidad"</h1>
    </div>
</template>
 
<!-- A base de JavaScript -->
<script>
export default {
  data() {
    return {
      numero: this.valor,
      titulo: "Contador",
    };
  },
 
  methods: {
    calcularCuadrado() {
        console.log("Método calcularCuadrado");
      return this.numero * this.numero;
    },
    incrementar() {
      this.numero++;
    },
    decrementar() {
      this.numero--;
    },
  },
 
  computed:{
    calcularCuadradoComputed(){
        console.log("Método calcularCuadradoComputed");
        return this.numero * this.numero;
    }
  },
 
  //Primera forma de declarar
  //props: ['encabezado', 'valor']
 
  //Segunda forma de declarar
  props: {
    encabezado: {
    type: String,
    validator(value) {
      // Retorna false si el valor contiene la letra "a"
      return !value.includes('a');
    }
  },
    valor: Number,
    valor2: {
      type: Number,
      required: false,
      default: 77,
      validator(value){
        //programo mi validacion bajo mi criterio y retorno true 
        //cuando es valido para mi
        //retorno false cuando no es valido para mi
        return value<=77;

      }
    },
    esVerdad: {
      type: Boolean,
      required: true,
    },
    arreglo: Array,
    fecha: Date,
    objetoPersona: Object,
  }
 
};
</script>
 
<!-- A base de CSS -->
<style>
h2 {
  box-shadow: #64B687 5px 5px 5px;
  color: blue;
}
p {
  color: red;
}
div {
  margin-top: 20px;
}
button {
    background-color: #64B687;
    border-radius: 5px;
    border: 1px solid white;
    color: white;
    cursor: pointer;
    margin: 0px 5px;
    padding: 5px 10px;  
}
 
button:hover {
    background-color: #5AA67B;
}
</style>