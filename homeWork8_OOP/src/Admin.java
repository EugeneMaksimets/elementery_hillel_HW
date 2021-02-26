public class Admin extends ForAllUser {
    private String name;
    private String mail;
    private String password;
    private String role;
    private int age;

    public Admin(String name, String mail, String password, int age) {
        super(name, mail, password, age);
    }

    @Override
    public String getCharacter() {
        return role;
    }

    @Override
    public void setCharacter() {
        this.role = "ADMIN";
    }


}
