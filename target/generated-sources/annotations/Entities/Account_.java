package Entities;

import Entities.AccessLogs;
import Entities.AccessRoom;
import Entities.AuditLogs;
import Entities.BillingInfo;
import Entities.Booking;
import Entities.Building;
import Entities.Feedback;
import Entities.Notifications;
import Entities.Payments;
import Entities.Promotions;
import Entities.Reservations;
import Entities.ReservationsHistory;
import Entities.Reviews;
import Entities.RoomAccessCards;
import Entities.SecurityLogs;
import Entities.TransactionAuditLogs;
import Entities.Transactions;
import Entities.UserIdentifier;
import Entities.UserProfile;
import Entities.UsersRoles;
import Entities.UsersSessions;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-13T14:17:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile CollectionAttribute<Account, Reservations> reservationsCollection;
    public static volatile CollectionAttribute<Account, ReservationsHistory> reservationsHistoryCollection;
    public static volatile CollectionAttribute<Account, BillingInfo> billingInfoCollection;
    public static volatile CollectionAttribute<Account, Transactions> transactionsCollection;
    public static volatile CollectionAttribute<Account, Reviews> reviewsCollection;
    public static volatile CollectionAttribute<Account, RoomAccessCards> roomAccessCardsCollection;
    public static volatile SingularAttribute<Account, Feedback> feedback;
    public static volatile CollectionAttribute<Account, AccessLogs> accessLogsCollection;
    public static volatile CollectionAttribute<Account, Notifications> notificationsCollection;
    public static volatile SingularAttribute<Account, String> password;
    public static volatile CollectionAttribute<Account, Building> buildingCollection;
    public static volatile CollectionAttribute<Account, AuditLogs> auditLogsCollection;
    public static volatile CollectionAttribute<Account, UserIdentifier> userIdentifierCollection;
    public static volatile CollectionAttribute<Account, AccessRoom> accessRoomCollection;
    public static volatile SingularAttribute<Account, Integer> id;
    public static volatile CollectionAttribute<Account, UserProfile> userProfileCollection;
    public static volatile SingularAttribute<Account, String> email;
    public static volatile CollectionAttribute<Account, UsersRoles> usersRolesCollection;
    public static volatile CollectionAttribute<Account, Promotions> promotionsCollection;
    public static volatile SingularAttribute<Account, String> cnp;
    public static volatile CollectionAttribute<Account, TransactionAuditLogs> transactionAuditLogsCollection;
    public static volatile CollectionAttribute<Account, Booking> bookingCollection;
    public static volatile SingularAttribute<Account, Date> datetimeconnected;
    public static volatile CollectionAttribute<Account, Payments> paymentsCollection;
    public static volatile CollectionAttribute<Account, SecurityLogs> securityLogsCollection;
    public static volatile CollectionAttribute<Account, UsersSessions> usersSessionsCollection;
    public static volatile SingularAttribute<Account, String> location;
    public static volatile SingularAttribute<Account, String> username;
    public static volatile SingularAttribute<Account, String> status;

}