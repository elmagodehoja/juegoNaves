package bpc.framework.consola;

public interface ElementoJuego {
    public abstract void inicializar();
    void añadir(GameObject obj);
    void retirar(GameObject obj);
    public abstract void ejecutarFrame();
    public abstract void finalizar();
}
