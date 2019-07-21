package com.eror.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class PosetaDto {

    private int idPosete;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate datumPosete;
    private String opis;

    public int getIdPosete() {
        return idPosete;
    }

    public void setIdPosete(int idPosete) {
        this.idPosete = idPosete;
    }

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
}
