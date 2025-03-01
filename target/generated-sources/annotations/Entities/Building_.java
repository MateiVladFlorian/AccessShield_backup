package Entities;

import Entities.Account;
import Entities.Rooms;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-02-26T22:18:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Building.class)
public class Building_ { 

    public static volatile CollectionAttribute<Building, Rooms> roomsCollection;
    public static volatile SingularAttribute<Building, Date> createdAt;
    public static volatile SingularAttribute<Building, Account> accountId;
    public static volatile SingularAttribute<Building, String> accessKey;
    public static volatile SingularAttribute<Building, BigDecimal> price;
    public static volatile SingularAttribute<Building, String> name;
    public static volatile SingularAttribute<Building, String> addressLocation;
    public static volatile SingularAttribute<Building, Integer> countRooms;
    public static volatile SingularAttribute<Building, Integer> id;

}