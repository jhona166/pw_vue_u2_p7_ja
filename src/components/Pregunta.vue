<template>
    <img
      :src="imagen"
     
      alt="No se puede ver"
    />
   
    <input v-model="pregunta" type="text" placeholder="Hazme una pregunta" />
    <p>Recuerda que cuando finalices tu pregunta dar un ?</p>
   
    <h1>{{ pregunta }}</h1>
    <h2>{{ respuesta }}</h2>
  </template>
   
  <script>
  export default {
    data() {
      return {
        pregunta: "Hola Mundo",
        respuesta:null,
         image:"https://yesno.wtf/assets/yes/14-b57c6dc03aa15a4b18f53eb50d6197ee.gif"

      };
    },
    watch:{
        pregunta(value, oldValue){
                console.log(value);
                console.log(oldValue);
            if(value.includes('?')){
                //Programar la llamada a la API para obtener
                //el SI o el No, y la imagen 
                   console.log('AQUI LLAMO AL API');
                   //this.llamarAPI();
                   this.fachada(); 
            }
        }

    },

    methods:{
       async llamarAPI(){
          const data= await fetch('https://yesno.wtf/api').then(resp=>resp.json())
            console.log(data);
            this.respuesta=data.answer;
            this.imagen = data.image;
            console.log(data);

        },
        async fachada(){
            await this.llamarAPI();     
        }
    },
  };
  </script>
   
  <style>
  </style>