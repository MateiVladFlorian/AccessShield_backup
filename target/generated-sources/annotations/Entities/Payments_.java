package Entities;

import Entities.Account;
import Entities.PaymentMethods;
import Entities.Reservations;
import Entities.TransactionAuditLogs;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-13T14:17:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Payments.class)
public class Payments_ { 

    public static volatile SingularAttribute<Payments, TransactionAuditLogs> auditId;
    public static volatile SingularAttribute<Payments, Account> accountId;
    public static volatile CollectionAttribute<Payments, PaymentMethods> paymentMethodsCollection;
    public static volatile SingularAttribute<Payments, BigDecimal> amount;
    public static volatile SingularAttribute<Payments, Reservations> reservationId;
    public static volatile SingularAttribute<Payments, Integer> paymentId;
    public static volatile SingularAttribute<Payments, Date> paymentDate;
    public static volatile SingularAttribute<Payments, String> paymentStatus;

}