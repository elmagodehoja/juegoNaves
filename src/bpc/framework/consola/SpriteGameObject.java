package bpc.framework.consola;

import bpc.daw.consola.Sprite;

import java.awt.*;

public abstract class SpriteGameObject extends GameObject{
    //Variables de instancia
    private Sprite sprite;
    private Image image;
    private Point puntoInicial;

    //Constructor
    public SpriteGameObject(Image img, int x, int y){

        this.sprite = null;
        this.image = img;
        this.puntoInicial = new Point(x,y);

    }

    //Metodos

    @Override
    public void inicializar(){
        Rectangle cuadroImagen = new Rectangle(0, 0, this.image.getWidth(null), this.image.getHeight(null));

        this.sprite = this.consola.getCapaSprites().crearSprite(
                this.image,
                cuadroImagen,
                this.puntoInicial.x,
                this.puntoInicial.y
        );
    }

    public int getX(){
        return this.sprite.getX();
    }

    public int getY(){
        return this.sprite.getY();
    }

    public int getAnchura(){
        return this.image.getWidth(null);
    }

    public int getAltura(){
        return this.image.getHeight(null);
    }

    public void moverX(int cx){
        this.sprite.moverX(cx);
    }

    public void moverY(int cy){
        this.sprite.moverY(cy);
    }

    public void setX(int x){
        this.sprite.moverX(x-this.sprite.getX());
    }

    public void setY(int y){
        this.sprite.moverY(y-this.sprite.getY());
    }

    @Override
    public void finalizar(){
        this.consola.getCapaSprites().eliminarSprite(this.sprite);
    }
}
