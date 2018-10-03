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
    
    function verifica_contr(elem){
        var contr1 = document.getElementById("contr1").value;
        var contr2 = document.getElementById("contr2").value;
        if(contr1 !== contr2){
            correcto = false;
            $("#warning_password").show();
        }else{
            correcto = true;
            $("#warning_password").hide();
        }
    }
    function actualiza_contr(){
        $('#contr2').show()
        $('#contr2').text("");
        correcto = false;
    }
    
    function enviar(form){
        if(correcto)
            form.submit();
        else{
            $('#contr1').css("border", "1px solid red")
            $('#contr2').css("border", "1px solid red")
        }
    }
</script>
      
<div style="margin-top: 20px; margin-bottom: 100px">
    <%@include file="./header.jsp" %>
</div>
<form action="/editar/datos" method="POST">
    <div>        
            <div class="div_registro" style="width: 100%">
                <label for="recipient-name" >Contraseña</label>
                <input id="contr1"type="password" name="contrasena" maxlength="15" onchange="actualiza_contr()"/>
                <input id="contr2" type="password"  style="display:none"maxlength="15" name="contrasena2" placeholder="Ingresa nuevamente" onkeyup="verifica_contr($(this).parent())" />                
                <img id="warning_password" style="display: none"src="<c:url value="/imagenes/warning.svg" />" style="width: 50px; height: 50px" >
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
    
        
            <button type="button" class="btn btn-aceptar" style="width: 200px; margin-top: 50px;" onclick="enviar($(this).parent())">Guardar </button>
</form>
<div style="margin-top: 50px">
    <%@include file="./footer.jsp" %>
</div>

