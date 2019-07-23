package com.eror.service;

import com.eror.dto.SpecijalnostDTO;
import com.eror.entity.Specijalnost;

import java.util.List;

public interface SpecijalnostService {

    Specijalnost kreirajSpecijalnost(Specijalnost specijalnost);

    List<SpecijalnostDTO> listaSpecijalnost();
}
