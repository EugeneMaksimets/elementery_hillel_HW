import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class AdminService implements SomeService {

    @Override
    public boolean verifyUser(ForAllUser user) throws IOException {
        return SomeService.super.verifyUser(user);

    }


    @Override
    public void saveInfo(ForAllUser user) throws IOException {
        final String NEW_ERROR = "Cannot save account. You must use another e-mail";
        if (!verifyUser(user)) {
            System.out.println(NEW_ERROR);
        } else {

            final String HAPPY = "Account is creating! Success!!!";
            Writer output = new BufferedWriter(new FileWriter("src/test.txt", true));
            output.write("\n" + ForAllUser.getInfo(user) + "\n");
            output.close();
            System.out.println(HAPPY);
        }
    }
}


