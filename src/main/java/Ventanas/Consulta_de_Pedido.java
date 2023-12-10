/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import ListaEnlazadaGenerica.*;
import Datos.Pedidos;
import Datos.Proveedores;
import java.util.LinkedList;
import javax.management.modelmbean.ModelMBean;
import javax.swing.text.JTextComponent;
import java.util.HashSet;
import javax.swing.text.TableView;
/**
 *
 * @author ROBSKY
 */


public class Consulta_de_Pedido extends javax.swing.JFrame {
    DefaultTableModel tablaDetalles;
    //buscador de archivo para exportar
   JFileChooser archivo = new JFileChooser(System.getProperty("user.dire"));
   
   //Archivo de proveedores
    DefaultTableModel tablaProveedores;
    //buscador de archivo para exportar
   JFileChooser archivo2 = new JFileChooser(System.getProperty("user.dire"));
   
   
   
    
  
   
     //instanciacion de lista enlazada
    ListaInterfaceGenerica<Pedidos> ListaPedidos= new ListaEnlasadaGenericaImpl<Pedidos>();
    
     private void cargarArticulosListaEnlazada() {
        try {
            String texto = "";
            Object cabeceras[] = {"Id. de pedido","Cliente/Proveedor","Fecha de pedido","Fecha de entrega","Fecha de envio","Forma de envio","Cargo"};
            tablaDetalles = new DefaultTableModel(cabeceras,0);
            archivo.showOpenDialog(this);
            File abrir = archivo.getSelectedFile();
            Object[] elemento = new Object[7];
            if (abrir != null){
                
                FileReader fichero = new FileReader(abrir);
                BufferedReader leer = new BufferedReader(fichero);
                //se crea la lista enlazada
                

                while ((texto = leer.readLine()) != null) {
                    String registro[] = texto.split(";");

                    Pedidos articulo = new Pedidos();
                    
                    articulo.setIdPedido(registro[0]);
                    articulo.setCliente(registro[1]);
                    articulo.setFechaPedido(registro[2]);
                    articulo.setFechaEntrega(registro[3]);
                    articulo.setFechaEnvio(registro[4]);
                    articulo.setFormaEnvio(registro[5]);
                    articulo.setCargo(registro[6]);
   
                    NodoGenerico<Pedidos> nuevoNodo = new NodoGenerico<>(articulo);
                    
                    ListaPedidos.insertarFinal(nuevoNodo); //se debe crear una lista enlazada para guardar objetos tipo clase Articulos
                    
                    
                }
                

                
            }
            TablaModeloLinkedList(ListaPedidos);

        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }
     
     public ListaInterfaceGenerica<Pedidos> GetListaArticulos()
    {
        return ListaPedidos;
    }
     
     
     
     
     
     //instanciacion de lista enlazada PRoveedores
    ListaInterfaceGenerica<Proveedores> ListaProveedores= new ListaEnlasadaGenericaImpl<Proveedores>();
    
     private void cargarProveedoresListaEnlazada() {
        try {
            String texto = "";
            Object cabeceras[] = {"Id. de proveedor","Nombre de compañia","Nombre del contacto","Cargo del contacto","Direccion",
                "Ciudad","Region","Codigo postal","Pais","Telefono","Fax"};
            tablaProveedores = new DefaultTableModel(cabeceras,0);
            archivo2.showOpenDialog(this);
            File abrir = archivo2.getSelectedFile();
            Object[] elemento = new Object[11];
            if (abrir != null){
                
                FileReader fichero = new FileReader(abrir);
                BufferedReader leer = new BufferedReader(fichero);
                //se crea la lista enlazada
                
                while ((texto = leer.readLine()) != null) 
                {
                // Utiliza expresión regular para dividir, elimina espacios adicionales y maneja campos vacíos
                    String[] registro = texto.split(";",-1);

                    Proveedores proveedor = new Proveedores();

                    if (registro.length >= 11) {
                        proveedor.setIdProveedor(registro[0]);
                        proveedor.setNombreCompania(registro[1]);
                        proveedor.setNombreContacto(registro[2]);
                        proveedor.setCargoContacto(registro[3]);
                        proveedor.setDireccion(registro[4]);
                        proveedor.setCiudad(registro[5]);
                        proveedor.setRegion(registro[6]);
                        proveedor.setCodigoPostal(registro[7]);
                        proveedor.setPais(registro[8]);
                        proveedor.setTelefono(registro[9]);
                        proveedor.setFax(registro[10]);
                    } else {
                        // Manejar el caso en el que no hay suficientes elementos en el registro
                        System.out.println("Error: No hay suficientes elementos en el registro.");
                    }

                    NodoGenerico<Proveedores> nuevoNodo = new NodoGenerico<>(proveedor);

                    ListaProveedores.insertarFinal(nuevoNodo);
                    

                    if (nuevoNodo.getElemento() == null)
                        System.out.println("Objeto Proveedor nulo agregado correctamente a ListaProveedores");
                }

                    
                
                    
                }
                
             
            
            }catch (IOException e) {
            System.out.println("Error" + e);

         
        }
    }
     
     
     
     
     
    
     
     //-------Implementacion filtro Clientes-------------------------------------------------------------------
     public void CargandoListaFiltroCliente()
     {
        ListaInterfaceGenerica<Pedidos> listaPedidos = ListarNombresCliente();

    // Lógica adicional usando la lista de categorías
        for (int i = 1; i <= listaPedidos.TamanioLista(); i++) 
        {
            jCBNombreCliente.addItem(listaPedidos.buscarIteradorIndice(i).getElemento().getCliente());
            // Tu lógica aquí usando la categoría
            System.out.println("Categoría añadida: " + listaPedidos.buscarIteradorIndice(i).getElemento().getCliente());
        } 
    }  
    
     
    //Filtrando Categorias de Articulo sin repetir el mismo nombre de Categorias a una lista enlazada  ListaCategoria
    public ListaInterfaceGenerica<Pedidos> ListarNombresCliente() {
        ListaInterfaceGenerica<Pedidos> ListaCliente = new ListaEnlasadaGenericaImpl<>();
        HashSet<String> categoriasUnicas = new HashSet<>();

        for (int i = 1; i <= ListaPedidos.TamanioLista(); i++) {
            Pedidos Objarticulo = ListaPedidos.buscarIteradorIndice(i).getElemento();
            String NombreCliente = Objarticulo.getCliente();

            // Verificar si la categoría ya está en el conjunto
            if (categoriasUnicas.contains(NombreCliente)) {
                System.out.println("No se copió un tipo de categoría");
            } else {
                // Agregar el objeto a ListaCategoria y actualizar el conjunto
                NodoGenerico<Pedidos> NodoNuevo = new NodoGenerico<>(Objarticulo);
                ListaCliente.insertarFinal(NodoNuevo);
                categoriasUnicas.add(NombreCliente);
                System.out.println("Se copió un tipo de categoría: " + NombreCliente);
            }
        }

        return ListaCliente;
    }
//metodo para boton Filtro Cliente
    public void FiltroCliente(String NombreCategoria) 
    {
        ListaInterfaceGenerica<Pedidos> ListaFiltroCategoria = new ListaEnlasadaGenericaImpl<>();
        for (int i = 1; i <= ListaPedidos.TamanioLista(); i++) {
            Pedidos articulo = ListaPedidos.buscarIteradorIndice(i).getElemento();

            if (articulo.getCliente().equalsIgnoreCase(NombreCategoria)) {
                NodoGenerico<Pedidos> nuevoNodo = new NodoGenerico<>(articulo);
                ListaFiltroCategoria.insertarFinal(nuevoNodo);
                System.out.println("Filtrado con éxito: " + articulo.getCliente());
            } else {
                System.out.println("Sin coincidencia: " + articulo.getCliente());
            }

        }
        TablaModeloLinkedList(ListaFiltroCategoria);
    
    }

    
    
     
    
    
    
    
    
    
    
    
     
     //-------Implementacion filtro Paises/Ciudades-------------------------------------------------------------------
     public void CargandoComboBoxPaises()
     {
        ListaInterfaceGenerica<Proveedores> listaPaises = ListarNombresPaises();

    // Lógica adicional usando la lista de paises
        for (int i = 1; i <= listaPaises.TamanioLista(); i++) 
        {
            jCBPaises.addItem(listaPaises.buscarIteradorIndice(i).getElemento().getPais());
            // Tu lógica aquí usando la categoría
            System.out.println("Categoría añadida: " + listaPaises.buscarIteradorIndice(i).getElemento().getPais());
        } 
    }  
    
     
    //Filtrando Categorias de Articulo sin repetir el mismo nombre de Categorias a una lista enlazada  ListaCategoria
    public ListaInterfaceGenerica<Proveedores> ListarNombresPaises() {
        ListaInterfaceGenerica<Proveedores> ListaCategoria = new ListaEnlasadaGenericaImpl<>();
        HashSet<String> categoriasUnicas = new HashSet<>();

        for (int i = 1; i <= ListaProveedores.TamanioLista(); i++) {
            Proveedores ObjProveedores = ListaProveedores.buscarIteradorIndice(i).getElemento();
            String PaisActual = ObjProveedores.getPais();

            // Verificar si la categoría ya está en el conjunto
            if (categoriasUnicas.contains(PaisActual)) {
                System.out.println("No se copió un tipo de categoría");
            } else {
                // Agregar el objeto a ListaCategoria y actualizar el conjunto
                NodoGenerico<Proveedores> NodoNuevo = new NodoGenerico<>(ObjProveedores);
                ListaCategoria.insertarFinal(NodoNuevo);
                categoriasUnicas.add(PaisActual);
                System.out.println("Se copió un tipo de categoría: " + PaisActual);
            }
        }

        return ListaCategoria;
    }
    
    
    //se debe filtrar una lista 
    //mostrando contenido despues de filtrar por un parametro seleccionado en combobox
    
    
    
        public void CargarListaPedidosPorPais(String NombrePais) 
    {
        ListaInterfaceGenerica<Proveedores> ListaProveedorPorPais = new ListaEnlasadaGenericaImpl<>();
        ListaInterfaceGenerica<Pedidos> ListaPedidosPorPais = new ListaEnlasadaGenericaImpl<>();
        
        
        for(int i=1; i<=ListaProveedores.TamanioLista();i++)
        {
            if(ListaProveedores.buscarIteradorIndice(i).getElemento().getPais().equalsIgnoreCase(NombrePais))
            {  
                Proveedores Proveedor = ListaProveedores.buscarIteradorIndice(i).getElemento();
                NodoGenerico<Proveedores> nuevoNodo = new NodoGenerico<>(Proveedor);
                
                ListaProveedorPorPais.insertarFinal(nuevoNodo);
            }
            else
            {
                System.out.print("No hay coincidencia de pais");
            }
        }
        
        for(int i=1; i<= ListaProveedorPorPais.TamanioLista();i++)
        {
            
            for(int j=1; j<=ListaPedidos.TamanioLista(); j++)
            {
                if(ListaPedidos.buscarIteradorIndice(j).getElemento().getCliente().equalsIgnoreCase(ListaProveedorPorPais.buscarIteradorIndice(i).getElemento().getNombreCompania()))
                {  
                    Pedidos Pedido= ListaPedidos.buscarIteradorIndice(j).getElemento();
                    NodoGenerico<Pedidos> nuevoNodo = new NodoGenerico<>(Pedido);

                    ListaPedidosPorPais.insertarFinal(nuevoNodo);
                }
                else
                {
                    System.out.print("No hay coincidencia de Nombre de cliente con nombre de Compañia");
                }
            }
            
            
        }
        
        TablaModeloLinkedList(ListaPedidosPorPais);
    }      
        
        
    //--------------Busqueda por JtexFile---------------------------------------------  
        public void FiltroFechaPedido(String FechaPedidoBuscado) 
    {
        ListaInterfaceGenerica<Pedidos> ListaFiltroFechaPedido = new ListaEnlasadaGenericaImpl<>();
        for (int i = 1; i <= ListaPedidos.TamanioLista(); i++) {
            Pedidos Pedido = ListaPedidos.buscarIteradorIndice(i).getElemento();

            if (Pedido.getFechaPedido().equalsIgnoreCase(FechaPedidoBuscado)) {
                NodoGenerico<Pedidos> nuevoNodo = new NodoGenerico<>(Pedido);
                ListaFiltroFechaPedido.insertarFinal(nuevoNodo);
                System.out.println("Filtrado con éxito: " + Pedido.getCliente());
            } else {
                System.out.println("Sin coincidencia: " + Pedido.getCliente());
            }

        }
        TablaModeloLinkedList(ListaFiltroFechaPedido);
    
    }
      
         public void FiltroFechaEnvio(String FechaEnvioBuscado) 
    {
        ListaInterfaceGenerica<Pedidos> ListaFiltroFechaEnvio = new ListaEnlasadaGenericaImpl<>();
        for (int i = 1; i <= ListaPedidos.TamanioLista(); i++) {
            Pedidos Pedido = ListaPedidos.buscarIteradorIndice(i).getElemento();

            if (Pedido.getFormaEnvio().equalsIgnoreCase(FechaEnvioBuscado)) {
                NodoGenerico<Pedidos> nuevoNodo = new NodoGenerico<>(Pedido);
                ListaFiltroFechaEnvio.insertarFinal(nuevoNodo);
                System.out.println("Filtrado con éxito: " + Pedido.getCliente());
            } else {
                System.out.println("Sin coincidencia: " + Pedido.getCliente());
            }

        }
        TablaModeloLinkedList(ListaFiltroFechaEnvio);
    
    }
        
        
        
        
        
        
        
    
        
    /*
     //-------Implementacion filtro Compañia de Envio-------------------------------------------------------------------
     public void CargandoListaFiltroCompania()
     {
        ListaInterfaceGenerica<Pedidos> listaCategorias = ListarNombresCompania();

    // Lógica adicional usando la lista de categorías
        for (int i = 1; i <= listaCategorias.TamanioLista(); i++) 
        {
            jCBNombreCategoria.addItem(listaCategorias.buscarIteradorIndice(i).getElemento().get);
            // Tu lógica aquí usando la categoría
            System.out.println("Categoría añadida: " + listaCategorias.buscarIteradorIndice(i).getElemento().getCategoria());
        } 
    }  
    
     
    //Filtrando Categorias de Articulo sin repetir el mismo nombre de Categorias a una lista enlazada  ListaCategoria
    public ListaInterfaceGenerica<Articulos> ListarNombresCompania() {
        ListaInterfaceGenerica<Articulos> ListaCategoria = new ListaEnlasadaGenericaImpl<>();
        HashSet<String> categoriasUnicas = new HashSet<>();

        for (int i = 1; i <= ListaArticulos.TamanioLista(); i++) {
            Articulos Objarticulo = ListaArticulos.buscarIteradorIndice(i).getElemento();
            String categoriaActual = Objarticulo.getCategoria();

            // Verificar si la categoría ya está en el conjunto
            if (categoriasUnicas.contains(categoriaActual)) {
                System.out.println("No se copió un tipo de categoría");
            } else {
                // Agregar el objeto a ListaCategoria y actualizar el conjunto
                NodoGenerico<Articulos> NodoNuevo = new NodoGenerico<>(Objarticulo);
                ListaCategoria.insertarFinal(NodoNuevo);
                categoriasUnicas.add(categoriaActual);
                System.out.println("Se copió un tipo de categoría: " + categoriaActual);
            }
        }

        return ListaCategoria;
    }

    public void FiltroCompania(String NombreCategoria) 
    {
        ListaInterfaceGenerica<Pedidos> ListaFiltroCategoria = new ListaEnlasadaGenericaImpl<>();
        for (int i = 1; i <= ListaArticulos.TamanioLista(); i++) {
            Articulos articulo = ListaArticulos.buscarIteradorIndice(i).getElemento();

            if (articulo.getCategoria().equalsIgnoreCase(NombreCategoria)) {
                NodoGenerico<Articulos> nuevoNodo = new NodoGenerico<>(articulo);
                ListaFiltroCategoria.insertarFinal(nuevoNodo);
                System.out.println("Filtrado con éxito: " + articulo.getNombreProducto());
            } else {
                System.out.println("Sin coincidencia: " + articulo.getNombreProducto());
            }

        }
        TablaModeloLinkedList(ListaFiltroCategoria);
    
    }
    
    
    */
    
    
    
    
    
    
    

    
   
     
    
     public void CargandoBusquedaBinariaCliente()
     {
         TablaModeloLinkedList(AsignacionObjBusquedaBinariaAListaEnlazada());
       
     }
     
     
     
    
  
  //Busqueda binaria por nombre y asignacion de objeto a lista enlazada
    public ListaInterfaceGenerica AsignacionObjBusquedaBinariaAListaEnlazada()
    {
       ListaInterfaceGenerica<Pedidos> ListaBusquedaBinariaNombreProducto = new ListaEnlasadaGenericaImpl<>();
        NodoGenerico<Pedidos> NodoBusquedaProducto = new NodoGenerico<Pedidos>(busquedaBinariaClientes(jTextNombreCliente.getText()));
        ListaBusquedaBinariaNombreProducto.insertarFinal(NodoBusquedaProducto);
        return ListaBusquedaBinariaNombreProducto;
    }
     
    
    
    public Pedidos busquedaBinariaClientes(String nombreProducto) 
    {
        Ordenamiento_ShellSort_Nombre("Ascendente");
        int inicio = 1;
        int fin = ListaPedidos.TamanioLista() ;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            NodoGenerico<Pedidos> nodoMedio = ListaPedidos.buscarIteradorIndice(medio + 1); // Sumamos 1 para ajustarnos al índice de la lista

            Pedidos PedidoMedio = nodoMedio.getElemento();
            String nombreMedio = PedidoMedio.getCliente();

            int comparacion = nombreMedio.compareToIgnoreCase(nombreProducto);

            if (comparacion == 0) {
                return PedidoMedio; // Se encontró el artículo
            } else if (comparacion < 0) {
                inicio = medio + 1; // Buscar en la mitad derecha
            } else {
                fin = medio - 1; // Buscar en la mitad izquierda
            }
        }

        return null; // No se encontró el artículo
        
    }
   
    
   
    
    
    
    
    

     
 
  
 


  
  
    
    Pedidos valorActual =new Pedidos();
    
