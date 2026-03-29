package bpc.framework.consola.test;

import java.awt.*;

public class ResolucionTest {
    public static void main(String[] args) {
        Dimension[] dimension = {new Dimension(4096, 2160), new Dimension(1920, 1080), new Dimension(2560, 1440), new Dimension(2560, 600)};
        for (int i = 0; i < dimension.length; i++) {
            System.out.println(dimension[i].toString());
        }
    }
}
