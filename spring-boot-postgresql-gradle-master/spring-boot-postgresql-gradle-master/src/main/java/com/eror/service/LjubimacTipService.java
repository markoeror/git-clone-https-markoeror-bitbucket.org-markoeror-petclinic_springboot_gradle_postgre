package com.eror.service;

import com.eror.entity.LjubimacTip;

import java.util.List;

public interface LjubimacTipService {
    public List<LjubimacTip> listaTipovaLjubimaca();

    public LjubimacTip findLjubimacTipById(Integer idLjubimacTip);

    LjubimacTip save(LjubimacTip ljubimacTip);
}
