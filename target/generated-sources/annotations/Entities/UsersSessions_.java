package Entities;

import Entities.Account;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-13T14:17:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(UsersSessions.class)
public class UsersSessions_ { 

    public static volatile SingularAttribute<UsersSessions, Date> createdAt;
    public static volatile SingularAttribute<UsersSessions, Account> accountId;
    public static volatile SingularAttribute<UsersSessions, Date> lastActivity;
    public static volatile SingularAttribute<UsersSessions, Integer> sessionId;
    public static volatile SingularAttribute<UsersSessions, Boolean> isActive;
    public static volatile SingularAttribute<UsersSessions, String> deviceId;

}