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
            System.out.println((char) 27 + "[31m" +"Координаты не должны иметь отрицательное значение!" + (char)27 + "[0m");
        }
    }


    @Override
    public String toString(){
        return x+"; "+y;
    }
}
