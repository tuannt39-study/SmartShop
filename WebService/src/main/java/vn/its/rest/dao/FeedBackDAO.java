package vn.its.rest.dao;

import java.util.List;

import vn.its.rest.model.FeedBack;

public interface FeedBackDAO {
	
	public List<FeedBack> findAllFeedBack();

	public FeedBack findFeedBackById(long id);

	public void addFeedBack(FeedBack feedBack);

	public void updateFeedBack(FeedBack feedBack);

	public void deleteFeedBack(long id);

}
