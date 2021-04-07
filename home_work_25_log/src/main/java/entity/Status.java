package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statuses")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //use IDENTITY (with SEQUENCE don't work)
    private int id;
    @Column(name = "alias", unique = true, nullable = false, length = 15)
    private String alias;

    @Column(name = "description", nullable = false)
    private String description;

    public Status(String alias, String description) {
        this.alias = alias;
        this.description = description;
    }

    public Status() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", alias='" + alias + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
