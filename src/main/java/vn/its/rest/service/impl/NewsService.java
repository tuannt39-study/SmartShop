package vn.its.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.its.rest.dao.impl.NewsDao;

@Service("NewsService")
public class NewsService {
	
	@Autowired
	NewsDao newsDao;
	
}
