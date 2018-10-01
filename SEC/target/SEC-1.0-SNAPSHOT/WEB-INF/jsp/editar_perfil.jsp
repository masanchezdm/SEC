<%-- 
    Document   : editar_perfil
    Created on : 23/09/2018, 04:08:25 PM
    Author     : adrisan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
    function varifica_tel(elem){
        if (elem.val().length > 10) {
            elem.val(elem.val().slice(0,10)); 
        }
    }
    
    function verifica_contr(elem){
        var contr1 = document.getElementById("contr1").value;
        var contr2 = document.getElementById("contr2").value;
        if(contr1 !== contr2){
            $("#warning_password").show();
        }else{
            $("#warning_password").hide();
        }
    }
    
</script>
      
<div style="margin-top: 20px; margin-bottom: 100px">
    <%@include file="./header.jsp" %>
</div>

<div>
    <form action="/editar/datos" method="POST">
        <div class="row" style="display: inline-block">
            <span style="font-size: 25px; color: #51c5c9;">Edita tus datos</span>
             <div class="div_registro" style="margin: 10px 20%; height: 70%; width: 60%; text-align: left">
                 <div class="form-group datos" style="margin-top: 20px; width: 100% " >
                     <label for="recipient-name" >Nombre</label>
                     <input type="text" name="nombre" maxlength="15" placeholder="Nombre"  style="width: 180px;"/>
                     <input type="text" name="app_pat" maxlength="15" placeholder="Paterno" style="width: 180px;"/>
                     <input type="text" name="app_mat" maxlength="15" placeholder="Materno" style="width: 180px;"/>
                 </div>
                 <div class="form-group datos" style="width: 100%" >
                     <label for="recipient-name"  >Usuario</label>
                     <input type="text" maxlength="10" name="usuario"/>
                 </div>
                 <div class="form-group datos" style="width: 100%">
                     <label for="recipient-name" >Telefono</label>
                     <input type="number" min="0" max="99999" maxlength="5" name="tel" onkeyup="varifica_tel($(this))"/>
                 </div>
                 <div class="form-group datos" style="width: 100%">
                     <label for="recipient-name" >Contraseña</label>
                     <input id="contr1"type="password" name="contrasena"/>
                     <input id="contr2" type="password" maxlength="10" name="contrasena2" placeholder="Ingresa nuevamente" onkeyup="verifica_contr($(this).parent())" />                
                     <img id="warning_password" style="display: none"src="<c:url value="/imagenes/warning.svg" />" style="width: 50px; height: 50px" >
                 </div>            
             </div>    
        </div>
         <div style="margin-top: 20px;">
             <span style="font-size: 25px; color: #48bcc1; ">Niveles seleccionados</span>
             <div style="display: inline-block; width: 90%; text-align: center" >
                  <button type="button" class="btn btn-nivel" name=""> Primaria </button>
                  <button type="button" class="btn btn-nivel" name="">  Primaria </button>
                  <button type="button" class="btn btn-nivel" name=""> Primaria </button>
                  <button type="button" class="btn btn-nivel"> Primaria </button>
             </div>
         </div>

         <div style="margin-top: 20px;">
             <span style="font-size: 25px; color: #0095c9; ">Materias seleccionados </span> 
             <div style="display: inline-block; width: 90%; text-align: center" >
                  <button type="button" class="btn btn-materia"> Primaria </button>
                  <button type="button" class="btn btn-materia"> Primaria </button>
                  <button type="button" class="btn btn-materia"> Primaria </button>
                  <button type="button" class="btn btn-materia"> Primaria </button>
             </div>
         </div>

        <button type="submit" class="btn btn-aceptar" style="width: 200px; margin-top: 50px;">Guardar </button>
    </form>
</div>
    
<div style="margin-top: 50px">
    <%@include file="./footer.jsp" %>
</div>

