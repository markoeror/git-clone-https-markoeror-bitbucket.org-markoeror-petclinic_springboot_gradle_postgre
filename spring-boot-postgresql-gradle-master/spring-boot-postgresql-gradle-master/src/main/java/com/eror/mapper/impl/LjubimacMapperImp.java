package com.eror.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import com.eror.dto.LjubimacDTO;
import com.eror.entity.Ljubimac;
import com.eror.mapper.LjubimacMapper;
import org.springframework.stereotype.Component;


@Component
public class LjubimacMapperImp implements LjubimacMapper {
	
	@Override
	public LjubimacDTO toLjubimacDto(Ljubimac ljubimac) {
		LjubimacDTO ljubimacDto= new LjubimacDTO();
		ljubimacDto.setId(ljubimac.getId());
		ljubimacDto.setNaziv(ljubimac.getIme());
		return ljubimacDto;
	}

	@Override
	public Ljubimac toLjubimac(LjubimacDTO ljubimacDto) {
		Ljubimac ljubimac= new Ljubimac();
		ljubimac.setId(ljubimacDto.getId());
		ljubimac.setIme(ljubimacDto.getNaziv());
		return ljubimac;
	}
	@Override
	public List<LjubimacDTO> toLjubimacDtos(List<Ljubimac> list) {
		List<LjubimacDTO>listLjubimacDto= new ArrayList<LjubimacDTO>();
		for(Ljubimac ljubimac: list) {
			LjubimacDTO ljubimacDto= new LjubimacDTO();
			ljubimacDto.setId(ljubimac.getId());
			ljubimacDto.setNaziv(ljubimac.getIme());
			listLjubimacDto.add(ljubimacDto);
		}
		return listLjubimacDto;
	}



	@Override
	public List<Ljubimac> toLjubimac(List<LjubimacDTO> list) {
		List<Ljubimac>lista= new ArrayList<>();
		for(LjubimacDTO lj:list) {
			Ljubimac ljubimac= new Ljubimac();
			ljubimac.setId(lj.getId());
			ljubimac.setIme(lj.getNaziv());
			lista.add(ljubimac);
		}
		return lista;
	}

}
