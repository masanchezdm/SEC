<%-- 
    Document   : header
    Created on : 13/09/2018, 01:06:42 AM
    Author     : adrisan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SEC</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="<c:url value="/css/estilos.css"/> ">
        <link rel="shortcut icon" href="">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="<c:url value="/js/ejemplo.js" />"></script>
    </head>
    <header id="cabecera">
        <button class="btn"> Features</button>
        <button class="btn"> Enterprise</button>
        <button type="button" class="btn"> Support </button>
        <button type="button" class="btn btn-registro"> Registrarse </button>
        <% if ((String)session.getAttribute("usuario") == null) { %>
            <button type="button" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo"class="btn btn-sesion"> Iniciar </button>
        <% } else {%>
            <button type="button" class="btn btn-sesion" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                ${sesion}
            </button>
            <div class="dropdown-menu" style="margin-top: 15px">
                <form  id="perfil_form" action="/editar_perfil" method="GET">
                    <a class="dropdown-item" href="#" onclick="document.getElementById('perfil_form').submit()">Perfil</a>
                </form>
                <div class="dropdown-divider"></div>                
                <form  id="formid" action="/cerrar_sesion" method="GET">
                    <a class="dropdown-item" href="#" onclick="document.getElementById('formid').submit()">Cerrar sesion</a>
                </form>
              </div>
        <% } %>
    </header>
    
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <form action="/iniciar_sesion" method="GET">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Hola de nuevo</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                    <div class="modal-body" style="text-align: left">

                      <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Correo:</label>
                        <input type="text" class="form-control" name="correo">
                      </div>
                      <div class="form-group">
                        <label for="message-text" class="col-form-label">Contraseña:</label>
                        <input type="password" class="form-control" name="contrasena">
                      </div>

                  </div>
                  <div class="modal-footer">                
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="submit " class="btn btn-primary">Aceptar</button>
                  </div>
                </div>
            </form>
        </div>
      </div>

</html>
