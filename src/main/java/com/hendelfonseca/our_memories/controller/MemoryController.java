package com.hendelfonseca.our_memories.controller;

import com.hendelfonseca.our_memories.repository.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoryController {

    @Autowired
    private MemoryRepository memoryRepository;

    @GetMapping("/memory")
    public String memory() {
        return memoryRepository.findAll().toString();
    }

}
