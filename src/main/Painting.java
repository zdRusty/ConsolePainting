package main;

/*
    created by zdRusty
*/

import comn.MyCanvas;
import figures.Ellipse;
import figures.Figure;
import figures.Rectangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Painting {
    public static void main(String[] args){
        List<Figure> list = new ArrayList<>();
        MyCanvas.setCanvas(60,20);

        Figure rect1 = new Rectangle(0,0,60,20,'░');
        Figure rect2 = new Rectangle(2,1,56,18);
        Figure rect3 = new Rectangle(4,2,52,16,'*');
        Figure rect4 = new Rectangle(20,0,20,20);
        Figure ell = new Ellipse(30,9,7, 3, '*');

        list.add(rect1);
        list.add(rect2);
        list.add(rect3);
        list.add(rect4);
        list.add(ell);
        list.forEach(Figure::draw);
        /*try {
            for(Figure x: list){
                x.draw();
                Thread.sleep(300);
                MyCanvas.print();
                clrscr();
            }
        } catch (InterruptedException e){}*/
        rect2.remove();
        MyCanvas.print();
    }

    public static void clrscr(){
        try
        {
            Process proc = Runtime.getRuntime().exec("cmd cls");
            //proc.waitFor();
            proc.destroy();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
