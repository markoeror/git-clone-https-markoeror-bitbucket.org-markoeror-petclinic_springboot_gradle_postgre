package com.eror.service;

import com.eror.dto.TipPregledaDTO;
import com.eror.entity.Pregled;
import com.eror.entity.TipPregleda;

import java.util.List;

public interface TipPregledaService {
    public TipPregledaDTO sacuvajTipPregleda(TipPregleda tipPregleda);
    public List<TipPregleda> listaTipPregleda();
}
