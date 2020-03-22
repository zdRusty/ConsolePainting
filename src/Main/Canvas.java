package Main;

// Lazy Singleton

import java.util.Arrays;

public class Canvas {
    private static Canvas canvas;
    private static int n;
    private static int m;
    public static char [][] chars;

    private Canvas(int n, int m){
        Canvas.n =n;
        Canvas.m =m;
    }

    public static void getMatrix (int n, int m){
        if (canvas ==null) {
            canvas = new Canvas(n, m);
            chars=gen();
        }
    }

    public static void print() {
        char[][] mat = chars;
        for (char[] value : mat) {
            for (char c : value) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static char[][] gen (){
        int n = Canvas.n;
        int m = Canvas.m;
        char[][] mat = new char[m][n];
        for (char[] value : mat) {
            Arrays.fill(value, ' ');

        }
        return mat;
    }
}
