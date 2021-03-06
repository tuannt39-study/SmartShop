package vn.its.rest.dao;

import java.util.List;

import vn.its.rest.model.News;

public interface NewsDAO {

	public List<News> findAllNews();

	public List<News> findNewsByTitlte(String title);

	public News findNewsById(long Id);

	public void addNews(News news);

	public void updateNews(News news);

	public void deleteNews(long id);

	public boolean isNewsExist(News news);
}
