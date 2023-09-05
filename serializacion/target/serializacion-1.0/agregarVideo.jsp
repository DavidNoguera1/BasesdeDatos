<%-- 
    Document   : agregarvideo
    Created on : 29/08/2023, 5:45:41 p. m.
    Author     : Sistemas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rockola</title>
       <style>
        /* Estilo para el cuerpo de la página */
        body {
            background-image: url('img/fondo-geometrico-plano_23-2148967370.avif'); /* Ruta de la imagen */
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            height: 100vh;
            justify-content: center;
            text-align: center;
        }

        /* Estilo para la barra de navegación */
        ul {
            list-style-type: none;
            padding: 0;
            background-color: rgba(0, 0, 0, 0.5); /* Fondo gris semitransparente */
        }

        ul li {
            padding: 10px 0;
        }

        ul li a {
            text-decoration: none;
            color: white;
            font-weight: bold;
            font-size: 18px;
        }

        /* Estilo para el formulario */
        form {
            background-color: rgba(255, 255, 255, 0.7); /* Fondo blanco semitransparente */
            padding: 15px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); /* Sombra suave */
            margin: 20px auto; /* Centrar en el medio de la página */
            max-width: 400px; /* Ancho máximo del formulario */
            display: flex;
            flex-direction: column; /* Centrar elementos verticalmente */
            align-items: center; /* Centrar elementos horizontalmente */
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        textarea {
            width: 100%;
            padding: 5px;
            margin-bottom: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        textarea {
            resize: vertical;
        }

        input[type="submit"] {
            background-color: #007BFF;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        a {
            color: white;
            font-weight: bold;
            text-decoration: none;
            margin-top: 10px;
            display: inline-block;
        }
    </style>
    </head>
    <body>
        
        <form action="SvVideo" method="POST">         
            
            <label for="idVideo">idVideo:</label>
            <input type="text" name="idVideo"><br>
            
            <label for="titulo">Titulo:</label>
            <input type="text" name="titulo"><br>
            
            <label for="autor">Autor:</label>
            <input type="text" name="autor"><br>
            
            <label for="anio">Año:</label>
            <input type="text" name="anio"><br>
            
            <label for="url">Url:</label>
            <input type="text" name="url"><br>
            
            <label for="categoria">Categoria:</label>
            <input type="text" name="categoria"><br>
            
            <label for="letra">Letra:</label>
            <textarea id="id" name="letra" rows="5" cols="10"></textarea>
            
            <input type="submit" value="Agregar video">
        </form>  
        <a href="index.jsp">Volver al menu</a>
    </body>
</html>
