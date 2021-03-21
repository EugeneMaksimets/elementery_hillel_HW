package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Clients {
    private String name;
    private String email;
    private String about;
    private Long phone;
    private int id;
    private int age;

    public Clients(String name, String email, String about, Long phone, int age) {          //constructor for save
        this.name = name;
        this.email = email;
        this.about = about;
        this.phone = phone;
        this.age = age;
    }
}

