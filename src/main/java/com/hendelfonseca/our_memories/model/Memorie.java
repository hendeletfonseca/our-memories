package com.hendelfonseca.our_memories.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_memorie")
public class Memorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_memorie")
    private Long id;

    @Column(name = "date_memorie", nullable = false)
    private LocalDate date;

    @OneToMany
    @JoinColumn(name = "tb_memorie_img_id_memorie_img")
    private List<MemorieImg> memorieImgs;

    public Memorie() {
    }

    public Memorie(LocalDate date) {
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

    public List<MemorieImg> getMemorieImgs() {
        return memorieImgs;
    }

    public void setMemorieImgs(List<MemorieImg> memorieImgs) {
        this.memorieImgs = memorieImgs;
    }
}
