package test;

import org.hibernate.cfg.Configuration;
import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.spi.PersistenceUnitInfo;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-test.xml")
public class ExportDatabaseSchema {

    @Autowired
    LocalContainerEntityManagerFactoryBean entityManagerFactory;

    @Test
    public void exportDatabaseSchema(){
        PersistenceUnitInfo persistenceUnitInfo = entityManagerFactory.getPersistenceUnitInfo();
        Map jpaPropertyMap = entityManagerFactory.getJpaPropertyMap();

        Configuration configuration = new Ejb3Configuration().configure( persistenceUnitInfo, jpaPropertyMap ).getHibernateConfiguration();

        SchemaExport schema = new SchemaExport(configuration);
        schema.setOutputFile("schema.sql");
        schema.setDelimiter(";");
        schema.create(true, false);
    }
}