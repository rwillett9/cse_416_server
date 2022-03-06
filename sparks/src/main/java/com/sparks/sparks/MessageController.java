package com.sparks.sparks;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController indicates that the data returned by each method will be written straight into the response 
 * body instead of rendering a template
 * @CrossOrigin allows the specified url to make cross origin requests
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class MessageController {
    private final MessageRepository repository;

    // injects the MessageRepository into the class variable
    MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    /**
     * HTTP GET request
     * @return all Message Objects in the MessageRepository
     */
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/messages")
    List<Message> all() {
        List<Message> messageList = repository.findAll();
        // update get counters
        for (Message m: messageList) {
            m.access();
        }
        return messageList;
    }

    /**
     * HTTP POST request
     * saves a new Message Object to the MessageRepository
     * @param newMessage new Message Object to be saved
     * @return the now saved newMessage Object
     */
    @PostMapping("/messages")
    Message newMessage(@RequestBody Message newMessage) {
        return repository.save(newMessage);
    }

    /**
     * HTTP GET request
     * find a Message with specific id
     * @param id id of Message Object we want
     * @return Message Object with corresponding id if it exists, otherwise throw MessageNotFoundException
     */
    @GetMapping("/messages/{id}")
    Message one(@PathVariable Long id) {
        Message message = repository.findById(id).orElseThrow(() -> new MessageNotFoundException(id));
        // increment access counter
        message.access();
        return message;
    }

    /**
     * HTTP PUT request
     * update Message with specified id if it exists, otherwise create new Message object and store it in MessageRepository
     * @param newMessage stores new Message fields to be injected into old Message
     * @param id id of Message we want to update
     * @return updated Message with specified id
     */
    @PutMapping("/messages/{id}")
    Message replaceMessage(@RequestBody Message newMessage, @PathVariable Long id) {
        return repository.findById(id)
        .map(message -> {
            message.setName(newMessage.getName());
            message.setMessage(newMessage.getMessage());
            return repository.save(message);
        })
        .orElseGet(() -> {
            newMessage.setId(id);
            return repository.save(newMessage);
        });
    }

    /**
     * HTTP DELETE request
     * delete Message with specified id
     * @param id id of message to be deleted
     */
    @DeleteMapping("/messages/{id}")
    void deleteMessage(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
