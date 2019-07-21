package com.eror.dto;

import com.eror.entity.Veterinar;

public interface VeterinarFasada {
    public Veterinar kreirajVeterinara(Veterinar veterinar, Integer idSpecijalizacije, Integer idLjubimca);
}
