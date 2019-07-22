package com.eror.dto;

import com.eror.entity.Poseta;

import java.util.List;

public class LjubimacDTO {

    private int id;
    private String ime;
    private List<PosetaDto> listaPoseta;

    public List<PosetaDto> getListaPoseta() {
        return listaPoseta;
    }

    public void setListaPoseta(List<PosetaDto> listaPoseta) {
        this.listaPoseta = listaPoseta;
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
}
