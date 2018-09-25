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
    function selected_role(elem){
        $( ".btn-tipo-usu" ).each(function() {
            $( this ).css("background-color", "white");
            $( this ).css("color", "black");
        });
        elem.css("background-color", "#bfb1ff");
        elem.css("color", "white");
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
                     <input type="text" name="nombre" placeholder="Nombre"  style="width: 180px;"/>
                     <input type="text" name="app_pat" placeholder="Paterno" style="width: 180px;"/>
                     <input type="text" name="app_mat" placeholder="Materno" style="width: 180px;"/>
                 </div>
                 <div class="form-group datos" style="width: 100%" >
                     <label for="recipient-name" >Usuario</label>
                     <input type="text" name="usuario"/>
                 </div>
                 <div class="form-group datos" style="width: 100%">
                     <label for="recipient-name" >Telefono</label>
                     <input type="text" name="tel"/>
                 </div>
                 <div class="form-group datos" style="width: 100%">
                     <label for="recipient-name" >Correo</label>
                     <input type="text" name="correo"/>
                 </div>
                 <div class="form-group datos" style="width: 100%">
                     <label for="recipient-name" >Contraseña</label>
                     <input type="text" name="contrasena"/>
                     <input type="text" name="contrasena2" placeholder="Ingresa nuevamente"/>                
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

