package com.hendelfonseca.our_memories.repository;

import com.hendelfonseca.our_memories.model.Memory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryRepository extends JpaRepository<Memory, Long> {
}
