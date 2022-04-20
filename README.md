<h1>Setup</h1>

<h2>First, you must complete the necessary fields in the 
<code>sparks/src/main/resources/application.properties file</code>

The file should look like the following:
</h2>

<code>
spring.jpa.hibernate.ddl-auto=create

spring.datasource.url=jdbc:mysql://{databaseURL}/{databasename}

spring.datasource.username={username}

spring.datasource.password={password}
</code>

<h2>You must fill in the <code>databaseURL</code>, <code>databasename</code>, <code>username</code>, and <code>password</code>
fields.

MAKE SURE YOU REMOVE THE CURLY BRACKETS ("{" and "}")

<h1>Start Server</h1>

<h2>To start server, navigate to sparks folder and run:</h2>

<code>./mvnw clean spring-boot:run</code>

Alternatively, you can run by running the main method in:

<code>/sparks/src/main/java/com/sparks/sparks/MainApplication.java</code>

<h1>Testing</h1>

For testing visit the following link and scroll down to the section with sample curl code:

https://spring.io/guides/tutorials/rest/

