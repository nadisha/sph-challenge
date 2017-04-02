package com.sph.newspaper.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sph.newspaper.converter.DtoStringToLocalDateConverter;
import com.sph.newspaper.domain.Article;
import com.sph.newspaper.rest.dto.ArticleDto;
import com.sph.newspaper.service.ArticleService;
import com.sph.newspaper.service.mapper.ArticleMapper;

@RestController
@RequestMapping(value = "/api/articles")
public class ArticleRestController {
	
	@Autowired
	private ArticleService service;
	
	@Autowired
	private ArticleMapper mapper;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<ArticleDto> getAllArticles() {
		try {
			List<Article> articles = service.getAll();
			return mapper.convertToDtoList(articles);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ArticleDto getArticle(@PathVariable String id) {
		try {			
			return mapper.convertToDto(service.getById(id));
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@RequestMapping(value = "{dd-MM-yyyy}/{count}", method = RequestMethod.GET)
	public List<ArticleDto> readArticles(@PathVariable("dd-MM-yyyy") String date, @PathVariable int count) {
		try {			
			DtoStringToLocalDateConverter converter = new DtoStringToLocalDateConverter("dd-MM-yyyy");
			List<Article> articles = service.getByPublishedDateAndCount(converter.convert(date), count);
			return mapper.convertToDtoList(articles);
		} catch (Exception ex) {
			throw ex;
		}
	}	
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ArticleDto saveArticle(@RequestBody ArticleDto articleDto) {
		try {
			Article article = mapper.convertToEntity(articleDto);
			article = service.saveOrUpdate(article);
			return mapper.convertToDto(article);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ArticleDto updateArticle(@PathVariable String id, @RequestBody ArticleDto articleDto) {
		try {
			Article article = mapper.convertToEntity(articleDto);
			article = service.saveOrUpdate(article);
			return mapper.convertToDto(article);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> removeArticle(@PathVariable String id) {
		try {
			service.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception ex) {
			throw ex;
		}
	}
}
