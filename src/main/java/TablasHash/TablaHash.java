/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TablasHash;


import Datos.Detalles_Pedidos;
import Datos.Pedidos;
import Pruebas.NodoGenerico;
import java.util.ArrayList;
import java.util.List;

public class TablaHash {
    private static final int TAMANO_TABLA = 10;  // Tamaño de la tabla hash
    private List<List<NodoGenerico<?>>> tabla;

    public TablaHash() {
        this.tabla = new ArrayList<>(TAMANO_TABLA);
        for (int i = 0; i < TAMANO_TABLA; i++) {
            tabla.add(new ArrayList<>());
        }
    }

    // Función hash simple para demostración
    private int funcionHash(String clave) {
        return clave.hashCode() % TAMANO_TABLA;
    }

    public void insertarEnTabla(NodoGenerico<?> nodo) {
        String clave = obtenerClaveDesdeNodo(nodo); // Adaptar según tus necesidades
        int indice = funcionHash(clave);
        tabla.get(indice).add(nodo);
    }

    // Obtener la clave desde el nodo (adaptar según tus necesidades)
    private String obtenerClaveDesdeNodo(NodoGenerico<?> nodo) {
        if (nodo.getDato() instanceof Detalles_Pedidos) {
            return ((Detalles_Pedidos) nodo.getDato()).getIdPedido();
        } else if (nodo.getDato() instanceof Pedidos) {
            return ((Pedidos) nodo.getDato()).getIdPedido();
        }
        return null;
    }

    // Método para imprimir la tabla hash (solo para propósitos de demostración)
    public void imprimirTablaHash() {
        for (int i = 0; i < TAMANO_TABLA; i++) {
            System.out.print("Índice " + i + ": ");
            for (NodoGenerico<?> nodo : tabla.get(i)) {
                System.out.print(obtenerClaveDesdeNodo(nodo) + " ");
            }
            System.out.println();
        }
    }
    
    public NodoGenerico<?> buscarEnTabla(String clave) 
    {
        int indice = funcionHash(clave);
        List<NodoGenerico<?>> listaEnIndice = tabla.get(indice);

        for (NodoGenerico<?> nodo : listaEnIndice) {
            if (obtenerClaveDesdeNodo(nodo).equals(clave)) {
                return nodo;
            }
        }
        return null; // No se encontró la clave en la tabla
    }

  
}
