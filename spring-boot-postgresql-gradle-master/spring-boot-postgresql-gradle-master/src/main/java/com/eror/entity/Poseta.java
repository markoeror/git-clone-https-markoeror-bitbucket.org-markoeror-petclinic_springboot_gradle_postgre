package com.eror.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Poseta extends BazniEntitet {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datumPosete;
    private String opis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ljubimca")
    private Ljubimac ljubimac;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "poseta_pregled", joinColumns = @JoinColumn(name = "id_posete"), inverseJoinColumns = @JoinColumn(name = "id_pregleda"))
    private Set<Pregled> setPregleda = new HashSet<>();


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

    public Set<Pregled> getSetPregleda() {
        return setPregleda;
    }

    public void setSetPregleda(Set<Pregled> setPregleda) {
        this.setPregleda = setPregleda;
    }

    //Metode za sinhronizaciju poseta i pregleda
    public void addPregled(Pregled pregled) {
        setPregleda.add(pregled);
        pregled.getSetPoseta().add(this);
    }

    public void removePregled(Pregled pregled) {
        setPregleda.remove(pregled);
        pregled.getSetPoseta().remove(this);
    }
}

