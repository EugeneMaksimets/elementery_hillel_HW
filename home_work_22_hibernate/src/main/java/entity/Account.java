package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //use IDENTITY (with SEQUENCE don't work)
    private int id;

    @Column(name = "client_id", nullable = false)
    private int client_id;

    @Column(name = "number", unique = true, nullable = false, length = 20)
    private String number;
    @Column(name = "value", nullable = false)
    private double value;

    public Account() {

    }

    public Account(int client_id, String number, double value) {
        this.client_id = client_id;
        this.number = number;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", client_id=" + client_id +
                ", number='" + number + '\'' +
                ", value=" + value +
                '}';
    }
}
