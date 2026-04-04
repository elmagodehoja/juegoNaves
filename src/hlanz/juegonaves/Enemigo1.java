package hlanz.juegonaves;

public class Enemigo1 extends Enemigo{
    //Variables de instancia
    private int velocidad;

    //Constructor
    public Enemigo1(int x,int y,int v){
        super(x,y,CacheImagenes.getInstancia().getImage("malo1.png"));
        this.velocidad = v;
    }


    @Override
    public int getPuntuacion() {
        return 0;
    }

    @Override
    public void inicializar() {
        super.inicializar();
    }

    @Override
    public void ejecutarFrame() {
        moverX(this.velocidad);

        if (getX() <= 0 || (getX() + getAnchura()) >= this.juego.getAnchuraPantalla()) {
            this.velocidad = -this.velocidad;
        }
    }

    @Override
    public void finalizar() {
        super.finalizar();
    }
}
