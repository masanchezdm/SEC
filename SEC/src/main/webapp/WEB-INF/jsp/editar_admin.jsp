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
    <div class="div_registro" style="">        
        <label for="recipient-name" >Contraseña</label>
        <input type="text" name="contrasena"/>
        <input type="text" name="contrasena2" placeholder="Ingresa nuevamente"/>  
    </div>
    
    <div style="margin-top: 20px;">
        <span style="font-size: 25px; color: #48bcc1; ">Niveles disponibles</span>
        <div style="display: inline-block; width: 90%; text-align: center" >
             <button type="button" class="btn btn-nivel" name=""> Primaria 
                 <span class="eliminar">-</span>
             </button>
             <div style="text-align: center">
                <hr style="width:70%; margin-left: 15%">
                <div style="height: 10px;">
                    +
                </div>
                <hr style="width:70%; margin-left: 15%">
            </div>
        </div>
    </div>
    <div style="margin-top: 20px;">
        <span style="font-size: 25px; color: #0095c9; ">Materias seleccionados </span> 
        <div style="display: inline-block; width: 90%; text-align: center" >
             <button type="button" class="btn btn-materia" name=""> Español
                 <span class="eliminar">-</span>
             </button>
        </div>
        <div style="text-align: center">
            <hr style="width:70%; margin-left: 15%">
            <div style="height: 10px;">
                +
            </div>
            <hr style="width:70%; margin-left: 15%">
        </div>
    </div>
</div>

<div>
    <span style="font-size: 25px; color: #ff1241; ">Denuncias</span>
    <br>
    imprime cada usuario denunciado
</div>
    
<div style="margin-top: 50px">
    <%@include file="./footer.jsp" %>
</div>

