package com.hendelfonseca.our_memories.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_memory_img")
public class MemoryImg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_memory_img")
    private Long id;
    @Column(name = "url_memory_img", nullable = false)
    private String url;

    public MemoryImg() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
