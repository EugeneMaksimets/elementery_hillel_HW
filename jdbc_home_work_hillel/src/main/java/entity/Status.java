package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Status {
    private int id;
    private String alias;
    private String description;

    public Status(String alias, String description) {           //for save
        this.alias = alias;
        this.description = description;
    }
}
