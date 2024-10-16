package com.hendelfonseca.our_memories.service;

import com.hendelfonseca.our_memories.exception.UserNotFoundException;
import com.hendelfonseca.our_memories.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void shouldStoreUser() {
        User user = new User("username");
        assertNotNull(userService.create(user));
    }

    @Test
    public void shouldFindUserById() {
        User savedUser = userService.create(new User("username"));
        User readedUser = userService.read(savedUser.getId());
        assertNotNull(readedUser);
        assertEquals(readedUser.getId(), savedUser.getId());
    }

    @Test
    public void shouldThrowUserNotFoundException() {
        UUID invalidId = UUID.randomUUID();
        assertThrows(UserNotFoundException.class, () -> {
            userService.read(invalidId);
        });
    }

    @Test
    public void shouldUpdateUser() {
        User user = new User("username");
        User createdUser = userService.create(user);

        createdUser.setUsername("updated");
        User updatedUser = userService.update(createdUser);
        assertNotNull(updatedUser);
        assertEquals(updatedUser.getId(), createdUser.getId());
        assertEquals(updatedUser.getUsername(), createdUser.getUsername());

    }

}
