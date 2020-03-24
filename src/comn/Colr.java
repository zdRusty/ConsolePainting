package comn;

/*
    created by zdRusty
*/

import java.util.HashMap;
import java.util.Map;

public class Colr {

    public static String setColr (char c, String color){

        char simb;
        Map<String,String> map = new HashMap<>();
        map.put("black", "[30m");
        map.put("red", "[31m");
        map.put("green", "[32m");
        map.put("yellow", "[33m");
        map.put("blue", "[34m");
        map.put("purple", "[35m");
        map.put("lightBlue", "[36m");
        map.put("white", "[37m");

        for(Map.Entry<String,String> x: map.entrySet()){
            if(color.equals(x.getKey()))
                return (char) 27 + "" +x.getValue() + "" + c + "" + (char)27 + "[0m";
        }

        return String.valueOf(c);
    }
}
