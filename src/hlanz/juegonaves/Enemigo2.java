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
        this.velocidad = v * 0.01;
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
        // Incrementar el ángulo
        this.angulo += this.velocidad;

        // Reiniciar si supera 2π
        if (this.angulo >= 2 * Math.PI) {
            this.angulo = 0;
        }

        // Calcular nuevas coordenadas respecto al centro
        double x = this.centroX + this.radio * Math.cos(this.angulo);
        double y = this.centroY + this.radio * Math.sin(this.angulo);

        // Mover enemigo a la nueva posición
        this.setX((int)x);
        this.setY((int)y);
    }
}
