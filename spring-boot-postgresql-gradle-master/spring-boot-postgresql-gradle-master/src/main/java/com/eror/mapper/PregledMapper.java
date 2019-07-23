package com.eror.mapper;

import com.eror.dto.PregledDto;
import com.eror.entity.Pregled;

import java.util.List;

public interface PregledMapper {

    PregledDto toPregledDTO(Pregled pregled);

    List<PregledDto> toPregledDTOS(List<Pregled> list);


}
