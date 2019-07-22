package com.eror.mapper;

import com.eror.dto.VeterinarDTO;
import com.eror.entity.Veterinar;

public interface VeterinarMapper {
    public Veterinar toVeterinar(VeterinarDTO veterinarDTO);

    public VeterinarDTO toVeterinarDTO(Veterinar veterinar);

    public VeterinarDTO toVeterinarDTOPosete(Veterinar veterinar);

}
