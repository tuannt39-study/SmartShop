package vn.its.rest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.its.rest.dao.NewsDAO;
import vn.its.rest.model.News;

@Repository
public class NewsDAOImpl implements NewsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<News> findAllNews() {
		List<News> listNews = new ArrayList<>();
		String sql = "from News";
		Session session = sessionFactory.getCurrentSession();
		listNews = session.createQuery(sql, News.class).list();
		return listNews;
	}

	@Override
	public List<News> findNewsByTitlte(String title) {
		List<News> news = new ArrayList<>();
		for (News listNews : findAllNews()) {
			String titleTemp = listNews.getTitle();
			if (titleTemp.contains(title)) {
				news.add(listNews);
				return news;
			}
		}
		return null;
	}

	@Override
	public News findNewsById(long id) {
		Session session = sessionFactory.getCurrentSession();
		News news = session.get(News.class, id);
		if (news == null) {
			return null;
		}
		return news;
	}

	@Override
	public void addNews(News news) {
		Session session = sessionFactory.getCurrentSession();
		session.save(news);
	}

	@Override
	public void updateNews(News news) {
		Session session = sessionFactory.getCurrentSession();
		session.update(news);
	}

	@Override
	public void deleteNews(long id) {
		Session session = sessionFactory.getCurrentSession();
		News news = session.get(News.class, id);
		if (findNewsById(id) != null) {
			session.delete(news);
		}
	}

	@Override
	public boolean isNewsExist(News news) {
		if (findNewsByTitlte(news.getTitle()) != null) {
			return true;
		} else {
			return false;
		}
	}

}
