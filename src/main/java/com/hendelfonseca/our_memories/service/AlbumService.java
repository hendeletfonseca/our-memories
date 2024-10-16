package com.hendelfonseca.our_memories.service;

import com.hendelfonseca.our_memories.model.Album;
import com.hendelfonseca.our_memories.repository.AlbumRepository;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Album create(Album album) {
        return albumRepository.save(album);
    }
}
