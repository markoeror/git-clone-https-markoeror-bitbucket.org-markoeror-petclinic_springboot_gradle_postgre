package com.eror.mapper.impl;

import com.eror.dto.LjubimacTipDTO;
import com.eror.entity.LjubimacTip;
import com.eror.mapper.LjubimacTipMapper;
import org.springframework.stereotype.Component;

@Component
public class LjubimacTipMapperImp implements LjubimacTipMapper {
    @Override
    public LjubimacTip toLjubimacTip(LjubimacTipDTO ljubimacTipDTO) {
        LjubimacTip ljubimacTip = new LjubimacTip();
        ljubimacTip.setId(ljubimacTipDTO.getId());
        ljubimacTip.setIme(ljubimacTipDTO.getNaziv());
        return ljubimacTip;
    }

    @Override
    public LjubimacTipDTO toLjubimacTipDTO(LjubimacTip ljubimacTip) {
        LjubimacTipDTO ljubimacTipDTO = new LjubimacTipDTO();
        ljubimacTipDTO.setId(ljubimacTip.getId());
        ljubimacTipDTO.setNaziv(ljubimacTip.getIme());
        return ljubimacTipDTO;
    }
}

