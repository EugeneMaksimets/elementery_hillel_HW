package eugene_maksimets;

import java.util.regex.Pattern;

public class InfoFieldsValidation {
    private static final String CORRECT_STRING = " is correct";
    private static final String INCORRECT_STRING = " is incorrect";
    private static String result;

    public static String mailValidation(String mail) {

        Pattern mailPattern = Pattern.compile("^(.+)@?([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");
        if (mailPattern.matcher(mail).matches()) {
            result = mail + CORRECT_STRING;
        } else {
            result = mail + INCORRECT_STRING;
        }
        return result;
    }

    public static String phoneValidator(String phone) {
        Pattern phonePattern = Pattern.compile("^\\+?3?8?(0\\d{9})$");
        if (phonePattern.matcher(phone).matches()) {
            result = phone + CORRECT_STRING;
        } else {
            result = phone + INCORRECT_STRING;
        }
        return result;
    }

    public static String birthDayValidation(String birthDay) {
        Pattern birthDayPattern = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d");
        if (birthDayPattern.matcher(birthDay).matches()) {
            result = birthDay + CORRECT_STRING;
        } else {
            result = birthDay + INCORRECT_STRING;
        }
        return result;
    }
}
