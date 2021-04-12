package util;

import java.util.Optional;
import java.util.regex.Pattern;

public class MailValidation {
    public static Optional<String> validation(String mail) {
        Pattern mailPattern = Pattern.compile("^(.+)@?([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");
        if (mail == null || !mailPattern.matcher(mail).matches() || mail.isEmpty()) {
            System.err.println(mail + ": incorrect e-mail");
            return Optional.empty();
        } else {
            System.out.println(mail + ": e-mail is correct");
            return Optional.of(mail);
        }
    }
}
