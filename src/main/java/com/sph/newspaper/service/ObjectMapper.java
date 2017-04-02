package com.sph.newspaper.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class ObjectMapper<T, S> {
	
	@Autowired
	protected ModelMapper modelMapper;	
	
	public abstract T convertToDto(S source);
	
	public abstract S convertToEntity(T source);

	public abstract List<T> convertToDtoList(List<S> source);
	
	public abstract List<S> convertToEntityList(List<T> source);
}
