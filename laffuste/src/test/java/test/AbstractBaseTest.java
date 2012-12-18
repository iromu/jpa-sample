package test;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;


@ContextConfiguration("classpath:spring-test.xml")
@Transactional
public abstract class AbstractBaseTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    JpaTransactionManager transactionManager;

    @BeforeTransaction
    public void setupData() throws Exception {
        DataSource dataSource = transactionManager.getDataSource();
        Connection con = DataSourceUtils.getConnection(dataSource);
        IDatabaseConnection dbUnitCon = new DatabaseConnection(con);
        InputStream in = getClass().getResourceAsStream("/dbunit-test-data/data.xml");
        IDataSet dataSet = new FlatXmlDataSet(in);

        try {
            DatabaseOperation.CLEAN_INSERT.execute(dbUnitCon, dataSet);
        } finally {
            DataSourceUtils.releaseConnection(con, dataSource);
        }
        executeSqlScript("classpath:data.sql", false);
    }
}
