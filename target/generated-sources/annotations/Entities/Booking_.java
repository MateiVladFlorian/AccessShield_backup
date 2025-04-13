package Entities;

import Entities.Account;
import Entities.Rooms;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-13T14:17:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, Account> accountId;
    public static volatile SingularAttribute<Booking, Date> checkIn;
    public static volatile SingularAttribute<Booking, Date> checkOut;
    public static volatile SingularAttribute<Booking, Integer> bookingId;
    public static volatile SingularAttribute<Booking, Rooms> roomId;
    public static volatile SingularAttribute<Booking, String> status;

}