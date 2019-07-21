package com.eror.mapper;

import com.eror.dto.SpecijalnostDTO;
import com.eror.entity.Specijalnost;

public interface SpecijalnostMapper {

    public SpecijalnostDTO toSpecijalnostDto(Specijalnost specijalnost);
    public Specijalnost toSpecijalnost(SpecijalnostDTO specijalnostDTO);
}
