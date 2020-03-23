package Figures;

/*
    created by zdRusty
*/

import Comn.Coords;
import Comn.MyCanvas;

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
        for(int y = centre.y - rHeight; y <= centre.y + rHeight; y++){
            for(int x = centre.x - rWide; x <= centre.x + rWide; x++){
                if (rWide==1){
                    if((x!=centre.x-rWide&&y==centre.y)||(x!=centre.x+rWide&&y==centre.y))
                        canvas[y][x] = brush;
                }//else
            }
        }

        for(int y = centre.y - rHeight; y <= centre.y + rHeight; y++){
            for(int x = centre.x - rWide; x <= centre.x + rWide; x++){
                if (rHeight==1){
                    if((y!=centre.y-rHeight&&x==centre.x)||(y!=centre.y+rHeight&&x==centre.x))
                        canvas[y][x] = brush;
                }
            }
        }
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
        return String.format("координаты центра: (%d,%d) \n\nширина: %d; высота: %d",centre.x, centre.y, rWide*2, rHeight*2);
    }
}
