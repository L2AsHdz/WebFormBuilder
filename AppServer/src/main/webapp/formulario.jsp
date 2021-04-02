<%-- 
    Document   : formulario
    Created on : 29/03/2021, 02:08:52
    Author     : asael
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${form.titulo}</title>
        <!--CSS-->
        <jsp:include page="/WEB-INF/extras/extrasCSS.jsp"/>
    </head>
    <body>

        <div class="container-fluid">
            <div class="row my-5">
                <div class="col-2"></div>
                <div class="col-8">
                    <c:choose>
                        <c:when test="${form.tema eq 'DARK'}">
                    <div class="card my-5 text-white">
                        <div class="card-header text-center bg-dark">
                        </c:when>
                        <c:otherwise>
                    <div class="card my-5">
                        <div class="card-header text-center">
                        </c:otherwise>
                    </c:choose>
                            <h4>${form.titulo}</h4>
                        </div>
                        <c:choose>
                            <c:when test="${form.tema eq 'DARK'}">
                        <div class="card-body bg-secondary">
                            </c:when>
                            <c:otherwise>
                        <div class="card-body">
                            </c:otherwise>
                        </c:choose>

                            <form id="form-id" action="${pageContext.request.contextPath}/readData" method="POST" enctype="multipart/form-data">

                                <c:forEach var="c" items="${form.componentes}">
                                    <c:choose>
                                        <c:when test="${c.clase eq 'CAMPO_TEXTO'}">
                                            <div class="form-group">
                                                <label for="${c.nombreCampo}">${c.textoVisible}</label>
                                                <input type="text" class="form-control" name="${c.nombreCampo}">
                                            </div>
                                        </c:when>
                                        <c:when test="${c.clase eq 'AREA_TEXTO'}">
                                            <div class="form-group">
                                                <label for="${c.nombreCampo}">${c.textoVisible}</label>
                                                <textarea class="form-control" name="${c.nombreCampo}" rows="${c.noFilas}" cols="${c.noColumnas}"></textarea>
                                            </div>
                                        </c:when>
                                        <c:when test="${c.clase eq 'CHECKBOX'}">
                                            <label>${c.textoVisible}</label>
                                            <c:forEach var="o" items="${c.options}">
                                                <div class="form-check">
                                                    <label class="form-check-label">
                                                        <input type="checkbox" class="form-check-input" name="${c.nombreCampo}">${o}
                                                    </label>
                                                </div>
                                            </c:forEach>
                                        </c:when>
                                        <c:when test="${c.clase eq 'RADIO'}">
                                            <label>${c.textoVisible}</label>
                                            <c:forEach var="o" items="${c.options}">
                                                <div class="form-check">
                                                    <label class="form-check-label">
                                                        <input type="radio" class="form-check-input" name="${c.nombreCampo}">${o}
                                                    </label>
                                                </div>
                                            </c:forEach>
                                        </c:when>
                                        <c:when test="${c.clase eq 'FICHERO'}">
                                            <div class="form-group mt-3">
                                                <label>${c.textoVisible}</label>
                                                <input type="file" class="form-control-file border" name="${c.nombreCampo}" accept=".*">
                                            </div>
                                        </c:when>
                                        <c:when test="${c.clase eq 'IMAGEN'}">
                                            <label>${c.textoVisible}</label>
                                            <div class="form-group">
                                                <img src="${c.url}" class="img-fluid" name="${c.nombreCampo}" alt="${c.nombreCampo}">
                                            </div>
                                        </c:when>
                                        <c:when test="${c.clase eq 'COMBO'}">
                                            <div class="form-group">
                                                <label>${c.textoVisible}</label>
                                                <select class="form-control" name="${c.nombreCampo}" id="${c.nombreCampo}">
                                                    <option value="">Seleccione un opcion...</option>
                                                    <c:forEach var="o" items="${c.options}">
                                                        <option>${o}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </c:when>
                                        <c:when test="${c.clase eq 'BOTON'}">
                                            <div class="text-center">
                                                <button type="submit" class="btn btn-primary">${c.textoVisible}</button>
                                            </div>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--JS--> 
        <jsp:include page="/WEB-INF/extras/extrasJS.jsp"/>
    </body>
</html>
