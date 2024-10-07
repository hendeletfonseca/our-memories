package com.hendelfonseca.our_memories.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_user")
    private UUID id;

    @Column(name = "username_user", nullable = false)
    private String username;

    @ManyToMany
    @JoinTable(
            name = "tb_user_memory",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_memory")
    )
    Set<Memory> memories = new HashSet<>();

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, Set<Memory> memories) {
        this.username = username;
        this.memories = memories;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Memory> getMemories() {
        return memories;
    }

    public void setMemories(Set<Memory> memories) {
        this.memories = memories;
    }
}
