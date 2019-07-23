package com.eror.dto;

public class PregledDto {

    private int id;
    private String ime;
    private Double cena;
    private String tipPregleda;


    public String getTipPregleda() {
        return tipPregleda;
    }

    public void setTipPregleda(String tipPregleda) {
        this.tipPregleda = tipPregleda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }
}
