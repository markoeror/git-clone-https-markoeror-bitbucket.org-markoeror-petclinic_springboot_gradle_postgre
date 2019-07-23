package com.eror.dto;

import com.eror.entity.Veterinar;

public interface VeterinarFasada {
    Veterinar kreirajVeterinara(Veterinar veterinar, Integer idSpecijalizacije);
}
