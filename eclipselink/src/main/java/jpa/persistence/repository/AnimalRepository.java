package jpa.persistence.repository;

import jpa.persistence.model.Animal;
import org.springframework.data.repository.CrudRepository;

/**
 * User: wantez
 * Date: 06/05/13
 * Time: 20:13
 */
public interface AnimalRepository extends CrudRepository<Animal, Long> {

}
