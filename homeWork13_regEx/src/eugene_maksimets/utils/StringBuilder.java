package eugene_maksimets.utils;

import eugene_maksimets.exceptions.StringFormatException;

import java.util.Arrays;

public class StringBuilder {
    public static String buildString(String str, char[] chr) {
        String arrayToString;
        String result;
        if (chr == null) {
            System.out.println("Array = null");
            throw new NullPointerException();
        } else {
            arrayToString = Arrays.toString(chr);
            if (arrayToString.trim().isEmpty() && arrayToString.trim().isBlank()
                    || str.trim().isEmpty() && str.trim().isBlank()) {
                try {
                    throw new StringFormatException();
                } catch (StringFormatException e) {
                    e.printStackTrace();
                }
            } else {
                str = str.toUpperCase().trim();
                arrayToString = arrayToString.toLowerCase().trim();
            }
        }
        String firstResult = str.concat(" ").concat(arrayToString);
        if (firstResult.length() % 2 != 0) {
            result = firstResult.substring(firstResult.length() / 2, firstResult.length() / 2 + 1);
        } else {
            result = firstResult.substring((firstResult.length() / 2) - 1, firstResult.length() / 2 + 1);
        }
        return result;
    }
}
