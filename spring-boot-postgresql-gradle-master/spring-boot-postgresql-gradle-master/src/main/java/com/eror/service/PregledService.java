package com.eror.service;

import com.eror.dto.PregledDto;
import com.eror.entity.Pregled;

import java.util.List;

public interface PregledService {
    public PregledDto sacuvajPregled(Pregled pregled, String idTipPregleda);
    public List<PregledDto> listaPregledaDTO(List<Pregled> list);
}
