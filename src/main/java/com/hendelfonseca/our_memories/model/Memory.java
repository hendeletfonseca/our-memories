package com.hendelfonseca.our_memories.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_memory")
public class Memory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_memory")
    private Long id;

    @Column(name = "date_memory", nullable = false)
    private LocalDate date;

    @OneToMany(
            mappedBy = "memory",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MemoryImage> images;

    public Memory() {
    }

    public Memory(LocalDate date) {
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

    public List<MemoryImage> getImages() {
        return images;
    }

    public void setImages(List<MemoryImage> images) {
        this.images = images;
    }
}
