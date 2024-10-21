<%-- 
    Document   : index
    Created on : 20 oct 2024, 5:21:55 p.m.
    Author     : pc
--%>

<%@page import="modelo.marcas"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    </head>
    <body>
        <h1>Formulario Productos</h1>
        <div class="container">
            <form action="sr_producto" method="post" class="form-group" enctype="multipart/form-data">
                
                <label for="lbl_producto"><b>Producto:</b></label>
                <input type="text" name="txt_producto"id="txt_producto" class="form-control" placeholder="Ejemplo: Producto" required>
                
                 <label for="lbl_marca"><b>Marca:</b></label>
                <select name="drop_marca" id="drop_marca" class="form-control"> 
                <% 
                 marcas marcas = new marcas();
                 HashMap<String, String> drop = marcas.drop_Marca();
                 for(String i: drop.keySet()){
                  out.println("<option value='" + i + "'> "+drop.get(i)+" </option>");
                 
                    }
                
                
                
                
                %>
                
                
                
                
                </select>
                
                <label for="lbl_descripcion"><b>Descripcion:</b></label>
                <input type="text" name="txt_descripcion"id="txt_descripcion" class="form-control" placeholder="Ejemplo: Descripcion" required>
               
                <label for="lbl_imagen"><b>Imagen:</b></label>
                <input type="file" name="file_imagen" id="file_imagen" class="form-control">
                
                <img id="img_preview" src="#" alt="Vista previa de la imagen" style="display:none; width: 200px; height: 200px;"/>
                
                <label for="lbl_precio_costo"><b>Precio Costo:</b></label>
                <input type="number" name="txt_precio_costo" id="txt_precio_costo" class="form-control" placeholder="Ejemplo: 500.00" required>
                                
                <label for="lbl_precio_venta"><b>Precio Venta:</b></label>
                <input type="number" name="txt_precio_venta" id="txt_precio_venta" class="form-control" placeholder="Ejemplo: 650.00" required>
                                                
                <label for="lbl_existencia"><b>Existencia:</b></label>
                <input type="number" name="txt_existencia" id="txt_existencia" class="form-control" required>
                                
                <label for="lbl_fecha_ingreso"><b>Fecha Ingreso:</b></label>
                 <input type="date" name="txt_fecha_ingreso" id="txt_fecha_ingreso" class="form-control" required>
                                
                 
                 <br>
                <button  name="btn_agregar" id="btn_agregar" value="agregar"class="btn btn-primary">Agregar</button>
            </form>
            </div>
                 <script>
            function previewImage() {
                const file = document.getElementById("file_imagen").files[0];
                const preview = document.getElementById("img_preview");

                if (file) {
                    const reader = new FileReader();
                    reader.onload = function(e) {
                        preview.src = e.target.result;
                        preview.style.display = "block";
                    };
                    reader.readAsDataURL(file);
                } else {
                    preview.src = "#";
                    preview.style.display = "none";
                }
            }
            document.getElementById("file_imagen").addEventListener("change", previewImage);
        </script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</form>
    </body>
</html>