package com.eror.mapper.impl;

import com.eror.dto.SpecijalnostDTO;
import com.eror.entity.Specijalnost;
import com.eror.mapper.SpecijalnostMapper;
import org.springframework.stereotype.Component;

@Component
public class SpecijanostMapperImp implements SpecijalnostMapper {
    @Override
    public SpecijalnostDTO toSpecijalnostDto(Specijalnost specijalnost) {
        SpecijalnostDTO specijalnostDTO = new SpecijalnostDTO();
        specijalnostDTO.setId(specijalnost.getId());
        specijalnostDTO.setIme(specijalnost.getIme());
        return  specijalnostDTO;

    }

    @Override
    public Specijalnost toSpecijalnost(SpecijalnostDTO specijalnostDTO) {
        Specijalnost specijalnost= new Specijalnost();
        specijalnost.setId(specijalnostDTO.getId());
        specijalnost.setIme(specijalnost.getIme());
        return specijalnost;
    }
}
