package com.eror.mapper;

import java.util.List;

import com.eror.dto.LjubimacDTO;
import com.eror.entity.Ljubimac;

public interface LjubimacMapper {

	LjubimacDTO toLjubimacDto(Ljubimac ljubimac);
	Ljubimac toLjubimac(LjubimacDTO ljubimacDto);
	List<LjubimacDTO> toLjubimacDtos(List<Ljubimac> list);
	List<Ljubimac>toLjubimac(List<LjubimacDTO> list);
}
