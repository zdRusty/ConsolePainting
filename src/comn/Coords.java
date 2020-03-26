package comn;

/*
    created by zdRusty
*/

public class Coords{

    public int x;
    public int y;

    public Coords(int x, int y) {
        try {
            if (x >= 0 && y >= 0) {
                this.x = x;
                this.y = y;
            } else throw new MinesCoordException();
        } catch (MinesCoordException e) {
            System.out.println("Координаты не должны быть отрицательными!");
        }
    }


    @Override
    public String toString(){
        return x+"; "+y;
    }
}
