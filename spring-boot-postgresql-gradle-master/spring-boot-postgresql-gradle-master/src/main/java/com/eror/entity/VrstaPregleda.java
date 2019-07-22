package com.eror.entity;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

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
