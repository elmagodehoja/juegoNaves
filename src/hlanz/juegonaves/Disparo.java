package hlanz.juegonaves;

import bpc.framework.consola.Escena;
import bpc.framework.consola.Resolucion;
import bpc.framework.consola.SpriteGameObject;

public class Disparo extends SpriteGameObject {
    private int idjugador;
    private int vx;
    private int vy;

    public Disparo(int id, int x, int y, int vx, int vy){
        this.idjugador=id;
        super( ,x,y);
        this.vx=vx;
        this.vy=vy;
    }
    @Override
    public void inicializar() {
        this.escena.inicializar();
    }
    @Override
    public void ejecutarFrame() {
        this.moverX(vx);
        this.moverY(vy);
        if (vx*vy<Resolucion.PANTALLA_COMPLETA)
    }
    @Override
    public void finalizar() {
        this.escena.finalizar();
    }
}
