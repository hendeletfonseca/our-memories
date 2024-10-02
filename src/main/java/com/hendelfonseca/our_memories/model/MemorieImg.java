package com.hendelfonseca.our_memories.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_memorie_img")
public class MemorieImg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_memorie_img")
    private Long id;
    @Column(name = "url_memorie_img", nullable = false)
    private String url;

    public MemorieImg() {
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
