package jpa.persistence.model;

import jpa.persistence.customizer.AnimalCustomizer;
import lombok.Getter;
import lombok.Setter;
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
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {

    }
}
