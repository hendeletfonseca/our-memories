package com.hendelfonseca.our_memories.service;

import com.hendelfonseca.our_memories.model.Memory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class MemoryTest {

    @Autowired
    private IMemoryService service;

    @Test
    public void shouldStoreMemorie() {
        Memory memory = new Memory(LocalDate.now());
        assertNotNull(service.create(memory));
    }

    @Test
    public void shouldFindMemorieById() {
        Memory savedMemory = service.create(new Memory(LocalDate.now()));
        Memory readedMemory = service.read(savedMemory.getId());
        assertNotNull(readedMemory);
        assertEquals(savedMemory.getId(), readedMemory.getId());
    }

    @Test
    public void shouldUpdateMemorie() {
        Memory savedMemory = service.create(new Memory(LocalDate.now()));
        savedMemory.setDate(LocalDate.now().plusDays(1));

        Memory updatedMemory = service.update(savedMemory);
        assertNotNull(updatedMemory);
        assertEquals(savedMemory.getId(), updatedMemory.getId());
        assertEquals(savedMemory.getDate(), updatedMemory.getDate());
    }

    @Test
    public void shouldDeleteMemorie() {
        Memory memory = new Memory(LocalDate.now());
        service.create(memory);
        service.delete(memory.getId());
        assertNull(service.read(memory.getId()));
    }

}
