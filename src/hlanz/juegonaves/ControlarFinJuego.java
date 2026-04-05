package hlanz.juegonaves;

import bpc.framework.consola.Escena;
import bpc.framework.consola.GameObject;

public class ControlarFinJuego extends GameObject {
    public ControlarFinJuego(){}

    @Override
    public void inicializar() {}

    @Override
    public void ejecutarFrame() {
        JuegoNaves juegoNaves = new JuegoNaves();
        if (juegoNaves.getEnemigos().isEmpty()){
            this.juego.detener();
        }
    }

    @Override
    public void finalizar() {}
}
