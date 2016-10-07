package com.msa04.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.msa04.documents.EuroRate;

@RepositoryRestResource (path = "eurorates")
public interface EuroRatesRepository extends MongoRepository<EuroRate, String> {

	public List<EuroRate> findAll();
	public List<EuroRate> findByDate(@Param("date") String date);
	public EuroRate findByDateAndCurrency(@Param("date")String date, @Param("currency")String currency);
	
}