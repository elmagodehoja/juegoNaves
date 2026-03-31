package bpc.framework.consola.test;

import bpc.framework.consola.ElementoJuego;
import bpc.framework.consola.Escena;

public class EscenaTesteadora extends Escena implements ElementoJuego {
    private GameObjectTesteador tester;

    public EscenaTesteadora(){
        super();
        this.tester = new GameObjectTesteador();
    }
    @Override
    public void inicializar() {
        this.tester.inicializar();
    }
    @Override
    protected void añadirObjetosIniciales() {
        this.añadir(tester);
    }
    @Override
    public void ejecutarFrame() {
        this.tester.frameCounter();
    }
    @Override
    public void finalizar() {
        this.tester.finalizar();
    }
}
