package com.eror.mapper.impl;

import com.eror.dto.TipPregledaDTO;
import com.eror.entity.Pregled;
import com.eror.entity.TipPregleda;
import com.eror.mapper.TipPregledaMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TipPregledaMapperImp implements TipPregledaMapper {
    @Override
    public TipPregledaDTO toTipPregledaDTO(TipPregleda tipPregleda) {
        TipPregledaDTO tipPregledaDTO = new TipPregledaDTO();
        tipPregledaDTO.setId(tipPregleda.getId());
        tipPregledaDTO.setIme(tipPregleda.getIme());
        return tipPregledaDTO;
    }

    @Override
    public Pregled toTipPregleda(TipPregledaDTO tipPregledaDTO) {
        Pregled tipPregleda = new Pregled();
        tipPregleda.setIme(tipPregledaDTO.getIme());
        tipPregleda.setId(tipPregledaDTO.getId());
        return tipPregleda;
    }

    @Override
    public List<TipPregledaDTO> listTipPregledaDTO(List<TipPregleda> list) {
        List<TipPregledaDTO> listaTipaPregledaDTO = new ArrayList<>();
        for (TipPregleda tipPregleda : list) {
            TipPregledaDTO tipPregledaDTO = new TipPregledaDTO();
            tipPregledaDTO.setId(tipPregleda.getId());
            tipPregledaDTO.setIme(tipPregleda.getIme());
            listaTipaPregledaDTO.add(tipPregledaDTO);
        }
        return listaTipaPregledaDTO;
    }
}
