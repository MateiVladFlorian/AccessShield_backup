package Entities;

import Entities.Account;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-13T14:17:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(SecurityLogs.class)
public class SecurityLogs_ { 

    public static volatile SingularAttribute<SecurityLogs, Account> accountId;
    public static volatile SingularAttribute<SecurityLogs, String> eventDetails;
    public static volatile SingularAttribute<SecurityLogs, Date> eventTime;
    public static volatile SingularAttribute<SecurityLogs, Integer> logId;
    public static volatile SingularAttribute<SecurityLogs, String> eventType;

}