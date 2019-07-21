package com.eror.mapper;

import java.util.ArrayList;
import java.util.List;

import com.eror.dto.LjubimacDto;
import com.eror.entity.Ljubimac;
import org.springframework.stereotype.Component;


@Component
public class LjubimacMapperImp implements LjubimacMapper {
	
	@Override
	public LjubimacDto toLjubimacDto(Ljubimac ljubimac) {
		LjubimacDto ljubimacDto= new LjubimacDto();
		ljubimacDto.setId(ljubimac.getId());
		ljubimacDto.setNaziv(ljubimac.getIme());
		return ljubimacDto;
	}

	@Override
	public List<LjubimacDto> toLjubimacDtos(List<Ljubimac> list) {
		List<LjubimacDto>listLjubimacDto= new ArrayList<LjubimacDto>();	
		for(Ljubimac ljubimac: list) {
			LjubimacDto ljubimacDto= new LjubimacDto();
			ljubimacDto.setId(ljubimac.getId());
			ljubimacDto.setNaziv(ljubimac.getIme());
			listLjubimacDto.add(ljubimacDto);
		}
		return listLjubimacDto;
	}

	@Override
	public Ljubimac toLjubimac(LjubimacDto ljubimacDto) {
		Ljubimac ljubimac= new Ljubimac();
		ljubimac.setId(ljubimacDto.getId());
		ljubimac.setIme(ljubimacDto.getNaziv());
		return ljubimac;
	}

	@Override
	public List<Ljubimac> toLjubimac(List<LjubimacDto> list) {
		List<Ljubimac>lista= new ArrayList<>();
		for(LjubimacDto lj:list) {
			Ljubimac ljubimac= new Ljubimac();
			ljubimac.setId(lj.getId());
			ljubimac.setIme(lj.getNaziv());
			lista.add(ljubimac);
		}
		return lista;
	}

}
