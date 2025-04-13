package Entities;

import Entities.Account;
import Entities.BillingInfo;
import Entities.Payments;
import Entities.ReservationsHistory;
import Entities.Rooms;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-13T14:17:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Reservations.class)
public class Reservations_ { 

    public static volatile SingularAttribute<Reservations, Account> accountId;
    public static volatile SingularAttribute<Reservations, Date> checkIn;
    public static volatile SingularAttribute<Reservations, BillingInfo> billingId;
    public static volatile SingularAttribute<Reservations, Integer> reservationId;
    public static volatile CollectionAttribute<Reservations, ReservationsHistory> reservationsHistoryCollection;
    public static volatile CollectionAttribute<Reservations, Payments> paymentsCollection;
    public static volatile SingularAttribute<Reservations, Date> checkOut;
    public static volatile SingularAttribute<Reservations, Rooms> roomId;
    public static volatile SingularAttribute<Reservations, String> status;

}