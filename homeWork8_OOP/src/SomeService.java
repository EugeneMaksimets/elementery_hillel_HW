import java.io.*;
import java.util.Scanner;

public interface SomeService {
    default boolean verifyUser(ForAllUser user) throws IOException {
        final String ERROR_NEED_NEW_MAIL = "You cannot use this e-mail. Please use another";
        final String VERIFY_USER = "Account with this e-mail creating";
        final String GOOD_MAIL = "You can use this mail";
        final String FOR_ADMIN_GOOD_MAIL = "Haven't this mail in app";
        FileReader fileReader = new FileReader("src/test.txt");
        Scanner scan = new Scanner(fileReader);
        boolean result = true;
        while (scan.hasNextLine()) {
            if (scan.nextLine().equals(user.getMail())) {
                result = false;
                break;
            }
        }
        fileReader.close();
        if (!result && user.getCharacter().equals("USER")) {
            System.out.println(result + "\n" + ERROR_NEED_NEW_MAIL);

        } else if (!result && user.getCharacter().equals("ADMIN")) {
            System.out.println(result + "\n" + VERIFY_USER);

        } else if (result && user.getCharacter().equals("USER")) {
            System.out.println(result + "\n" + GOOD_MAIL);
        } else {
            System.out.println(result + "\n" + FOR_ADMIN_GOOD_MAIL);
        }
        return result;
    }

    default void saveInfo(ForAllUser user) throws IOException {

    }
}