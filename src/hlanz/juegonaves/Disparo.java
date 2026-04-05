package hlanz.juegonaves;

import bpc.framework.consola.SpriteGameObject;

import java.awt.*;

public class Disparo extends SpriteGameObject {
    private int idjugador;
    private int vx;
    private int vy;

    public Disparo(int id, int x, int y, int vx, int vy){
        super( CacheImagenes.getInstancia().getImage("disparo.png"),x,y);
        this.idjugador=id;
        this.vx=vx;
        this.vy=vy;
    }
    @Override
    public void inicializar() {

    }
    @Override
    public void ejecutarFrame() {
        this.moverX(vx);
        this.moverY(vy);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        if (vx> dimension.width || vy>dimension.height || vx<0 || vy<0){
            this.escena.finalizar();
        }
        JuegoNaves juegoNaves = new JuegoNaves();
        Marcador marcador = new Marcador();
        for (int i = 0; i <juegoNaves.getEnemigos().size() ; i++) {
            if (juegoNaves.getEnemigos().get(i).getX() == this.vx && juegoNaves.getEnemigos().get(i).getY()==this.vy){
                this.finalizar();
                juegoNaves.getEnemigos().remove(i);
                marcador.incrementarPuntos(this.idjugador, juegoNaves.getEnemigos().get(i).getPuntuacion());
            }
        }
    }
    @Override
    public void finalizar() {

    }
}
