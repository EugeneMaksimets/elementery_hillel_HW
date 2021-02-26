
public abstract class ForAllUser {

    private int age;
    private String name;
    private String password;
    private String mail;

    public ForAllUser(String name, String mail, String password, int age) {
        setName(name);
        setMail(mail);
        setPassword(password);
        setAge(age);
        setCharacter();
    }

    public abstract void setCharacter();

    public abstract String getCharacter();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPassword() {
        return password;
    }


    public void setMail(String mail) {
        this.mail = mail;
    }


    public String getMail() {
        return mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public static String getInfo(ForAllUser user) {
        String result = user.getCharacter() + "\n" + user.getName() + "\n" + user.getAge() + "\n" + user.getMail() + "\n" + user.getPassword();
        return result;
    }


}
