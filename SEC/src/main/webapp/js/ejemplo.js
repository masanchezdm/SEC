/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function cambiaColores(){
   var x = document.getElementById("cabecera");
   x.style.backgroundColor = "#C01E05";
   x = document.getElementById("formulario");
   x.style.backgroundColor = "#FA3C3E";
   x = document.getElementById("param");
   x.style.backgroundColor = "#359EA4";
   x = document.getElementsByClassName("boton");
   for(i=0;i<x.length;i++){
    x[i].style.backgroundColor = "#007B9D";
   }
    
}
