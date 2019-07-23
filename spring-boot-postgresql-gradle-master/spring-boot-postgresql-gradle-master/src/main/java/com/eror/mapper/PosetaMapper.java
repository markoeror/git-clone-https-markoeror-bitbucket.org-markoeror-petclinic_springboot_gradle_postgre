package com.eror.mapper;

import com.eror.dto.PosetaDto;
import com.eror.entity.Poseta;

import java.util.List;

public interface PosetaMapper {

    List<PosetaDto> listaPosetaDtos(List<Poseta> list);

    Poseta toPoseta(PosetaDto posetaDto);

    PosetaDto toPosetaDto(Poseta poseta);

    List<PosetaDto> listaPosetaDtosPregledi(List<Poseta>list);


}
