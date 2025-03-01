package migrate_db;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;

/**
 *
 * @author vlad
 */
public class MigrateDatabase {
    public MigrateDatabase() {
        try {
            Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/accesscontrol", "postgres", "test1234")
                .load();

            flyway.migrate();
            System.out.println("Migrarea bazei de date a fost realizată cu succes!");
        } catch (FlywayException e) {
            System.err.println("Eroare în migrarea bazei de date: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
