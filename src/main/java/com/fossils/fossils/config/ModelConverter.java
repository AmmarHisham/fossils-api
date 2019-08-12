package com.fossils.fossils.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConverter {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
