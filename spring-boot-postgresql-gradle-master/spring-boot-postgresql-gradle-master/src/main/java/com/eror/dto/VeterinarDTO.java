package com.eror.dto;

import java.util.List;
import java.util.Set;

public class VeterinarDTO {

    private int id;
    private String ime;
    private Set<LjubimacDTO> setLjubDto;

    public Set<LjubimacDTO> getSetLjubDto() {
        return setLjubDto;
    }

    public void setSetLjubDto(Set<LjubimacDTO> setLjubDto) {
        this.setLjubDto = setLjubDto;
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
