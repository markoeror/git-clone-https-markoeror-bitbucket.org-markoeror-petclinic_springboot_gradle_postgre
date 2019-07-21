package com.eror.service.impl;

import com.eror.dto.PosetaDto;
import com.eror.dto.VlasnikDTO;
import com.eror.entity.Ljubimac;
import com.eror.entity.Poseta;
import com.eror.entity.Vlasnik;
import com.eror.exception.EntityNotFoundException;
import com.eror.exception.EntityServerErrorException;
import com.eror.mapper.PosetaMapper;
import com.eror.mapper.VlasnikMapper;
import com.eror.repository.LjubimacRepository;
import com.eror.repository.PosetaRepository;
import com.eror.repository.VlasnikRepository;
import com.eror.service.PosetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PosetaServiceImp implements PosetaService {

    private final VlasnikRepository vlasnikRepository;
    private final VlasnikMapper vlasnikMapper;
    private final PosetaRepository posetaRepository;
    private final LjubimacRepository ljubimacRepository;
    private final PosetaMapper posetaMapper;

    @Autowired
    public PosetaServiceImp(VlasnikRepository vlasnikRepository, VlasnikMapper vlasnikMapper,
                            PosetaRepository posetaRepository, LjubimacRepository ljubimacRepository, PosetaMapper posetaMapper) {
        super();
        this.vlasnikRepository = vlasnikRepository;
        this.vlasnikMapper = vlasnikMapper;
        this.posetaRepository = posetaRepository;
        this.ljubimacRepository = ljubimacRepository;
        this.posetaMapper = posetaMapper;
    }


    @Override
    @Transactional
    public VlasnikDTO vrati(Integer idVlasnika) {
        Vlasnik vlasnik = vlasnikRepository.findVlasnikById(idVlasnika);
        if (vlasnik == null) throw new EntityNotFoundException("Vlasnik za id ne postoji");

        return vlasnikMapper.toVlasnikDto(vlasnik);
    }

    @Override
    @Transactional
    public void deletePoseta(Integer idPosete) {
        Poseta poseta = posetaRepository.findPosetaById(idPosete);
        if (poseta == null) throw new EntityNotFoundException("Ne postoji poseta za Id");
        posetaRepository.delete(poseta);
    }


    @Override
    @Transactional
    public PosetaDto update(PosetaDto posetaDto, Integer idLjubimca) {
        Ljubimac ljubimac = ljubimacRepository.findLjubimacById(idLjubimca);
        if (ljubimac == null) throw new EntityNotFoundException("Ljubimac sa tim Idjem ne postoji");
        Poseta poseta = posetaMapper.toPoseta(posetaDto);
        poseta.setLjubimac(ljubimac);
        try {
            poseta = posetaRepository.save(poseta);
        } catch (Exception e) {
            throw new EntityServerErrorException("Nisu updejtovani podaci");
        }

        return posetaMapper.toPosetaDto(poseta);
    }

    @Override
    @Transactional
    public PosetaDto savePoseta(Poseta poseta, Integer idLjubimca) {
        Ljubimac ljubimac = ljubimacRepository.findLjubimacById(idLjubimca);
        if (ljubimac == null) throw new EntityNotFoundException("Ljubimac sa tim Id-jem ne postoji");
        poseta.setLjubimac(ljubimac);
        try {
            poseta = posetaRepository.save(poseta);
        } catch (Exception e) {
            throw new EntityServerErrorException("Nije sacuvana poseta");
        }
        return posetaMapper.toPosetaDto(poseta);

    }


}
