package hlanz.juegonaves;

public class Enemigo2 extends Enemigo{
    //Variables de instancia
    private int centroX;
    private int centroY;
    private int radio;
    private double angulo;
    private double velocidad;

    //Constructores
    public Enemigo2(int x, int y, int cx, int cy, int r, int v){
        super(x,y,CacheImagenes.getInstancia().getImage("malo2.png"));
        this.radio = r;
        this.velocidad = v;
        this.angulo = 0;
        this.centroX = cx;
        this.centroY = cy;
    }


    @Override
    public int getPuntuacion() {
        return (int)this.velocidad*3;
    }

    @Override
    public void ejecutarFrame() {
        this.angulo += this.velocidad;

        if (this.angulo >= 2 * Math.PI) {
            this.angulo = 0;
        }
        int nuevaX = centroX + (int) (radio * Math.cos(angulo));
        int nuevaY = centroY + (int) (radio * Math.sin(angulo));

        setX(nuevaX);
        setY(nuevaY);
    }
}
