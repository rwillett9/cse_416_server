package com.sparks.sparks;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * By declaring this MessageRepository interface we can now:
 *  - create new Messages
 *  - update existing Messages
 *  - delete Messages
 *  - find Messages (one, all, or search by properties)
 * We made sure to specify domain type as Message and id type as Long
 */
interface MessageRepository extends JpaRepository<Message, Long> {

}
