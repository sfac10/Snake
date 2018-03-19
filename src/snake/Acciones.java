package snake;
import java.awt.*;

public interface Acciones {
    
    public void comer(Point p);
    
    static public void mover(Point p){}
    
    public void girar();
    
    public void nextestadoC(Celda c);
    
}
