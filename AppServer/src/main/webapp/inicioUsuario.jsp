<%-- 
    Document   : principal
    Created on : 27/03/2021, 18:39:48
    Author     : asael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>WebFormBuilder - ${user.nombre}</title>

        <!--CSS-->
        <jsp:include page="/WEB-INF/extras/extrasCSS.jsp"/>
    </head>
    <body>
        <!-- Barra de navegacion -->
        <jsp:include page="/WEB-INF/user/navBar.jsp"/>
        
        
        
        <!--JS--> 
        <jsp:include page="/WEB-INF/extras/extrasJS.jsp"/>
    </body>
</html>
