package com.sph.newspaper.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.sph.newspaper.domain.Article;

public interface ArticleRepository extends MongoRepository<Article, String> {
	
	List<Article> findByPublishedDateBetween(LocalDateTime from, LocalDateTime to, Pageable pageable);
	
	Article findByCode(String code);
}
