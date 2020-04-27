package com.ritesh.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritesh.microservices.limitsservice.bean.LimitsConfiguration;

@RestController
public class LimitsConfigurationController {
	@Autowired
	private Configuration configration;

	@GetMapping("/limits")
	public LimitsConfiguration retriveLimitsFromConfiguration() {

		return new LimitsConfiguration(configration.getMaximum(), configration.getMinimum());

	}

}
