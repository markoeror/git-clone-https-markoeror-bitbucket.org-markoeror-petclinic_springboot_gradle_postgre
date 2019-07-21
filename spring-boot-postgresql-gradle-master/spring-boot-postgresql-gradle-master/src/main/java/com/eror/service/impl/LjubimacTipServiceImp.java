package com.eror.service.impl;

import java.util.List;

import com.eror.entity.LjubimacTip;
import com.eror.repository.LjubimacTipRepository;
import com.eror.service.LjubimacTipService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LjubimacTipServiceImp implements LjubimacTipService {
	private final LjubimacTipRepository ljubimacTipRepository;
	public LjubimacTipServiceImp(LjubimacTipRepository ljubimacTipRepository) {
		super();
		this.ljubimacTipRepository = ljubimacTipRepository;
	}
	@Override
	@Transactional
	public List<LjubimacTip> listaTipovaLjubimaca() {
		
		return ljubimacTipRepository.findAll();
	}
	@Override
	@Transactional
	public LjubimacTip findLjubimacTipById(Integer idLjubimacTip) {
		// TODO Auto-generated method stub
		return ljubimacTipRepository.findLjubimacTipById(idLjubimacTip);
	}
	@Override
	@Transactional
	public  LjubimacTip save(LjubimacTip ljubimacTip){
		return  ljubimacTipRepository.save(ljubimacTip);
	}
}
