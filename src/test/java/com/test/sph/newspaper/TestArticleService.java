package com.test.sph.newspaper;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.sph.newspaper.config.ServiceConfig;
import com.sph.newspaper.domain.Article;
import com.sph.newspaper.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class}, loader = AnnotationConfigContextLoader.class)
public class TestArticleService {
	@Autowired
	private ArticleService articleService;
	
	@Test
	public void testArticleSave() {
		LocalDate modifiedDate = LocalDate.of(2017, Month.FEBRUARY, 28);
		LocalDate publishedDate = LocalDate.of(2015, Month.DECEMBER, 20);
		Article article = new Article();
		article.setAuthor("Jessika H. Bottiani");
		article.setContent("Black and White Adolescents’ Perceived Equity, School Belonging, and Adjustment Problems");
		article.setHeadline("A Multilevel Examination of Racial Disparities in High School Discipline");
		article.setModifiedDate(modifiedDate);
		article.setPublication("The Electrochemical Society");
		article.setPublishedDate(publishedDate);
		articleService.saveOrUpdate(article);
	}
	
	
}
