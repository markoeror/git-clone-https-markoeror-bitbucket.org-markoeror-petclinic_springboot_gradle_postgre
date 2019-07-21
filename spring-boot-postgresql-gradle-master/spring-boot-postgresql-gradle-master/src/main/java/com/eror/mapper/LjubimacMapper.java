package com.eror.mapper;

import com.eror.dto.LjubimacDTO;
import com.eror.entity.Ljubimac;

import java.util.List;

public interface LjubimacMapper {

    LjubimacDTO toLjubimacDto(Ljubimac ljubimac);

    Ljubimac toLjubimac(LjubimacDTO ljubimacDto);

    List<LjubimacDTO> toLjubimacDtos(List<Ljubimac> list);

    List<Ljubimac> toLjubimac(List<LjubimacDTO> list);
}
