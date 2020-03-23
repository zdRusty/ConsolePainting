package Main;

/*
    created by zdRusty
*/

import Comn.MyCanvas;
import Figures.Ellipse;
import Figures.Figure;
import Figures.Rectangle;
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
        Figure ell = new Ellipse(29,9,1, 1);

        list.add(rect1);
        list.add(rect2);
        list.add(rect3);
        list.add(rect4);
        list.add(ell);
        list.forEach(Figure::draw);
        /*try {
            for(Figure x: list){
                x.draw();
                Thread.sleep(100);
                MyCanvas.print();
                System.out.println();
                System.out.println();
                System.out.println();
            }
        } catch (InterruptedException e){}*/
        rect2.remove();
        MyCanvas.print();
    }
}
