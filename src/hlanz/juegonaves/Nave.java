package hlanz.juegonaves;

import bpc.daw.consola.Teclado;
import bpc.framework.consola.SpriteGameObject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;

public abstract class Nave extends SpriteGameObject {
    private int teclaIzquierda;
    private int teclaDerecha;
    private int teclaDisparo;
    private int velocidad;
    private Instant ultimoDisparoRealizado;

    public Nave(int ti, int tde, int tdi, int v, Image image){
        super(image,0,0);
        this.teclaIzquierda = ti;
        this.teclaDerecha = tde;
        this.teclaDisparo = tdi;
        this.velocidad = v;
        this.ultimoDisparoRealizado = Instant.EPOCH;
    }

    protected Nave() {
    }

    public void dispara(){
        Instant actual = Instant.now();
        if(Duration.between(this.ultimoDisparoRealizado, actual).getSeconds() >= 1){
            this.ultimoDisparoRealizado = actual;
            this.realizarDisparo();
        }
    }

    protected abstract void realizarDisparo();

    @Override
    public void ejecutarFrame(){
        Teclado teclado = this.consola.getTeclado();
        if(teclado.teclaPulsada(this.teclaIzquierda)){
            if(this.getX() - this.velocidad >= 0){
                 this.moverX(-this.velocidad);
            }
        }
        if(teclado.teclaPulsada(this.teclaIzquierda)){
            if(this.getX() + this.getAnchura() + this.velocidad <= juego.getAnchuraPantalla()){
                this.moverX(this.velocidad);
            }
        }
        if(teclado.teclaPulsada(this.teclaDisparo)){
            this.dispara();
        }
    }
}
