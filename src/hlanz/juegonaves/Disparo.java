package hlanz.juegonaves;

import bpc.framework.consola.SpriteGameObject;

import java.awt.*;

public class Disparo extends SpriteGameObject {
    private int idjugador;
    private int vx;
    private int vy;

    public Disparo(int id, int x, int y, int vx, int vy){
        super(CacheImagenes.getInstancia().getImage("disparo.png"),x,y);
        this.idjugador=id;
        this.vx=vx;
        this.vy=vy;
    }
    @Override
    public void ejecutarFrame() {
        this.moverX(vx);
        this.moverY(vy);
        if (this.getX() > this.juego.getAnchuraPantalla() || this.getY() > this.juego.getAlturaPantalla() || this.getX() < 0 || this.getY() < 0) {
            this.escena.retirar(this);
        } else {
            JuegoNaves juegoNaves = (JuegoNaves) this.escena;
            Marcador marcador = juegoNaves.getMarcador();
            Rectangle rectDisparo = new Rectangle(this.getX(), this.getY(), this.getAnchura(), this.getAltura());
            boolean impactado = false;
            for (int i = 0; i < juegoNaves.getEnemigos().size() && !impactado; i++) {
                Enemigo enemigo = juegoNaves.getEnemigos().get(i);
                Rectangle rectEnemigo = new Rectangle(enemigo.getX(), enemigo.getY(), enemigo.getAnchura(), enemigo.getAltura());
                if (rectDisparo.intersects(rectEnemigo)) {
                    marcador.incrementarPuntos(this.idjugador, enemigo.getPuntuacion());
                    this.escena.retirar(enemigo);
                    this.escena.retirar(this);
                    impactado = true;
                }
            }
        }
    }
}