    public void Ordenamiento_ShellSort_Nombre(String Tipo) 
    {
        
        int n = ListaPedidos.TamanioLista();
        int incremento = n;

        do {
            incremento = incremento / 2;
            for (int i = incremento; i <= n; i++) {
                NodoGenerico<Pedidos> nodoActual = ListaPedidos.buscarIteradorIndice(i);
                if (nodoActual != null) {
                    Pedidos valorActual = nodoActual.getElemento();

                    int j = i;
                    while (j >= incremento) {
                        NodoGenerico<Pedidos> nodoAnterior = ListaPedidos.buscarIteradorIndice(j - incremento);
                        if (nodoAnterior != null) {
                            Pedidos valorAnterior = nodoAnterior.getElemento();
                           
                            if(Tipo.equalsIgnoreCase("Ascendente"))
                            {
                                if (compararAmenorQueBTipo01(valorActual.getCliente(), valorAnterior.getCliente()) ) {
                                        ListaPedidos.buscarIteradorIndice(j).setElemento(valorAnterior);
                                        System.out.print("Valor intercambiado correctamente");
                                        j -= incremento;
                                    } else {
                                        break;  
                                    }
                            }else
                            {
                                if (compararAmenorQueBTipo02(valorActual.getCliente(), valorAnterior.getCliente()) ) {
                                        ListaPedidos.buscarIteradorIndice(j).setElemento(valorAnterior);
                                        System.out.print("Valor intercambiado correctamente");
                                        j -= incremento;
                                    } else {
                                        break;  
                                    }
                            }
                           
                           
                              
                                    
                            
                        } else {
                            break;
                        }
                    }

                    ListaPedidos.buscarIteradorIndice(j).setElemento(valorActual);
                }
            }
        } while (incremento > 1);
        
        
        
        
    }    
    
