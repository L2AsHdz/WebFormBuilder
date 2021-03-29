<%-- 
    Document   : componentesHTML
    Created on : 28/03/2021, 14:47:55
    Author     : asael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--CSS-->
        <jsp:include page="/WEB-INF/extras/extrasCSS.jsp"/>
    </head>
    <body>

        <div class="container-fluid">
            <div class="row">
                <div class="col-6">

                    <!-- Clase tipo campo texto -->
                    <div class="form-group">
                        <label for="campoTexto">Campo Texto</label>
                        <input type="text" class="form-control" name="campoTexto" value="">
                    </div>

                    <!-- Clase tipo area texto -->
                    <div class="form-group">
                        <label for="areaTexto">Area texto:</label>
                        <textarea id="area" class="form-control" name="areaTexto" rows="5"></textarea>
                    </div>

                    <!-- Clase tipo checkbox -->
                    <label for="check">Checkbox</label>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input type="checkbox" class="form-check-input" name="check" value="">Option 1
                        </label>
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input type="checkbox" class="form-check-input" name="check" value="">Option 2
                        </label>
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input type="checkbox" class="form-check-input" name="check" value="">Option 3
                        </label>
                    </div>

                    <!-- Clase tipo radio button -->
                    <label for="algo" class="mt-3">Radio</label>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="radio" value="">Option 1
                        </label>
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="radio" value="">Option 2
                        </label>
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="radio" value="">Option 3
                        </label>
                    </div>

                    <!-- Clse de tipo fichero -->
                    <div class="form-group mt-3">
                        <label for="file">Fichero</label>
                        <input type="file" class="form-control-file border" name="file" accept=".*">
                    </div>

                    <!-- Clase tipo imagen -->
                    <label for="imagen">Imagen</label>
                    <div class="form-group">
                        <img src="resources/billete.png" class="img-fluid" alt="Responsive image">
                    </div>

                    <!-- Clase tipo combobox -->
                    <div class="form-group">
                        <label for="combo">Combo</label>
                        <select class="form-control" name="combo" id="combo">
                            <option>Seleccione un opcion...</option>
                            <option>Holi1</option>
                            <option>Holi2</option>
                            <option>Holi3</option>
                            <option>Holi4</option>
                        </select>
                    </div>

                    <!-- Clase tipo boton -->
                    <label for="boton">Boton</label>
                    <div class="text-center mb-5">
                        <button type="submit" class="btn btn-primary btn-block">Boton</button>
                    </div>
                </div>
            </div>
        </div>

        <!--JS--> 
        <jsp:include page="/WEB-INF/extras/extrasJS.jsp"/>
    </body>
</html>
