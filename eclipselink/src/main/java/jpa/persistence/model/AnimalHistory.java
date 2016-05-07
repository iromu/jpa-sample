package jpa.persistence.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    private Long pk;

    private String id;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date start;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date end;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
