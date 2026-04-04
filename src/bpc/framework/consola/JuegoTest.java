package bpc.framework.consola;

import bpc.framework.consola.test.EscenaTesteadora;
import bpc.framework.consola.test.GameObjectTesteador;


public class JuegoTest {
    public static void main(String[] args){
        GameObjectTesteador objeto = new GameObjectTesteador();
        EscenaTesteadora escenaTesteadora = new EscenaTesteadora();
        Juego juego = new Juego();

        escenaTesteadora.juego = juego;
        escenaTesteadora.inicializar();

        for(int i=0;i<120; i++){
            escenaTesteadora.ejecutarFrame();
        }

        int frames = objeto.frameCounter();
        System.out.println("Los frames ejecutados han sido: " + frames);

        if(frames >= 110 && frames <= 130){
            System.out.println("El test ha salido bien");
        }else{
            System.out.println("El tet ha salido mal");
        }
    }
}