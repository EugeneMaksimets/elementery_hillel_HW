package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "statuses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String alias;
    @Column(nullable = false)
    private String descriptions;
    @ManyToMany(mappedBy = "statuses")
    private Set<Client> clients;
    @OneToMany(mappedBy = "status", fetch = FetchType.EAGER)
    private Set<Card> card;

    public Status(String alias, String descriptions) {
        this.alias = alias;
        this.descriptions = descriptions;
    }
}
