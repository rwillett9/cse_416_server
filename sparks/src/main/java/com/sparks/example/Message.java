package com.sparks.example;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

// JPA annotation to make this object ready for storage in JPA-based data store
@Entity
class Message {
    // marked as primary key and automatically populated by JPA provider
    private @Id @GeneratedValue Long id;
    // attributes of Message Object
    private String name;
    private String message;
    private int timesAccessed;

    // default constructor
    Message() {}

    // overloaded constructor
    Message(String name, String message) {
        this.name = name;
        this.message = message;
        this.timesAccessed = 0;
    }

    // setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setMessage(String message) { this.message = message; }
    public void setTimesAccessed(int timesAccessed) { this.timesAccessed = timesAccessed; }

    // getters
    public Long getId() { return this.id; }
    public String getName() { return this.name; }
    public String getMessage() { return this.message; }
    public int getTimesAccessed() { return this.timesAccessed; }

    // increment times accessed
    public void access() { this.timesAccessed++; }

    // override default Object equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Message)) { return false; }
        Message message = (Message) o;
        return Objects.equals(this.id, message.id) && Objects.equals(this.name, message.name) 
            && Objects.equals(this.message, message.message);
    }

    // override default Object hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.message);
    }

    // override default Object toString method
    @Override
    public String toString() {
        return this.name + ": \"" + this.message + "\"";
    }
}