package eugene_maksimets.util;


import eugene_maksimets.exception.UserExpectedError;
import eugene_maksimets.exception.WrongFieldException;
import eugene_maksimets.exception.WrongSumException;

public class Helper {

    public static void checkId(String id) throws WrongFieldException {
        if (id.length() != 10) {
            throw new WrongFieldException();
        }
    }

    public static void checkAddMoney(double amount) throws WrongSumException {
        if (amount > 1000) {
            throw new WrongSumException();
        }
    }

    public static void checkTransaction(String enteredId, String idSending) {
        if (!enteredId.equals(idSending)) {
            throw new UserExpectedError();
        }
    }
}
