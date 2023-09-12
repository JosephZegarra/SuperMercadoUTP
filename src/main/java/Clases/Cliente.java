/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


public class Cliente extends Personas 
{
   //VALORES
    protected int CodiCLiente;
    protected String TipoCLiente;
    
    //CONSTRUCTOR
     public Cliente() 
    {
        
    }
     
    //CONSTRUCCION
    public Cliente(int CodiCLiente, String TipoCLiente, String NombreClie, String ApellidoClie, String DNI, String CarnetExtrajeria, String Dirreccion) {
        super(NombreClie, ApellidoClie, DNI, CarnetExtrajeria, Dirreccion);
        this.CodiCLiente = CodiCLiente;
        this.TipoCLiente = TipoCLiente;
    }
    
   //SET

    public void setCodiCLiente(int CodiCLiente) {
        this.CodiCLiente = CodiCLiente;
    }

    public void setTipoCLiente(String TipoCLiente) {
        this.TipoCLiente = TipoCLiente;
    }
    
   //GET

    public int getCodiCLiente() {
        return CodiCLiente;
    }

    public String getTipoCLiente() {
        return TipoCLiente;
    }
    
}
