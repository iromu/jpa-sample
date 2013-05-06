import jpa.persistence.model.Animal;
import jpa.persistence.repository.AnimalRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * User: wantez
 * Date: 06/05/13
 * Time: 20:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
@Transactional
public class AnimalTest {

    @Autowired
    AnimalRepository repository;

    @Test
    public void testInsert() {
        Animal animal = new Animal();
        animal.setName("Tiger");
        animal = repository.save(animal);

        assertEquals(animal, repository.findOne(animal.getId()));

        repository.delete(animal);
    }


    @Test
    public void testMultiple() {

        repository.save(new Animal("Tiger"));
        repository.save(new Animal("Leopard"));
        repository.save(new Animal("Snow Leopard"));
        repository.save(new Animal("Lion"));
        repository.save(new Animal("Mountain Lion"));

        assertEquals(5, repository.count());
        repository.deleteAll();
    }


    @Test
    public void testHistory() {
        Animal animal = new Animal();
        animal.setName("Tiger");
        animal = repository.save(animal);

        assertEquals(animal, repository.findOne(animal.getId()));
        assertEquals(1, repository.count());

        animal.setName("Leopard");

        animal = repository.save(animal);

        assertEquals(animal, repository.findOne(animal.getId()));
        assertEquals(1, repository.count());

    }
}
