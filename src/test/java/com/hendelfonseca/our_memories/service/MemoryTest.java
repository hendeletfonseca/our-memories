package com.hendelfonseca.our_memories.service;

import com.hendelfonseca.our_memories.exception.MemoryNotFoundException;
import com.hendelfonseca.our_memories.model.Album;
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
    private MemoryService service;
    @Autowired
    private AlbumService albumService;

    @Test
    public void shouldStoreMemorie() {

        Album album = albumService.create(new Album());

        Memory memory = new Memory(album, LocalDate.now());
        assertNotNull(service.create(memory));
    }

    @Test
    public void shouldFindMemorieById() {
        Album album = albumService.create(new Album());

        Memory savedMemory = service.create(new Memory(album, LocalDate.now()));
        Memory readedMemory = service.read(savedMemory.getId());
        assertNotNull(readedMemory);
        assertEquals(savedMemory.getId(), readedMemory.getId());
    }

    @Test
    public void shouldThrowUserNotFoundException() {
        long invalidId = -1L;
        assertThrows(MemoryNotFoundException.class, () -> {
            service.read(invalidId);
        });
    }
    @Test
    public void shouldUpdateMemorie() {
        Album album = albumService.create(new Album());

        Memory savedMemory = service.create(new Memory(album, LocalDate.now()));
        savedMemory.setDate(LocalDate.now().plusDays(1));

        Memory updatedMemory = service.update(savedMemory);
        assertNotNull(updatedMemory);
        assertEquals(savedMemory.getId(), updatedMemory.getId());
        assertEquals(savedMemory.getDate(), updatedMemory.getDate());
    }

    @Test
    public void shouldDeleteMemorie() {
        Memory memory = new Memory(albumService.create(new Album()), LocalDate.now());
        service.create(memory);
        service.delete(memory.getId());
        assertThrows(MemoryNotFoundException.class, () -> {
            service.read(memory.getId());
        });
    }

}
