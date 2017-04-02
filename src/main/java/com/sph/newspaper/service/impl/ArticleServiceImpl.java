package com.sph.newspaper.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sph.newspaper.domain.Article;
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
	public Article saveOrUpdate(Article article) {
		if (article.getId() == null) {
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
