package vn.its.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.its.rest.dao.FeedBackDAO;
import vn.its.rest.model.FeedBack;
import vn.its.rest.service.FeedBackService;

@Service
@Transactional
public class FeedBackServiceImpl implements FeedBackService{
	
	@Autowired
	private FeedBackDAO feedBackDAO;

	@Override
	public List<FeedBack> findAllFeedBack() {
		return feedBackDAO.findAllFeedBack();
	}

	@Override
	public FeedBack findFeedBackById(long id) {
		return feedBackDAO.findFeedBackById(id);
	}

	@Override
	public void addFeedBack(FeedBack feedBack) {
		feedBackDAO.addFeedBack(feedBack);
	}

	@Override
	public void updateFeedBack(FeedBack feedBack) {
		feedBackDAO.updateFeedBack(feedBack);
	}

	@Override
	public void deleteFeedBack(long id) {
		feedBackDAO.deleteFeedBack(id);
	}

}
