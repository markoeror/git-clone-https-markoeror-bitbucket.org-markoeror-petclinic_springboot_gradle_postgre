package com.eror.service;

import com.eror.dto.PregledDto;
import com.eror.entity.Pregled;

import java.util.List;

public interface PregledService {
    PregledDto sacuvajPregled(Pregled pregled, Integer idTipPregleda);

    List<PregledDto> listaPregledaDTO();
}
