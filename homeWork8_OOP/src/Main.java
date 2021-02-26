
public class Main {

    public static void main(String[] args) throws Exception {
        User user = new User("Alex", "iDontUseThis@mail.com", "sssss", 24);
        Admin admin = new Admin("Eugene", "anotherDontUse@mail.com", "veryHardPassword", 25);
        System.out.println("1: ");
        new UserService().saveInfo(admin);
        System.out.println("2: ");
        new AdminService().verifyUser(admin);
        System.out.println("3: ");
        new AdminService().saveInfo(admin);
        System.out.println("4: ");
        new UserService().verifyUser(admin);

        System.out.println("5: ");
        new UserService().saveInfo(user);
        System.out.println("6: ");
        new AdminService().verifyUser(user);
        System.out.println("7: ");
        new AdminService().saveInfo(user);
        System.out.println("8: ");
        new UserService().verifyUser(user);
    }
}
