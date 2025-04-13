package Entities;

import Entities.Account;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-13T15:06:47", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Feedback.class)
public class Feedback_ { 

    public static volatile SingularAttribute<Feedback, String> feedbackText;
    public static volatile SingularAttribute<Feedback, Date> createdAt;
    public static volatile SingularAttribute<Feedback, Account> accountId;
    public static volatile SingularAttribute<Feedback, Integer> reservationId;
    public static volatile SingularAttribute<Feedback, Integer> rating;
    public static volatile SingularAttribute<Feedback, Integer> feedbackId;
    public static volatile SingularAttribute<Feedback, Integer> roomId;
    public static volatile SingularAttribute<Feedback, Integer> staffId;

}