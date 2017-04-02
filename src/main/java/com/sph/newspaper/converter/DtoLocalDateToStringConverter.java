package com.sph.newspaper.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.modelmapper.AbstractConverter;

public class DtoLocalDateToStringConverter extends AbstractConverter<LocalDate, String> {
	
	private final String DEFAULT_DATEFORMAT = "dd-MM-yyyy";
	
	private Optional<String> dateformat = Optional.empty();
	
	public DtoLocalDateToStringConverter() {}
	
	public DtoLocalDateToStringConverter(String dateformat) {
		this.dateformat = Optional.ofNullable(dateformat);
	}
	
	@Override
	protected String convert(LocalDate source) {
		if (source == null) {
			return null;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_DATEFORMAT);
		if (this.dateformat.get().length() > 0) {
			formatter = DateTimeFormatter.ofPattern(this.dateformat.get());
		}
		return source.format(formatter);
	}

	public void setDateformat(String dateformat) {
		this.dateformat = Optional.of(dateformat);
	}
}
