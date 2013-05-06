package jpa.persistence.customizer;

import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.history.HistoryPolicy;

/**
 * User: wantez
 * Date: 06/05/13
 * Time: 19:56
 */
public class AnimalCustomizer implements DescriptorCustomizer {

    @Override
    public void customize(ClassDescriptor cd) throws Exception {
        HistoryPolicy policy = new HistoryPolicy();
        policy.addStartFieldName("START");
        policy.addEndFieldName("END");
        policy.addHistoryTableName("ANIMAL","ANIMAL_HISTORY");
        policy.setShouldHandleWrites(true);
        cd.setHistoryPolicy(policy);
    }
}