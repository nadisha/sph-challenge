package com.sph.newspaper.service.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sph.newspaper.domain.Article;
import com.sph.newspaper.rest.dto.ArticleDto;
import com.sph.newspaper.service.ObjectMapper;

@Service
public class ArticleMapper extends ObjectMapper<ArticleDto, Article> {

	@Override
	public ArticleDto convertToDto(Article source) {
		return modelMapper.map(source, ArticleDto.class);
	}

	@Override
	public Article convertToEntity(ArticleDto source) {
		return modelMapper.map(source, Article.class);
	}

	@Override
	public List<ArticleDto> convertToDtoList(List<Article> source) {
		List<ArticleDto> dtos = new ArrayList<>();
		if (source != null && !source.isEmpty()) {
			dtos = source.stream().map(s -> convertToDto(s)).collect(Collectors.toList());
		}
		return dtos;
	}

	@Override
	public List<Article> convertToEntityList(List<ArticleDto> source) {
		List<Article> entities = new ArrayList<>();
		if (source != null && !source.isEmpty()) {
			entities = source.stream().map(s -> convertToEntity(s)).collect(Collectors.toList());
		}
		return entities;
	}

}
