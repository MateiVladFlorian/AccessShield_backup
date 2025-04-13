package Entities;

import Entities.Account;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-13T14:17:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Promotions.class)
public class Promotions_ { 

    public static volatile SingularAttribute<Promotions, BigDecimal> discountPercentage;
    public static volatile SingularAttribute<Promotions, Integer> maxUses;
    public static volatile SingularAttribute<Promotions, Account> accountId;
    public static volatile SingularAttribute<Promotions, Date> endDate;
    public static volatile SingularAttribute<Promotions, Integer> usesCount;
    public static volatile SingularAttribute<Promotions, String> description;
    public static volatile SingularAttribute<Promotions, String> promoCode;
    public static volatile SingularAttribute<Promotions, Integer> promotionId;
    public static volatile SingularAttribute<Promotions, Date> startDate;

}