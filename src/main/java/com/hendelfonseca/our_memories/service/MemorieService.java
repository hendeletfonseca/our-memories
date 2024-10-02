package com.hendelfonseca.our_memories.service;

import com.hendelfonseca.our_memories.model.Memorie;
import com.hendelfonseca.our_memories.repository.MemorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemorieService implements IMemorieService {

    private final MemorieRepository repo;

    public MemorieService(MemorieRepository repo) {
        this.repo = repo;
    }

    @Override
    public Memorie create(Memorie memorie) {
        return repo.save(memorie);
    }

    @Override
    public Memorie read(long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Memorie update(Memorie memorie) {
        return repo.save(memorie);
    }

    public void delete(Memorie memorie) {
        repo.delete(memorie);
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Memorie> readAll() {
        return List.of();
    }
}
