package com.hendelfonseca.our_memories.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_album")
    private Long id;

    @Column(name = "title_album")
    private String title;

    @ManyToMany(mappedBy = "albums",
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    Set<User> users = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "id_memory")
    private Set<Memory> memories = new HashSet<>();

    public Album() {
    }

    public Album(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Memory> getMemories() {
        return memories;
    }

    public void setMemories(Set<Memory> memories) {
        this.memories = memories;
    }
}
