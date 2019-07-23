package com.eror.service;

import com.eror.entity.LjubimacTip;

import java.util.List;

public interface LjubimacTipService {
    List<LjubimacTip> listaTipovaLjubimaca();

    LjubimacTip findLjubimacTipById(Integer idLjubimacTip);

    LjubimacTip save(LjubimacTip ljubimacTip);
}
