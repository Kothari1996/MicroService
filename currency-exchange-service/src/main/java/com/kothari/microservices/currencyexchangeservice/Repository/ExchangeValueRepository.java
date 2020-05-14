package com.kothari.microservices.currencyexchangeservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kothari.microservices.currencyexchangeservice.Entity.ExchangeValue;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long >{

	ExchangeValue findByFromAndTo(String from,String to);
}
