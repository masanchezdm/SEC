<%-- 
    Document   : mi-registro
    Created on : 23/09/2018, 01:31:54 PM
    Author     : adrisan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <div class="row" style="display: inline-block">
            <div class="div_registro" style=" border: 1px solid #4631FF;margin: 10px 5%; height: 70%; width: 30%; text-align: left">
                <div class="form-group" style="margin-top: 20px" >
                    <label for="recipient-name" >Nombre</label>
                    <input type="text" name="nombre" placeholder="Nombre"  style="width: 180px;"/>
                    <input type="text" name="app_pat" placeholder="Paterno" style="width: 180px;"/>
                    <input type="text" name="app_mat" placeholder="Materno" style="width: 180px;"/>
                </div>
                <div class="form-group" >
                    <label for="recipient-name" >Usuario</label>
                    <input type="text" name="usuario"/>
                </div>
                <div class="form-group" >
                    <label for="recipient-name" >Telefono</label>
                    <input type="text" name="usuario"/>
                </div>
                <div class="form-group">
                    <label for="recipient-name" >Correo</label>
                    <input type="text" name="correo"/>
                </div>
                <div class="form-group">
                    <label for="recipient-name" >Contraseña</label>
                    <input type="text" name="contrasena"/>
                    <input type="text" name="contrasena" placeholder="Ingresa nuevamente"/>
                </div>
            </div>    
            <div>            
                <div style="display: inline-block " >
                    <button type="button" class="btn btn-tipo-usu" onclick="selected_role($(this))" > Alumno </button>
                    <button type="button" class="btn btn-tipo-usu" onclick="selected_role($(this))" > Estudiante </button>
                </div>
                <div class="form-group" style="">
                    <div style="text-align: center " >Agrega tus intereses</div>
                </div>
                <!--Aqui meteremos un for para iterar y mostrar las materias de la tabla-->
                <div style="display: inline-block ">
                    <button type="button" class="btn btn-materia"> Materia </button>
                    <button type="button" class="btn btn-materia"> Materia2 </button>
                    <button type="button" class="btn btn-materia"> Materia3 </button>
                </div>
            </div>
        </div>

    </body>
</html>
