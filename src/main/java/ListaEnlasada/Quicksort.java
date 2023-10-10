/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaEnlasada;

/**
 *
 * @author Home
 */
public class Quicksort 
{
     public  void delay()
    {   try 
        {   Thread.sleep(10);//1000 = 1seg
        } 
        catch (Exception e) 
        {   System.out.println(e);
        }
    }
    
    public int [] Ordenamiento_Quicksort(int []arreglo, int primero, int ultimo, int tipo)
    {
        if(ultimo-primero < 1)
            return arreglo;
        int pivote= arreglo[ultimo];
        int indice = primero -1;
        
        for(int i=primero; i<ultimo; i++)
            if(arreglo[i]<= pivote)
                swap(arreglo, ++indice, i);
        swap(arreglo, indice + 1, ultimo);
        
        Ordenamiento_Quicksort(arreglo, primero, indice, tipo);
        Ordenamiento_Quicksort(arreglo, indice + 2, ultimo, tipo);
        delay();
        return arreglo;
        
    
    }
    
    
    public void swap(int arreglo[], int primero, int segundo)
    {   int temp=arreglo[primero];
        arreglo[primero]=arreglo[segundo];
        arreglo[segundo]= temp;
        
    }
    
    
    
}







