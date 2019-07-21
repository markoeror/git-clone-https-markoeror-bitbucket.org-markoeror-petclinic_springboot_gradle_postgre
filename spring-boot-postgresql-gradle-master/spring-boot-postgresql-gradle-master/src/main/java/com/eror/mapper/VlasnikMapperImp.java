package com.eror.mapper;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.comtrade.dto.VlasnikDto;
import com.comtrade.entity.Vlasnik;
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
