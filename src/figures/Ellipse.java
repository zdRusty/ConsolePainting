package figures;

/*
    created by zdRusty
*/

import comn.Coords;
import comn.MyCanvas;

import java.util.Arrays;

public class Ellipse implements Figure{

    private Coords centre;
    private int rWide;
    private int rHeight;
    private char[][] canvas = MyCanvas.chars;
    private char brush = '█';

    char[][] temp = canvas;

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

        for(int y = 0; y <= rHeight; y++){
            for(int x = 0; x <= rWide; x++){
                canvas[y][x] = subDrawWide(rWide, rHeight)[y][x];
            }
        }

        /*for(int y = 0; y < canvas.length; y++){
            for(int x = 0; x < canvas[y].length; x++){
                canvas[y][x] = subDrawHeight(rWide, rHeight)[y][x];
            }
        }*/

    }

    private char[][] subDrawWide (int radW, int radH){
       char[][] temp = new char[2*radW][2*radH];
       for(int y=centre.y;y<2*radH;y++){
           for(int x=centre.x;x<2*radW;x++){
               temp[y][x]=brush;
           }
       }
       return temp;
    }
    /*private char[][] subDrawHeight (int radW, int radH){
        char[][] tempHeight = canvas;
        char[][] subHeightCanvas = canvas;

        if (radH>1) {

            for(int y = centre.y - radH+2; y <= centre.y + radH-2; y++){
                for(int x = centre.x - radW; x <= centre.x + radW; x++) {
                    tempHeight[y][x] = brush;
                }
            }

            for(int y = 0; y < canvas.length; y++){
                for(int x = 0; x < canvas[y].length; x++){
                    subHeightCanvas[y][x] = tempHeight[y][x];
                }
            }

            return subDrawHeight(radW,radH-1);
        } else {

            for (int y = centre.y - radH+1; y <= centre.y + radH-1; y++) {
                for (int x = centre.x - radW; x <= centre.x + radW; x++) {
                    tempHeight[y][x] = brush;
                }
            }

            for(int y = 0; y < canvas.length; y++){
                for(int x = 0; x < canvas[y].length; x++){
                    subHeightCanvas[y][x] = tempHeight[y][x];
                }
            }

        } return subHeightCanvas;
    }*/

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
