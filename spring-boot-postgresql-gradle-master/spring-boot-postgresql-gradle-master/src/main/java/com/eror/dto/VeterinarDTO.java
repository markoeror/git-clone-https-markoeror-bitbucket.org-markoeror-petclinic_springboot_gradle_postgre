package com.eror.dto;

import java.util.List;
import java.util.Set;

public class VeterinarDTO {

    private int id;
    private String ime;
    private List<LjubimacDTO> listLjubDto;

    public List<LjubimacDTO> getListLjubDto() {
        return listLjubDto;
    }

    public void setListLjubDto(List<LjubimacDTO> listLjubDto) {
        this.listLjubDto = listLjubDto;
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
