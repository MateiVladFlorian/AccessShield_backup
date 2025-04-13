package Entities;

import Entities.Rooms;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-13T15:06:47", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(RoomsAmenities.class)
public class RoomsAmenities_ { 

    public static volatile SingularAttribute<RoomsAmenities, Integer> amenityId;
    public static volatile SingularAttribute<RoomsAmenities, String> amenityName;
    public static volatile SingularAttribute<RoomsAmenities, String> description;
    public static volatile SingularAttribute<RoomsAmenities, Rooms> roomId;

}