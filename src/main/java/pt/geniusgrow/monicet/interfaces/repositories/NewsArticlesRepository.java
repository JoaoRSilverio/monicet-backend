package pt.geniusgrow.monicet.interfaces.repositories;

import pt.geniusgrow.monicet.models.cms.NewsArticle;

import java.util.List;

public interface NewsArticlesRepository {
    List<NewsArticle> getById(List<Long> ids);
    NewsArticle getByTitle(String title);
    Long saveArticle(NewsArticle article);
}
