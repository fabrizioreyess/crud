/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Marca;

/**
 *
 * @author pc
 */
public class sr_producto extends HttpServlet {

    Marca marca;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_producto</title>");
            out.println("</head>");
            out.println("<body>");

            // Obtener los parámetros enviados desde el formulario
           
            String producto = request.getParameter("txt_producto");
            int idMarca = Integer.parseInt(request.getParameter("drop_marca"));
            String descripcion = request.getParameter("txt_descripcion");
            String imagen = request.getParameter("file_imagen");
            double precioCosto = Double.parseDouble(request.getParameter("txt_precio_costo"));
            double precioVenta = Double.parseDouble(request.getParameter("txt_precio_venta"));
            int existencia = Integer.parseInt(request.getParameter("txt_existencia"));
            String fechaIngreso = request.getParameter("txt_fecha_ingreso");

            

            // Instancia el objeto Marca y asigna los valores obtenidos
            marca = new Marca();
            marca.setProducto(producto);
            marca.setId_Marca(idMarca);
    
            marca.setDescripcion(descripcion);
            marca.setImagen(imagen);
            marca.setPrecio_costo(precioCosto);
            marca.setPrecio_venta(precioVenta);
            marca.setExistencia(existencia);
            marca.setFecha_ingreso(fechaIngreso);

            // Botón Agregar
            if ("agregar".equals(request.getParameter("btn_agregar"))) {
                if (marca.agregar() > 0) {
                    response.sendRedirect("index.jsp");
                } else {
                    out.println("<h1>Error al agregar el producto</h1>");
                    out.println("<a href='index.jsp'>Regresar</a>");
                }
            }

           

            out.println("</body>");
            out.println("</html>");
        }
    }

    
}
