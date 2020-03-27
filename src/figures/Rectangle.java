package figures;

/*
    created by zdRusty
*/

import comn.Coords;
import comn.MyCanvas;
import comn.OutOfCanvasException;

public class Rectangle implements Figure{

    private Coords top1;
    private Coords top2;
    private Coords low1;
    private Coords low2;
    private char brush = '█';
    private char[][] canvas = MyCanvas.chars;
    //private String color;

    public Rectangle (int x, int y, int wide, int height){
        try {
            if(x<=MyCanvas.n&&y<=MyCanvas.m) {
                this.top1 = new Coords(x, y);
                this.top2 = new Coords(top1.x + wide, top1.y);
                this.low1 = new Coords(top1.x, top1.y + height);
                this.low2 = new Coords(top1.x + wide, top1.y + height);
                if(top2.x>MyCanvas.n) top2.x=MyCanvas.n;
                if(low1.y>MyCanvas.m) low1.y=MyCanvas.m;
            }
            else throw new OutOfCanvasException();
        } catch (OutOfCanvasException e) {
            System.out.println((char) 27 + "" +"[31m" +"Фигура находится за пределами холста!"+ (char)27 + "[0m");
        }
    }

    public Rectangle (int x, int y, int wide, int height, char brush){
        try {
            if(x<=MyCanvas.n&&y<=MyCanvas.m) {
                this.top1 = new Coords(x, y);
                this.top2 = new Coords(top1.x + wide, top1.y);
                this.low1 = new Coords(top1.x, top1.y + height);
                this.low2 = new Coords(top1.x + wide, top1.y + height);
                if(top2.x>MyCanvas.n) top2.x=MyCanvas.n;
                if(low1.y>MyCanvas.m) low1.y=MyCanvas.m;
                this.brush = brush;
            }
            else throw new OutOfCanvasException();
        } catch (OutOfCanvasException e) {
            System.out.println((char) 27 + "" +"[31m" +"Фигура находится за пределами холста!"+ (char)27 + "[0m");
        }
    }

    @Override
    public void draw (){
        if(top1!=null&&top2!=null&&low1!=null&&low2!=null) {
            for (int y = top1.y; y <= low1.y; y++) {
                for (int x = top1.x; x <= top2.x; x++) {
                    if (x == top1.x || x == top2.x)
                        canvas[y][x] = brush;
                }
            }
            for (int y = top1.y; y <= low1.y; y++) {
                for (int x = top1.x; x <= top2.x; x++) {
                    if (y == top1.y || y == low1.y)
                        canvas[y][x] = brush;
                }
            }
        }
    }

    @Override
    public void fill() {
        if(top1!=null&&top2!=null&&low1!=null&&low2!=null) {
            for (int y = top1.y; y <= low1.y; y++) {
                for (int x = top1.x; x <= top2.x; x++) {
                    canvas[y][x] = brush;
                }
            }
        }
    }

    @Override
    public void remove() {
        if(top1!=null&&top2!=null&&low1!=null&&low2!=null) {
            for (int y = top1.y; y <= low1.y; y++) {
                for (int x = top1.x; x <= top2.x; x++) {
                    if (x == top1.x || x == top2.x)
                        canvas[y][x] = ' ';
                }
            }
            for (int y = top1.y; y <= low1.y; y++) {
                for (int x = top1.x; x <= top2.x; x++) {
                    if (y == top1.y || y == low1.y)
                        canvas[y][x] = ' ';
                }
            }
        }
    }

    @Override
    public void removeAll() {
        if(top1!=null&&top2!=null&&low1!=null&&low2!=null) {
            for (int y = top1.y; y <= low1.y; y++) {
                for (int x = top1.x; x <= top2.x; x++) {
                    canvas[y][x] = ' ';
                }
            }
        }
    }

    @Override
    public String toString() {
        if(top1!=null&&top2!=null&&low1!=null&&low2!=null) {
            int wide = top2.x - top1.x;
            int height = low1.y - top1.y;
            return String.format("координаты начала: (%d,%d) \nширина: %d; высота: %d", top1.x, top1.y, wide, height);
        } return "";
    }
}
