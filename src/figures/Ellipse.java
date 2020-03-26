package figures;

/*
    created by zdRusty
*/

import comn.Coords;
import comn.MyCanvas;

public class Ellipse implements Figure{

    private Coords centre;
    private int rWide;
    private int rHeight;
    private char[][] canvas = MyCanvas.chars;
    private char brush = '█';

    private Ellipse(Coords centre, int rWide, int rHeight){
        this.centre = centre;
        this.rWide = rWide;
        this.rHeight = rHeight;
    }

    public Ellipse(int x, int y, int rWide, int rHeight){
        this.centre = new Coords(x,y);
        this.rWide = rWide;
        this.rHeight = rHeight;
    }

    public Ellipse(int x, int y, int rWide, int rHeight, char brush){
        this.centre = new Coords(x,y);
        this.rWide = rWide;
        this.rHeight = rHeight;
        this.brush = brush;
    }

    @Override
    public void draw() {

        for(int y = 0; y < canvas.length; y++){
            for(int x = 0; x < canvas[y].length; x++){
                canvas[y][x] = subDrawWide(rWide, rHeight)[y][x];
            }
        }
        for(int y = 0; y < canvas.length; y++){
            for(int x = 0; x < canvas[y].length; x++){
                canvas[y][x] = subDrawHeight(rWide, rHeight)[y][x];
            }
        }

    }

    private char[][] subDrawWide (int radW, int radH){
        char[][] temp = canvas;
        if (radW!=1&&radW!=2) {

            for(int y = centre.y - radH; y <= centre.y + radH; y++){
                for(int x = centre.x - radW+2; x <= centre.x + radW-2; x++) {
                    temp[y][x] = brush;
                }
            }

            return subDrawWide(radW-1,radH);
        } else {

            for (int y = centre.y - radH; y <= centre.y + radH; y++) {
                for (int x = centre.x - radW+1; x <= centre.x + radW-1; x++) {
                    temp[y][x] = brush;
                }
            }

        } return temp;
    }
    private char[][] subDrawHeight (int radW, int radH){
        char[][] temp = canvas;
        if (radH!=1&&radH!=2) {

            for(int y = centre.y - radH+2; y <= centre.y + radH-2; y++){
                for(int x = centre.x - radW; x <= centre.x + radW; x++) {
                    temp[y][x] = brush;
                }
            }

            return subDrawHeight(radW,radH-1);
        } else {

            for (int y = centre.y - radH+1; y <= centre.y + radH-1; y++) {
                for (int x = centre.x - radW; x <= centre.x + radW; x++) {
                    temp[y][x] = brush;
                }
            }

        } return temp;
    }

    @Override
    public void remove() {

    }

    @Override
    public void removeAll() {

    }

    @Override
    public void fill() {

    }

    @Override
    public String toString() {
        return String.format("координаты центра: (%d,%d) \nширина: %d; высота: %d", centre.x, centre.y, rWide*2, rHeight*2);
    }
}
