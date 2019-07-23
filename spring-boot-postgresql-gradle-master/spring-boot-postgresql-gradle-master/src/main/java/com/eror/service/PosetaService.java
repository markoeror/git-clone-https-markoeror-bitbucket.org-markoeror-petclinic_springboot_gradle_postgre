package com.eror.service;


import com.eror.dto.PosetaDto;
import com.eror.dto.VlasnikDTO;
import com.eror.entity.Poseta;

import java.util.List;


public interface PosetaService {

    VlasnikDTO vrati(Integer idVlasnika);

    void deletePoseta(Integer idPosete);

    PosetaDto update(PosetaDto posetaDto, Integer idLjubimca);


    PosetaDto savePoseta(Poseta poseta, Integer idLjubimca);

    List<PosetaDto> findAll();
}
