package snake;
import java.awt.*;

public class Recuadro{
    
    public Recuadro(){
        mapa = new Celda[7][7];
        
        for(int y=0; y<mapa.length; y++)
            for(int x=0; x<mapa[y].length; x++)
                mapa[x][y] = new Celda(new Point(x,y), 0);
    }
    //Este constructor crea el espacio por el que va a circular la serpiente.
    
    public void setposicion(Celda c){
        mapa[c.getposicion().x][c.getposicion().y] = c;
    }
    //Permite modificar una determinada posicion del recuadro,
    
    public Celda getposicion(Celda c){
        return mapa[c.getposicion().x][c.getposicion().y];
    }
    
    public Celda[][] getmapa(){
        return mapa;
    } //getter del recuadro
    
    public String toString(int x, int y){
        return x + "," + y;
    }
    //permite imprimir las posiciones del mapa
    
    private Celda[][] mapa;
    //El recuadro es una matriz de Celdas
}



class Celda{
    
    public Celda(Point p){
        posicion = p;
    }
    
    public Celda(Point p, int tC){
        posicion = p;
        estadoC = tC;
    }
    //una celda es una posición en el mapa cuyo valor es 0, 1 o 2 si esta respectivamente libre, ocupada o es alimento.
    
    public void setposicion(Point p){
        posicion = p;
    } //setter de posicion
    
    public Point getposicion(){
        return posicion;
    } //getter de posicion
    
    public void setestado(int e){
        estadoC = e;
    }
    //Para modificar el valor de una posición. 
    
    public int getestado(){
        return estadoC;
    }
    //Para indicar si una posicion está libre (0), ocupada (1) o es alimento (2).
        
    public static Celda crearComida(Celda c){
    int x = 7, y = 7; 
    
    while(x>6)
        x = (int)(Math.random()*10);
    while(y>6)
        y = (int)(Math.random()*10);
    c.setposicion(new Point(x,y));
    if(c.getestado() == 0)
        return new Celda(new Point(x,y),2);
    else{
        Celda.crearComida(c);
        return c;
    }
    
    }
    
    private Point posicion;
    private int estadoC;
}