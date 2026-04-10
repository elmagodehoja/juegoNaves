package hlanz.juegonaves;

public class Nave2 extends Nave{
    public Nave2(int ti, int tde, int tdi){
        super(ti,tde,tdi,3,CacheImagenes.getInstancia().getImage("nave2.png"));
    }
    @Override
    protected void realizarDisparo() {
        Disparo d1 = new Disparo(1,this.getX()+this.getAnchura()/2,this.getY(),-3,-3);
        Disparo d2 = new Disparo(1,this.getX()+this.getAnchura()/2,this.getY(),3,-3);
        this.escena.añadir(d1);
        this.escena.añadir(d2);
    }
}
