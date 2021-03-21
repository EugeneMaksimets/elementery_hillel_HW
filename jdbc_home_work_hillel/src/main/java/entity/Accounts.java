package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Accounts {
    private int id;
    private int client_id;
    private String number;
    private double value;

    public Accounts(int client_id, String number, double value) {           //for save
        this.client_id = client_id;
        this.number = number;
        this.value = value;
    }
}