    //orden ascendente

   public boolean compararAmenorQueBTipo01(String a, String b) 
   {
    // Comparar los Strings directamente
    return a.compareTo(b) < 0;
    }
   public boolean compararAmenorQueBTipo02(String a, String b) 
   {
    // Comparar los Strings directamente
    return a.compareTo(b) > 0;
    }
     
   
   
 
     //------------------------------------------------------------------
     public void TablaModeloLinkedList(ListaInterfaceGenerica<Pedidos> Lista)
     {
         LinkedList<Pedidos> list =new LinkedList<>();
         
         
         //pasando los valores de l¡nuestra lista enlazada a la linkedList
         for (int i = 1; i <= Lista.TamanioLista(); i++) 
            {
                
               list.add(Lista.buscarIteradorIndice(i).getElemento());
                
            }
         DefaultTableModel modeloEnlazada = (DefaultTableModel) jTableAticulos.getModel();
         
         
         
          Object[] row;
            for (int i = 0; i < list.size(); i++) {
                row = new Object[7];
                row[0] = list.get(i).getIdPedido();
                row[1] = list.get(i).getCliente();
                row[2] = list.get(i).getFechaPedido();
                row[3] = list.get(i).getFechaEntrega();
                row[4] = list.get(i).getFechaEnvio();
                row[5] = list.get(i).getFormaEnvio();
                row[6] = list.get(i).getCargo();
                
                modeloEnlazada.addRow(row);
                
            }
         
     }
     
