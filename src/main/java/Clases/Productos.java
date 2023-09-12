package Clases;

/**
 *
 * @author user
 */
public class Productos 
{
    //VALORES 
    protected int IdProductos;
    protected String Nombres;
    protected String FechaFabricacion;
    protected String FechaVencimiento;
    protected int Cantidad;
    protected String Categoria;
   
    //CONSTRUCTOR
    public Productos() 
    {
        
    }
    
    //COSNTRUCTORES DE CLASE
    public Productos(int IdProductos, String Nombres, String FechaFabricacion, String FechaVencimiento, int Cantidad, String Categoria) {
        this.IdProductos = IdProductos;
        this.Nombres = Nombres;
        this.FechaFabricacion = FechaFabricacion;
        this.FechaVencimiento = FechaVencimiento;
        this.Cantidad = Cantidad;
        this.Categoria = Categoria;
    }
    
    //SET
    public void setIdProductos(int IdProductos) {
        this.IdProductos = IdProductos;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public void setFechaFabricacion(String FechaFabricacion) {
        this.FechaFabricacion = FechaFabricacion;
    }

    public void setFechaVencimiento(String FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
    
    
    //GET
    public int getIdProductos() {
        return IdProductos;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getFechaFabricacion() {
        return FechaFabricacion;
    }

    public String getFechaVencimiento() {
        return FechaVencimiento;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public String getCategoria() {
        return Categoria;
    }
    
            
}
