package com.eror.service;

import java.util.List;
import com.eror.entity.LjubimacTip;

public interface LjubimacTipService {
	public List<LjubimacTip> listaTipovaLjubimaca();

	public LjubimacTip findLjubimacTipById(Integer idLjubimacTip);
}
