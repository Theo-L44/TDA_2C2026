import java.io.*;
import java.util.*;

public class Main {
    public static void main ( String [] args ) {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
        Scanner scanner = new Scanner (br);
        PrintWriter printer = new PrintWriter (bw);
        
        //Tengo que manejar el dato inicial para que me quede una lista
        int n = scanner.nextInt(); //cantidad de vendedores
        
        int[] vendedores = new int[n+1]; //como quiero usar los valores de la lista para calcular la longitud de la cadena de superiores, agrego una posicion fantasma a la cual no voy a acceder nunca, que seria la pos 0, pues 1<=n<2000
        
        for (int i=1;i<=n;i++) {
            vendedores[i] = scanner.nextInt(); //array de vendedores
        }

        //si lo pienso como un árbol, las hojas son los vendedores que no tienen superiores, y el -1, el nodo que no tiene revendedor inmediato, la raíz

        //Yo quiero averiguar la cantidad minima de mesas necesarias. Independientemente de la cantidad de nodos, la cantidad de mesas necesarias va a ser el largo de la rama del árbol más grande, porque empezando desde la raíz, ninguno de los nodos puede estar con su hijo, que en nuestro problema sería el superior.
        //Si elijo 2 nodos cualesquiera, que están en distintas ramas y los junto en una mesa, eso no me molesta porque ninguno es superior del otro.

        int cantidadMesas = 0;

        for (int i=1;i<=n;i++){
            
            int posicion = i;
            int largoCadenaSuperiores = 0; //cuento el largo de la cadena de vendedores, porque ya se que no se pueden sentar juntos aquellos que sean superiores

            while(vendedores[posicion]!=-1){ //-1 sería la raiz de mi árbol
                posicion = vendedores[posicion]; //voy siguiendo la cadena de superiores contando la cantidad de los mismos para después comparar
                largoCadenaSuperiores++;
            }

            if (largoCadenaSuperiores > cantidadMesas){ //si la cantidadMesas es inferior a la cadena de superiores actual, actualizo
                cantidadMesas=largoCadenaSuperiores;
            }   

        }

        cantidadMesas+=1; //no estaba contando la raiz, que también forma parte de la cadena de superiores, por eso sumo 1
        printer.println(cantidadMesas);
        
        printer.close();
    }
}