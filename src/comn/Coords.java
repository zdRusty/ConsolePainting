package comn;

/*
    created by zdRusty
*/

public class Coords{

    public final int x;
    public final int y;

    public Coords(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString(){
        return x+"; "+y;
    }
}
