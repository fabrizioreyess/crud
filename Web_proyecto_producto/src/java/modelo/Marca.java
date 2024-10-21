/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author pc
 */
public class Marca extends Producto{
    private String producto;
    private int id_Marca;
    private Conexion cn; 

    public Marca() {}
    public Marca(String producto, int id_Marca, int id, int existencia, String descripcion, String imagen, String fecha_ingreso, double precio_costo, double precio_venta) {
        super(id, existencia, descripcion, imagen, fecha_ingreso, precio_costo, precio_venta);
        this.producto = producto;
        this.id_Marca = id_Marca;
    }

    
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getId_Marca() {
        return id_Marca;
    }

    public void setId_Marca(int id_Marca) {
        this.id_Marca = id_Marca;
    }

   
    
    
    public int  agregar (){
       int retorno = 0;
        try {
            
            PreparedStatement parametro;
            cn = new Conexion ();
            
            String query="INSERT INTO db_tiendaa, productos(producto,id_Marca,Descripcion,Imagen,precio_costo,precio_venta,existencia,fecha_ingreso) VALUES(?,?,?,?,?,?,?,?);";
            cn.abrir_conexion();
            parametro = (  PreparedStatement )cn.conexionBD.prepareStatement(query);
            
            parametro.setString(1, getProducto());                 
            parametro.setInt(2, getId_Marca());                   
            parametro.setString(3, getDescripcion());              
            parametro.setString(4, getImagen());
            parametro.setDouble(5, getPrecio_costo());             
            parametro.setDouble(6, getPrecio_venta());             
            parametro.setInt(7, getExistencia()); 
            parametro.setString(8, getFecha_ingreso());
            
            
           
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
            
            
            
        }
        
    return retorno;
    }
    
     
    
}

