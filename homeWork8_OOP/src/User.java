
public class User extends ForAllUser {
    private String name;
    private String mail;
    private String password;
    private String role;
    private int age;

    public User(String name, String mail, String password, int age) {
        super(name, mail, password, age);
    }

    @Override
    public String getCharacter() {
        return role;
    }

    @Override
    public void setCharacter() {
        this.role = "USER";
    }

}
