package com.eror.repository;



import java.util.List;
import java.util.Set;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comtrade.entity.Vlasnik;

@Repository
public interface VlasnikRepository extends JpaRepository<Vlasnik, Integer>{

	
	@Query("select v from Vlasnik v")
	Set<Vlasnik> findAllVlasnici();
	
	
	Vlasnik findVlasnikById(Integer id);

	@Query("select v from Vlasnik v where prezime = :prezime")
	List<Vlasnik> findListVlasnikaByPrezime(@Param("prezime") String prezime);


	



}
