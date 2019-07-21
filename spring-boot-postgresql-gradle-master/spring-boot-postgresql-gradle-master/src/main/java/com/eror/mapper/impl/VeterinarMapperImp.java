package com.eror.mapper.impl;

import com.eror.dto.VeterinarDTO;
import com.eror.entity.Veterinar;
import com.eror.mapper.VeterinarMapper;

public class VeterinarMapperImp implements VeterinarMapper {
    @Override
    public Veterinar toVeterinar(VeterinarDTO veterinarDTO) {
        Veterinar veterinar = new Veterinar();
        veterinar.setId(veterinarDTO.getId());
        veterinar.setIme(veterinarDTO.getIme());
        return veterinar;
    }

    @Override
    public VeterinarDTO toVeterinarDTO(Veterinar veterinar) {
        VeterinarDTO veterinarDTO = new VeterinarDTO();
        veterinarDTO.setId(veterinar.getId());
        veterinarDTO.setIme(veterinar.getIme());
        return veterinarDTO;
    }
}
