package com.hendelfonseca.our_memories.service;

import com.hendelfonseca.our_memories.model.Memorie;

import java.time.LocalDate;
import java.util.List;

public interface IMemorieService {
    public Memorie create(Memorie memorie);
    public Memorie read(long id);
    public Memorie update(Memorie memorie);
    public void delete(long id);
    public List<Memorie> readAll();
}
