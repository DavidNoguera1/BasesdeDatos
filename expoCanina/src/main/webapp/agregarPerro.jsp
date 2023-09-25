<%-- 
    Document   : agregarPerro
    Created on : 20/09/2023, 4:50:03 p. m.
    Author     : Sistemas (Grupo Portilla, Noguera y Bolaños)
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@include file= "templates/header.jsp" %>

<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="#">
        <img src="imagenes/banner.jpeg" width="1300" height="180" class="d-inline-block align-top" alt="">
    </a>
</nav>
<div class="container p-4">
    <div class="row">
        <div class="col-md-4">
            <div class="card card-body">
                <h3>Insertar nuevo perro</h3>
                <form action="SvPerro" method="POST"> <!-- Cambiamos el método a POST -->
                    <div class="input-group mb-3">
                        <label class="input-group-text" for="nombre">Nombre:</label>
                        <input type="text" name="nombre" class="form-control">
                    </div>
                    <div class="input-group mb-3">
                        <label class="input-group-text" for="raza">Raza:</label>
                        <input type="text" name="raza" class="form-control">
                    </div>
                    <div class="input-group mb-3">
                        <label class="input-group-text" for="imagen">Imagen:</label>
                        <input type="text" name="imagen" class="form-control">
                    </div>
                    <div class="input-group mb-3">
                        <label class="input-group-text" for="puntos">Puntos:</label>
                        <select name="puntos" class="form-select">
                            <option selected>Seleccione...</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <!-- Agrega aquí el resto de las opciones -->
                        </select>
                    </div>
                    <div class="input-group mb-3">
                        <label class="input-group-text" for="edad">Edad:</label>
                        <input type="text" name="edad" class="form-control">
                    </div>
                    <input type="submit" value="Agregar perro" class="form-control">
                </form><br>
                <a href="index.jsp">Volver al Menú</a>
            </div>
        </div>
        <!-- Tabla de datos -->
        <div class="col-md-8">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Raza</th>
                        <th>Imagen</th>
                        <th>Puntos</th>
                        <th>Edad</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="perro" items="${misPerros}">
                        <tr>
                            <td>${perro.nombre}</td>
                            <td>${perro.raza}</td>
                            <td>${perro.imagen}</td>
                            <td>${perro.puntos}</td>
                            <td>${perro.edad}</td>
                            <td>
                                <!-- Agrega aquí enlaces o botones para editar o eliminar el perro -->
                                <a href="editarPerro.jsp?id=${perro.id}">Editar</a>
                                <a href="eliminarPerro.jsp?id=${perro.id}">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file= "templates/fooder.jsp" %>