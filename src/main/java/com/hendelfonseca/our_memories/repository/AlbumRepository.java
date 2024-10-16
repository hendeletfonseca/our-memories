package com.hendelfonseca.our_memories.repository;

import com.hendelfonseca.our_memories.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
