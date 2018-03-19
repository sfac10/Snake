package snake;
import java.util.*;

public class Snake {

    public static void main(String[] args) {
       
        System.out.println("SNAKE");
        menuI();
    }
    //El método main ejecuta el menuI.
    
    public static void menuI(){
        Scanner s = new Scanner(System.in);
        
        System.out.println(" 1.Nuevo juego. \n 2.Mejores puntuaciones. \n 3.Salir.");
        
        try{
            int e = s.nextInt();
            
            if(e<1 || e>3){
                System.out.println("Opción no válida. Inténtelo de nuevo.");
                menuI();
            }
            else
                switch(e){
                    case 1:
                        juego();
                        break;
                    case 2:
                        puntuaciones();
                        break;
                    case 3:
                        System.out.close();
                        break;
                }
            
        }catch(InputMismatchException e){
            System.out.println("Hubo un problema. Inténtelo de nuevo.");
            menuI();
        }
    }
    //El menuI permite elegir entre inicar un nuevo juego, ver puntuaciones o salir de luego.
    
    public static void juego(){
        mModalidad();
        mDificultad(); 
        
        Recuadro r = new Recuadro();
        while(Cuerpo.vida)
            System.out.println("ola");
        
    }
    //Basicamente este método hace que funcione el programa.
    //Ejecuta dos menus y posteriormente inicia el juego.
    /*
    La idea es que cree primero el recuadro, cuyas posiciones se encuentran libres.
    Luego hay que crear una serpiente (Cuerpo) que ocupe una cierta posición inicial.
    Posteriormente irán apareciendo puntos(comidas) para que la serpiente coma y crezca.
    La unica forma para que pierda la serpiente es que se estrelle consigo misma (modo clasico).
    */
    
    public static void mModalidad(){
        Scanner s = new Scanner(System.in);
        System.out.println("Modalidad \n 1.Clásico. \n 2.Multinivel. \n 3. <---");
        
        try{
            int e = s.nextInt();
            
            switch(e){
                case 1:
                    
                    break;
                case 2:
                    System.out.println("No disponible en el momento.");
                    mModalidad();
                    break;
                case 3:
                    menuI();
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    mModalidad();
                    break;
            }
            
        }catch(InputMismatchException e){
            System.out.println("Hubo un problema. Inténtelo de nuevo.");
            mModalidad();
        }
    }
    //Este menu permite elegir si jugar libre o multinivel
    //Por ahora la opcion de multinivel no está funcionando
    
    public static void mDificultad(){
        Scanner s = new Scanner(System.in);
        System.out.println("Dificultad \n 1.Lento. \n 2.Moderado. \n 3.Rápido. \n 4.Desafiante. \n 5. <---");
        
        try{
            int e = s.nextInt();
            
            if(e>=1 && e<= 4)
                dificultad = e;
            else if(e == 5)
                mModalidad();
            else{
                System.out.println("Opción no válida. Inténtelo de nuevo.");
                mDificultad();
            }
            
        }catch(InputMismatchException e){
            System.out.println("Hubo un problema. Inténtelo de nuevo.");
            mDificultad();
        }    
    }
    //Este menu permite elegir la velocidad de movimiento de la serpiente.
    
    public static void puntuaciones(){
        //Se muestran los datos de un archivo.
        System.out.println("No disponible en el momento.");
        menuI();
    }
    //Este metodo permite ver los mejores puntajes.
    //Por ahora está inhabilitado.
    //La idea es que se guarden los puntajes en un doc y se muestren los cinco puntajes más altos.

    static int dificultad;
}
