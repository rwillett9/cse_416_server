<h1>Start Server</h1>

<h2>To start server, navigate to sparks folder and run:</h2>

<code>./mvnw clean spring-boot:run</code>

Alternatively, you can run by running the main method in:

<code>/sparks/src/main/java/com/sparks/sparks/MainApplication.java</code>

<h1>Testing</h1>

For testing visit the following link and scroll down to the section with sample curl code:

https://spring.io/guides/tutorials/rest/

<h1>API Calls</h1>

Make sure <code>localhost:8080</code> is available for the server to run on.

<h2>Message Object</h2>

Message: {

    id Long: unique id for identification

    name String: representation of Message

    message String: message

    timesAccessed int: total times this message was retrieved
}

<h2>GET <code>localhost:8080/messages</code></h2>

Returns: all Messages in the dummydb

<h2>POST <code>localhost:8080/messages</code></h2>

Body: Message Object

Returns: new Message that is now saved in dummydb

<h2>GET <code>localhost:8080/messages/{id}</code></h2>

Returns: Message with specified id if it exists, otherwise 404 error

<h2>PUT <code>localhost:8080/messages/{id}</code></h2>

Body: Message Object

Returns: Message that has now been updated, or new Message if Message with id didn't already exist

<h2>DELETE <code>localhost:8080/messages/{id}</code></h2>

Returns: nothing