package Entities;

import Entities.Account;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-04T22:03:39", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(AccessLogs.class)
public class AccessLogs_ { 

    public static volatile SingularAttribute<AccessLogs, Integer> accessId;
    public static volatile SingularAttribute<AccessLogs, Account> accountId;
    public static volatile SingularAttribute<AccessLogs, Date> exitTime;
    public static volatile SingularAttribute<AccessLogs, Boolean> accessGranted;
    public static volatile SingularAttribute<AccessLogs, Integer> logId;
    public static volatile SingularAttribute<AccessLogs, Date> accessTime;
    public static volatile SingularAttribute<AccessLogs, String> status;

}