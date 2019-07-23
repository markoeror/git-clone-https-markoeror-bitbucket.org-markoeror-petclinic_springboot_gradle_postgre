package com.eror.mapper;

import com.eror.dto.VeterinarDTO;
import com.eror.entity.Veterinar;

public interface VeterinarMapper {
    Veterinar toVeterinar(VeterinarDTO veterinarDTO);

    VeterinarDTO toVeterinarDTO(Veterinar veterinar);

    VeterinarDTO toVeterinarDTOPosete(Veterinar veterinar);

}
