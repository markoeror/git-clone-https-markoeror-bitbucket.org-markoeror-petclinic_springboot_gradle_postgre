package com.eror.service;


import com.eror.dto.PosetaDto;
import com.eror.dto.VlasnikDTO;
import com.eror.entity.Poseta;


public interface PosetaService {

    public VlasnikDTO vrati(Integer idVlasnika);

    public void deletePoseta(Integer idPosete);

    public PosetaDto update(PosetaDto posetaDto, Integer idLjubimca);


    public PosetaDto savePoseta(Poseta poseta, Integer idLjubimca);
}
