package com.eror.mapper.impl;



import com.eror.dto.VlasnikDto;
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
	public VlasnikDto toVlasnikDto(Vlasnik vlasnik) {
		VlasnikDto vlasnikDto= new VlasnikDto();
		vlasnikDto.setId(vlasnik.getId());
		vlasnikDto.setImeVlasnika(vlasnik.getIme());
		vlasnikDto.setListaLjubDto(ljubimacMapper.toLjubimacDtos(vlasnik.getListLjubimac()));
		return vlasnikDto;
	}

}
