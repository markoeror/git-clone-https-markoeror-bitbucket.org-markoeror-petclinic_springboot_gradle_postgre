package com.eror.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import com.eror.dto.PosetaDto;
import com.eror.entity.Poseta;
import com.eror.mapper.PosetaMapper;
import org.springframework.stereotype.Component;


@Component
public class PosetaMapperImp implements PosetaMapper {

	@Override
	public List<PosetaDto> listaPosetaDtos(List<Poseta> list) {
		List<PosetaDto> listaPoseta= new ArrayList<PosetaDto>();
		for(Poseta poseta: list) {
			PosetaDto posetaDto= new PosetaDto();
			posetaDto.setIdPosete(poseta.getId());
			posetaDto.setDatum_posete(poseta.getDatumPosete());
			posetaDto.setOpis(poseta.getOpis());
			listaPoseta.add(posetaDto);
		}
		return listaPoseta;
	}

	@Override
	public Poseta toPoseta(PosetaDto posetaDto) {
		Poseta poseta= new Poseta();
		poseta.setId(posetaDto.getIdPosete());
		poseta.setDatumPosete(posetaDto.getDatum_posete());
		poseta.setOpis(posetaDto.getOpis());
		return poseta;
	}

	@Override
	public PosetaDto toPosetaDto(Poseta poseta) {
		PosetaDto posetaDto= new PosetaDto();
		posetaDto.setDatum_posete(poseta.getDatumPosete());
		posetaDto.setIdPosete(poseta.getId());
		posetaDto.setOpis(poseta.getOpis());
		return posetaDto;
	}

}
