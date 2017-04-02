package com.sph.newspaper.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.sph.newspaper.domain.Article;

public interface ArticleRepository extends MongoRepository<Article, String> {
	
	List<Article> findByPublishedDate(LocalDate publishedDate, Pageable pageable);
}
