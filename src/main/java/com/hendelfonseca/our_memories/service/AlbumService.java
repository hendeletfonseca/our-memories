package com.hendelfonseca.our_memories.service;

import com.hendelfonseca.our_memories.exception.AlbumNotFoundException;
import com.hendelfonseca.our_memories.model.Album;
import com.hendelfonseca.our_memories.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Album create(Album album) {
        return albumRepository.save(album);
    }

    public List<Album> readAll() {
        return albumRepository.findAll();
    }

    public Album read(Long id) {
        return albumRepository
                .findById(id)
                .orElseThrow(() -> new AlbumNotFoundException(id));
    }

    public boolean existsById(Long id) {
        return albumRepository.existsById(id);
    }

    public void delete(Long id) {
        albumRepository.deleteById(id);
    }

    public List<Album> readAllByUserId(UUID userId) {
        return albumRepository.findAlbumsByUsersId(userId);
    }
}
