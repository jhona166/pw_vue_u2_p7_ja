<template>
  <h2>{{titulo}}</h2>
  <p>{{ numero }}<sup>2</sup>={{calcularCuadradoComputado}}</p>
  <p>{{ numero }}<sup>2</sup>={{calcularCuadradoComputado}}</p>
  <div>
    <button v-on:click="incrementar()">+1</button>
    <button v-on:click="decrementar()">-1</button>
</div>
</template>

<script>
import { defineSSRCustomElement } from 'vue';

export default {
 
  
  data(){
    return {
      numero:10, 
      titulo:'Contador'
    }
  },
  methods:{
    calcularCuadrado(){
      console.log("Entro a calcular");
    return this.numero*this.numero;
  
  },
  incrementar(){
      this.numero++;
    },
    decrementar(){
      this.numero--;
    }

  },
  computed:{
    calcularCuadradoComputado(){
      console.log('Entro a calcular computado');
      return this.numero * this.numero;
  }
  }
};
</script>

<style>
button{
  background: #64B687;
  border-radius:5px;
  border:1px solid white;
  color:white;
  cursor: pointer;
  margin: 0px 5px;
  padding: 5px 15px;

}
button:hover{
  background: #5aa67b;
}
</style>