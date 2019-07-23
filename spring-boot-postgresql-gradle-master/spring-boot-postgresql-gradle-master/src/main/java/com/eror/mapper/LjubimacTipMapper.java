package com.eror.mapper;

import com.eror.dto.LjubimacTipDTO;
import com.eror.entity.LjubimacTip;

public interface LjubimacTipMapper {

    LjubimacTip toLjubimacTip(LjubimacTipDTO ljubimacTipDTO);

    LjubimacTipDTO toLjubimacTipDTO(LjubimacTip ljubimacTip);
}
