package catering_service.service;

import java.util.List;
import catering_service.entity.Rating;

public interface RatingService {
	
	List<Rating> findAll();
	Rating findById(int ratingId);
	List<Rating> findMaxScore();
	void save(Rating rating);
	void update(Rating rating);
	void delete(Rating rating);


}
