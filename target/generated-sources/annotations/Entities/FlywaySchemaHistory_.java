package Entities;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-13T15:06:47", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(FlywaySchemaHistory.class)
public class FlywaySchemaHistory_ { 

    public static volatile SingularAttribute<FlywaySchemaHistory, Integer> executionTime;
    public static volatile SingularAttribute<FlywaySchemaHistory, Date> installedOn;
    public static volatile SingularAttribute<FlywaySchemaHistory, Integer> installedRank;
    public static volatile SingularAttribute<FlywaySchemaHistory, Boolean> success;
    public static volatile SingularAttribute<FlywaySchemaHistory, Integer> checksum;
    public static volatile SingularAttribute<FlywaySchemaHistory, String> description;
    public static volatile SingularAttribute<FlywaySchemaHistory, String> installedBy;
    public static volatile SingularAttribute<FlywaySchemaHistory, String> type;
    public static volatile SingularAttribute<FlywaySchemaHistory, String> version;
    public static volatile SingularAttribute<FlywaySchemaHistory, String> script;

}