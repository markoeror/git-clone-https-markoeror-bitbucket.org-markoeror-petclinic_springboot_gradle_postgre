package com.eror.mapper;

import com.eror.dto.TipPregledaDTO;
import com.eror.entity.Pregled;
import com.eror.entity.TipPregleda;

import java.util.List;

public interface TipPregledaMapper {

    TipPregledaDTO toTipPregledaDTO(TipPregleda tipPregleda);

    Pregled toTipPregleda(TipPregledaDTO tipPregledaDTO);

    List<TipPregledaDTO> listTipPregledaDTO(List<TipPregleda> list);
}
