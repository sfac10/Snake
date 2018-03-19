package snake;
import java.awt.*;

public class Pruebas {

    public static void main(String[] args) {
        
        Recuadro r = new Recuadro();
        Cuerpo c = new Cuerpo();
        Point p = new Point(3,3);
        
        posicionN(r,c);
        mostrarR(r);
        
        while(Cuerpo.vida){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("Secuencia interrumpida");
            }
            Cuerpo.mover(p);
            
            posicionN(r,c);
            mostrarR(r);
            
            p.x++;
            if(p.x == 7)
                p.x = 0;
        }
        
    }
    
    public static void mostrarR(Recuadro r){
        
        for(int i=0; i<r.getmapa().length; i++){
            for(int j=0; j<r.getmapa()[i].length; j++)
                System.out.print(r.getmapa()[j][i].getestado() + "  ");
            System.out.println();
        }
        System.out.println("\n");
    }
    
    public static void posicionN(Recuadro r, Cuerpo c){
        Nodo n = c.cabeza;
        
        for(int i=0; i<Cuerpo.tamaño; i++){
            r.setposicion(n.casilla);
            n = n.next;
        }
    }
    
}
