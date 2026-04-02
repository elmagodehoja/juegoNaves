package bpc.framework.consola.test;

import bpc.framework.consola.Juego;
import bpc.framework.consola.Resolucion;


public class JuegoTest {
    public static void main(String[] args){
        GameObjectTesteador objeto = new GameObjectTesteador();
        EscenaTesteadora escenaTesteadora = new EscenaTesteadora();

        Juego juego = new Juego();

        Thread juegoComienzo = new Thread(() -> {
            juego.iniciar(escenaTesteadora, Resolucion.VENTANA_VGA);
        });
        juegoComienzo.start();

        try{
            Thread.sleep(2000);
            juego.detener();
            juegoComienzo.join();

            int frames = objeto.frameCounter();
            System.out.println("Los frames ejecutados han sido: " + frames);

            if(frames >= 110 && frames <= 130){
                System.out.println("El test ha salido bien");
            }else{
                System.out.println("El tet ha salido mal");
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}