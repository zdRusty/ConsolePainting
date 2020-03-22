package Figures;

/*
    created by zdRusty
*/

import Comn.Colr;
import Comn.Coords;
import Comn.MyCanvas;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Figure{

    private Coords top1;
    private Coords top2;
    private Coords low1;
    private Coords low2;
    private char c = '█';
    private char[][] canvas = MyCanvas.chars;
    private String color;

    public Rectangle(Coords top1, Coords top2, Coords low1, Coords low2){
        this.top1 = top1;
        this.top2 = top2;
        this.low1 = low1;
        this.low2 = low2;
    }

    public Rectangle (int x, int y, int wide, int height){
        this.top1 = new Coords(x,y);
        this.top2 = new Coords(top1.x + wide,top1.y);
        this.low1 = new Coords(top1.x,top1.y + height);
        this.low2 = new Coords(top1.x + wide,top1.y + height);
    }

    public Rectangle (int x, int y, int wide, int height, char c){
        this.top1 = new Coords(x,y);
        this.top2 = new Coords(top1.x + wide,top1.y);
        this.low1 = new Coords(top1.x,top1.y + height);
        this.low2 = new Coords(top1.x + wide,top1.y + height);
        this.c = c;
    }

    @Override
    public void draw (){
        for(int y = this.top1.y; y<this.low1.y; y++){
            for(int x=this.top1.x;x<this.top2.x;x++){
                if (x==this.top1.x||x==this.top2.x-1)
                    canvas[y][x]=c;
            }
        }
        for(int y = this.top1.y; y<this.low1.y; y++){
            for(int x=this.top1.x;x<this.top2.x;x++){
                if (y==this.top1.y||y==this.low1.y-1)
                canvas[y][x]=c;
            }
        }
    }

    @Override
    public void fill() {
        for(int y = this.top1.y; y<this.low1.y; y++){
            for(int x=this.top1.x;x<this.top2.x;x++){
                canvas[y][x]=c;
            }
        }
    }

    @Override
    public void remove() {
        for(int y = this.top1.y; y<this.low1.y; y++){
            for(int x=this.top1.x;x<this.top2.x;x++){
                if (x==this.top1.x||x==this.top2.x-1)
                    canvas[y][x]=' ';
            }
        }
        for(int y = this.top1.y; y<this.low1.y; y++){
            for(int x=this.top1.x;x<this.top2.x;x++){
                if (y==this.top1.y||y==this.low1.y-1)
                    canvas[y][x]=' ';
            }
        }

    }

    @Override
    public void removeAll() {
        for(int y=this.top1.y;y<this.low1.y;y++){
            for(int x=this.top1.x;x<this.top2.x;x++){
                canvas[y][x]=' ';
            }
        }
    }

    @Override
    public String toString() {
        int wide = top2.x-top1.x;
        int height = low1.y-top1.y;
        return String.format("координаты начала: (%d,%d) \nширина: %d; высота: %d",top1.x, top1.y, wide ,height);
    }
}
