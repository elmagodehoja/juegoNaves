package hlanz.juegonaves;

import bpc.framework.consola.GameObject;
import java.util.Arrays;

public class Marcador extends GameObject {
    private int[] puntos;

    public Marcador(){
        this.puntos = new int[2];
    }

    public void incrementarPuntos(int jugador, int puntos){
        if (jugador < 1 || jugador > 2){
            throw new IllegalArgumentException("Numero de jugador incorrecto");
        }
        if (puntos < 1){
            throw new IllegalArgumentException("La cantidad de puntos para asignar debe ser mayor o igual a 1");
        }

        if (jugador-1 == 0){
            this.puntos[0] += puntos;
        } else {
            this.puntos[1] += puntos;
        }
    }

    @Override
    public void inicializar() {
        Arrays.fill(this.puntos,0);
    }

    @Override
    public void añadir(GameObject obj) {

    }

    @Override
    public void retirar(GameObject obj) {

    }

    @Override
    public void ejecutarFrame() {
        // todo --> Hacer lo del marcador cuando sepa como se ve en si la pantalla de juego para saber donde es mas optimo colocar el marcador
    }

    @Override
    public void finalizar() {}
}
