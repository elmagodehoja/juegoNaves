package bpc.framework.consola;
import bpc.daw.consola.Consola;

import java.util.ArrayList;
import java.util.List;

public abstract class Escena implements ElementoJuego {
    protected Juego juego;
    protected Consola consola ;
    private List<GameObject> objectos;

    public Escena(){
        if (this.juego== null|| this.consola ==null){
            throw new IllegalStateException("Hay que añadir la escena al juego para poder inicializarla");
        }else {
            this.objectos = new ArrayList<>();
        }
    }
    protected abstract void añadirObjetosIniciales();
    @Override
    public void añadir(GameObject obj){
        this.objectos.add(obj);
        this.juego = obj.juego;
        this.consola = obj.consola;
        obj.inicializar();
    }
    @Override
    public void retirar(GameObject obj){
        obj.finalizar();
        this.objectos.remove(obj);
        obj.consola = null;
        obj.escena = null;
    }
    @Override
    public void ejecutarFrame(){

    }
}
