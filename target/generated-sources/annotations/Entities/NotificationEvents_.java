package Entities;

import Entities.Notifications;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-04T22:03:39", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(NotificationEvents.class)
public class NotificationEvents_ { 

    public static volatile SingularAttribute<NotificationEvents, Integer> eventId;
    public static volatile CollectionAttribute<NotificationEvents, Notifications> notificationsCollection;
    public static volatile SingularAttribute<NotificationEvents, String> defaultNotificationMessage;
    public static volatile SingularAttribute<NotificationEvents, String> eventDescription;
    public static volatile SingularAttribute<NotificationEvents, String> eventType;
    public static volatile SingularAttribute<NotificationEvents, String> priority;

}