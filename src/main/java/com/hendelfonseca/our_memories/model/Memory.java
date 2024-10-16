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

    @ManyToOne
    @JoinColumn(name = "id_album", nullable = false)
    private Album album;

    public Memory() {
    }

    public Memory(Album album, LocalDate date) {
        this.album = album;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<MemoryImg> getMemoryImgs() {
        return memoryImgs;
    }

    public void setMemoryImgs(List<MemoryImg> memoryImgs) {
        this.memoryImgs = memoryImgs;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
