package hlanz.juegonaves;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CacheImagenes {
    private static CacheImagenes instancia;
    private Map<String, Image> imagenes;

    private CacheImagenes(){
        this.imagenes = new HashMap<>();
    }

    public static CacheImagenes getInstancia(){
        if (instancia == null){
            instancia = new CacheImagenes();
        }
        return instancia;
    }

    public Image getImage(String archivo){
        Image imagen = null;
        if (this.imagenes.containsKey(archivo)){
            imagen = this.imagenes.get(archivo);
        } else {
            try {
                imagen = ImageIO.read(new File(archivo));
                this.imagenes.put(archivo, imagen);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return imagen;
    }
}
