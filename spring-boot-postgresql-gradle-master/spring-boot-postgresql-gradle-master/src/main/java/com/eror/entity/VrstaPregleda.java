package com.eror.entity;

import javax.persistence.Entity;

@Entity
public class VrstaPregleda extends BazniEntitet {
    private Double cena;

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }
}
