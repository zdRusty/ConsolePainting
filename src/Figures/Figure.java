package Figures;

import Main.Coords;

public interface Figure {
    /*Coords top1 = null;
    Coords top2 = null;
    Coords low1 = null;
    Coords low2 = null;*/

    void draw(char[][] a);
    Figure getOne(char[][] a);
    void remove(char[][] a);

}
