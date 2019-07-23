package com.eror.service;

import com.eror.dto.TipPregledaDTO;
import com.eror.entity.TipPregleda;

import java.util.List;

public interface TipPregledaService {
    TipPregledaDTO sacuvajTipPregleda(TipPregleda tipPregleda);

    List<TipPregleda> listaTipPregleda();

    TipPregleda findTipPregledaById(Integer id);
}
