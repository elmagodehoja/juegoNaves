package hlanz.juegonaves;

import bpc.framework.consola.SpriteGameObject;

import java.awt.*;

public abstract class Enemigo extends SpriteGameObject {
    //Constructor
    public Enemigo(int x,int y, Image img){
        super(img,x,y);
    }

    //Metodos
    public abstract int getPuntuacion();
}
