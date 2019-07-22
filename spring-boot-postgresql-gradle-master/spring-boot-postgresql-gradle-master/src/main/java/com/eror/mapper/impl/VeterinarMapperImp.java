package com.eror.mapper.impl;

import com.eror.dto.VeterinarDTO;
import com.eror.entity.Ljubimac;
import com.eror.entity.Veterinar;
import com.eror.mapper.LjubimacMapper;
import com.eror.mapper.VeterinarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        List<Ljubimac> listLjubimaca= new ArrayList<>();
        listLjubimaca.addAll(veterinar.getSetLjubimaca());
        veterinarDTO.setListLjubDto(ljubimacMapper.toLjubimacDtos(listLjubimaca));
        return veterinarDTO;
    }

    @Override
    public VeterinarDTO toVeterinarDTOPosete(Veterinar veterinar) {
        VeterinarDTO veterinarDTO = new VeterinarDTO();
        veterinarDTO.setId(veterinar.getId());
        veterinarDTO.setIme(veterinar.getIme());
        List<Ljubimac> listLjubimaca= new ArrayList<>();
        listLjubimaca.addAll(veterinar.getSetLjubimaca());
        veterinarDTO.setListLjubDto(ljubimacMapper.toLjubimacDtosPoseta(listLjubimaca));
        return veterinarDTO;
    }
}
