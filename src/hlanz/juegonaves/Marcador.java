package hlanz.juegonaves;

import bpc.framework.consola.GameObject;

import java.awt.*;
import java.util.Arrays;

public class Marcador extends GameObject {
    private int[] puntos;

    public Marcador(){
        this.puntos = new int[2];
    }

    public void incrementarPuntos(int jugador, int puntos){
        if (jugador < 0 || jugador > 1){
            throw new IllegalArgumentException("Numero de jugador incorrecto");
        }
        if (puntos < 0){
            throw new IllegalArgumentException("La cantidad de puntos para asignar debe ser mayor o igual a 1");
        }

        this.puntos[jugador] += puntos;
    }

    @Override
    public void inicializar() {
        Arrays.fill(this.puntos,0);
    }

    @Override
    public void ejecutarFrame() {
        Graphics dibujar = this.consola.getCapaCanvas().getGraphics();

        dibujar.setColor(Color.BLACK);
        dibujar.fillRect(0, 0, this.juego.getAnchuraPantalla(), 40);

        dibujar.setFont(new Font("Arial", Font.BOLD, 20));
        dibujar.setColor(Color.WHITE);
        dibujar.drawString("Jugador 1: " + this.puntos[0], 20, 30);
        dibujar.drawString("Jugador 2: " + this.puntos[1], this.juego.getAnchuraPantalla() - 200, 30);
    }

    @Override
    public void finalizar() {}
}
