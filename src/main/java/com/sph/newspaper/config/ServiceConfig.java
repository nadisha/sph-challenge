package com.sph.newspaper.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.sph.newspaper.converter.DtoLocalDateToStringConverter;
import com.sph.newspaper.converter.DtoStringToLocalDateConverter;

@Configuration
@ComponentScan(basePackages = {"com.sph.newspaper.service"})
@Import(value = RepositoryConfig.class)
public class ServiceConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		String dateFormat = env.getProperty("app.date.format");
		DtoLocalDateToStringConverter localDateToStringConv = new DtoLocalDateToStringConverter(dateFormat);
		DtoStringToLocalDateConverter stringToLocalDateConv = new DtoStringToLocalDateConverter(dateFormat);
		modelMapper.addConverter(localDateToStringConv);
		modelMapper.addConverter(stringToLocalDateConv);
		return modelMapper; 
	}
}
