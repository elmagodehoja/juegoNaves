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
        int puntos = 0;
        if (this.velocidad<0){
            puntos = -this.velocidad*2;
        }else {
            puntos = this.velocidad*2;
        }
        return puntos;
    }

    @Override
    public void ejecutarFrame() {
        moverX(this.velocidad);

        if (getX() <= 0 || (getX() + getAnchura()) >= this.juego.getAnchuraPantalla()) {
            this.velocidad = -this.velocidad;
        }
    }
}
