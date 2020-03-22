package Main;

import Figures.Figure;
import Figures.Rectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
    created by zdRusty
*/

public class Painting {
    public static void main(String[] args){
        List<Figure> list = new ArrayList<>();
        Canvas.getMatrix(60,20);

        char[][] can = Canvas.chars;
        Figure rect1 = new Rectangle(5,5,6,3);
        Figure rect2 = new Rectangle(6,6,8,4);
        Figure rect3 = new Rectangle(8,8,12,6);
        list.add(rect1);list.add(rect2);list.add(rect3);

        try {
            for(Figure x: list){
                x.draw(can);
                Canvas.print();
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        rect2.remove(can);
        Canvas.print();
    }
}
