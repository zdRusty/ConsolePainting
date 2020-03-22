package Comn;

/*
    Lazy Singleton
    created by zdRusty
*/

import java.util.Arrays;

public class MyCanvas {
    private static MyCanvas myCanvas;
    private static int n;
    private static int m;
    public static char [][] chars;

    private MyCanvas(int n, int m){
        MyCanvas.n =n;
        MyCanvas.m =m;
    }

    public static void getCanvas(int n, int m){
        if (myCanvas ==null) {
            myCanvas = new MyCanvas(n, m);
            chars=gen();
        }
    }

    public static void print() {
        char[][] can = chars;
        for (char[] value : can) {
            for (char c : value) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void clear(){
        for (char[] value : chars) {
            Arrays.fill(value, ' ');
        }
    }

    private static char[][] gen (){
        int n = MyCanvas.n;
        int m = MyCanvas.m;
        char[][] can = new char[m][n];
        for (char[] value : can) {
            Arrays.fill(value, ' ');
        }
        return can;
    }
}
