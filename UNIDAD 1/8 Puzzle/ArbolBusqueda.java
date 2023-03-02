
package puzzle8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Mario R�os
 */
public class ArbolBusqueda {
    
    Nodo raiz;
    String objetivo;
    String NodosPadre;
    public ArbolBusqueda(Nodo raiz, String objetivo)
    {
        this.raiz = raiz;
        this.objetivo = objetivo;
    }
    
    //Busqueda por Anchura
    public void busquedaPorAnchura()
    {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        Queue<Nodo> estadosPorVisitar = new LinkedList();
        
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                    //System.out.println("---Metiendo nuevo Nodo");
                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }

            }
            
            nodoActual = estadosPorVisitar.poll();
            NodosPadre=nodoActual.getPadre().getEstado();

            System.out.println(NodosPadre.substring(0, 1)+"|"+NodosPadre.substring(1, 2)+"|"+NodosPadre.substring(2, 3)+"\n"+NodosPadre.substring(3, 4)+"|"+NodosPadre.substring(4, 5)+"|"+NodosPadre.substring(5, 6)+"\n"+NodosPadre.substring(6, 7)+"|"+NodosPadre.substring(7, 8)+"\n");
            
        }
      

        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        //System.out.println("El nodo padre es: "+nHijo.getEstado());
        //System.out.println("El orden es: "+nodoActual.getEstado());
        String NodoFinal=nodoActual.getEstado();
        System.out.println("El orden es: ");
        System.out.println(NodoFinal.substring(0, 1)+"|"+NodoFinal.substring(1, 2)+"|"+NodoFinal.substring(2, 3)+"\n"+NodoFinal.substring(3, 4)+"|"+NodoFinal.substring(4, 5)+"|"+NodoFinal.substring(5, 6)+"\n"+NodoFinal.substring(6, 7)+"|"+NodoFinal.substring(7, 8));

    }
    
}
