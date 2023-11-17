package Datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Clientes 
{
    protected String IdCliente;
    protected String NombreCompania;
    protected String NombreContacto;
    protected String CargoContacto;
    protected String Direccion;
    protected String Ciudad;
    protected String Region;
    protected String CodigoPostal;
    protected String Pais;
    protected String Telefono;
    protected String Fax;

    public Clientes() {

    }

    public Clientes(String IdCliente, String NombreCompania, String NombreContacto, String CargoContacto,
                    String Direccion, String Ciudad, String Region, String CodigoPostal, String Pais, String Telefono,
                    String Fax) {
        this.IdCliente = IdCliente;
        this.NombreCompania = NombreCompania;
        this.NombreContacto = NombreContacto;
        this.CargoContacto = CargoContacto;
        this.Direccion = Direccion;
        this.Ciudad = Ciudad;
        this.Region = Region;
        this.CodigoPostal = CodigoPostal;
        this.Pais = Pais;
        this.Telefono = Telefono;
        this.Fax = Fax;
    }

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNombreCompania() {
        return NombreCompania;
    }

    public void setNombreCompania(String NombreCompania) {
        this.NombreCompania = NombreCompania;
    }

    public String getNombreContacto() {
        return NombreContacto;
    }

    public void setNombreContacto(String NombreContacto) {
        this.NombreContacto = NombreContacto;
    }

    public String getCargoContacto() {
        return CargoContacto;
    }

    public void setCargoContacto(String CargoContacto) {
        this.CargoContacto = CargoContacto;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getCodigoPostal() {
        return CodigoPostal;
    }

    public void setCodigoPostal(String CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    @Override
    public String toString() {
        return IdCliente + "; " + NombreCompania + "; " + NombreContacto + "; " + CargoContacto + "; " +
                Direccion + "; " + Ciudad + "; " + Region + "; " + CodigoPostal + "; " + Pais + "; " +
                Telefono + "; " + Fax;
    }
    
    
    String line;
    String csvDelimitador = ";"; // El delimitador que separa los valores en el CSV
    public void CopiarContenidoEImpresion(String csvFile, int numFilas)
    {  
        Clientes[] listaobjetos = new Clientes[numFilas];
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
            {
                int indice = 0;
                
                while ((line = br.readLine()) != null) {
                    // Dividir la línea en partes usando el delimitador
                    String[] partes = line.split(csvDelimitador);

                            Clientes objeto=new Clientes();
                            objeto.setIdCliente(partes[0]);
                            objeto.setNombreCompania(partes[1]);
                            objeto.setNombreContacto(partes[2]);
                            objeto.setCargoContacto(partes[3]);
                            objeto.setDireccion(partes[4]);
                            objeto.setCiudad(partes[5]);
                            objeto.setRegion(partes[6]);
                            objeto.setCodigoPostal(partes[7]);
                            objeto.setPais(partes[8]);
                            objeto.setTelefono(partes[9]);
                            objeto.setFax(partes[10]);
                            

                    // Agregar el objeto al arreglo
                    listaobjetos[indice] = objeto;
                    indice++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            // Ahora, objetos contiene todos los objetos creados a partir del archivo CSV
            for (Clientes objeto : listaobjetos) 
            {
                System.out.println(objeto);
            }
    }
    
    
    
    
}
