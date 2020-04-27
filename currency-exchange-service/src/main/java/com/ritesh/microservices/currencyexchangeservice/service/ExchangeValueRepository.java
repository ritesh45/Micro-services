package com.ritesh.microservices.currencyexchangeservice.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritesh.microservices.currencyexchangeservice.bean.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	ExchangeValue findByFromAndTo(String from, String to);

}
