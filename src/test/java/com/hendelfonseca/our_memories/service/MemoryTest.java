package com.hendelfonseca.our_memories.service;

import com.hendelfonseca.our_memories.model.Memory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class MemoryTest {

    @Autowired
    private IMemoryService service;

    @Test
    public void shouldStoreMemory() {
        Memory memory = new Memory(LocalDate.now());
        assertNotNull(service.create(memory));
    }

    @Test
    public void shouldFindMemoryById() {
        Memory savedMemory = service.create(new Memory(LocalDate.now()));
        Memory readedMemory = service.read(savedMemory.getId());
        assertNotNull(readedMemory);
        assert savedMemory.getId().equals(readedMemory.getId());
    }

    @Test
    public void shouldUpdateMemory() {
        Memory memory = new Memory(LocalDate.now());
        service.create(memory);

        memory.setDate(LocalDate.of(2003,6,16));
        Memory updatedMemory = service.update(memory);
        assertNotNull(updatedMemory);
        assert updatedMemory.getDate().equals(memory.getDate());

        updatedMemory = service.read(memory.getId());
        assertNotNull(updatedMemory);
        assert updatedMemory.getDate().equals(memory.getDate());
    }

}
