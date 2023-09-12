package Clases;

/**
 *
 * @author user
 */
public class Trabajadores extends Personas
{
    //VALORES 
    protected int IdTrabajadores;
    protected String Turno;
    protected String FechaIngreso;
    protected String Cargo;
    protected String Area;
   
    //CONSTRUCTOR
     public Trabajadores() 
    {   
    }
   
    //CONSTRUCTORES

    public Trabajadores(int IdTrabajadores, String Turno, String FechaIngreso, String Cargo, String Area, String NombreClie, String ApellidoClie, String DNI, String CarnetExtrajeria, String Dirreccion) {
        super(NombreClie, ApellidoClie, DNI, CarnetExtrajeria, Dirreccion);
        this.IdTrabajadores = IdTrabajadores;
        this.Turno = Turno;
        this.FechaIngreso = FechaIngreso;
        this.Cargo = Cargo;
        this.Area = Area;
    }
    
    //SET
    public void setIdTrabajadores(int IdTrabajadores) {
        this.IdTrabajadores = IdTrabajadores;
    }

    public void setTurno(String Turno) {
        this.Turno = Turno;
    }

    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }
    
    //GET
    public int getIdTrabajadores() {
        return IdTrabajadores;
    }

    public String getTurno() {
        return Turno;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public String getCargo() {
        return Cargo;
    }

    public String getArea() {
        return Area;
    }
    
}
