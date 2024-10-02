package com.hendelfonseca.our_memories.service;

import com.hendelfonseca.our_memories.model.Memorie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class MemorieTest {

    @Autowired
    private IMemorieService service;

    @Test
    public void shouldStoreMemorie() {
        Memorie memorie = new Memorie(LocalDate.now());
        assertNotNull(service.create(memorie));
    }

    @Test
    public void shouldFindMemorieById() {
        Memorie savedMemorie = service.create(new Memorie(LocalDate.now()));
        Memorie readedMemorie = service.read(savedMemorie.getId());
        assertNotNull(readedMemorie);
        assert savedMemorie.getId().equals(readedMemorie.getId());
    }

    @Test
    public void shouldUpdateMemorie() {
        Memorie memorie = new Memorie(LocalDate.now());
        service.create(memorie);

        memorie.setDate(LocalDate.of(2003,6,16));
        Memorie updatedMemorie = service.update(memorie);
        assertNotNull(updatedMemorie);
        assert updatedMemorie.getDate().equals(memorie.getDate());

        updatedMemorie = service.read(memorie.getId());
        assertNotNull(updatedMemorie);
        assert updatedMemorie.getDate().equals(memorie.getDate());
    }

}