    public void TablaModeloLinkedListReinicio()
     {
         DefaultTableModel modeloEnlazada = (DefaultTableModel) jTableAticulos.getModel();
         
         modeloEnlazada.setRowCount(0);
         
     }
    
    
    
    
    
    
    
    
    
    
    
    
     //-------PROVEEDORES----------------------------------
     public void TablaModeloPROVEEDORESLinkedList(ListaInterfaceGenerica<Proveedores> Lista)
     {
         LinkedList<Proveedores> list =new LinkedList<>();
         
         
         //pasando los valores de l¡nuestra lista enlazada a la linkedList
         for (int i = 1; i <= Lista.TamanioLista(); i++) 
            {
                
               list.add(Lista.buscarIteradorIndice(i).getElemento());
                
            }
         //DefaultTableModel modeloEnlazada2 = (DefaultTableModel) jTable1.getModel();
         
         
         
          Object[] row;
            for (int i = 0; i < list.size(); i++) {
                row = new Object[11];
                row[0] = list.get(i).getIdProveedor();
                row[1] = list.get(i).getNombreCompania();
                row[2] = list.get(i).getCargoContacto();
                row[3] = list.get(i).getNombreContacto();
                row[4] = list.get(i).getDireccion();
                row[5] = list.get(i).getCiudad();
                row[6] = list.get(i).getRegion();
                row[7] = list.get(i).getCodigoPostal();
                row[8] = list.get(i).getPais();
                row[9] = list.get(i).getTelefono();
                row[10] = list.get(i).getFax();

                
               // modeloEnlazada2.addRow(row);
                
            }
         
     }
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Consulta_de_Pedido() {
        initComponents();
        this.setTitle(" Consulta de Artículos");
        this.setLocationRelativeTo(this);
         
    }
    
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAticulos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jBtnFiltrarCliente = new javax.swing.JButton();
        jTextNombreCliente = new javax.swing.JTextField();
        jTextFechaEnvio = new javax.swing.JTextField();
        jTextFechaPedido = new javax.swing.JTextField();
        jComboBoxOrdenamiento = new javax.swing.JComboBox<>();
        jButtonOrdenar = new javax.swing.JButton();
        jButtonFiltrarPais = new javax.swing.JButton();
        jCBNombreCliente = new javax.swing.JComboBox<>();
        jCBPaises = new javax.swing.JComboBox<>();
        jBotonBuscarNombreArticulo = new javax.swing.JButton();
        jButtonBuscarFechaPedido = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        canvas1 = new java.awt.Canvas();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMnuItemPrincipal = new javax.swing.JMenuItem();
        jMenuArticulos = new javax.swing.JMenu();
        jMnuArticulos = new javax.swing.JMenuItem();
        jMenProveedores = new javax.swing.JMenuItem();

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Multiconsulta de Articulos");

