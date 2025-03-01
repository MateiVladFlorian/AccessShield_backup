package Entities;

import Entities.Transactions;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-02-26T22:18:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(PaymentGateways.class)
public class PaymentGateways_ { 

    public static volatile SingularAttribute<PaymentGateways, String> supportedCurrencies;
    public static volatile SingularAttribute<PaymentGateways, BigDecimal> transactionFee;
    public static volatile SingularAttribute<PaymentGateways, String> apiUrl;
    public static volatile SingularAttribute<PaymentGateways, String> gatewayName;
    public static volatile SingularAttribute<PaymentGateways, Date> integrationDate;
    public static volatile CollectionAttribute<PaymentGateways, Transactions> transactionsCollection;
    public static volatile SingularAttribute<PaymentGateways, Integer> gatewayId;
    public static volatile SingularAttribute<PaymentGateways, String> status;

}