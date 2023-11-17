package ListaEnlazadaArticulo;
import ListaEnlasada.*;
import ListaEnlasada.*;
import java.util.Scanner;
/*
public class Main 
{
    static Scanner consola = new Scanner(System.in);
    private int menu()
{ 
    int opcion;
    System.out.println(
        "--------------------------------------------------------\n"+
        "LISTA ENLAZADA SIMPLE\n"+
        "--------------------------------------------------------\n"+
        "1. Insertar al FINAL de la LISTA\n"+
        "2. Insertar al INICIO de la LISTA\n"+
        "3. Eliminar del INICIO de la LISTA\n"+
        "4. Eliminar del FINAL de la LISTA\n"+
        "5. Imprimir LISTA\n"+
        "6. Buscar un Elemento de la LISTA\n"+
        "7. Insertar un Elemento de la LISTA\n"+
        "8. Eliminar un Elemento de la LISTA\n"+
        "9. Tamaño de la LISTA\n"+
        "10. Ordenar la LISTA\n"+
        "0. FIN\n"+
        "--------------------------------------------------------\n"+

        "Ingrese la opción [1 - 7]");
    opcion = consola.nextInt();
    return opcion;
}
public static void main(String[] args) throws Exception
{
//CREAMOS LA LISTA ENLAZADA
    ListaInterface listaSimple = new ListaEnlasadaArticuloImpl() ;
    int opcion;
    Main objPrincipal = new  Main();
    do
{ 
    opcion = objPrincipal.menu();
    switch(opcion)
    {
        case 1://INSERTAR AL FINAL
        System.out.println("Ingrese el Número :");
        int item = consola.nextInt();
        listaSimple.insertarFinal(new Nodo(item));
        System.out.println(listaSimple.imprimirLista());
        break;

        case 2: //INSERTAR AL INICIO
        System.out.println("Ingrese el Número :");
        int item2 = consola.nextInt();
        listaSimple.insertarInicio(new Nodo(item2));
        System.out.println(listaSimple.imprimirLista());
        break;

        case 3: //RETIRAR DEL INICIO
        System.out.println("Nodo Eliminado : " +
        listaSimple.retirarInicio());
        System.out.println(listaSimple.imprimirLista());
        break;
        
        case 4: //RETIRAR DEL FINAL
        System.out.println("Nodo Eliminado : " +
        listaSimple.retirarFinal());
        System.out.println(listaSimple.imprimirLista());
        break;
        
        case 5: //IMPRIMIR LA LISTA
            System.out.println(listaSimple.imprimirLista());
            break;
            
        case 6: //BUSCAR VALOR
           System.out.println("Ingrese el Valor que desea buscar:");
            int itembuscado = consola.nextInt();
            System.out.println("Suvalor está en el indice: " + listaSimple.buscar(itembuscado));
            break;
            
            
        case 7: //Insertar un Elemento de la LISTA (InsertarDentro)
            System.out.println(listaSimple.imprimirLista());
            System.out.println("Ingrese la posición en la que desea insertar el numero");
            int item3 = consola.nextInt();
            System.out.println("Ingrese el numero");
            int item4 = consola.nextInt();
            listaSimple.insertarDentro(new Nodo(item4),item3);
            System.out.println(listaSimple.imprimirLista());
            
            break;
            
        case 8://eliminar un elemento dentro de la lista
            System.out.println("Ingrese la posición a la que desea eliminar el valor");
            int eliminaNodo =consola.nextInt();
            System.out.println("El nodo eliminado es: " + listaSimple.RetirarDentro(eliminaNodo));
            
            break;
        
        case 9://eliminar un elemento dentro de la lista
            System.out.println("El tamaño de la lista es: " + listaSimple.TamanioLista());
            break;
        case 10://Ordenar  lista por quicksort
            
            listaSimple.Ordenamiento_ShellSort();
            System.out.println("La lista ordenada es: " + listaSimple.imprimirLista() );   

            break;   


        case 0:
        System.exit(0);
        break;
        default:
        System.out.println("Error: Ingrese una opción valida");
        break;
     }
        }while(true);
    }
}


*/