        jLabel7.setText("Nombre Cliente:");

        jTableAticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id. de pedido", "Cliente/Proveedor", "Fecha de pedido", "Fecha de entrega", "Fecha de envio", "Forma de envio", "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableAticulos);

        jLabel8.setText("Fecha de Pedido:");

        jLabel10.setText("Fecha de Envio:");

        jBtnFiltrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filtrar.png"))); // NOI18N
        jBtnFiltrarCliente.setText("Filtro Cliente/Compañia");
        jBtnFiltrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFiltrarClienteActionPerformed(evt);
            }
        });

        jTextNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreClienteActionPerformed(evt);
            }
        });

        jTextFechaEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFechaEnvioActionPerformed(evt);
            }
        });

        jTextFechaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFechaPedidoActionPerformed(evt);
            }
        });

        jComboBoxOrdenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Descendente" }));
        jComboBoxOrdenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOrdenamientoActionPerformed(evt);
            }
        });

        jButtonOrdenar.setText("Ordenar");
        jButtonOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrdenarActionPerformed(evt);
            }
        });

        jButtonFiltrarPais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filtrar.png"))); // NOI18N
        jButtonFiltrarPais.setText("Filtro Pais/Ciudad");
        jButtonFiltrarPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarPaisActionPerformed(evt);
            }
        });

        jCBNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBNombreClienteActionPerformed(evt);
            }
        });

        jCBPaises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBPaisesActionPerformed(evt);
            }
        });

        jBotonBuscarNombreArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LupaDeBuscador.png"))); // NOI18N
        jBotonBuscarNombreArticulo.setText("Buscar Nombre");
        jBotonBuscarNombreArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonBuscarNombreArticuloActionPerformed(evt);
            }
        });

        jButtonBuscarFechaPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LupaDeBuscador.png"))); // NOI18N
        jButtonBuscarFechaPedido.setText("Buscar FechaPedido");
        jButtonBuscarFechaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarFechaPedidoActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LupaDeBuscador.png"))); // NOI18N
        jButton1.setText("Buscar Fecha Envio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");

        jMnuItemPrincipal.setText("Menu Principal");
        jMnuItemPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuItemPrincipalActionPerformed(evt);
            }
        });
        jMenu1.add(jMnuItemPrincipal);

        jMenuBar1.add(jMenu1);

        jMenuArticulos.setText("Importar");

        jMnuArticulos.setText("Pedidos");
        jMnuArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuArticulosActionPerformed(evt);
            }
        });
        jMenuArticulos.add(jMnuArticulos);

        jMenProveedores.setText("Proveedoress");
        jMenProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenProveedoresActionPerformed(evt);
            }
        });
        jMenuArticulos.add(jMenProveedores);

        jMenuBar1.add(jMenuArticulos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(185, 185, 185)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextFechaEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButtonBuscarFechaPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jBotonBuscarNombreArticulo)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(239, 239, 239)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonOrdenar)
                                    .addComponent(jComboBoxOrdenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jBtnFiltrarCliente))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jCBNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonFiltrarPais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCBPaises, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(59, 59, 59)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBotonBuscarNombreArticulo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscarFechaPedido))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextFechaEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonOrdenar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxOrdenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBPaises, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnFiltrarCliente)
                            .addComponent(jButtonFiltrarPais))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMnuItemPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuItemPrincipalActionPerformed
        Ventana_Principal principal = new Ventana_Principal();
        principal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMnuItemPrincipalActionPerformed

    private void jMnuArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuArticulosActionPerformed
        //cargarArticulos();
        cargarArticulosListaEnlazada();
        
        //cargando lista de Filtros en combobox
        CargandoListaFiltroCliente();
        
        
        
    }//GEN-LAST:event_jMnuArticulosActionPerformed

    private void jMenuProveedoresActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        cargarProveedoresListaEnlazada();
        
        //cargando filtros de Pais/Ciudad y Compañia de envios en ComboBox
        
        
        
    } 
    private void jComboBoxOrdenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOrdenamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxOrdenamientoActionPerformed

    private void jButtonOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrdenarActionPerformed
        // TODO add your handling code here:
        
        String Opcion= jComboBoxOrdenamiento.getSelectedItem().toString();
        Ordenamiento_ShellSort_Nombre(Opcion);
        TablaModeloLinkedListReinicio();   
        TablaModeloLinkedList(ListaPedidos);
        
        
        
    }//GEN-LAST:event_jButtonOrdenarActionPerformed

    private void jTextFechaEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFechaEnvioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFechaEnvioActionPerformed

    private void jBtnFiltrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFiltrarClienteActionPerformed
        // TODO add your handling code here:
        

        TablaModeloLinkedListReinicio();

        FiltroCliente(jCBNombreCliente.getSelectedItem().toString());
        
    }//GEN-LAST:event_jBtnFiltrarClienteActionPerformed
                                               

    private void jButtonFiltrarPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarPaisActionPerformed
        // TODO add your handling code here:
        TablaModeloLinkedListReinicio();
        CargarListaPedidosPorPais(jCBPaises.getSelectedItem().toString());
        
    }//GEN-LAST:event_jButtonFiltrarPaisActionPerformed

    private void jCBNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBNombreClienteActionPerformed
        // TODO add your handling code here:
        //forma para adquirir la lista enlazada que devuelve ListarNombresCategoria();
      
        
        
    }//GEN-LAST:event_jCBNombreClienteActionPerformed

    private void jTextNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreClienteActionPerformed

    private void jBotonBuscarNombreArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonBuscarNombreArticuloActionPerformed
        // TODO add your handling code here:
     TablaModeloLinkedListReinicio();
     CargandoBusquedaBinariaCliente();
    }//GEN-LAST:event_jBotonBuscarNombreArticuloActionPerformed

    private void jCBPaisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBPaisesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBPaisesActionPerformed

    private void jMenProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenProveedoresActionPerformed
        // TODO add your handling code here:
        
        
        
        cargarProveedoresListaEnlazada();
        
        CargandoComboBoxPaises();
        
        
        
        
        
    }//GEN-LAST:event_jMenProveedoresActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonBuscarFechaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarFechaPedidoActionPerformed
        // TODO add your handling code here:
        TablaModeloLinkedListReinicio();
        FiltroFechaPedido(jTextFechaPedido.getText());
    }//GEN-LAST:event_jButtonBuscarFechaPedidoActionPerformed

    private void jTextFechaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFechaPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFechaPedidoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Consulta_de_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta_de_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta_de_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta_de_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
         //Consulta_de_Articulos consultaVista= new Consulta_de_Articulos();
        //</editor-fold>
        //</editor-fold>
        
         //Consulta_de_Articulos consultaVista= new Consulta_de_Articulos();
        
         
         
         
         
         
         
        
         
         
         
        
        
        

        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta_de_Pedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private javax.swing.JButton jBotonBuscarNombreArticulo;
    private javax.swing.JButton jBtnFiltrarCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBuscarFechaPedido;
    private javax.swing.JButton jButtonFiltrarPais;
    private javax.swing.JButton jButtonOrdenar;
    private javax.swing.JComboBox<String> jCBNombreCliente;
    private javax.swing.JComboBox<String> jCBPaises;
    private javax.swing.JComboBox<String> jComboBoxOrdenamiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenProveedores;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenuArticulos;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMnuArticulos;
    private javax.swing.JMenuItem jMnuItemPrincipal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAticulos;
    private javax.swing.JTextField jTextFechaEnvio;
    private javax.swing.JTextField jTextFechaPedido;
    private javax.swing.JTextField jTextNombreCliente;
    // End of variables declaration//GEN-END:variables
}
