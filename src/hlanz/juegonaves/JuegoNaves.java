package hlanz.juegonaves;

import bpc.framework.consola.Escena;

import java.util.List;

public class JuegoNaves extends Escena {
    private List<Enemigo> enemigos;

    public List<Enemigo> getEnemigos(){
        return this.enemigos;
    }

    public static void main(String[] args) {

    }


    @Override
    protected void añadirObjetosIniciales() {

    }
}
