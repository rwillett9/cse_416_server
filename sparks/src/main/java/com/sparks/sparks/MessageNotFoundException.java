package com.sparks.sparks;

// initialize custom Exception for when Message with given id does not exist
public class MessageNotFoundException extends RuntimeException{
    MessageNotFoundException(Long id) {
        super("Could not find Message with id=" + id);
    }
}
