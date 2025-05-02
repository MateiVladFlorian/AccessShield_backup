## Description
 This application is designed to manage complex reservations for multiple buildings.<br/>
 The application is implemented in Java and uses the Swing framework for the UI.

 ## Installation Steps
 Before configuring and creating the database, it is necessary to download and install the PostgreSQL server, available online at the following link: [<b>https://www.postgresql.org/download/</b>](https://www.postgresql.org/download/). If you are running the Windows operating system, open the <b>pgAdmin 4</b> interface to create the 'accesscontrol' database using the 'postgres' admin account.
 When the run button is pressed (or F6 on the keyboard), the EclipseLink framework applies the available migrations using the Flyway Maven Plugin.<br/><br/>
<b>To automate the database migration process, edit the flyway.conf file as follows:</b>
<br/>

```shell

flyway.user=postgres
flyway.password=test1234
flyway.schemas=accesscontrol
flyway.locations=classpath:db/migration
flyway.url=jdbc:postgresql://localhost:5432/accesscontrol
flyway.cleanDisabled=false

```

If you prefer or use other operating systems such as Linux, enter the following commands using the command line:

```shell

$ mvn clean flyway:migrate -Dflyway.configFiles=flyway.conf
$ mvn flyway:clean

```
