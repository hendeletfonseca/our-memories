package com.hendelfonseca.our_memories.repository;

import com.hendelfonseca.our_memories.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findAlbumsByUsersId(UUID userId);
}
