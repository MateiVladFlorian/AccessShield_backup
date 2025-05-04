package Entities;

import Entities.Account;
import Entities.Reservations;
import Entities.TransactionAuditLogs;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-04T22:03:39", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(BillingInfo.class)
public class BillingInfo_ { 

    public static volatile SingularAttribute<BillingInfo, Date> expiryDate;
    public static volatile SingularAttribute<BillingInfo, Account> accountId;
    public static volatile SingularAttribute<BillingInfo, Integer> billingId;
    public static volatile CollectionAttribute<BillingInfo, Reservations> reservationsCollection;
    public static volatile SingularAttribute<BillingInfo, String> cardType;
    public static volatile CollectionAttribute<BillingInfo, TransactionAuditLogs> transactionAuditLogsCollection;
    public static volatile SingularAttribute<BillingInfo, String> billingAddress;
    public static volatile SingularAttribute<BillingInfo, String> cardNumber;

}