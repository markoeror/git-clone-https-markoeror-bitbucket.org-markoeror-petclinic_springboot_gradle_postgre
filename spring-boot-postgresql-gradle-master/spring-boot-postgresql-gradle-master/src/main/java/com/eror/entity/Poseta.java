package com.eror.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Poseta extends BazniEntitet {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datumPosete;
    private String opis;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ljubimca")
    private Ljubimac ljubimac;

    public LocalDate getDatumPosete() {
        return datumPosete;
    }

    public void setDatumPosete(LocalDate datumPosete) {
        this.datumPosete = datumPosete;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Ljubimac getLjubimac() {
        return ljubimac;
    }

    public void setLjubimac(Ljubimac ljubimac) {
        this.ljubimac = ljubimac;
    }
}
