import java.io.IOException;

public class UserService implements SomeService {

    @Override
    public boolean verifyUser(ForAllUser user) throws IOException {
        return SomeService.super.verifyUser(user);
    }

    @Override
    public void saveInfo(ForAllUser user) throws IOException {
        final String ERROR = "Error. Haven't Access";
        System.out.println(ERROR);
    }
}
