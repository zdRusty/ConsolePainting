package Matrixes;

// Lazy Singleton

import java.util.Arrays;

public class Matrix {
    private static Matrix matrix;
    private static int n;
    private static int m;
    public static char [][] chars;

    private Matrix(int n, int m){
        Matrix.n =n;
        Matrix.m =m;
    }

    public static void getMatrix (int n, int m){
        if (matrix==null) {
            matrix = new Matrix(n, m);
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
        int n = Matrix.n;
        int m = Matrix.m;
        char[][] mat = new char[m][n];
        for (char[] value : mat) {
            Arrays.fill(value, ' ');

        }
        return mat;
    }
}
