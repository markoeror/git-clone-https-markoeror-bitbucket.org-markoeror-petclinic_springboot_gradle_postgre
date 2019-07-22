package com.eror.mapper.impl;

import com.eror.dto.LjubimacDTO;
import com.eror.dto.PosetaDto;
import com.eror.entity.Ljubimac;
import com.eror.mapper.LjubimacMapper;
import com.eror.mapper.PosetaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class LjubimacMapperImp implements LjubimacMapper {
    private final PosetaMapper posetaMapper;
    @Autowired
    public LjubimacMapperImp(PosetaMapper posetaMapper) {
        this.posetaMapper = posetaMapper;
    }

    @Override
    public LjubimacDTO toLjubimacDto(Ljubimac ljubimac) {
        LjubimacDTO ljubimacDto = new LjubimacDTO();
        ljubimacDto.setId(ljubimac.getId());
        ljubimacDto.setIme(ljubimac.getIme());
        return ljubimacDto;
    }

    @Override
    public LjubimacDTO toLjubimacDtoPosete(Ljubimac ljubimac) {
        LjubimacDTO ljubimacDto = new LjubimacDTO();
        ljubimacDto.setId(ljubimac.getId());
        ljubimacDto.setIme(ljubimac.getIme());
        ljubimacDto.setListaPoseta(posetaMapper.listaPosetaDtos(ljubimac.getListaPoseta()));
        return ljubimacDto;
    }

    @Override
    public Ljubimac toLjubimac(LjubimacDTO ljubimacDto) {
        Ljubimac ljubimac = new Ljubimac();
        ljubimac.setId(ljubimacDto.getId());
        ljubimac.setIme(ljubimacDto.getIme());
        return ljubimac;
    }

    @Override
    public List<LjubimacDTO> toLjubimacDtos(List<Ljubimac> list) {
        List<LjubimacDTO> listLjubimacDto = new ArrayList<LjubimacDTO>();
        for (Ljubimac ljubimac : list) {
            LjubimacDTO ljubimacDto = new LjubimacDTO();
            ljubimacDto.setId(ljubimac.getId());
            ljubimacDto.setIme(ljubimac.getIme());
            listLjubimacDto.add(ljubimacDto);

        }
        return listLjubimacDto;
    }

    @Override
    public List<LjubimacDTO> toLjubimacDtosPoseta(List<Ljubimac> list) {
        List<LjubimacDTO> listLjubimacDto = new ArrayList<LjubimacDTO>();
        for (Ljubimac ljubimac : list) {
            LjubimacDTO ljubimacDto = new LjubimacDTO();
            ljubimacDto.setId(ljubimac.getId());
            ljubimacDto.setIme(ljubimac.getIme());
            ljubimacDto.setListaPoseta(posetaMapper.listaPosetaDtos(ljubimac.getListaPoseta()));
            listLjubimacDto.add(ljubimacDto);

        }
        return listLjubimacDto;
    }

    @Override
    public List<Ljubimac> toLjubimac(List<LjubimacDTO> list) {
        List<Ljubimac> lista = new ArrayList<>();
        for (LjubimacDTO lj : list) {
            Ljubimac ljubimac = new Ljubimac();
            ljubimac.setId(lj.getId());
            ljubimac.setIme(lj.getIme());
            lista.add(ljubimac);
        }
        return lista;
    }

    @Override
    public Set<LjubimacDTO> toLjubimacDTOsSet(Set<Ljubimac> set) {
        Set<LjubimacDTO>setLjubimacaDto= new HashSet<>();
        for (Ljubimac lj: set){
            LjubimacDTO ljubimacDTO= new LjubimacDTO();
            ljubimacDTO.setId(lj.getId());
            ljubimacDTO.setIme(lj.getIme());
            setLjubimacaDto.add(ljubimacDTO);
        }
        return setLjubimacaDto;
    }

}
