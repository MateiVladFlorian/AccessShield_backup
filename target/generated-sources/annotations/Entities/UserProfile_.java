package Entities;

import Entities.Account;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-04T22:03:39", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(UserProfile.class)
public class UserProfile_ { 

    public static volatile SingularAttribute<UserProfile, String> country;
    public static volatile SingularAttribute<UserProfile, Account> accountId;
    public static volatile SingularAttribute<UserProfile, String> numberPhone;
    public static volatile SingularAttribute<UserProfile, String> name;
    public static volatile SingularAttribute<UserProfile, String> imageProfile;
    public static volatile SingularAttribute<UserProfile, String> description;
    public static volatile SingularAttribute<UserProfile, Integer> id;

}