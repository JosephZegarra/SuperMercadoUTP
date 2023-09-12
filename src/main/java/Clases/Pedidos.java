package Clases;


public class Pedidos 
{
    //VALORES 
    protected int IdPedidos;
    protected double CostoUnd;
    protected double CostoTotal;
    protected String DetallesPedido;
    protected int Cantidad;
    
    //CONSTRUTOR
    public Pedidos() 
    {
       
    }
    
    //CONSTRUCTORES
    public Pedidos(int IdPedidos, double CostoUnd, double CostoTotal, String DetallesPedido, int Cantidad) {
        this.IdPedidos = IdPedidos;
        this.CostoUnd = CostoUnd;
        this.CostoTotal = CostoTotal;
        this.DetallesPedido = DetallesPedido;
        this.Cantidad = Cantidad;
    }
    
    //SET
    public void setIdPedidos(int IdPedidos) {
        this.IdPedidos = IdPedidos;
    }

    public void setCostoUnd(double CostoUnd) {
        this.CostoUnd = CostoUnd;
    }

    public void setCostoTotal(double CostoTotal) {
        this.CostoTotal = CostoTotal;
    }

    public void setDetallesPedido(String DetallesPedido) {
        this.DetallesPedido = DetallesPedido;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
         
   //GET
    public int getIdPedidos() {
        return IdPedidos;
    }

    public double getCostoUnd() {
        return CostoUnd;
    }

    public double getCostoTotal() {
        return CostoTotal;
    }

    public String getDetallesPedido() {
        return DetallesPedido;
    }

    public int getCantidad() {
        return Cantidad;
    }
    
}
