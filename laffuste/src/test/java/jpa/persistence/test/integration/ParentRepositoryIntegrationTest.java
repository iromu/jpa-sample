package jpa.persistence.test.integration;

import jpa.persistence.model.Child;
import jpa.persistence.model.Parent;
import jpa.persistence.repository.ParentRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.AbstractBaseTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;


public class ParentRepositoryIntegrationTest extends AbstractBaseTest {

    @Autowired
    ParentRepository parentRepository;

    @Test
    public void savesParent() {
        Parent parent = parentRepository.save(new Parent());
        assertThat(parent.getId(), is(notNullValue()));
    }

    @Test
    public void savesParentWithChild() {
        Parent parent = new Parent();
        parent.setChild(new Child("Tom", "gnu"));

        Parent parentPersisted = parentRepository.save(parent);
        assertThat(parentPersisted.getId(), is(notNullValue()));
        assertThat(parentPersisted.getChild().getId(), is(notNullValue()));
        assertThat(parentPersisted.getChild().getId(), is(4L));
        assertThat(parentPersisted.getChild().getRandom(), is("gnu"));
    }
}
