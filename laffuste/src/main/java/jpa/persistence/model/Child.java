package jpa.persistence.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author irodriguezm
 */
@Entity
@NoArgsConstructor
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private String random;

    @OneToOne(cascade=CascadeType.PERSIST)
    @Setter
    private Parent parent;

    public Child(String name, String random) {
        this.name = name;
        this.random = random;
    }
}
