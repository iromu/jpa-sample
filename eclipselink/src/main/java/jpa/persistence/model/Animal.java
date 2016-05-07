package jpa.persistence.model;

import jpa.persistence.customizer.AnimalCustomizer;
import org.eclipse.persistence.annotations.Customizer;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

/**
 * User: wantez
 * Date: 06/05/13
 * Time: 19:41
 */
@Entity
@Table(name = "ANIMAL")
@Customizer(AnimalCustomizer.class)
public class Animal extends AbstractPersistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
