package bpc.framework.consola;
import bpc.daw.consola.Consola;

import java.util.ArrayList;
import java.util.List;

public abstract class Escena implements ElementoJuego {
    protected Juego juego;
    protected Consola consola ;
    private List<GameObject> objectos;

    public Escena(){
    }
    protected abstract void añadirObjetosIniciales();
/*la proteccion consiste en que si alguno de los dos es null, automaticamente genera el error,
 si nunco en null se creara la lista de objetos normalemnte*/
@Override
public void inicializar(){
    if (this.juego== null|| this.consola ==null){
        throw new IllegalStateException("Hay que añadir la escena al juego para poder inicializarla");
    }else {
        this.objectos = new ArrayList<>();
        this.añadirObjetosIniciales();
    }
}
    public void añadir(GameObject obj){
        obj.juego = this.juego;
        obj.consola = this.consola;
        obj.escena = this;
        obj.inicializar();
        this.objectos.add(obj);
    }
    public void retirar(GameObject obj){
        obj.finalizar();
        this.objectos.remove(obj);
        obj.consola = null;
        obj.escena = null;
    }
    @Override
    public void ejecutarFrame(){
        for (int i = 0; i <this.objectos.size() ; i++) {
            this.objectos.get(i).ejecutarFrame();
        }
    }
    @Override
    public void finalizar(){
        while (!this.objectos.isEmpty()) {
            this.retirar(this.objectos.get(0));
        }
    }
}
