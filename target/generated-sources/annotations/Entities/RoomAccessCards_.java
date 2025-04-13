package Entities;

import Entities.Account;
import Entities.Rooms;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-13T15:06:47", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(RoomAccessCards.class)
public class RoomAccessCards_ { 

    public static volatile SingularAttribute<RoomAccessCards, Account> accountId;
    public static volatile SingularAttribute<RoomAccessCards, Integer> cardId;
    public static volatile SingularAttribute<RoomAccessCards, String> cardCode;
    public static volatile SingularAttribute<RoomAccessCards, Date> issueDate;
    public static volatile SingularAttribute<RoomAccessCards, Boolean> isActive;
    public static volatile SingularAttribute<RoomAccessCards, Rooms> roomId;
    public static volatile SingularAttribute<RoomAccessCards, Date> expirationDate;

}