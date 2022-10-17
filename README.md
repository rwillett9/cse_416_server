<h1>Setup</h1>

<h2>First, you must complete the necessary fields in the 
<code>sparks/src/main/resources/application.properties file</code>

The file should look like the following:
</h2>

<code>
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://PUBLIC_IP_ADDRESS/DB_NAME
spring.datasource.username=username
spring.datasource.password=password
spring.cloud.gcp.project-id=PROJECT_ID_FROM_GCP_PROJECT
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.cloud.gcp.sql.instance-connection-name=CONNECTION_NAME_FROM_GCP_DATABASE
spring.cloud.gcp.sql.database-name=DB_NAME
spring.cloud.gcp.logging.enabled=true
spring.sql.init.mode=always
</code>

<h2>You must fill in the <code>PUBLIC_IP_ADDRESS</code> of your GCP mysql server, <code>PROJECT_ID_FROM_GCP_PROJECT</code>, <code>CONNECTION_NAME_FROM_GCP_DATABASE</code>, <code>DB_NAME</code>, <code>username</code>, and <code>password</code>
fields.

<h1>Start Server</h1>

<h2>To start server, navigate to sparks folder and run:</h2>

<code>./mvnw clean spring-boot:run</code>

Alternatively, you can run by running the main method in:

<code>/sparks/src/main/java/com/sparks/sparks/MainApplication.java</code>

<h1>Testing</h1>

For testing visit the following link and scroll down to the section with sample curl code:

https://spring.io/guides/tutorials/rest/

