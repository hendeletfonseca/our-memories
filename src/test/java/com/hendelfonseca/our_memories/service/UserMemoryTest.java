package com.hendelfonseca.our_memories.service;

import com.hendelfonseca.our_memories.model.Memory;
import com.hendelfonseca.our_memories.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class UserMemoryTest {

    @Autowired
    private IUserService userService;
    @Autowired
    private IMemoryService memoryService;

    @Test
    public void shouldAddMemoryToUser() {
        Memory memory = memoryService.create(new Memory(LocalDate.now()));
        User user = userService.create(new User("username"));
        User userWithMemory = userService.addMemoryToUser(user.getId(), memory.getId());

        Memory memoryAfterUpdate = memoryService.read(memory.getId());
        assertEquals(userWithMemory.getMemories().size(), 1);
        assertEquals(memoryAfterUpdate.getUsers().size(), 1);
    }
}
