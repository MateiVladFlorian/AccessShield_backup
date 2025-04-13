package Entities;

import Entities.Payments;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-13T15:06:47", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(PaymentMethods.class)
public class PaymentMethods_ { 

    public static volatile SingularAttribute<PaymentMethods, Payments> paymentId;
    public static volatile SingularAttribute<PaymentMethods, Integer> methodId;
    public static volatile SingularAttribute<PaymentMethods, String> methodName;
    public static volatile SingularAttribute<PaymentMethods, String> description;

}