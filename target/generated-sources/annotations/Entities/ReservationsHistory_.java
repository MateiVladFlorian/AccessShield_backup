package Entities;

import Entities.Account;
import Entities.Reservations;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-13T15:06:47", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ReservationsHistory.class)
public class ReservationsHistory_ { 

    public static volatile SingularAttribute<ReservationsHistory, Account> accountId;
    public static volatile SingularAttribute<ReservationsHistory, Reservations> reservationId;
    public static volatile SingularAttribute<ReservationsHistory, Integer> historyId;
    public static volatile SingularAttribute<ReservationsHistory, String> action;
    public static volatile SingularAttribute<ReservationsHistory, Date> actionDate;

}