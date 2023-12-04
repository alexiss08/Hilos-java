package CarrerasMascotas;

import java.util.concurrent.CyclicBarrier;

public class Mascotas extends Thread {
    String nombre;
    private int avance = 0;
    private static int numeroMascotas = 0; // Contador para rastrear el orden de llegada
    private CyclicBarrier barrera;

    public Mascotas(String nombre) {
        this.nombre = nombre;
    }

    public void setBarrera(CyclicBarrier barrera) {
        this.barrera = barrera;
    }

    @Override
    public void run() {
        while (avance < 30) { // La distancia total de la carrera es 30 metros
            int avanzar = 5; // Avanzar 5 metros a la vez
            avance += avanzar;

            System.out.println(nombre + " va en " + avance + " metros.");

            try {
                Thread.sleep(2000); // Retraso de 2 segundos después de cada iteración de 5 metros
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        numeroMascotas++;
        System.out.println(nombre + " ha terminado la carrera en el puesto " + numeroMascotas);

        try {
            barrera.await(); // Esperar a que todos los hilos lleguen a la barrera
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

