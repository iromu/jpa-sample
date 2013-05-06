package jpa.persistence.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: wantez
 * Date: 06/05/13
 * Time: 20:36
 */
@Entity
@Table(name = "ANIMAL_HISTORY")
public class AnimalHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long pk;

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private java.util.Date start;

    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private java.util.Date end;
}
