package com.eror.entity;


import javax.persistence.Entity;

@Entity
public class Pregled extends ImeEntity {

   private Double cena;
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
