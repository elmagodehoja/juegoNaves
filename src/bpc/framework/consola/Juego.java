package bpc.framework.consola;

import bpc.daw.consola.Consola;
import bpc.daw.consola.Teclado;

import java.awt.event.KeyEvent;

public class Juego {
    private Consola consola;
    private Escena escena;
    private Resolucion resolucion;
    private  boolean detener;

    public Juego(){
    }

    public void iniciar(Escena e, Resolucion r){
        this.resolucion = r;
        int ancho = r.getResolucion().width;
        int alto = r.getResolucion().height;
        Consola consolaDaw = new Consola("Juego Naves",ancho,alto);
        this.consola = new Consola();
        this.setEscena(e);
        this.detener = false;

        Teclado teclado = this.consola.getTeclado();
        while(detener == false && teclado.teclaPulsada(KeyEvent.VK_ESCAPE) == false){
            this.escena.ejecutarFrame();
            this.consola.esperarSiguienteFrame();
        }
        this.escena.finalizar();
    }

    public void setEscena(Escena e){
        this.escena = e;
        this.escena.juego = this;
        this.escena.consola = this.consola;
        this.escena.inicializar();
    }

    public Escena getEscena(){
        return this.escena;
    }

    public void detener(){
        this.detener = true;
    }

    public int getAnchuraPantalla(){
        return this.resolucion.getResolucion().width;
    }
    public int getAlturaPantalla(){
        return this.resolucion.getResolucion().height;
    }
}
