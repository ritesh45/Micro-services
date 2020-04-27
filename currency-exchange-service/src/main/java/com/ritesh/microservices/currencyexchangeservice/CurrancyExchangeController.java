package com.ritesh.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ritesh.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.ritesh.microservices.currencyexchangeservice.service.ExchangeValueRepository;

@RestController
public class CurrancyExchangeController {
	@Autowired
	private Environment environment;
	@Autowired
	private ExchangeValueRepository exchange;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		// ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to,
		// BigDecimal.valueOf(65));
		ExchangeValue exchangeValue = exchange.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}

}
