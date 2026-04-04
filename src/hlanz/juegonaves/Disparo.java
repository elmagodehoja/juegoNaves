package hlanz.juegonaves;

import bpc.framework.consola.Escena;
import bpc.framework.consola.GameObject;
import bpc.framework.consola.Resolucion;
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
    }
    @Override
    public void finalizar() {

    }
}
