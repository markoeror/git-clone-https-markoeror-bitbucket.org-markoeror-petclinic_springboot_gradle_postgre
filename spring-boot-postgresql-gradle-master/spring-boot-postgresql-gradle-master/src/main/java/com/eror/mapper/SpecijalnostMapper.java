package com.eror.mapper;

import com.eror.dto.SpecijalnostDTO;
import com.eror.entity.Specijalnost;

public interface SpecijalnostMapper {

    SpecijalnostDTO toSpecijalnostDto(Specijalnost specijalnost);

    Specijalnost toSpecijalnost(SpecijalnostDTO specijalnostDTO);
}
