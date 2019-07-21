package com.eror.mapper;

import com.eror.dto.LjubimacTipDTO;
import com.eror.entity.LjubimacTip;
import org.springframework.stereotype.Component;

@Component
public class LjubimacTipMapper {

    public LjubimacTip toLjubimacTip(LjubimacTipDTO ljubimacTipDTO){
        LjubimacTip ljubimacTip= new LjubimacTip();
        ljubimacTip.setId(ljubimacTipDTO.getId());
        ljubimacTip.setIme(ljubimacTipDTO.getNaziv());
        return  ljubimacTip;
    }

    public LjubimacTipDTO toLjubimacTipDTO(LjubimacTip ljubimacTip){
        LjubimacTipDTO ljubimacTipDTO= new LjubimacTipDTO();
        ljubimacTipDTO.setId(ljubimacTip.getId());
        ljubimacTipDTO.setNaziv(ljubimacTip.getIme());
        return ljubimacTipDTO;
    }
}

