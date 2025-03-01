package Entities;

import Entities.Account;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-02-26T22:18:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(AuditLogs.class)
public class AuditLogs_ { 

    public static volatile SingularAttribute<AuditLogs, Account> accountId;
    public static volatile SingularAttribute<AuditLogs, Date> actionTime;
    public static volatile SingularAttribute<AuditLogs, Integer> reservationId;
    public static volatile SingularAttribute<AuditLogs, String> ipAddress;
    public static volatile SingularAttribute<AuditLogs, String> action;
    public static volatile SingularAttribute<AuditLogs, Integer> logId;
    public static volatile SingularAttribute<AuditLogs, String> userAgent;

}