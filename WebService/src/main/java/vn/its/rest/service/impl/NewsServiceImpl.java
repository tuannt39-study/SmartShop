package vn.its.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.its.rest.dao.NewsDAO;
import vn.its.rest.model.News;
import vn.its.rest.service.NewsService;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDAO newsDAO;

	@Override
	public List<News> findAllNews() {

		return newsDAO.findAllNews();
	}

	@Override
	public List<News> searchNewsByTitlte(String title) {

		return newsDAO.searchNewsByTitlte(title);
	}

	@Override
	public News searchNewsById(long id) {

		return newsDAO.searchNewsById(id);
	}

	@Override
	public void addNews(News news) {

		newsDAO.addNews(news);

	}

	@Override
	public void updateNews(News news) {

		newsDAO.updateNews(news);
	}

	@Override
	public void deleteNews(long id) {

		newsDAO.deleteNews(id);
	}

	@Override
	public boolean isNewsExist(News news) {

		return newsDAO.isNewsExist(news);
	}

}
