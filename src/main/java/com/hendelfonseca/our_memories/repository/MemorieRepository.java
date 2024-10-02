package com.hendelfonseca.our_memories.repository;

import com.hendelfonseca.our_memories.model.Memorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface MemorieRepository extends JpaRepository<Memorie, Long> {
}
