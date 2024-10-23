package com.hendelfonseca.our_memories.controller;

import com.hendelfonseca.our_memories.exception.AlbumNotFoundException;
import com.hendelfonseca.our_memories.exception.UserNotFoundException;
import com.hendelfonseca.our_memories.model.Album;
import com.hendelfonseca.our_memories.model.User;
import com.hendelfonseca.our_memories.service.AlbumService;
import com.hendelfonseca.our_memories.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AlbumController {

    private final AlbumService albumService;
    private final UserService userService;

    public AlbumController(AlbumService albumService, UserService userService) {
        this.albumService = albumService;
        this.userService = userService;
    }

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> findAll() {
        List<Album> albums = albumService.readAll();

        if (albums.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/albums")
    public ResponseEntity<List<Album>> findAllByUserId(@PathVariable UUID userId) {
        if (!userService.existsById(userId)) {
            throw new UserNotFoundException();
        }

        List<Album> albums = albumService.readAllByUserId(userId);
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/albums/{id}/users")
    public ResponseEntity<List<User>> findAllUsersByAlbumId(@PathVariable Long id) {
        if (!albumService.existsById(id)) throw new AlbumNotFoundException(id);

        List<User> users = userService.readAllByAlbumId(id);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<Album> findById(@PathVariable Long id) {
        Album album = albumService.read(id);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @PostMapping("/albums")
    public ResponseEntity<Album> create(@RequestBody Album album) {
        Album newAlbum = albumService.create(new Album(album.getTitle()));
        return new ResponseEntity<>(newAlbum, HttpStatus.CREATED);
    }

    @DeleteMapping("/albums/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        albumService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/users/{userId}/albums")
    public ResponseEntity<Album> addAlbum(@PathVariable("userId") UUID userId, @RequestBody Album albumRequest) {
        if (!userService.existsById(userId)) {
            throw new UserNotFoundException();
        }

        User user = userService.read(userId);
        Long albumRequestId = albumRequest.getId();

        if (albumRequestId != null && albumRequestId != 0L) {
            Album _album = albumService.read(albumRequestId);
            user.addAlbum(_album);
            userService.update(user);
            return new ResponseEntity<>(_album, HttpStatus.CREATED);
        }

        user.addAlbum(albumRequest);
        return new ResponseEntity<Album>(albumService.create(albumRequest), HttpStatus.CREATED);

    }

}
