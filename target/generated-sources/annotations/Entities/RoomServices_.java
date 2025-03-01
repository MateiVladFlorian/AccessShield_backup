package Entities;

import Entities.Rooms;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-02-26T22:18:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(RoomServices.class)
public class RoomServices_ { 

    public static volatile SingularAttribute<RoomServices, String> serviceType;
    public static volatile SingularAttribute<RoomServices, String> serviceDescription;
    public static volatile SingularAttribute<RoomServices, Integer> serviceId;
    public static volatile SingularAttribute<RoomServices, Date> serviceTime;
    public static volatile SingularAttribute<RoomServices, Rooms> roomId;

}