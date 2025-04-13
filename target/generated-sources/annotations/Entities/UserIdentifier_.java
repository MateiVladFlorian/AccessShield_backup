package Entities;

import Entities.Account;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-13T14:17:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(UserIdentifier.class)
public class UserIdentifier_ { 

    public static volatile SingularAttribute<UserIdentifier, Account> accountId;
    public static volatile SingularAttribute<UserIdentifier, String> userCode;
    public static volatile SingularAttribute<UserIdentifier, Integer> userIdentifierId;

}