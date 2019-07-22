package com.eror.service.impl;

import com.eror.dto.PregledDto;
import com.eror.entity.Pregled;
import com.eror.entity.TipPregleda;
import com.eror.mapper.PregledMapper;
import com.eror.repository.PregledRepository;
import com.eror.service.PregledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PregledServiceImp implements PregledService {
    private final PregledRepository pregledRepository;
    private final PregledMapper pregledMapper;
    @Autowired
    public PregledServiceImp(PregledRepository pregledRepository,PregledMapper pregledMapper) {
        this.pregledRepository = pregledRepository;
        this.pregledMapper=pregledMapper;
    }

    @Override
    @Transactional
    public PregledDto sacuvajPregled(Pregled pregled, String idTipPregleda) {
       
        Pregled pregled1= pregledRepository.save(pregled);
        PregledDto pregledDto= pregledMapper.toPregledDTO(pregled1);
        return pregledDto;
    }

    @Override
    @Transactional
    public List<PregledDto> listaPregledaDTO(List<Pregled> list) {
        return null;
    }
}
