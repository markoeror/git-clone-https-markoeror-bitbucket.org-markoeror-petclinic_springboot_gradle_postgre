package com.eror.mapper.impl;


import com.eror.dto.VlasnikDTO;
import com.eror.entity.Vlasnik;
import com.eror.mapper.LjubimacMapper;
import com.eror.mapper.VlasnikMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VlasnikMapperImp implements VlasnikMapper {
    private final LjubimacMapper ljubimacMapper;

    @Autowired
    public VlasnikMapperImp(LjubimacMapper ljubimacMapper) {
        super();
        this.ljubimacMapper = ljubimacMapper;
    }

    @Override
    public VlasnikDTO toVlasnikDto(Vlasnik vlasnik) {
        VlasnikDTO vlasnikDto = new VlasnikDTO();
        vlasnikDto.setId(vlasnik.getId());
        vlasnikDto.setImeVlasnika(vlasnik.getIme());
        vlasnikDto.setListaLjubDto(ljubimacMapper.toLjubimacDtos(vlasnik.getListLjubimac()));
        return vlasnikDto;
    }

}
