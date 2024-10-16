package com.hendelfonseca.our_memories.service;

import com.hendelfonseca.our_memories.exception.AlbumNotFoundException;
import com.hendelfonseca.our_memories.exception.UserNotFoundException;
import com.hendelfonseca.our_memories.model.Album;
import com.hendelfonseca.our_memories.model.User;
import com.hendelfonseca.our_memories.repository.AlbumRepository;
import com.hendelfonseca.our_memories.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserAlbumService {
    private final AlbumRepository albumRepository;
    private final UserRepository userRepository;

    public UserAlbumService(AlbumRepository albumRepository, UserRepository userRepository) {
        this.albumRepository = albumRepository;
        this.userRepository = userRepository;
    }

    public Album addUserToAlbum(long albumId, UUID userId) {
        Optional<Album> album = albumRepository.findById(albumId);
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) throw new UserNotFoundException();
        if (album.isEmpty()) throw new AlbumNotFoundException();

        album.get().getUsers().add(user.get());
        return albumRepository.save(album.get());
    }


}
