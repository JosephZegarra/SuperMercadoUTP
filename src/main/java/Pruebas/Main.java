
package Pruebas;

public class Main 
{
  public static void main(String[] args) {
        // Crear algunos pedidos
        Pedidos pedido1 = new Pedidos("P001", "Cliente1", "2023-01-01", "2023-01-10", "2023-01-05", "Envio1", "Cargo1");
        Pedidos pedido2 = new Pedidos("P002", "Cliente2", "2023-02-01", "2023-02-10", "2023-02-05", "Envio2", "Cargo2");
        Pedidos pedido3 = new Pedidos("P003", "Cliente3", "2023-03-01", "2023-03-10", "2023-03-05", "Envio3", "Cargo3");

        // Crear una lista enlazada genérica de Pedidos
        ListaEnlazadaGenerica<Pedidos> listaPedidos = new ListaEnlazadaGenerica<>();

        // Insertar pedidos en la lista
        listaPedidos.insertarFinal(new NodoGenerico<>(pedido1));
        listaPedidos.insertarFinal(new NodoGenerico<>(pedido2));
        listaPedidos.insertarFinal(new NodoGenerico<>(pedido3));

        // Imprimir la lista
        System.out.println("Lista de Pedidos:\n" + listaPedidos.imprimirLista());

        // Retirar el primer pedido de la lista
        Pedidos pedidoRetirado = listaPedidos.retirarInicio();
        System.out.println("Pedido retirado: " + pedidoRetirado.getIdPedido());

        // Imprimir la lista después de retirar el primer pedido
        System.out.println("Lista de Pedidos después de retirar el primer pedido:\n" + listaPedidos.imprimirLista());

        // Obtener el tamaño de la lista
        System.out.println("Tamaño de la lista de pedidos: " + listaPedidos.TamanioLista());

        // Buscar un pedido en la lista
        int indicePedido2 = listaPedidos.buscar(pedido2);
        System.out.println("Índice del Pedido 2: " + indicePedido2);

        // Insertar un nuevo pedido en una posición específica
        Pedidos nuevoPedido = new Pedidos("P004", "Cliente4", "2023-04-01", "2023-04-10", "2023-04-05", "Envio4", "Cargo4");
        listaPedidos.insertarDentro(new NodoGenerico<>(nuevoPedido), 1);

        // Imprimir la lista después de insertar un nuevo pedido
        System.out.println("Lista de Pedidos después de insertar un nuevo pedido:\n" + listaPedidos.imprimirLista());
    }  
}
