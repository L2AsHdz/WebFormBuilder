<%-- 
    Document   : principal
    Created on : 27/03/2021, 18:39:48
    Author     : asael
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <div class="container-fluid">
            <div class="row mt-5">
                <div class="col-1"></div>
                <div class="col-10">
                    <div class="card">
                        <div class="card-header">
                            <h4>Formularios creados</h4>
                        </div>
                        <div class="card-body">
                            <table class="table table-striped">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>#</th>
                                        <th>Id</th>
                                        <th>Nombre</th>
                                        <th>Titulo</th>
                                        <th>Tema</th>
                                        <th>Fecha creacion</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="form" items="${formularios}" varStatus="status">
                                        <tr>
                                            <td>${status.count}</td>
                                            <td>${form.id}</td>
                                            <td>${form.nombre}</td>
                                            <td>${form.titulo}</td>
                                            <td>${form.tema}</td>
                                            <td>${form.fechaCreacion}</td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/builder?id=${form.id}" class="btn btn-outline-info">
                                                    <i class="fas fa-plus"></i> Generar
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--JS--> 
        <jsp:include page="/WEB-INF/extras/extrasJS.jsp"/>
    </body>
</html>
