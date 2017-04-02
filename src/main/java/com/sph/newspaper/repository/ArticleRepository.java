package com.sph.newspaper.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sph.newspaper.domain.Article;

public interface ArticleRepository extends MongoRepository<Article, String> {

}
