package com.eror.service.impl;

import com.eror.dto.PregledDto;
import com.eror.entity.Pregled;
import com.eror.entity.TipPregleda;
import com.eror.exception.EntityNotFoundException;
import com.eror.mapper.PregledMapper;
import com.eror.repository.PregledRepository;
import com.eror.service.PregledService;
import com.eror.service.TipPregledaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PregledServiceImp implements PregledService {
    private final PregledRepository pregledRepository;
    private final PregledMapper pregledMapper;
    private final TipPregledaService tipPregledaService;
    @Autowired
    public PregledServiceImp(PregledRepository pregledRepository,PregledMapper pregledMapper,TipPregledaService tipPregledaService) {
        this.pregledRepository = pregledRepository;
        this.pregledMapper=pregledMapper;
        this.tipPregledaService=tipPregledaService;
    }

    @Override
    @Transactional
    public PregledDto sacuvajPregled(Pregled pregled, Integer idTipPregleda) {
        TipPregleda tipPregleda=tipPregledaService.findTipPregledaById(idTipPregleda);
        if(tipPregleda==null) throw new EntityNotFoundException("Ne postoji tip pregleda sa datim Id-jem");
        pregled.setTipPregleda(tipPregleda);
        pregledRepository.save(pregled);
        PregledDto pregledDto= pregledMapper.toPregledDTO(pregled);
        return pregledDto;
    }

    @Override
    @Transactional
    public List<PregledDto> listaPregledaDTO() {
        List<Pregled>listaPregleda= pregledRepository.findAll();
        List<PregledDto> listaPregledaDTO=pregledMapper.toPregledDTOS(listaPregleda);
        return listaPregledaDTO;
    }
}
