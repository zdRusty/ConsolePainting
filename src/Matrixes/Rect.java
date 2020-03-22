package Matrixes;

import java.util.ArrayList;
import java.util.List;

public class Rect {
    private Coord top1;
    private Coord top2;
    private Coord low1;
    private Coord low2;

    public Rect(Coord top1, Coord top2, Coord low1, Coord low2){
        this.top1 = top1;
        this.top2 = top2;
        this.low1 = low1;
        this.low2 = low2;
    }

    public Rect(int x, int y, int wide, int height){
        this.top1 = new Coord(x,y);
        this.top2 = new Coord(top1.x + wide,top1.y);
        this.low1 = new Coord(top1.x,top1.y + height);
        this.low2 = new Coord(top1.x + wide,top1.y + height);
    }

    public static Rect getRect (char[][] a){
        Coord top1;
        Coord top2;
        Coord low1;
        Coord low2;
        List<Integer> wide = new ArrayList<>();
        List<Integer> height = new ArrayList<>();

        int z=0;
        for(int x=0;x<a[0].length;x++){
            if(x!=a[0].length-1){
                if(a[z][x]=='█'&&a[z][x+1]!=' ') {
                    wide.add(x);
                    height.add(z);
                }
                if(a[z][x]=='█'&&a[z][x+1]==' ') {
                    wide.add(x);
                    height.add(z);
                    break;
                }
            }
            else if(a[z][x]==1){
                wide.add(x);
                height.add(z);
                break;
            }

            if(x==a[0].length-1&&z==a[0].length-1) break;

            if (wide.size()==0&&x==a[0].length-1){
                z++;
                x=-1;
            }
        }
        if(wide.size()==0||height.size()==0) return null;

        top1 = new Coord(wide.get(0),height.get(0));
        top2 = new Coord(wide.get(wide.size()-1),height.get(0));

        for(int y=height.get(0);y<a.length;y++){
            int x=wide.get(0);
            if(y!=a[y].length-1){
                if(a[y][x]=='█'&&a[y+1][x]!=' ') {
                    height.add(y);
                }
                if(a[y][x]=='█'&&a[y+1][x]==' ') {
                    height.add(y);
                    break;
                }
            }
            else if(a[y][x]==1){
                height.add(y);
                break;
            }
        }

        low1 = new Coord(wide.get(0),height.get(height.size()-1));
        low2 = new Coord(wide.get(wide.size()-1),height.get(height.size()-1));

        return new Rect(top1, top2, low1, low2);
    }

    public static void removeRect (char[][] a, Rect rect){
        for(int y=rect.top1.y;y<=rect.low1.y;y++){
            for(int x=rect.top1.x;x<=rect.top2.x;x++){
                a[y][x]=' ';
            }
        }
    }

    public static void drowRect(char[][] a, Rect rect){
        for(int y=rect.top1.y;y<rect.low1.y;y++){
            for(int x=rect.top1.x;x<rect.top2.x;x++){
                a[y][x]='█';
            }
        }
    }

    @Override
    public String toString() {
        int wide = top2.x-top1.x;
        int height = low1.y-top1.y;
        return String.format("координаты начала: (%d,%d) \nширина: %d; высота: %d",top1.x, top1.y, wide ,height);
    }

    public static class Coord{
        int x;
        int y;

        public Coord(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public String toString(){
            return x+"; "+y;
        }
    }
}
