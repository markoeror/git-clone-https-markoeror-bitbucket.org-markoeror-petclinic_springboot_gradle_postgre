package com.eror.mapper;

import com.eror.dto.LjubimacTipDTO;
import com.eror.entity.LjubimacTip;

public interface LjubimacTipMapper {

    public LjubimacTip toLjubimacTip(LjubimacTipDTO ljubimacTipDTO);
    public LjubimacTipDTO toLjubimacTipDTO(LjubimacTip ljubimacTip);
}
