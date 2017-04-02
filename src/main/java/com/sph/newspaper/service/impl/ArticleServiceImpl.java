package com.sph.newspaper.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sph.newspaper.domain.Article;
import com.sph.newspaper.exception.ApplicationException;
import com.sph.newspaper.exception.ArticleAlreadyExistException;
import com.sph.newspaper.repository.ArticleRepository;
import com.sph.newspaper.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository repository;
	
	@Override
	public List<Article> getAll() {
		return repository.findAll();
	}

	@Override
	public Article getById(String id) {
		return repository.findOne(id);
	}
	
	@Override
	public List<Article> getByPublishedDateAndCount(LocalDate date, int count) {
		PageRequest pageRequest = new PageRequest(0, count);
		return repository.findByPublishedDate(date, pageRequest);
	}

	@Override
	public Article saveOrUpdate(Article article) throws ApplicationException{
		// If the id is NULL, then consider as a new article
		if (article.getId() == null) {
			// Check whether an article is already available for the provided code.
			Article oldArticle = repository.findByCode(article.getCode());
			if (oldArticle != null) {
				throw new ArticleAlreadyExistException("An article is already available for code " + article.getCode());
			}
			article.setPublishedDate(LocalDate.now());
		}
		article.setModifiedDate(LocalDate.now());
		return repository.save(article);
	}

	@Override
	public void remove(String id) {
		repository.delete(id);
	}

}
