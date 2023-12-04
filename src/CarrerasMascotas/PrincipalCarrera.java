package CarrerasMascotas;

import java.util.concurrent.CyclicBarrier;

public class PrincipalCarrera {
    public static void main (String[]args){
        Mascotas caballo1 = new Mascotas("El gran Rojo");
        Mascotas caballo2 = new Mascotas("Relampago");
        Mascotas caballo3 = new Mascotas("Rafaga Plateada");
        CyclicBarrier barrera = new CyclicBarrier(3); // 3 hilos deben llegar a la barrera
        
        caballo1.setBarrera(barrera);
        caballo2.setBarrera(barrera);
        caballo3.setBarrera(barrera);
        
        //inicio mis hilos
        caballo1.start();
        caballo2.start();
        caballo3.start();
    }
}
