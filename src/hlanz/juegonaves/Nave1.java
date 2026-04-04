package hlanz.juegonaves;

public class Nave1 extends Nave{
    public Nave1(int ti, int tde, int tdi){
        super(ti,tde,tdi,5,CacheImagenes.getInstancia().getImage("nave1.png"));
    }
    @Override
    protected void realizarDisparo() {
        Disparo d = new Disparo(0,this.getX(),this.getY(),0,-10);
        this.escena.añadir(d);
    }
}
