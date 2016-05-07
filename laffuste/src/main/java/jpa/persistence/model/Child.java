package jpa.persistence.model;

import javax.persistence.*;

/**
 * @author irodriguezm
 */
@Entity
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String random;

    @OneToOne(cascade=CascadeType.PERSIST)
    private Parent parent;

    public Child(String name, String random) {
        this.name = name;
        this.random = random;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
