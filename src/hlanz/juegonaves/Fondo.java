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
        CapaCanvas capaCanvas = super.consola.getCapaCanvas();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        capaCanvas.getGraphics().drawImage(this.imagen, 0, 0, dimension.width, dimension.height, this.camara.x, this.camara.y, this.camara.x + this.camara.width, this.camara.y + this.camara.height, null);
        this.camara.y+=this.velocidadCamara;
        if (this.camara.y + this.camara.height >= this.imagen.getHeight(null)) {
            this.camara.y = 0;
        }
    }

    @Override
    public void finalizar() {
    }
}
