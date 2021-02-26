package eugene_maksimets.exception;

import java.io.IOException;

public class WrongSumException extends IOException {
    final private String WRONG_SUM_EX = "Write correct sum\n Sum must be <=1000";

    @Override
    public String getMessage() {
        return WRONG_SUM_EX;
    }
}
