package com.sph.newspaper.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.modelmapper.AbstractConverter;

public class DtoLocalDateTimeToStringConverter extends AbstractConverter<LocalDateTime, String> {
	
	private final String DEFAULT_DATEFORMAT = "dd-MM-yyyy hh:mm a";
	
	private Optional<String> dateformat = Optional.empty();
	
	public DtoLocalDateTimeToStringConverter() {}
	
	public DtoLocalDateTimeToStringConverter(String dateformat) {
		this.dateformat = Optional.ofNullable(dateformat);
	}
	
	@Override
	protected String convert(LocalDateTime source) {
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
