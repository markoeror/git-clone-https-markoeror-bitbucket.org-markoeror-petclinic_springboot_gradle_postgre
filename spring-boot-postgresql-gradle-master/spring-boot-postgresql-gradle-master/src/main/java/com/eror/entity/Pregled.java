package com.eror.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pregled extends ImeEntity {

    private Double cena;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipPregleda")
    private TipPregleda tipPregleda;

    @ManyToMany(mappedBy = "setPregleda")
    private Set<Poseta> setPoseta = new HashSet<>();


    public Set<Poseta> getSetPoseta() {
        return setPoseta;
    }

    public void setSetPoseta(Set<Poseta> setPoseta) {
        this.setPoseta = setPoseta;
    }

    public TipPregleda getTipPregleda() {
        return tipPregleda;
    }

    public void setTipPregleda(TipPregleda tipPregleda) {
        this.tipPregleda = tipPregleda;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }
}
