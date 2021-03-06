package vn.its.rest.service;

import java.util.List;

import vn.its.rest.model.News;

public interface NewsService {

	public List<News> findAllNews();

	public List<News> findNewsByTitlte(String title);

	public News findNewsById(long id);

	public void addNews(News news);

	public void updateNews(News news);

	public void deleteNews(long id);

	public boolean isNewsExist(News news);
}
