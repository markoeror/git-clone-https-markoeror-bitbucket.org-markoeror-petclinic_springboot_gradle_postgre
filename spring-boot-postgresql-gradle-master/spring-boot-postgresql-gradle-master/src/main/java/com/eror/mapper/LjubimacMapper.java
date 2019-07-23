package com.eror.mapper;

import com.eror.dto.LjubimacDTO;
import com.eror.entity.Ljubimac;

import java.util.List;
import java.util.Set;

public interface LjubimacMapper {

    LjubimacDTO toLjubimacDto(Ljubimac ljubimac);

    LjubimacDTO toLjubimacDtoPosete(Ljubimac ljubimac);

    Ljubimac toLjubimac(LjubimacDTO ljubimacDto);

    List<LjubimacDTO> toLjubimacDtos(List<Ljubimac> list);

    List<Ljubimac> toLjubimac(List<LjubimacDTO> list);

    List<LjubimacDTO> toLjubimacDtosPoseta(List<Ljubimac> list);

    Set<LjubimacDTO> toLjubimacDTOsSet(Set<Ljubimac> list);


}
