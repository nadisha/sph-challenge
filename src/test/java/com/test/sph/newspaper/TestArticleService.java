package com.test.sph.newspaper;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.sph.newspaper.config.ServiceConfig;
import com.sph.newspaper.domain.Article;
import com.sph.newspaper.exception.ApplicationException;
import com.sph.newspaper.exception.ArticleAlreadyExistException;
import com.sph.newspaper.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class}, loader = AnnotationConfigContextLoader.class)
public class TestArticleService {
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	private final int RECORD_COUNT = 5;
	
	@Before
	public void before(){
		mongoTemplate.insert(ArticleMockData.getArticles(RECORD_COUNT), Article.class);
	}
	
	@After
	public void after(){		
		mongoTemplate.remove(Query.query(Criteria.where("author").is(ArticleMockData.AUTHOR)), Article.class);
	}
	
	@Test
	public void testArticleSave() throws ApplicationException{
		Article newArticle = ArticleMockData.getNew();
		newArticle = articleService.saveOrUpdate(newArticle);
		assertNotNull("New Article id should not be null", newArticle.getId());		
	}
	
	@Test
	public void testArticleAlreadyExist() {
		Article newArticle = ArticleMockData.getNew();
		try {
			articleService.saveOrUpdate(newArticle);
		} catch (ApplicationException ex) {
			ex.printStackTrace();
		}
		
		Article anotherArticle = ArticleMockData.getNew();
		try {
			articleService.saveOrUpdate(anotherArticle);
		} catch (ApplicationException ex) {
			assertTrue("Exception shouble be ArticleAlreadyExistException", ex instanceof ArticleAlreadyExistException);
		}
	}
	
	@Test
	public void testArticleUpdate()  throws ApplicationException{
		Article article = mongoTemplate.findOne(Query.query(Criteria.where("code").is(ArticleMockData.CODE + 1)), Article.class);
		String newCode = "NEW CODE";
		article.setCode(newCode);
		article =  articleService.saveOrUpdate(article);
		assertEquals("Before and after update the code shouble be identical", newCode, article.getCode());
	}	
	
	@Test
	public void testArticleGetById() {
		Article article = mongoTemplate.findOne(Query.query(Criteria.where("code").is(ArticleMockData.CODE + 1)), Article.class);
		Article other = articleService.getById(article.getId());
		assertEquals("Article document IDs shouble be identical", article.getId(), other.getId());
	}
	
	@Test
	public void testArticleRemove() {
		Article article = mongoTemplate.findOne(Query.query(Criteria.where("code").is(ArticleMockData.CODE + 1)), Article.class);
		articleService.remove(article.getId());
		Article other = articleService.getById(article.getId());
		assertNull("Aricle is not longer exist after delete", other);
	}
	
	@Test
	public void testArticleGetByDateAndCount() {
		LocalDate publishedDate = LocalDate.of(2017, Month.MARCH, 31);
		List<Article> articles = articleService.getByPublishedDateAndCount(publishedDate, RECORD_COUNT);
		assertEquals("There shoule be " + RECORD_COUNT + " articles available", RECORD_COUNT, articles.size());
	}
}
