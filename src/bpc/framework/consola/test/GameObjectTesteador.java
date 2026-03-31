package bpc.framework.consola.test;

import bpc.framework.consola.GameObject;

//Inicio del test "Escena"
public class GameObjectTesteador extends GameObject {
    private boolean inicializado;
    private int frameCounter;

    public GameObjectTesteador(){
        super();
        this.inicializado = false;
    }

    @Override
    public void inicializar() {
        this.inicializado = true;
    }
    public boolean inicializado(){
        return this.inicializado;
    }
    public int frameCounter(){
        return this.frameCounter;
    }
    @Override
    public void ejecutarFrame() {
        this.frameCounter+=1;
    }
    @Override
    public void finalizar() {
        this.inicializado = false;
    }
}
