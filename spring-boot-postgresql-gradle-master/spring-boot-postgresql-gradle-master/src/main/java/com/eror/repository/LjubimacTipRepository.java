package com.eror.repository;

import com.eror.entity.LjubimacTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LjubimacTipRepository extends JpaRepository<LjubimacTip, Integer> {

	LjubimacTip findLjubimacTipById(Integer idLjubimacTip);

}
