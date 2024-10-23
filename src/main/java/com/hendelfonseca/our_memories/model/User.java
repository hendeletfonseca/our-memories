package com.hendelfonseca.our_memories.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_user")
    private UUID id;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "tb_user_album",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_album")
    )
    Set<Album> albums = new HashSet<>();

    @Column(name = "username_user", nullable = false)
    private String username;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public void addAlbum(Album album) {
        this.albums.add(album);
        album.getUsers().add(this);
    }

    public void removeAlbum(long albumId) {
        Album album = this.albums.stream().filter(a -> a.getId().equals(albumId)).findFirst().orElse(null);
        if (album != null) {
            this.albums.remove(album);
            album.getUsers().remove(this);
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
