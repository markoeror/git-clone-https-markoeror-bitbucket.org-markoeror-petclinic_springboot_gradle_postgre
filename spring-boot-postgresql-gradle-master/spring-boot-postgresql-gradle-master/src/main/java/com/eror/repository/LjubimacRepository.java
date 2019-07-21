package com.eror.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comtrade.entity.Ljubimac;
@Repository
public interface LjubimacRepository extends JpaRepository<Ljubimac, Integer> {

}
