package hlanz.juegonaves;

import bpc.daw.consola.CapaCanvas;
import bpc.daw.consola.Consola;
import bpc.framework.consola.GameObject;

import java.awt.*;

public class Fondo extends GameObject {
    private Image imagen;
    private Rectangle camara;
    private int velocidadCamara;

    public Fondo(int vc){
        super();
        this.imagen= CacheImagenes.getInstancia().getImage("fondo.png");
        this.velocidadCamara= vc;
    }

    @Override
    public void inicializar() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.camara= new Rectangle(0,0,dimension.width,dimension.height);
    }

    @Override
    public void ejecutarFrame() {
        Consola consola = new Consola();
        CapaCanvas capaCanvas = consola.getCapaCanvas();
        Graphics graphics = capaCanvas.getGraphics();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.imagen.getGraphics().drawRect(0,0, dimension.width,dimension.height);
        this.camara.height+=this.velocidadCamara;
        if (this.camara.y + this.camara.height >= this.imagen.getHeight(null)) {
            this.camara.y = 0;
        }
    }

    @Override
    public void finalizar() {
    }
}
