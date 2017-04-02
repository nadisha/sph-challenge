package com.sph.newspaper.service;

import java.time.LocalDate;
import java.util.List;

import com.sph.newspaper.domain.Article;
import com.sph.newspaper.exception.ApplicationException;

public interface ArticleService {
	public List<Article> getAll();
	
	public Article getById(String id);
	
	public List<Article> getByPublishedDateAndCount(LocalDate date, int count);
	
	public Article saveOrUpdate(Article article) throws ApplicationException;
	
	public void remove(String id);
}
