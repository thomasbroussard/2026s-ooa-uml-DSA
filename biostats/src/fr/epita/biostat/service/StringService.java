package fr.epita.biostat.service;

public class StringService {

    public static String format(Object val) {
        return "\"" + String.valueOf(val) + "\"";
    }

    public static String join(String delimiter, Object... elements){
        if (elements == null || elements.length == 0){
            return "";
        }
        String result = "";
        for (int i = 0; i < elements.length - 1; i++) {
            result =  elements[i] + delimiter;
        }
        return result + elements[elements.length - 1];

    }
}
