const express= require("express");
const app=express();
const axios = require("axios");

const PORT= 5051 | process.env.PORT;


app.listen((PORT),()=>{
   console.log("Event generator started !");
   setTimeout(()=>{
       axios({
       method: 'post',
       url:'http://localhost:8090/flow/stock',
       data:{
        id:1,
        source:"SM",
        destination:"MDMS",
        libelle:"consommation",
        frequency:"1/60"
       },
       responseType: 'json'
   }).then((response)=>{
       console.log("Flow created !")
       console.log(response.data);
   })
},5000);

setTimeout(()=>{
    axios({
    method: 'post',
    url:'http://localhost:8090/flow/stock',
    data:{
     id:2,
     source:"SM",
     destination:"MDMS",
     libelle:"production",
     frequency:"1/15"
    },
    responseType: 'json'
}).then((response)=>{
    console.log("Flow created !")
    console.log(response.data);
})
},5000);
setTimeout(()=>{
    axios({
    method: 'post',
    url:'http://localhost:8091/flow/pricing',
    data:{
     id:3,
     source:"MDMS",
     destination:"SM",
     libelle:"prix",
     frequency:"1/60"
    },
    responseType: 'json'
}).then((response)=>{
    console.log("Flow created !")
    console.log(response.data);
})
},5000);
setTimeout(()=>{
    axios({
    method: 'post',
    url:'http://localhost:8091/flow/tension',
    data:{
     id:4,
     source:"MDMS",
     destination:"SM",
     libelle:"Réduction tension",
     frequency:"1"
    },
    responseType: 'json'
}).then((response)=>{
    console.log("Flow created !")
    console.log(response.data);
})
},5000);

});