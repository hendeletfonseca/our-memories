package com.hendelfonseca.our_memories.service;

import com.hendelfonseca.our_memories.model.Memory;

import java.util.List;

public interface IMemoryService {
    public Memory create(Memory memory);
    public Memory read(long id);
    public Memory update(Memory memory);
    public void delete(long id);
    public List<Memory> readAll();
}
