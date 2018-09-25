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
    
<div style="margin-top: 50px">
    <%@include file="./footer.jsp" %>
</div>

