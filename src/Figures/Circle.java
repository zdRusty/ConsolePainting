package Figures;

/*
    created by zdRusty
*/

import Comn.Coords;
import Comn.MyCanvas;

public class Circle implements Figure{

    private Coords centre;
    private int radius;
    private char[][] canvas = MyCanvas.chars;

    public Circle(Coords centre, int radius){
        this.centre = centre;
        this.radius = radius;
    }

    public Circle(int x, int y, int radius){
        this.centre = new Coords(x,y);
        this.radius = radius;
    }

    @Override
    public void draw() {
        for(int y = this.centre.y-radius; y<this.centre.y+radius; y++){
            for(int x=this.centre.x-radius;x<this.centre.x+radius;x++){
                if(Math.abs(x)<=radius||Math.abs(y)<=radius) canvas[y][x]='█';
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
        return String.format("координаты центра: (%d,%d) \nрадиус: %d",centre.x, centre.y, radius);
    }
}
