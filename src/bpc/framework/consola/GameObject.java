package bpc.framework.consola;

import bpc.daw.consola.Consola;
import bpc.framework.consola.Juego;
import bpc.framework.consola.Escena;

public abstract class GameObject implements ElementoJuego{
    protected Juego juego;
    protected Consola consola;
    protected Escena escena;
}
