package Matrixes;

import java.util.ArrayList;
import java.util.List;

/*
    created by zdRusty
*/

public class Painting {
    public static void main(String[] args) {
        List<Rect> list = new ArrayList<>();

        Matrix.getMatrix(60,20);
        char[][] c1 = Matrix.chars;
        Rect rect1 = new Rect(5,5,10,5);
        Rect rect2 = new Rect(8,8,10,5);
        Rect rect3 = new Rect(3,3,8,4);
        /*Rect.drowRect(c1, rect1);
        Rect.drowRect(c1, rect2);
        Rect.drowRect(c1, rect3);*/
        list.add(rect1);list.add(rect2);list.add(rect3);
        list.forEach(x-> Rect.drowRect(c1,x));
        Matrix.print();

    }

    public static int getRectangleCount(char[][] a) {
        List<Rect> list = new ArrayList<>();
        while (true){
            Rect rect = Rect.getRect(a);
            if(rect==null) break;
            list.add(rect);
            Rect.removeRect(a,rect);
        }
        return list.size();
    }
}
