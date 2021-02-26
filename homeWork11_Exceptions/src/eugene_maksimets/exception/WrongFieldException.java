package eugene_maksimets.exception;

import java.io.IOException;

public class WrongFieldException extends IOException {
    final private String WRONG_FIELD_EX = "Please write correct ID";

    @Override
    public String getMessage() {
        return WRONG_FIELD_EX;
    }
}