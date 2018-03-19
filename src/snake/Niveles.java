package snake;
import java.awt.*;


//La idea en esta clase es crear diferentes niveles para la modalidad multinivel
public class Niveles {
    
    public Niveles(Point p){
        espacio = new int[7][7];
        nivel0(p);
    }
    
    public Niveles(int n){
        nivel = n;
        espacio = new int[7][7];
        nivel1();
    }
    
    public void nivel0(Point p){
        
        if(p.x == espacio.length)
            p.x = 0;
        if(p.y == espacio[p.x].length)
            p.y = 0;
    }
    
    public void nivel1(){
        
    }
    
    private int nivel;
    private int[][] espacio;
    
}
