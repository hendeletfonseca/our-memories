package com.hendelfonseca.our_memories.service;

import com.hendelfonseca.our_memories.exception.MemoryNotFoundException;
import com.hendelfonseca.our_memories.model.Memory;
import com.hendelfonseca.our_memories.repository.MemoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryService implements IMemoryService {

    private final MemoryRepository repo;

    public MemoryService(MemoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public Memory create(Memory memory) {
        return repo.save(memory);
    }

    @Override
    public Memory read(long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Memory update(Memory memory) {
        Memory existing = repo.findById(memory.getId())
                        .orElseThrow(MemoryNotFoundException::new);

        existing.setDate(memory.getDate());
        existing.getImages().clear();
        if (memory.getImages() != null) existing.setImages(memory.getImages());

        return repo.save(existing);
    }

    public void delete(Memory memory) {
        repo.delete(memory);
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Memory> readAll() {
        return List.of();
    }
}
