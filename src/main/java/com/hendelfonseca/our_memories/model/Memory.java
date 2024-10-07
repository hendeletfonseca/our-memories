package com.hendelfonseca.our_memories.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_memory")
public class Memory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_memory")
    private Long id;

    @Column(name = "date_memory", nullable = false)
    private LocalDate date;

    @OneToMany
    @JoinColumn(name = "tb_memory_img_id_memory_img")
    private List<MemoryImg> memoryImgs;

    @ManyToMany(mappedBy = "memories", fetch = FetchType.EAGER)
    Set<User> users = new HashSet<>();

    public Memory() {
    }

    public Memory(LocalDate date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<MemoryImg> getMemorieImgs() {
        return memoryImgs;
    }

    public void setMemorieImgs(List<MemoryImg> memoryImgs) {
        this.memoryImgs = memoryImgs;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
