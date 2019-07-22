package com.eror.service.impl;

import com.eror.dto.TipPregledaDTO;
import com.eror.entity.Pregled;
import com.eror.entity.TipPregleda;
import com.eror.mapper.TipPregledaMapper;
import com.eror.repository.TipPregledaRepository;
import com.eror.service.TipPregledaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TipPregledaServiceImp implements TipPregledaService {
    private final TipPregledaRepository tipPregledaRepository;
    private final TipPregledaMapper tipPregledaMapper;
    @Autowired
    public TipPregledaServiceImp(TipPregledaRepository tipPregledaRepository,TipPregledaMapper tipPregledaMapper) {
        this.tipPregledaRepository = tipPregledaRepository;
        this.tipPregledaMapper=tipPregledaMapper;
    }

    @Override
    @Transactional
    public TipPregledaDTO sacuvajTipPregleda(TipPregleda tipPregleda) {
        tipPregledaRepository.save(tipPregleda);
        TipPregledaDTO tipPregledaDTO=tipPregledaMapper.toTipPregledaDTO(tipPregleda);
        return tipPregledaDTO;
    }


    @Override
    @Transactional
    public List<TipPregleda> listaTipPregleda() {
        return null;
    }
}
