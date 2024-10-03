package com.hendelfonseca.our_memories.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_memory_image")
public class MemoryImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_memory_image")
    private Long id;
    @Column(name = "url_memory_image", nullable = false)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "memory_id")
    private Memory memory;

    public MemoryImage() {
    }

    public MemoryImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }
}
