package Entities;

import Entities.Account;
import Entities.BillingInfo;
import Entities.Payments;
import Entities.Transactions;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-13T14:17:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(TransactionAuditLogs.class)
public class TransactionAuditLogs_ { 

    public static volatile SingularAttribute<TransactionAuditLogs, Integer> auditId;
    public static volatile SingularAttribute<TransactionAuditLogs, String> actionType;
    public static volatile SingularAttribute<TransactionAuditLogs, Account> performedBy;
    public static volatile SingularAttribute<TransactionAuditLogs, BillingInfo> billingId;
    public static volatile CollectionAttribute<TransactionAuditLogs, Payments> paymentsCollection;
    public static volatile SingularAttribute<TransactionAuditLogs, String> details;
    public static volatile CollectionAttribute<TransactionAuditLogs, Transactions> transactionsCollection;
    public static volatile SingularAttribute<TransactionAuditLogs, Date> timestamp;

}