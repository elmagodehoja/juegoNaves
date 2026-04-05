package hlanz.juegonaves;

import bpc.framework.consola.Escena;
import bpc.framework.consola.GameObject;
import bpc.daw.consola.*;
import bpc.framework.consola.Juego;
import bpc.framework.consola.Resolucion;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JuegoNaves extends Escena {
    private List<Enemigo> enemigos;

    public JuegoNaves(){
        this.enemigos = new ArrayList<>();
    }

    public List<Enemigo> getEnemigos(){
        return this.enemigos;
    }

    @Override
    public void añadir(GameObject obj){
        super.añadir(obj);
        if (obj instanceof Enemigo enemigo){
            this.enemigos.add(enemigo);
        }
    }

    @Override
    public void retirar(GameObject obj){
        super.retirar(obj);
        if (obj instanceof Enemigo enemigo){
            this.enemigos.remove(enemigo);
        }
    }

    @Override
    protected void añadirObjetosIniciales() {
        super.añadir(new ControlarFinJuego());
        super.añadir(new Fondo(1));
        super.añadir(new Nave1(KeyEvent.VK_LEFT,KeyEvent.VK_RIGHT,KeyEvent.VK_SPACE));
        super.añadir(new Nave2(KeyEvent.VK_A,KeyEvent.VK_D,KeyEvent.VK_E));
        Random r = new Random();

        for(int i = 0; i < 5; i++){
            int x = r.nextInt(800);
            int y = r.nextInt(400);
            int v = r.nextInt(3) + 1;

            super.añadir(new Enemigo1(x, y, v));
        }

        for(int i = 0; i < 3; i++){
            int cx = r.nextInt(800);
            int cy = r.nextInt(400);
            int radio = r.nextInt(100) + 50;
            int v = r.nextInt(2) + 1;

            super.añadir(new Enemigo2(cx, cy, cx, cy, radio, v));
        }
        super.añadir(new Marcador());
    }

    public static void main(String[] args) {
        Juego juego1 = new Juego();
        juego1.iniciar(juego1.getEscena(), Resolucion.VENTANA_FULLHD);
    }
}
