
package Clases;


public class Personas 
{
    protected String NombreClie;
    protected String ApellidoClie;
    protected String DNI;
    protected String CarnetExtrajeria;
    protected String Dirreccion;

    //CONSTRUCTORES
    public Personas(String NombreClie, String ApellidoClie, String DNI, String CarnetExtrajeria, String Dirreccion) {
        this.NombreClie = NombreClie;
        this.ApellidoClie = ApellidoClie;
        this.DNI = DNI;
        this.CarnetExtrajeria = CarnetExtrajeria;
        this.Dirreccion = Dirreccion;
    }

    //SET
  
    public void setNombreClie(String NombreClie) {
        this.NombreClie = NombreClie;
    }

    public void setApellidoClie(String ApellidoClie) {
        this.ApellidoClie = ApellidoClie;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setCarnetExtrajeria(String CarnetExtrajeria) {
        this.CarnetExtrajeria = CarnetExtrajeria;
    }

    public void setDirreccion(String Dirreccion) {
        this.Dirreccion = Dirreccion;
    }

    //GET
    public String getNombreClie() {
        return NombreClie;
    }

    public String getApellidoClie() {
        return ApellidoClie;
    }

    public String getDNI() {
        return DNI;
    }

    public String getCarnetExtrajeria() {
        return CarnetExtrajeria;
    }

    public String getDirreccion() {
        return Dirreccion;
    }
}
