package Comn;

/*
    created by zdRusty
*/

public class Coords{

    public int x;
    public int y;

    public Coords(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString(){
        return x+"; "+y;
    }
}
