package Pruebas;


public class ListaEnlazadaGenerica<T> implements ListaInterfaceGenerica<T> {
    private NodoGenerico<T> cabeza;
    private int tamanio;

    public ListaEnlazadaGenerica() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    @Override
    public void insertarFinal(NodoGenerico<T> nuevoNodo) {
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoGenerico<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        tamanio++;
    }

    @Override
    public void insertarInicio(NodoGenerico<T> nuevoNodo) {
        nuevoNodo.setSiguiente(cabeza);
        cabeza = nuevoNodo;
        tamanio++;
    }

    @Override
    public T retirarInicio() {
        if (cabeza == null) {
            return null;
        }
        T dato = cabeza.getDato();
        cabeza = cabeza.getSiguiente();
        tamanio--;
        return dato;
    }

    @Override
    public T retirarFinal() {
        if (cabeza == null) {
            return null;
        }
        if (cabeza.getSiguiente() == null) {
            T dato = cabeza.getDato();
            cabeza = null;
            tamanio--;
            return dato;
        }
        NodoGenerico<T> actual = cabeza;
        while (actual.getSiguiente().getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        T dato = actual.getSiguiente().getDato();
        actual.setSiguiente(null);
        tamanio--;
        return dato;
    }

    @Override
    public void insertarDentro(NodoGenerico<T> nuevoNodo, int indice) {
        if (indice < 0 || indice > tamanio) {
            throw new IndexOutOfBoundsException("Índice fuera de límites");
        }
        if (indice == 0) {
            insertarInicio(nuevoNodo);
        } else if (indice == tamanio) {
            insertarFinal(nuevoNodo);
        } else {
            NodoGenerico<T> actual = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                actual = actual.getSiguiente();
            }
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
            tamanio++;
        }
    }

    @Override
    public T RetirarDentro(int indice) {
        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException("Índice fuera de límites");
        }
        if (indice == 0) {
            return retirarInicio();
        } else if (indice == tamanio - 1) {
            return retirarFinal();
        } else {
            NodoGenerico<T> actual = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                actual = actual.getSiguiente();
            }
            T dato = actual.getSiguiente().getDato();
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            tamanio--;
            return dato;
        }
    }

    @Override
    public String imprimirLista() {
        StringBuilder resultado = new StringBuilder();
        NodoGenerico<T> actual = cabeza;
        while (actual != null) {
            if (actual.getDato() instanceof Pedidos) {
                Pedidos pedido = (Pedidos) actual.getDato();
                resultado.append("IdPedido: ").append(pedido.getIdPedido())
                        .append(", Cliente: ").append(pedido.getCliente())
                        .append(", FechaPedido: ").append(pedido.getFechaPedido())
                        .append(", FechaEntrega: ").append(pedido.getFechaEntrega())
                        .append(", FechaEnvio: ").append(pedido.getFechaEnvio())
                        .append(", FormaEnvio: ").append(pedido.getFormaEnvio())
                        .append(", Cargo: ").append(pedido.getCargo())
                        .append("\n");
            }
            actual = actual.getSiguiente();
        }
        return resultado.toString();
    }

    @Override
    public int TamanioLista() {
        return tamanio;
    }

    @Override
    public int buscar(T valor) {
        NodoGenerico<T> actual = cabeza;
        int indice = 0;
        while (actual != null) {
            if (actual.getDato().equals(valor)) {
                return indice;
            }
            actual = actual.getSiguiente();
            indice++;
        }
        return -1;
    }

    @Override
    public void Ordenamiento_ShellSort() {
        // Implementa el algoritmo de ordenamiento Shell Sort si es necesario.
        // No se proporciona la implementación completa aquí.
    }

    @Override
    public NodoGenerico<T> buscarIteradorIndice(int indice) {
        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException("Índice fuera de límites");
        }
        NodoGenerico<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual;
    }
}    

