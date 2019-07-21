package com.eror.mapper;

import com.eror.dto.PosetaDto;
import com.eror.entity.Poseta;

import java.util.List;

public interface PosetaMapper {

    public List<PosetaDto> listaPosetaDtos(List<Poseta> list);

    public Poseta toPoseta(PosetaDto posetaDto);

    public PosetaDto toPosetaDto(Poseta poseta);
}
