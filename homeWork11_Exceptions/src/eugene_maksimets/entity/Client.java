package eugene_maksimets.entity;

public class Client {
    public String userId;
    public String surname;
    public String id;
    public double amount;

    public Client(String user, String surname, String id, Double amount) {
        this.userId = user;
        this.surname = surname;
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public double getAmount() {
        return amount;
    }
}

