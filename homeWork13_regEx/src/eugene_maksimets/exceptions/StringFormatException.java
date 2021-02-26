package eugene_maksimets.exceptions;

import java.io.IOException;

public class StringFormatException extends IOException {
    @Override
    public String getMessage() {
        return "String is empty";
    }
}
