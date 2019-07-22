package com.eror.mapper;

import com.eror.dto.TipPregledaDTO;
import com.eror.entity.Pregled;
import com.eror.entity.TipPregleda;

import java.util.List;

public interface TipPregledaMapper {

    public TipPregledaDTO toTipPregledaDTO(TipPregleda tipPregleda);
    public Pregled toTipPregleda(TipPregledaDTO tipPregledaDTO);
    public List<TipPregledaDTO> listTipPregledaDTO(List<TipPregleda> list);
}
