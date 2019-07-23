package com.eror.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pregled extends ImeEntity {

   private Double cena;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_tipPregleda")
   private TipPregleda tipPregleda;

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
