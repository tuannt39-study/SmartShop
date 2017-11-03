package vn.its.rest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.its.rest.dao.FeedBackDAO;
import vn.its.rest.model.FeedBack;

@Repository
public class FeedBackDAOImpl implements FeedBackDAO{
	
	@Autowired
	private SessionFactory sessionFactory; 

	@Override
	public List<FeedBack> findAllFeedBack() {
		List<FeedBack> listFeedBack = new ArrayList<>();
		String sql = "from FeedBack";
		Session session = sessionFactory.getCurrentSession();
		listFeedBack = session.createQuery(sql, FeedBack.class).list();
		return listFeedBack;
	}

	@Override
	public FeedBack findFeedBackById(long id) {
		Session session = sessionFactory.getCurrentSession();
		FeedBack feedBackById = session.get(FeedBack.class, id);
		if (feedBackById == null) {
			return null;
		}
		return feedBackById;
	}

	@Override
	public void addFeedBack(FeedBack feedBack) {
		Session session = sessionFactory.getCurrentSession();
		session.save(feedBack);
	}

	@Override
	public void updateFeedBack(FeedBack feedBack) {
		Session session = sessionFactory.getCurrentSession();
		session.update(feedBack);
	}

	@Override
	public void deleteFeedBack(long id) {
		Session session = sessionFactory.getCurrentSession();
		FeedBack feedBackById = session.get(FeedBack.class, id);
		if (findFeedBackById(id) != null) {
			session.delete(feedBackById);
		}
	}
}
