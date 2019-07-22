package com.eror.mapper;

import com.eror.dto.PregledDto;
import com.eror.entity.Pregled;

import java.time.Period;
import java.util.List;

public interface PregledMapper {

    public PregledDto toPregledDTO(Pregled pregled);

    public List<PregledDto> toPregledDTOS(List<Pregled>list);
}
