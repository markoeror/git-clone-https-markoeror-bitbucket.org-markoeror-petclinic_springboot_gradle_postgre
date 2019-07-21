package com.eror.mapper;

import java.util.List;

import com.eror.dto.LjubimacDto;
import com.eror.entity.Ljubimac;

public interface LjubimacMapper {

	LjubimacDto toLjubimacDto(Ljubimac ljubimac);
	Ljubimac toLjubimac(LjubimacDto ljubimacDto);
	List<LjubimacDto> toLjubimacDtos(List<Ljubimac> list);
	List<Ljubimac>toLjubimac(List<LjubimacDto> list);
}
