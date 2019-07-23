package com.eror.mapper.impl;

import com.eror.dto.PosetaDto;
import com.eror.dto.PregledDto;
import com.eror.entity.Poseta;
import com.eror.entity.Pregled;
import com.eror.mapper.PosetaMapper;
import com.eror.mapper.PregledMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Component
public class PosetaMapperImp implements PosetaMapper {

    private final PregledMapper pregledMapper;
    @Autowired
    public PosetaMapperImp(PregledMapper pregledMapper) {
        this.pregledMapper = pregledMapper;
    }

    @Override
    public List<PosetaDto> listaPosetaDtos(List<Poseta> list) {
        List<PosetaDto> listaPoseta = new ArrayList<PosetaDto>();
        for (Poseta poseta : list) {
            PosetaDto posetaDto = new PosetaDto();
            posetaDto.setIdPosete(poseta.getId());
            posetaDto.setDatumPosete(poseta.getDatumPosete());
            posetaDto.setOpis(poseta.getOpis());
            listaPoseta.add(posetaDto);
        }
        return listaPoseta;
    }

    @Override
    public List<PosetaDto> listaPosetaDtosPregledi(List<Poseta> list) {
        List<PosetaDto>listPosetaDTO= new ArrayList<>();
        for(Poseta poseta:list){
            PosetaDto posetaDto= new PosetaDto();
            posetaDto.setIdPosete(poseta.getId());
            posetaDto.setDatumPosete(poseta.getDatumPosete());
            posetaDto.setOpis(poseta.getOpis());
            List<Pregled>listaPregleda= new ArrayList<Pregled>();
            Set<Pregled> setPregleda= poseta.getSetPregleda();
            listaPregleda.addAll(setPregleda);
            posetaDto.setListaPregledaDto(pregledMapper.toPregledDTOS(listaPregleda));
            listPosetaDTO.add(posetaDto);
        }
        return listPosetaDTO;
    }

    @Override
    public Poseta toPoseta(PosetaDto posetaDto) {
        Poseta poseta = new Poseta();
        poseta.setId(posetaDto.getIdPosete());
        poseta.setDatumPosete(posetaDto.getDatumPosete());
        poseta.setOpis(posetaDto.getOpis());
        return poseta;
    }

    @Override
    public PosetaDto toPosetaDto(Poseta poseta) {
        PosetaDto posetaDto = new PosetaDto();
        posetaDto.setDatumPosete(poseta.getDatumPosete());
        posetaDto.setIdPosete(poseta.getId());
        posetaDto.setOpis(poseta.getOpis());
        return posetaDto;
    }


}
