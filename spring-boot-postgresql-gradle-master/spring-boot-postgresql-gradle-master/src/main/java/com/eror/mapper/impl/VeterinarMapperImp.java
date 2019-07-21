package com.eror.mapper.impl;

import com.eror.dto.VeterinarDTO;
import com.eror.entity.Veterinar;
import com.eror.mapper.LjubimacMapper;
import com.eror.mapper.VeterinarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VeterinarMapperImp implements VeterinarMapper {
    private final LjubimacMapper ljubimacMapper;
    @Autowired
    public VeterinarMapperImp(LjubimacMapper ljubimacMapper) {
        this.ljubimacMapper = ljubimacMapper;
    }

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
        veterinarDTO.setSetLjubDto(ljubimacMapper.toLjubimacDTOsSet(veterinar.getSetLjubimaca()));
        return veterinarDTO;
    }
}
