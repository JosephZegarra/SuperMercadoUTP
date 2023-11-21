/*import Datos.Articulos;
import ListaEnlasada.ListaEnlasadaImpl;
import ListaEnlasada.ListaInterface;
import ListaEnlasada.Nodo;
import java.awt.Button;
import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FiltroArticulosCSV extends Articulos {
    protected String csvFile = "Articulos.csv";
    protected int numFilas; // Reemplazar con el número correcto de filas

    protected Articulos[] ListaArregloCopia;

    protected ListaInterface listaEnlazadaCategorias = new ListaEnlasada.ListaEnlasadaImpl();

    @Override
    public void start(Stage primaryStage) 
    {
        Button btnFiltrar = new Button("Filtrar por Nombre");
        Button btnOrdenar = new Button("Ordenar por Nombre");

        btnFiltrar.addActionListener(e -> {
            String nombreBuscado = "Té Dharamsala"; // Reemplazar con el valor ingresado por el usuario
            filtrarYImprimirPorNombre(nombreBuscado);
        });

        btnOrdenar.addActionListener(e -> ordenarYImprimirPorNombre());

        Visibilityox root = new AbstractMethodError();
        root.getChildren().addAll(btnFiltrar, btnOrdenar);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Consulta de Artículos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void CopiarContenidoEImpresion(String csvFile, int numFilas) {
        Articulos[] listaobjetos = new Articulos[numFilas];
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int indice = 0;

            String line;
            String csvDelimitador = ";"; // El delimitador que separa los valores en el CSV

            while ((line = br.readLine()) != null) {
                String[] partes = line.split(csvDelimitador);

                Articulos objeto = new Articulos();

                if (partes.length == 9) {
                    objeto.setIdProducto(partes[0]);
                    objeto.setNombreProducto(partes[1]);
                    objeto.setProveedores(partes[2]);
                    objeto.setCategoria(partes[3]);
                    objeto.setCantidadPorUnidad(partes[4]);
                    objeto.setPrecioPorUnidad(partes[5]);
                    objeto.setUnidadesExistentes(partes[6]);
                    objeto.setUnidadesPedidas(partes[7]);
                    objeto.setSuspendido(partes[8]);
                } else {
                    System.err.println("La línea no tiene suficientes elementos: " + line);
                }

                listaobjetos[indice] = objeto;
                indice++;
            }

            ListaArregloCopia = listaobjetos.clone();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Articulos objeto : listaobjetos) {
            System.out.println(objeto);
        }
    }

    public void copiarArregloAListaEnlazada() {
        int dimensionArreglo = numFilas;
        int c = 1;

        for (int i = 0; i < dimensionArreglo; i++) {
            Articulos articulos = ListaArregloCopia[i];

            Nodo nuevoNodo = new Nodo(articulos);
            listaEnlazadaCategorias.insertarFinal(nuevoNodo);
            c++;
        }
    }

    public void imprimir() {
        System.out.println(listaEnlazadaCategorias.imprimirLista());
    }

    public ListaInterface filtrarPorNombre(String nombre) {
        ListaInterface listaFiltrada = new ListaEnlasadaImpl();
        for (Articulos articulo : ListaArregloCopia) {
            if (articulo.getNombreProducto().equalsIgnoreCase(nombre)) {
                Nodo nuevoNodo = new Nodo(articulo);
                listaFiltrada.insertarFinal(nuevoNodo);
            }
        }
        return listaFiltrada;
    }

    public void filtrarYImprimirPorNombre(String nombre) {
        ListaInterface listaFiltrada = filtrarPorNombre(nombre);
        System.out.println("Resultados de la búsqueda por nombre '" + nombre + "':");
        System.out.println(listaFiltrada.imprimirLista());
    }

    public void ordenarYImprimirPorNombre() {
        listaEnlazadaCategorias.Ordenamiento_ShellSort();
        System.out.println("Lista ordenada por nombre:");
        System.out.println(listaEnlazadaCategorias.imprimirLista());
    }
}

*/