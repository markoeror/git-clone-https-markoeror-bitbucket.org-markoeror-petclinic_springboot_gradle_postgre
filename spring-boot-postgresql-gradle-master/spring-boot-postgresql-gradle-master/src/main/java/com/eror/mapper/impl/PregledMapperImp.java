package com.eror.mapper.impl;

import com.eror.dto.PregledDto;
import com.eror.entity.Pregled;
import com.eror.mapper.PregledMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PregledMapperImp implements PregledMapper {

    @Override
    public PregledDto toPregledDTO(Pregled pregled) {
        PregledDto pregledDto= new PregledDto();
        pregledDto.setId(pregled.getId());
        pregledDto.setIme(pregled.getIme());
        pregledDto.setCena(pregled.getCena());

        return pregledDto;
    }

    @Override
    public List<PregledDto> toPregledDTOS(List<Pregled> list) {
        List<PregledDto> listPregledaDto= new ArrayList<>();
        for (Pregled pregled:list) {
            PregledDto pregledDto= new PregledDto();
            pregledDto.setId(pregled.getId());
            pregledDto.setIme(pregled.getIme());
            pregledDto.setCena(pregled.getCena());
            listPregledaDto.add(pregledDto);
        }
        return listPregledaDto;
    }
}
