
package Clases;

/**
 *
 * @author user
 */
public class Proveedor 
{
    //VALORES
    protected int IdProveedor;
    protected String NombreProveedor;
    protected String Nacionalidad;
    
    //CONSTRUCTOR 
    public Proveedor() 
    {
        
    }
    
    //CONSTRUCTORES DE CLASE
    public Proveedor(int IdProveedor, String NombreProveedor, String Nacionalidad) {
        this.IdProveedor = IdProveedor;
        this.NombreProveedor = NombreProveedor;
        this.Nacionalidad = Nacionalidad;
    }
    
    //SET
    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public void setNombreProveedor(String NombreProveedor) {
        this.NombreProveedor = NombreProveedor;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }
    
    //GET
    public int getIdProveedor() {
        return IdProveedor;
    }

    public String getNombreProveedor() {
        return NombreProveedor;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }
    
}
