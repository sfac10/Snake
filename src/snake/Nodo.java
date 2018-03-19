package snake;
import java.awt.*;

public class Nodo {
    
    public Nodo(){}
    
    public Nodo(Celda c){
         casilla = c;
    }
    
    Celda casilla;
    Nodo next; 
}

class Cuerpo implements Acciones{

    public Cuerpo(){
        
        cabeza = new Nodo(new Celda(new Point(0,3), 1));
        cabeza.next = new Nodo(new Celda(new Point(1,3), 1));
        cabeza.next.next = new Nodo(new Celda(new Point(2,3), 1));
        cabeza.next.next.next = cabeza;
        
        tamaño = 3;
    }
    //Al crear la serpiente su tamaño inicial será de 3 unidades.
    
    public void comer(Point p){
        Nodo n = new Nodo(new Celda(p,1));
        
        Nodo aux = cabeza;
        for(int i=0; i<tamaño-1; i++)
            aux = aux.next;
        
        n.next = aux.next;
        aux.next = n;
        tamaño++;
    }
    //Al llegar a una posición donde haya "comida" la serpiente aumentará su tamaño.
    //Aún no está implemetada la "comida".
    
    static public void mover(Point nextP) {
        Nodo npos = new Nodo(new Celda(nextP,1));
        
        Nodo aux = cabeza;
        for(int i=0; i<tamaño-1; i++)
            aux = aux.next;
            
        npos.next = aux.next.next;  
        cabeza = npos.next;
        aux.next.casilla.setestado(0);
        aux.next = npos;
    }
    //El método funciona como si la serpiente estuviera comiendo la casilla libre de al frente y eliminando la última, dejándola libre.
    
    public void nextestadoC(Celda nextC) {
        if(nextC.getestado() == 0)
            mover(nextC.getposicion());
        else if(nextC.getestado() == 2){
            comer(nextC.getposicion());
            Celda.crearComida(nextC);
        }
        else
            vida = false;
    }
    //Si la casilla siguiente está libre, la serpiente se mueve. 
    
    public void girar() {
        
    }
    //En este método se implementan los controles de la serpiente.

    static Nodo cabeza;
    static int tamaño;
    static boolean vida = true;
}
