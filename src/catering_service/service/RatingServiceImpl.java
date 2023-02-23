package catering_service.service;

import java.util.List;
import catering_service.dao.RatingDAOImpl;
import catering_service.entity.Rating;

public class RatingServiceImpl implements RatingService {

	@Override
	public List<Rating> findAll() {
		RatingDAOImpl ratingDAOImpl = new RatingDAOImpl();
		List<Rating> ratingList = ratingDAOImpl.findAll();
		return ratingList;
	}

	@Override
	public void save(Rating rating) {
		RatingDAOImpl ratingDAOImpl = new RatingDAOImpl();
		int row = ratingDAOImpl.save(rating);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}

	@Override
	public void update(Rating rating) {
		RatingDAOImpl ratingDAOImpl = new RatingDAOImpl();
		int row = ratingDAOImpl.update(rating);
		if (row == 1)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");

	}

	@Override
	public void delete(Rating rating) {
		RatingDAOImpl ratingDAOImpl = new RatingDAOImpl();
		int row = ratingDAOImpl.delete(rating);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETE FAILED!!!!!!!!!!!!");

	}

	@Override
	public Rating findById(int ratingId) {
		RatingDAOImpl ratingDAOImpl = new RatingDAOImpl();
		Rating rating = ratingDAOImpl.findById(ratingId);
		return rating;
	}

	@Override
	public List<Rating> findMaxScore() {
		RatingDAOImpl ratingDAOImpl = new RatingDAOImpl();
		List<Rating> ratingList = ratingDAOImpl.findMaxScore();
		return ratingList;
	}

}
