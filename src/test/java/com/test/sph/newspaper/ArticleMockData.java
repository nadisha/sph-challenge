package com.test.sph.newspaper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

import com.sph.newspaper.domain.Article;

public class ArticleMockData {
	public final static String AUTHOR = "TEST";
	public final static String CODE = "CODE_";
	
	public static Article getNew() {
		LocalDateTime modifiedDate = LocalDateTime.of(2017, Month.FEBRUARY, 28, 10, 12);
		LocalDateTime publishedDate = LocalDateTime.of(2015, Month.DECEMBER, 20, 6, 10);
		Article article = new Article();		
		article.setAuthor(AUTHOR);
		article.setCode("CODE_0");
		article.setContent("Black and White Adolescents’ Perceived Equity, School Belonging, and Adjustment Problems");
		article.setHeadline("A Multilevel Examination of Racial Disparities in High School Discipline");
		article.setModifiedDate(modifiedDate);
		article.setPublication("The Electrochemical Society");
		article.setPublishedDate(publishedDate);
		return article;
	}
	
	public static List<Article> getArticles(int count) {
		List<Article> articles = new ArrayList<>();
		LocalDateTime modifiedDate = LocalDateTime.of(2017, Month.MARCH, 31, 01, 20);
		LocalDateTime publishedDate = LocalDateTime.of(2017, Month.MARCH, 31, 01, 20);		
		for (int i = 1; i <= count; i++ ) {
			Article article = new Article();	
			article.setAuthor(AUTHOR);
			article.setCode(CODE + i);
			article.setContent("Sample Content and the content number is " + i);
			article.setHeadline("Article headling number is " + i);
			modifiedDate = modifiedDate.plusMinutes(i*5);
			article.setModifiedDate(modifiedDate);
			article.setPublication("The Electrochemical Society");
			publishedDate = publishedDate.plusMinutes(i*5);
			article.setPublishedDate(publishedDate);
			articles.add(article);
		}
		return articles;
	}
}
