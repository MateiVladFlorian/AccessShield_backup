package Entities;

import Entities.Rooms;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-02-26T22:18:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(MaintenanceLogs.class)
public class MaintenanceLogs_ { 

    public static volatile SingularAttribute<MaintenanceLogs, Integer> maintenanceId;
    public static volatile SingularAttribute<MaintenanceLogs, Date> maintenanceDate;
    public static volatile SingularAttribute<MaintenanceLogs, String> description;
    public static volatile SingularAttribute<MaintenanceLogs, String> maintenanceType;
    public static volatile SingularAttribute<MaintenanceLogs, Rooms> roomId;

}